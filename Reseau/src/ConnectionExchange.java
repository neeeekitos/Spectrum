import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            out.flush(); //pour envoyer de Buffer au client

            //ajouter l'envoie du message dans la DB
        } catch (IOException e) {
            eventEcouteur.exception(ConnectionExchange.this, e);
            disconnect();
        }
    }

    private synchronized void connectToDb() {

        Connection connDb = null;
        try {
            String url = "jdbc:sqlite:path-to-db/chinook/chinook.db";
            connDb = DriverManager.getConnection(url);

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
    }
}