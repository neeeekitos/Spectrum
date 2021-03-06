
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/** Fenêtre qui permet d'ajouter des collaborateurs
 * @author Nikita TEREKHOV
 * @author Lena LEHMANN
 */
public class Ajouter extends JFrame {

    private Client user;
    private String currentProjectNom;

    /**Constructeur
     * @param user
     * @param currentProjectNom
     * */
    public Ajouter(Client user, String currentProjectNom) {
        this.user = user;
        this.currentProjectNom = currentProjectNom;
        initComponents();
    }

    /** Initialisation
     */
    private void initComponents() {
        final GridBagConstraints[] gridBagConstraints = new GridBagConstraints[1];

        //L' initialisation des variables
        top = new JPanel();
        leftPanel = new JPanel();
        collaborateur = new JLabel();
        rightPanel = new JPanel();
        panelLogo = new JPanel();
        jLabel1 = new JLabel();
        panelCode = new JPanel();
        codeJLabelExistant = new JLabel();
        codeProjet = new JTextField();
        code = new JLabel();
        bottom = new JPanel();
        valider = new JButton();
        addColab = new JLabel();
        collab = new ArrayList<JTextField>();


        //Layout du pane avec déclaration des dimensions
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setMaximumSize(new Dimension(562, 450));
        getContentPane().setMinimumSize(new Dimension(562, 450));

        //Le positionnement sur l'écran de la fenêtre
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 562 / 2),
                (int) (dimension.getHeight() / 2 - 450 / 2));

        //Dimensions du panel top (en haut)
        top.setMaximumSize(new Dimension(562, 396));
        top.setMinimumSize(new Dimension(562, 396));
        top.setPreferredSize(new Dimension(562, 396));

        //Layout du panel top
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

        //Layout du premier panel à gauche
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(new Color(69, 123, 157));

        //Paramètres du Jlabel collaborateurs et ajout dans le Panel leftPanel
        collaborateur.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        collaborateur.setText("Collaborateurs");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].ipady = 50;
        leftPanel.add(collaborateur, gridBagConstraints[0]);

        //Création d'ArrayList grâce aux TextFied avec les users (de la classe Client) des collaborateurs qu'on veut ajouter
        collab.add(0, new JTextField(""));
        collab.get(0).setMaximumSize(new Dimension(200, 26));
        collab.get(0).setMinimumSize(new Dimension(200, 26));
        collab.get(0).setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        leftPanel.add(collab.get(0), gridBagConstraints[0]);


        //Création de JLabel contenant un mouse listener
        addColab = new JLabel();
        addColab.setHorizontalAlignment(JLabel.CENTER);
        addColab.setPreferredSize(new Dimension(200, 40));
        addColab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addColab.setHorizontalAlignment(SwingConstants.LEFT);
        addColab.setIcon(new ImageIcon(this.getClass().getResource("add.png")));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 7;
        leftPanel.add(addColab, gridBagConstraints[0]);


        //Ajouter une méthode qui créée des JTextField et permet d'ajouter plusieurs collaborateurs
        addColab.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                addCollabMouseExited(evt);
            }

            private void addCollabMouseExited(MouseEvent evt) {
                addColab.setText("");
            }

            public void mouseEntered(MouseEvent evt) {
                addCollabMouseEntered(evt);
            }

            private void addCollabMouseEntered(MouseEvent evt) {
                addColab.setText("Plus de collaborateurs");
            }

            public void mouseClicked(MouseEvent e) {
                collab.add(counter, new JTextField(""));
                collab.get(counter).setMaximumSize(new Dimension(200, 26));
                collab.get(counter).setMinimumSize(new Dimension(200, 26));
                collab.get(counter).setPreferredSize(new Dimension(200, 26));

                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 6 + counter;
                leftPanel.add(collab.get(counter), gridBagConstraints[0]);

                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 7 + counter;
                leftPanel.add(addColab, gridBagConstraints[0]);
                counter++;
                leftPanel.repaint();

            }
        });


        //Ajouter le LeftPanel dans un ScrollPane
        scroll = new JScrollPane(leftPanel);
        scroll.setBackground(new Color(69, 123, 157));
        top.add(scroll);


        //Déclaration panel droit
        rightPanel.setMaximumSize(new Dimension(281, 396));
        rightPanel.setMinimumSize(new Dimension(281, 396));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(255, 255, 255));

        //Declaration du panel en haut qui appartient au rigthPanel
        panelLogo.setMaximumSize(new Dimension(281, 50));
        panelLogo.setMinimumSize(new Dimension(281, 50));
        panelLogo.setPreferredSize(new Dimension(281, 50));
        panelLogo.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Mettre le logo dans un Jlabel
        jLabel1.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));
        panelLogo.add(jLabel1);
        panelLogo.setBackground(new Color(237, 246, 249));

        //Ajouter le panelLogol au rigthPane
        rightPanel.add(panelLogo);


        //Panel pour créer le code
        panelCode.setLayout(new GridBagLayout());

        //L'ajout du titre du panelCode
        codeJLabelExistant.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        codeJLabelExistant.setText("Créer un code pour le projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 0;
        gridBagConstraints[0].ipady = 50;
        gridBagConstraints[0].anchor = GridBagConstraints.PAGE_START;
        panelCode.add(codeJLabelExistant, gridBagConstraints[0]);

        //L'ajout du sous-titre du panelCode
        code.setText("Le code va expirer dans 24 heures");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].ipady = 20;
        panelCode.add(code, gridBagConstraints[0]);
        panelCode.setBackground(new Color(237, 246, 249));
        rightPanel.add(panelCode);

        //L'ajout de TextField pour donner un code unique, afin de pouvoir accéder au projet
        codeProjet.setText("");
        codeProjet.setMaximumSize(new Dimension(200, 26));
        codeProjet.setMinimumSize(new Dimension(200, 26));
        codeProjet.setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        panelCode.add(codeProjet, gridBagConstraints[0]);

        //L'ajout de rigthPanel au Panel top, et du top au Pane
        top.add(rightPanel);
        getContentPane().add(top);

        //Création du panel bottom
        bottom.setMaximumSize(new Dimension(562, 54));
        bottom.setMinimumSize(new Dimension(562, 54));
        bottom.setPreferredSize(new Dimension(562, 54));
        bottom.setLayout(new GridBagLayout());

        //Création du bouton valider
        valider.setText("Valider");
        valider.setMaximumSize(new Dimension(100, 30));
        valider.setMinimumSize(new Dimension(100, 30));
        valider.setPreferredSize(new Dimension(100, 30));
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                validerActionPerformed(evt);
            }

            private void validerActionPerformed(ActionEvent evt) {

                ArrayList<String> collabString = new ArrayList<>();
                //on prend chaque TextField et on met le contenu dans ArrayList
                for (int i = 0; i < collab.size(); i++) {
                    if (!collab.get(i).getText().equals("")) {
                        collabString.add(collab.get(i).getText());
                        collab.get(i).setText("");
                    }
                }
                //mettons ensuite les collaborateurs dans la BD
                for (int i = 0; i < collabString.size(); i++) {
                    user.ajouterCollab(collabString.get(i), user.getProjectByName(currentProjectNom).getId());
                    codeProjet.setText("");
                }

                if (!codeProjet.getText().equals("")) {
                    user.getProjectByName(currentProjectNom).createCode(codeProjet.getText());
                    codeProjet.setText("");
                }
            }
        });
        bottom.add(valider, new GridBagConstraints());

        //L'ajout du bottom au pane;
        getContentPane().add(bottom);

        //Fixer la taille de la fenêtre
        setResizable(false);

        pack();
    }

    // Déclaration des variables
    private JButton valider;
    private javax.swing.JPanel panelCode;
    private javax.swing.JPanel bottom;
    private javax.swing.JLabel code;
    private javax.swing.JTextField codeProjet;
    private ArrayList<JTextField> collab;
    private javax.swing.JLabel collaborateur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel addColab;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JLabel codeJLabelExistant;
    private javax.swing.JPanel top;
    private int counter;
    // Fin de déclaration des variables
}
