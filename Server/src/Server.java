import com.sun.corba.se.pept.transport.ConnectionCache;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.rmi.ConnectIOException;
import java.util.*;
import java.util.concurrent.*;

public class Server implements EcouteurConnection{

    public final static int PORT = 8190;

    public static void main(String[] args) {
        new Server();
    }

    private HashMap<String, ConnectionExchange> connections = new HashMap<String, ConnectionExchange>();

//            ExecutorService pool = Executors.newFixedThreadPool(50);
//
//        /* utilisation des parametres permet de fermet la connection automatiquement
//        * car ServerSocket implements Autocloseable
//        */
//        try (ServerSocket server = new ServerSocket(PORT)) {
//            System.out.println("server is listening on port" + PORT);
//            while (true) {
//                try {
//                    Socket connection = server.accept();
//                    Callable<Void> task = new ChatThread(connection);
//                    pool.submit(task);
//                } catch (IOException ex) {
//                    System.err.println(ex.getMessage());
//                    System.exit(1);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("le serveur ne peut pas être démarré");
//        }
//    }
//
//    private static class ChatThread implements Callable<Void> {
//
//        private Socket connection;
//
//        ChatThread(Socket connection) {
//            this.connection = connection;
//        }
//
//        @Override
//        public Void call() {
//            try {
//                System.out.println("Nouveau client est connecté");
//                OutputStream output = connection.getOutputStream();
//                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(output));
//                DataInputStream in = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
//
//            } catch (IOException ex) {
//                System.err.println(ex);
//            } finally { //fermer la connection
//                try {
//                    connection.close();
//                } catch (IOException e){
//                    //rien
//                }
//            }
//            return null;
//        }
//    }

    private Server() {

        System.out.println("server est démarré");

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("server is listening on port" + PORT);
            while (true) {
                try {
                    Socket connection = server.accept();

                    //receive username to identify a person && attente 1 seconde pour obtenir le username, sinon disconnect
                    String username = "";
                    long initTime = System.currentTimeMillis();
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), Charset.forName("UTF-8")));

                    //timer in while
                    while (username.equals("") && System.currentTimeMillis()-initTime<1000) {
                        username = in.readLine();
                    }
                    System.out.println("================================");
                    System.out.println("username reçu : " + username);

                    //if we successfully received a username
                    if (!username.equals("")) {
                        new ConnectionExchange(this, connection, username);
                    } else {
                        out.write("#server# : try to reconnect");
                        out.flush();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            System.err.println("le serveur ne peut pas être démarré");
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void connectionReady(ConnectionExchange connection, String username) {
        connections.put(username, connection);
        System.out.println("l'utilisateur @" + username + " connecté");
        System.out.println("========================================");
        //sendToConnection(username,"Nouveau client connecté :" + username + connection);
    }

    @Override
    public synchronized void receiveString(String msg) {

        String[] parts = msg.split("###");
        ArrayList<String> destinateursConnection = new  ArrayList<String>(parts.length-3);

        //find connections
        for (int i = 3; i<parts.length; i++) {
            destinateursConnection.add(parts[i]);
        }

        System.out.println("serveur à reçu le message :" + msg);
        sendToConnection(destinateursConnection, msg);
    }

    @Override
    public synchronized void disconnect(ConnectionExchange connection) {
        connections.remove(connection.getUsername());
        System.out.println("Voici les utilisateurs qui restent connectés :");
        for (Map.Entry username : connections.entrySet()) {
            System.out.println(username.getKey());
        }
        connection.disconnect();
    }

    @Override
    public synchronized void exception(ConnectionExchange connection, IOException e) {
        System.out.println("Connection exception: " + e);
    }

    private void sendToConnection(ArrayList<String> destinateursConnection, String msg){

        System.out.println("server will send this : " + msg);

        for (int i = 0; i<destinateursConnection.size(); i++) {
            System.out.println("j'envoie le message à : ");
            System.out.println(destinateursConnection.get(i));
            ConnectionExchange conn = connections.get(destinateursConnection.get(i));
            if (conn != null) {
                conn.sendString(msg);
            } else {
                System.out.println("L'utilisateur @" + destinateursConnection.get(i) + " n'est pas en ligne");
            }
        }
    }
}
