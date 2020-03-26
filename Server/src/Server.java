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

    private HashMap<String, Connection> connections = new HashMap<String, Connection>();

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
                    new Connection(this, connection);
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
    public synchronized void connectionReady(Connection connection, String username) {
        connections.put(username, connection);
        //sendToConnection(username,"Nouveau client connecté :" + username + connection);
    }

    @Override
    public synchronized void receiveString(String msg) {
        String[] parts = msg.split("-");
        ArrayList<Connection> destinateursConnection = new  ArrayList<Connection>(parts.length-2);

        for (int i = 2; i<parts.length; i++) {
            destinateursConnection.add(connections.get(parts[i]));
        }

        //find connections
        sendToConnection(destinateursConnection, msg);
    }

    @Override
    public synchronized void disconnect(Connection connection) {
        connections.remove(connection);
        System.out.println("Client déconnecté :" + connection);
    }

    @Override
    public synchronized void exception(Connection connection, IOException e) {
        System.out.println("Connection exception: " + e);
    }

    private void sendToConnection(ArrayList<Connection> destinateursConnection, String msg){

        System.out.println(msg);

        for (Connection connection : destinateursConnection) {
            connection.sendString(msg);
        }
    }


}
