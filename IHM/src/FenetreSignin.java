import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Lena LEHMANN
 */

public class FenetreSignin extends JFrame {

    /**
     * Construit la fenêtre Signin
     */
    public FenetreSignin() {
        try {
            Image img = ImageIO.read(new FileInputStream("IHM/resources/background.jpg"));

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

    /** Initialisation
     */
    private void initComponents() {

        //Initialisation des variables
        conditions = new JFrame();
        jLabelLegalTerms = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        jLabelMemberSignIn = new javax.swing.JLabel();
        legalConCheckbox = new javax.swing.JCheckBox();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        userNameField = new javax.swing.JTextField();
        eMailField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jLabelSeeConditions = new javax.swing.JLabel();
        backToLogin = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabelRepeatPassword = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();

        //Définir les propriétés du pane conditions
        conditions.setMaximumSize(new java.awt.Dimension(600, 400));
        conditions.setMinimumSize(new java.awt.Dimension(600, 400));
        conditions.setPreferredSize(new java.awt.Dimension(600, 400));
        conditions.getContentPane().setLayout(new javax.swing.BoxLayout(conditions.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        //Définir les propriétés du legal terms
        jLabelLegalTerms.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelLegalTerms.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLegalTerms.setText("Legal terms and conditions");

        //Définir les propriétés du fenêtre
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        //Définir les propriétés du PanelPrincipal
        jPanelPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        jPanelPrincipal.setMaximumSize(new java.awt.Dimension(300, 700));

        //Définir les propriétés du label sign in
        jLabelMemberSignIn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelMemberSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMemberSignIn.setText("Member sign-in ");
        jLabelMemberSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelMemberSignIn.setOpaque(false);

        //Définir les propriétés du checkBox pour valider les legalConditions
        legalConCheckbox.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        legalConCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        legalConCheckbox.setText("J'accepte les conditions");
        legalConCheckbox.setOpaque(false);

        //Définir les TextField à compléter
        firstNameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lastNameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        userNameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        eMailField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        //Définir le bouton qui va envoyer les données dans la BD
        submitButton.setBackground(new java.awt.Color(102, 204, 255));
        submitButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        submitButton.setForeground(new java.awt.Color(0, 121, 203));
        submitButton.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("triangle.png"))); // NOI18N
        submitButton.setText("Envoyer");
        submitButton.setToolTipText("");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });

        //Définir le JLabel qui va afficher les conditions
        jLabelSeeConditions.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabelSeeConditions.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeeConditions.setText("see conditions");
        jLabelSeeConditions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSeeConditions.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSeeConditionsMouseClicked(evt);
            }
        });

        //Définir le JLabel qui va nous renvoyer vers LogIn
        backToLogin.setBackground(new java.awt.Color(231, 231, 231));
        backToLogin.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        backToLogin.setForeground(new java.awt.Color(255, 255, 255));
        backToLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backToLogin.setText("Retour vers Login");
        backToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToLoginMouseClicked(evt);
            }
        });

        //Définir les Labels affichés sur la fenêtre:
        //Rééecriture du mot de passe
        jLabelRepeatPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelRepeatPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRepeatPassword.setText("Réécrire le mot de passe");

        //Le mot de passe
        jLabelPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Mot de passe");

        //L'email
        jLabelEmail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("E-mail");

        //Le username
        jLabelUsername.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("Username");

        //Le nom
        jLabelLastName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelLastName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLastName.setText("Nom");

        //Le prénom
        jLabelFirstName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelFirstName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFirstName.setText("Prénom");

        //L'ajout de l'ensemble dans le panel principal avec le layout
        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
                jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                                                .addComponent(jLabelMemberSignIn)
                                                                .addGap(100, 100, 100))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                                                .addGap(136, 136, 136))))
                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(eMailField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                                                .addComponent(legalConCheckbox)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabelSeeConditions))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addComponent(backToLogin)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(submitButton)))
                                                .addContainerGap())
                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelRepeatPassword)
                                                        .addComponent(jLabelUsername)
                                                        .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelFirstName)
                                                        .addComponent(jLabelLastName)
                                                        .addComponent(jLabelPassword)
                                                        .addComponent(jLabelEmail))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelPrincipalLayout.setVerticalGroup(
                jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelMemberSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabelFirstName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelLastName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eMailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelRepeatPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSeeConditions)
                                        .addComponent(legalConCheckbox))
                                .addGap(29, 29, 29)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(backToLogin))
                                .addContainerGap())
        );

        getContentPane().add(jPanelPrincipal, new java.awt.GridBagConstraints());
        pack();
    }

    /** Envoi des données dans la BD
     * Et vérification des conditions sur le TextField
     * Si tout a bien été envoyé, on va être renvoyé vers Log In
     * @param evt l'évènement
     */
    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ImageIcon img = new ImageIcon("resources/attention.png");
        //Calcule et vérifie si toutes les conditions étaient respectées
        int counterConditions = 0;
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = userNameField.getText();
        String eMail = eMailField.getText();
        char[] password1 = jPasswordField1.getPassword();
        char[] password2 = jPasswordField2.getPassword();
        String password = new String(password1);

        if(username.equals("") || password1 ==null || password2 == null || eMail.equals("") || lastName.equals("") || firstName.equals("")) {
            JOptionPane notFilledOut = new JOptionPane();
            notFilledOut.showMessageDialog(null, "Veuillez remplir toutes les informations", "Attention", JOptionPane.ERROR_MESSAGE, img);

        }else{
            counterConditions++;
            if (Pattern.matches("^\\p{L}*$", firstNameField.getText())) {
                counterConditions++;
            } else {
                JOptionPane firstNameFalse = new JOptionPane();
                firstNameFalse.showMessageDialog(null, "Votre prénom ne doit être composé que de lettres\n" , "Attention",JOptionPane.ERROR_MESSAGE, img);

            }

            if (Pattern.matches("^\\p{L}*$", lastNameField.getText())) {
                counterConditions++;
            } else {
                JOptionPane lastNameFalse = new JOptionPane();
                lastNameFalse.showMessageDialog(null, "Votre nom ne doit être composé que de lettres\n" , "Attention",JOptionPane.ERROR_MESSAGE, img);

            }

            if (Pattern.matches("^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$", eMailField.getText())) {
                counterConditions++;
            } else {
                JOptionPane eMailFalse = new JOptionPane();
                eMailFalse.showMessageDialog(null, "Votre adresse e-mail n'est pas conforme\n", "Attention", JOptionPane.ERROR_MESSAGE, img);
            }

            if (Pattern.matches("^[a-zA-Z0-9._-]{3,}$", userNameField.getText())) {
                counterConditions++;
            } else {
                JOptionPane usernameFalse = new JOptionPane();
                usernameFalse.showMessageDialog(null, "Votre nom d'utilisateur doit suivre les règles suivantes : \n" +
                        "- au moins 3 caractères\n" +
                        "- les caractères autorisés sont les majuscules, minuscules, \" _ \"\n" +
                        "- les voyelles accentuées ne sont pas acceptées", "Attention",JOptionPane.ERROR_MESSAGE, img);

            }
            if(legalConCheckbox.isSelected()) {
                counterConditions++;
            }else{
                JOptionPane checkBoxNotChecked = new JOptionPane();
                checkBoxNotChecked.showMessageDialog(null, "Veuillez accepter les conditions d'utilisations\n" , "Attention",JOptionPane.ERROR_MESSAGE, img);

            }

            if (Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$", password)) {
                counterConditions++;
                if(Arrays.equals(password1, password2))  {
                    counterConditions++;
                    System.out.println(counterConditions);
                } else {

                    JOptionPane passwordDiff = new JOptionPane();
                    passwordDiff.showMessageDialog(null, "Les mots de passe ne sont pas identiques", "Attention", JOptionPane.ERROR_MESSAGE, img);
                }
            } else {
                JOptionPane passwordFalse = new JOptionPane();
                passwordFalse.showMessageDialog(null, "Votre mot de passe doit suivre les règles suivantes :\n " +
                        "- plus de 8 caractères\n" +
                        "- au moins une minuscule\n" +
                        "- au moins une majuscule\n" +
                        "- au moins un chiffre\n" +
                        "- au moins un caractère spécial : $ @ % * _ ! ^ & #\n" +
                        "- aucune voyelle accentuée", "Attention", JOptionPane.ERROR_MESSAGE, img);
            }

        }

        if (counterConditions==8) { //si on a vérifié 7 conditions
            try {
                ConnectionExchange.signinDB(firstName, lastName, username, eMail, password);
                this.dispose();

                new FenetreLogin().setVisible(true);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /** Ouvrir la fenêtre pour voir les conditions d'utilisation
     * @param evt l'évènement
     */
    private void jLabelSeeConditionsMouseClicked(java.awt.event.MouseEvent evt) {
        new FenetreConditions().setVisible(true);
    }

    /** Le renvoi vers LogIn
     * @param evt l'évènement
     */
    private void backToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToLoginMouseClicked

        new FenetreLogin().setVisible(true);
        this.dispose();
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

        /* Créé et affiche la forme*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreSignin().setVisible(true);
            }
        });
    }

    // Déclaration des variables
    private JFrame conditions;
    private javax.swing.JLabel backToLogin;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelMemberSignIn;
    private javax.swing.JLabel jLabelSeeConditions;
    private javax.swing.JLabel jLabelRepeatPassword;
    private javax.swing.JLabel jLabelLegalTerms;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField userNameField;
    private javax.swing.JTextField eMailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JCheckBox legalConCheckbox;
    private javax.swing.JButton submitButton;

}
