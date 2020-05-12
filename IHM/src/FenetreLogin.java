import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;


/**
 * @author lehma
 */

public class FenetreLogin extends JFrame {

    private JPanel background;


    public FenetreLogin() {
        try {
            Image img = ImageIO.read(new FileInputStream("IHM/images/background.jpg"));

            Image scaledImg = img.getScaledInstance(1000, 800,  java.awt.Image.SCALE_SMOOTH) ;

            this.setContentPane(new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(scaledImg, 0, 0, null);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }


    private void initComponents() {
        
        fondConnexionEchoue = new javax.swing.JPanel();
        msgConnexionEchoue = new javax.swing.JLabel();
        champRempli = new javax.swing.JDialog();
        msgChampRempli = new javax.swing.JLabel();
        okChampRempli = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        memberLogin = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        backToSignIn = new javax.swing.JLabel();

        fondConnexionEchoue.setBackground(new java.awt.Color(153, 153, 153));
        fondConnexionEchoue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        msgConnexionEchoue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        msgConnexionEchoue.setForeground(new java.awt.Color(255, 255, 255));
        msgConnexionEchoue.setText("Process failed, please check your connexion and try again");



        champRempli.setBackground(new java.awt.Color(102, 102, 102));
        champRempli.setUndecorated(true);

        msgChampRempli.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        msgChampRempli.setForeground(new java.awt.Color(255, 255, 255));
        msgChampRempli.setText("Please, fill out all the fields to login");

        setMinimumSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        jPanelPrincipal.setMaximumSize(new java.awt.Dimension(300, 700));

        memberLogin.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        memberLogin.setForeground(new java.awt.Color(255, 255, 255));
        memberLogin.setText("Member Login ");
        memberLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        memberLogin.setOpaque(false);

        usernameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        LoginButton.setBackground(new java.awt.Color(102, 204, 255));
        LoginButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(0, 121, 203));
        LoginButton.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("triangle.png"))); // NOI18N
        LoginButton.setText("Login");
        LoginButton.setToolTipText("");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });


        passwordLabel.setFont(new java.awt.Font("Arial", 0, 16));
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Mot passe");

        userName.setFont(new java.awt.Font("Arial", 0, 16));
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("Username");

        backToSignIn.setFont(new java.awt.Font("Arial", 1, 13));
        backToSignIn.setForeground(new java.awt.Color(255, 255, 255));
        backToSignIn.setText("Vers Sign in");
        backToSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backToSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToSignInMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(backToSignIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginButton)
                .addContainerGap())
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(memberLogin)
                                .addGap(100, 100, 100))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(logo)
                                .addGap(136, 136, 136))))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userName)
                            .addComponent(passwordLabel))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(memberLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(passwordLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToSignIn))
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanelPrincipal, new java.awt.GridBagConstraints());

        pack();
    }

    private void backToSignInMouseClicked(java.awt.event.MouseEvent evt) {
      new FenetreSignin().setVisible(true);
      this.dispose();
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            ConnectionExchange.loginDb(username, password);
            this.dispose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreLogin().setVisible(true);
            }
        });
    }

    // déclaration des variables
    private JFrame Conditions;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel backToSignIn;
    private javax.swing.JTextField usernameField;
    private javax.swing.JButton okChampRempli;
    private javax.swing.JDialog champRempli;
    private javax.swing.JLabel msgChampRempli;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel memberLogin;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel msgConnexionEchoue;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel fondConnexionEchoue;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPasswordField passwordField;

}
