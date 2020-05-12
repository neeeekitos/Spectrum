
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;

/**Classe qui va afficher les unfoermations d'un certain collaborateur
 * @author Nikita TEREKHOV
 * @author Valentina ETEGAN
 */
public class InformationsCollab extends javax.swing.JFrame {

    private String username;
    private boolean gained;
    private Client user;

    /**Constructeur
     * @param username du collaborateur sur laquell on veut les informations
     * @param user le Client sur lequelle on veeut les informations
     * */
    public InformationsCollab(String username, Client user) {
        this.username = username;
        this.user = user;
        initComponents();
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                //nothing
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();
            }
        });
    }

    /** Initialisation
     */
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        String prenom = "";
        String nom = "";
        String email = "";

        try {
            String[] infoArray = user.getConnectionExchange().getUserInfosByUsername(username);
            if (infoArray != null) {
                prenom = infoArray[0];
                nom = infoArray[1];
                email = infoArray[2];
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Initialisation des variables
        top = new javax.swing.JPanel();
        nomJLabel = new javax.swing.JLabel();
        prenomLabel = new javax.swing.JLabel();
        nomLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        effacerBotton = new javax.swing.JButton();
        titleInformations = new javax.swing.JLabel();

        //Definir les proprietes de la fenetre
        setMinimumSize(new java.awt.Dimension(150, 100));
        setMaximumSize(new java.awt.Dimension(150, 100));
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));
        top.setLayout(new java.awt.GridBagLayout());

        // Afficher le nom du collaborateur
        nomJLabel.setText("Nom : " + nom);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 0, 0);
        top.add(nomJLabel, gridBagConstraints);

        // Afficher le prenom du collaborateur
        prenomLabel.setText("Prénom : " + prenom);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 0, 0);
        top.add(prenomLabel, gridBagConstraints);

        // Afficher le nom du collaborateur
        nomLabel.setText("Nom d'utilisateur : " + username );
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 0, 0);
        top.add(nomLabel, gridBagConstraints);

        // Afficher le email du collaborateur
        emailLabel.setText("E-mail : " + email);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 0, 0);
        top.add(emailLabel, gridBagConstraints);

        //Le button qui eface les collaborateur
        effacerBotton.setText("Efacer l'utilisateur dans le projet");
        effacerBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(43, 14, 0, 25);
        top.add(effacerBotton, gridBagConstraints);

        //Afficher le titre du frame
        titleInformations.setText("Informations");

        top.add(titleInformations, new java.awt.GridBagConstraints());
        getContentPane().add(top);

        pack();
    }

    /** Efacer le colaborateur de ce projet
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            user.getConnectionExchange().deleteMemberFromProject(username);
            user.updateProjets();
            user.fenetre.updateCollaborateurs();
            user.fenetre.repaint();
            user.fenetre.validate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Declaration des variables
    private javax.swing.JButton effacerBotton;
    private javax.swing.JLabel nomJLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel titleInformations;
    private javax.swing.JPanel top;
}
