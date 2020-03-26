import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class Client implements EcouteurConnection {

    private static final String IP_ADDR = "localhost";
    private static final int PORT = 8190;
    private Connection connection;
    private FenetreApp fenetre;

    private String nom;
    private String prenom;
    private String username;
    private String mdp;
    private LinkedList<Projet> projets;


    public Client(FenetreApp fenetre){
        this.fenetre=fenetre;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("connection on local IP : "+ inetAddress.toString());
            connection = new Connection(this,"127.0.0.1", PORT);
        } catch (IOException e) {
            fenetre.printMsg("exception de connexion " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void connectionReady(Connection connection, String username) { fenetre.printMsg("connexion établie avec " + username); }

    @Override
    public void receiveString(String msg) {
        fenetre.printMsg(msg);
        System.out.println(" sdsdsdsds");
    }

    @Override
    public void disconnect(Connection connection) {
        fenetre.printMsg("Connection interrompue");
    }

    @Override
    public void exception(Connection connection, IOException e) {
        fenetre.printMsg("Exception de connection " + e);
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
        //str = Client.username . msg . collaborateurs
       // connection.sendMessage(str);
    }

//    Message message = new Message(username, msg, LocalDateTime.now(), projet.getArrayCollaborateurs());
//
//        projet.getMessages().add(message);
//
//        connection.sendMessage(message);

    public String getUsername(){
        return username;
    }

    public String getConnection(){
        return username;
    }
}
