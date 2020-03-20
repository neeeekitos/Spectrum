import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreApp extends JFrame implements ActionListener {

    private Client user;
    JFrame frame;
    JTextArea lConsole;

    public FenetreApp(Client client) {
        this.user = client;
        frame = new JFrame();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lConsole = new JTextArea("dddddd");
        frame.add(lConsole);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
