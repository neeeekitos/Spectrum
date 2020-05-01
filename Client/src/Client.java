import org.omg.CORBA.WStringSeqHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Client implements EcouteurConnection {

    private static final String IP_ADDR = "localhost";
    private static final int PORT = 8190;
    private ConnectionExchange connection;
    protected FenetreApp fenetre;

    private String nom;
    private String prenom;
    private String username;
    private LinkedList<Projet> projets;

    public static void main(String[] args){
        new Client("Nikita", "Nikita", "H");
    }

    public Client(String username, String prenom, String nom){

        this.username = username;
        this.nom = nom;
        this.prenom = prenom;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("connection on local IP : "+ inetAddress.toString());
            connection = new ConnectionExchange(this,"127.0.0.1", PORT, username);
            connection.sendString(username);
        } catch (IOException e) {
            System.out.println("exception de connexion " + e);
            e.printStackTrace();
        }

        //charger les projets
        projets = new LinkedList<>();
        try {
            projets = connection.updateProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* creer une fenetre dans un thread edt
         * ici on utilisera plutot invokeAndWait
         * car avec invokeLater la fenetre va etre créée de la façon asynchrone et
         * l'affichage des messages ( le chargement des messages ) va sortir une exception
         * vu que la fenetre était pas encore prête
         */
        try {
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    fenetre = new FenetreApp(Client.this);
                    fenetre.setVisible(true);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //charger les messages du 1er projet
        if (projets.size() != 0) {
            LinkedList<Message> messages = new LinkedList<>();
            try {
                messages = connection.updateMessages(projets.get(0));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            projets.get(0).setMsgs(messages);
            this.printMessages(messages);
        }

//        projets = new LinkedList<Projet>();
//        ArrayList<String> collabs = new ArrayList<>();
//        collabs.add("Nikita");
//        collabs.add("Roman");
//
//        createProject("lalala", collabs);

    }

    @Override
    public void connectionReady(ConnectionExchange connection, String username) {
        System.out.println("connexion établie avec " + username);
    }

    @Override
    public void receiveString(String msg) {

        String[] parts = msg.split("###");
        String sender = parts[0];
        String nomProjet = parts[1];
        String textMessage = parts[2];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date = dateFormat.format(new Date());

        this.getProjectByName(nomProjet).addMsg(new Message(sender, textMessage, date, getProjectByName(nomProjet)));

        fenetre.printMsg("\r\n" + sender + " : " + textMessage);
        System.out.println("message reçu : " + textMessage);

    }

    @Override
    public void disconnect(ConnectionExchange connection) {
        connection.disconnect();
        fenetre.printMsg("Connection interrompue");
    }

    @Override
    public void exception(ConnectionExchange connection, IOException e) {
        System.out.println("Exception de connection " + e);
    }

    public String getUsername(){
        return username;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getNom() { return nom; }

    public ConnectionExchange getConnectionExchange() { return connection; }

    public void createProject(String nom, ArrayList<String> collaborateurs) {
        int id = 0;
        try {
            id = connection.getLastIdProject();
            id++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //nouveau projet + vérier si le nom est déjà présent dans la liste des projets de notre user
        Projet projet = new Projet(id, nom, collaborateurs, new LinkedList<>());
        if (projets.contains(projet)) {
            //ajouter dans DB
            try {
                connection.addProjectToDB(projet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //ajouter localement
            projets.add(projet);
        } else {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane existingProject = new JOptionPane();
            existingProject.showMessageDialog(null, "Ce nom de projet existe déjà", "Attention", JOptionPane.ERROR_MESSAGE, img);
        }
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

        //sendToDB
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date = dateFormat.format(new Date());
        Message message = new Message(username, msg, date, projet);
        projet.addMsg(message);
        try {
            System.out.println("Envoie du message dans la BD : " + msg);
            connection.addMessageToDB(message);
        } catch (SQLException e) {
            System.out.println("Erreur d'envoi du message dans la BD : ");
            e.printStackTrace();
        }

        /*
         * sendString to all users from a project
         * collabStr: usernames separated by ###*
         */
        String collabStr = "";
        for (int i = 0; i < projet.getArrayCollaborateurs().size(); i++) {
            String usernameCollab = projet.getArrayCollaborateurs().get(i);
            if (!this.username.equals(usernameCollab)) {
                collabStr += usernameCollab + "###";
            }
        }

        String str = this.username + "###" + projet.getNom() + "###" + msg + "###" + collabStr;
        connection.sendString(str);
    }

    public synchronized void printMessages(LinkedList<Message> messages){
        //print dans un ordre inversé
        for (int i = messages.size() - 1; i>=0; i--) {
            fenetre.printMsg("\r\n" + username + " : " + messages.get(i).getMessage());
        }
    }
}
