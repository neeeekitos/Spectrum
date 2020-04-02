import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ConnectionExchange {

    private final Socket connection;
    private final BufferedWriter out;
    private final BufferedReader in;
    private final Thread cnThread;
    private final EcouteurConnection eventEcouteur;
    private String username;


    public ConnectionExchange(EcouteurConnection eventEcouteur, String ip, int port) throws IOException {
        this(eventEcouteur, new Socket(ip, port));
    }

    public ConnectionExchange(EcouteurConnection eventEcouteur, Socket connection) throws IOException {
        this.eventEcouteur = eventEcouteur;
        this.connection = connection;

        OutputStream output = connection.getOutputStream();
        InputStream input = connection.getInputStream();

        //conversion du string en bytes, puis mettre cela dans le buffer
        out = new BufferedWriter(new OutputStreamWriter(output, Charset.forName("UTF-8")));
        in = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        cnThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventEcouteur.connectionReady(ConnectionExchange.this, username);
                    while (!cnThread.isInterrupted()) {
                        eventEcouteur.receiveString(in.readLine());
                    }
                } catch (IOException e) {
                    eventEcouteur.exception(ConnectionExchange.this, e);
                } finally {
                    eventEcouteur.disconnect(ConnectionExchange.this);
                }
            }
        });
        cnThread.start();
    }

    @Override
    public String toString() {
        return "Connection: " + connection.getInetAddress() + ": " + connection.getPort();
    }

    public synchronized void disconnect() {
        cnThread.interrupt();
        try {
            connection.close();
        } catch (IOException e) {
            eventEcouteur.exception(ConnectionExchange.this, e);
        }
    }

    //syncronisé pour la securité
    public synchronized void sendString(String msg) {
        try {
            out.write(msg + "\r\n");
            out.flush(); //pour envoyer de Buffer à client/serveur

            //ajouter l'envoie du message dans la DB
        } catch (IOException e) {
            eventEcouteur.exception(ConnectionExchange.this, e);
            disconnect();
        }
    }

    private synchronized Connection connectToDb() {
        Connection connDb = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Spectrum";
            connDb = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connecté à la BD");

        } catch (SQLException e) {
            throw new Error("Erreur de connexion à la BD", e);
        } finally {
            try {
                if (connDb != null) {
                    connDb.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return connDb;
    }

    public boolean loginDb(String username, String password) throws SQLException {
        Connection connDb = this.connectToDb();

        ResultSet result = null;
        String requete = "SELECT * FROM users as u WHERE u.username="+username;


        Statement stmt = connDb.createStatement();
        result = stmt.executeQuery(requete);

        if (!result.equals(null)) {
            String usernameDb = result.getString(2);
            String passwordDb = result.getString(5);

            if (username.equals(usernameDb) && password.equals(passwordDb)) {
                new Client(username, result.getString(3), result.getString(4));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}