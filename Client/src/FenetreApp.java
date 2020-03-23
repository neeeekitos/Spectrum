import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreApp extends JFrame implements ActionListener {

    private JFrame frame;
    private Client user;
    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickname = new JTextField("username");
    private final JTextField fieldInput = new JTextField("fieldInput");

    public FenetreApp(Client user) {

        frame = new JFrame();
        this.user = user;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        log.setEditable(false);
        log.setLineWrap(true);
        fieldInput.addActionListener(this);
        add(log, BorderLayout.CENTER);
        add(fieldInput, BorderLayout.SOUTH);
        add(fieldNickname, BorderLayout.NORTH);
        setVisible(true);
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
        user.getConnection().sendString(fieldNickname.getText() + " : " + msg);
        this.validate();
    }
}
