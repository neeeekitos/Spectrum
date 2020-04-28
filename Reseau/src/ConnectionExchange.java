import javax.swing.*;
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
    private Connection connDb;


    public ConnectionExchange(EcouteurConnection eventEcouteur, String ip, int port, String username) throws IOException {
        this(eventEcouteur, new Socket(ip, port), username);
    }

    public ConnectionExchange(EcouteurConnection eventEcouteur, Socket connection, String username) throws IOException {
        this.eventEcouteur = eventEcouteur;
        this.connection = connection;
        this.username = username;
        this.connDb = connectToDb();

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

    public static synchronized Connection connectToDb() {
        Connection connDb = null;
        try {
            String url = "jdbc:mysql://localhost:3306/spectrum?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            connDb = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connecté à la BD");

        } catch (SQLException e) {
            throw new Error("Erreur de connexion à la BD", e);
        }
        return connDb;
    }

    public static void loginDb(String username, String password) throws SQLException {
        Connection connDB = connectToDb();

        ResultSet result = null;
        String requeteCheck = "SELECT * FROM users as u WHERE u.username=?";

        PreparedStatement preparedStmt = connDB.prepareStatement(requeteCheck);
        preparedStmt.setString(1, username);
        result = preparedStmt.executeQuery();

        //verifions si on a qqch dans un result
        if (result.next()) {

            String usernameDb = result.getString(2);
            String passwordDb = result.getString(5);

            if (password.equals(passwordDb)) {
                JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
                new Client(username, result.getString(3), result.getString(4));
            } else {
                JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
        }

        connDB.close();
    }

    public static boolean signinDB(String prenom, String nom, String username, String password) throws SQLException {

        Connection connDB = connectToDb();
        ResultSet result = null;

        //requete qui verifie si ce username est déjà utilisé
        String requeteCheck = "SELECT * FROM users as u WHERE u.username=?";

        PreparedStatement preparedStmt = connDB.prepareStatement(requeteCheck);
        preparedStmt.setString(1, username);
        result = preparedStmt.executeQuery();

        //verifions si on a qqch dans un result
        if (!result.next()) {

            //création d'insert statement
            String requete = " INSERT INTO users (username, prenom, nom, mdp) VALUES (?, ?, ?, ?)";
            preparedStmt = connDB.prepareStatement(requete);

            // ajouter les valeurs sql insert
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, prenom);
            preparedStmt.setString(3, nom);
            preparedStmt.setString(4, password);

            // executer
            return preparedStmt.execute();
        } else { return false; }
    }

    public synchronized void updateProjects() {
        Connection connDB = connectToDb();
        ResultSet result = null;

        //requete qui verifie si ce username est déjà utilisé
        String requeteCheck = "SELECT * FROM users as u WHERE u.username=?";

//        PreparedStatement preparedStmt = connDB.prepareStatement(requeteCheck);
//        preparedStmt.setString(1, username);
//        result = preparedStmt.executeQuery();
    }
}