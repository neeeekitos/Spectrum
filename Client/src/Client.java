import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

public class Client extends JFrame implements EcouteurConnection, ActionListener {

    private static final String IP_ADDR = "localhost";
    private static final int PORT = 8190;
    private Connection connection;
    private String username;
    private FenetreApp fenetre;

    public Client(FenetreApp fenetre, String username){
        this.username = username;
        this.fenetre=fenetre;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("connection on local IP : "+ inetAddress.toString());
            connection = new Connection(this,"127.0.0.1", PORT);
        } catch (IOException e) {
            printMsg("exception de connexion " + e);
            e.printStackTrace();
        }
        setVisible(true);
    }

    @Override
    public void connectionReady(Connection connection) { printMsg("connexion établie"); }

    @Override
    public void receiveString(Connection connection, String msg) {
        printMsg(msg);
        System.out.println(" sdsdsdsds");
    }

    @Override
    public void disconnect(Connection connection) {
        printMsg("Connection interrompue");
    }

    @Override
    public void exception(Connection connection, IOException e) {
        printMsg("Exception de connection " + e);
    }

    public synchronized void printMsg(String msg){ //тк работаем из потока окошка и соединения
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if (msg.equals("")) return;
        fieldInput.setText(null);
        connection.sendString(fieldNickname.getText() + " : " + msg);
        this.validate();
    }

    public String getUsername(){
        return username;
    }
}
