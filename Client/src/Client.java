import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Client implements EcouteurConnection {

    private static final String IP_ADDR = "localhost";
    private static final int PORT = 8190;
    private ConnectionExchange connection;
    protected FenetreApp fenetre;
    private Connection connDb;

    private String nom;
    private String prenom;
    private String username;
    private LinkedList<Projet> projets;

    public static void main(String[] args){
        new Client("Lol", "Nikita", "H");
    }

    public Client(String username, String prenom, String nom){

        this.username = username;
        this.nom = nom;
        this.prenom = prenom;

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fenetre = new FenetreApp(Client.this);
                fenetre.setVisible(true);
            }
        });

        projets = new LinkedList<Projet>();
        ArrayList<String> collabs = new ArrayList<>();
        collabs.add("Nikita");
        collabs.add("Roman");
        collabs.add("Lol");
        projets.add(new Projet(1, "pr1", collabs));

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("connection on local IP : "+ inetAddress.toString());
            connection = new ConnectionExchange(this,"127.0.0.1", PORT, username);
            connection.sendString(username);
        } catch (IOException e) {
            fenetre.printMsg("exception de connexion " + e);
            e.printStackTrace();
        }

        connection.updateProjects();
    }

    @Override
    public void connectionReady(ConnectionExchange connection, String username) {
        System.out.println("connexion établie avec " + username);
    }

    @Override
    public void receiveString(String msg) {

        String[] parts = msg.split("###");
        String sender = parts[0];
        String textMessage = parts[1];
        fenetre.printMsg("\r\n" + sender + " : " + textMessage);
        System.out.println("message reçu : " + textMessage);

    }

    @Override
    public void disconnect(ConnectionExchange connection) {
        fenetre.printMsg("Connection interrompue");
    }

    @Override
    public void exception(ConnectionExchange connection, IOException e) {
        fenetre.printMsg("Exception de connection " + e);
    }

    public String getUsername(){
        return username;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getNom() { return nom; }

    public void createProject(String nom, ArrayList<String> collaborateurs) {
        projets.add(new Projet(projets.size(), nom, collaborateurs));
    }

    public LinkedList<Projet> getProjets(){
        return projets;
    }

    public Projet getProjectByName(String name) {
        for (Projet projet : projets) {
            if (projet.getNom().equals(name)) {
                return projet;
            }
        }
        return null;
    }

    public ConnectionExchange getConnectionExchange() { return connection; }


//    public synchronized void printMsg(String msg){ //тк работаем из потока окошка и соединения
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                log.append(msg + "\n");
//                log.setCaretPosition(log.getDocument().getLength());
//            }
//        });
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String msg = fieldInput.getText();
//        if (msg.equals("")) return;
//        fieldInput.setText(null);
//        connection.sendString(fieldNickname.getText() + " : " + msg, usernames);
//        this.validate();
//    }

    public void sendMessage(String msg, Projet projet) {

//        Message message = new Message(username, msg, LocalDateTime.now(), projet.getArrayCollaborateurs());
//
//        projet.getMessages().add(message);

        //collabStr: usernames separated by #$#
        String collabStr = "";
        for (int i = 0; i < projet.getArrayCollaborateurs().size(); i++) {
            String usernameCollab = projet.getArrayCollaborateurs().get(i);
            if (!this.username.equals(usernameCollab)) {
                collabStr += usernameCollab + "###";
            }
        }

        String str = this.username + "###" + msg + "###" + collabStr;
        connection.sendString(str);
    }
}
