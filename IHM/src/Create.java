

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**Classe qui va créer l'affichage de la fenêtre contenant les messages(fenêtre principale)
 * @author Valentina ETEGAN
 * @author Roman HOCHHAUSEN
 */
public class Create extends javax.swing.JFrame {

    Client user;
    ListProjet listeProjets;

    /**Constructeur
     * @param user
     * @param listeProjets
     * */
    public Create(Client user, ListProjet listeProjets) {
        this.user=user;
        this.listeProjets=listeProjets;
        initComponents();
    }

    /** Initialisation
     */
    private void initComponents() {
        final GridBagConstraints[] gridBagConstraints = new GridBagConstraints[1];

        //Initialisation des composants
        top = new JPanel();
        panelCreateProjet = new JPanel();
        nouveauProjet = new JLabel();
        collaborateur = new JLabel();
        nomProjet = new JLabel();
        nom = new JTextField();
        panelRight = new JPanel();
        panelLogo = new JPanel();
        jLabel1 = new JLabel();
        panelProjet = new JPanel();
        projExistant = new JLabel();
        codeProjet = new JTextField();
        code = new JLabel();
        bottom = new JPanel();
        valider = new JButton();
        addColab = new JLabel();
        collab = new ArrayList<JTextField>();


        //Définir les dimensions de la fenêtre et sa position
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setMaximumSize(new Dimension(562,450));
        getContentPane().setMinimumSize(new Dimension(562,450));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 562/ 2),
                (int) (dimension.getHeight() / 2 - 450 / 2));

        //Définir les dimensions et layout du panel Top
        top.setMaximumSize(new Dimension(562, 396));
        top.setMinimumSize(new Dimension(562, 396));
        top.setPreferredSize(new Dimension(562, 396));
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

        //Définir le layout du panel à gauche
        panelCreateProjet.setLayout(new GridBagLayout());

        //Définir le titre : Nouveau Projet
        nouveauProjet.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        nouveauProjet.setText("NOUVEAU PROJET");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].ipady = 50;
        panelCreateProjet.add(nouveauProjet, gridBagConstraints[0]);

        //Définir le sous-titre : Collaborateur
        collaborateur.setText("COLLABORATEUR");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 4;
        gridBagConstraints[0].ipady = 20;
        panelCreateProjet.add(collaborateur, gridBagConstraints[0]);

        //Définir le JLabel Nom Projet
        nomProjet.setText("Nom du projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].fill = GridBagConstraints.VERTICAL;
        gridBagConstraints[0].ipady = 20;
        panelCreateProjet.add(nomProjet, gridBagConstraints[0]);
        panelCreateProjet.setBackground(new Color(69, 123, 157));

        //Définir le JTextField que prend le nom du projet pour le mettre dans la BD
        nom.setText("");
        nom.setMaximumSize(new Dimension(200, 26));
        nom.setMinimumSize(new Dimension(200, 26));
        nom.setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        panelCreateProjet.add(nom, gridBagConstraints[0]);

        //Définir un ArrayList de JTextField de collaborateurs qu'on va mettre dans la BD
        collab.add(0, new JTextField(""));
        collab.get(0).setMaximumSize(new Dimension(200, 26));
        collab.get(0).setMinimumSize(new Dimension(200, 26));
        collab.get(0).setPreferredSize(new Dimension(200, 26));

        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 5;
        panelCreateProjet.add(collab.get(0), gridBagConstraints[0]);

        //Créer le JLabel qui permet de créer plusieurs JTextField, afin d'ajouter plusieurs Collab
        addColab = new JLabel();
        addColab.setHorizontalAlignment(JLabel.CENTER);
        addColab.setPreferredSize(new Dimension(200, 40));
        addColab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addColab.setHorizontalAlignment(SwingConstants.LEFT);
        addColab.setIcon(new ImageIcon(this.getClass().getResource("add.png")));

        //Background de pane
        getContentPane().setBackground(new Color(237, 246, 249));

        //MouseListener pour Add qui va afficher un texte quand on passe la souris en-dessous
        //Il va créer des JTextField quand on clique dessus, pour pouvoir ajouter plusieurs collab
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

                //On créer les JTextField
                collab.add(counter, new JTextField(""));
                collab.get(counter).setMaximumSize(new Dimension(200, 26));
                collab.get(counter).setMinimumSize(new Dimension(200, 26));
                collab.get(counter).setPreferredSize(new Dimension(200, 26));

                //On les ajoute dans une ArrayList
                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 6+counter;
                panelCreateProjet.add(collab.get(counter),gridBagConstraints[0]);

                //On change la position de l'icone qui permet d'ajouter plusieurs collaborateurs
                //Pour pouvoir avoir l'icone tout le temps en bas de JTextField
                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 7+counter;
                panelCreateProjet.add(addColab, gridBagConstraints[0]);
                counter++;
                panelCreateProjet.repaint();

            }
        });

        //On ajoute la ArrayList dans le panel
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 7;
        panelCreateProjet.add(addColab, gridBagConstraints[0]);

        //On va créer un ScrollPane pour afficher l'ArrayList dans le panel
        scroll = new JScrollPane(panelCreateProjet);

        //Ajouter les collab dans le ScrollPane
        top.add(scroll);

        //Définir les propriétés du Panel à droite
        panelRight.setMaximumSize(new Dimension(281, 396));
        panelRight.setMinimumSize(new Dimension(281, 396));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBackground(new Color(255,255,255));

        //Définir les Paramètres du Panel qui va contenir le Logo
        panelLogo.setMaximumSize(new Dimension(281, 50));
        panelLogo.setMinimumSize(new Dimension(281, 50));
        panelLogo.setPreferredSize(new Dimension(281, 50));
        panelLogo.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Définir le Logo
        jLabel1.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));
        panelLogo.add(jLabel1);
        panelLogo.setBackground(new Color(237, 246, 249));

        //Ajouter le PanelLogo panelRigth
        panelRight.add(panelLogo);

        //Créer lePanel qui va prendre un code pour pouvoir nous connecter dans la BD
        panelProjet.setLayout(new GridBagLayout());

        //Le Titre du panelProjet
        projExistant.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        projExistant.setText("Projet existant");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 0;
        gridBagConstraints[0].ipady = 50;
        gridBagConstraints[0].anchor = GridBagConstraints.PAGE_START;
        panelProjet.add(projExistant, gridBagConstraints[0]);

        //Le TextField qui pend le code permettant de nous ajouter nous même dans un projet
        codeProjet.setText("");
        codeProjet.setMaximumSize(new Dimension(200, 26));
        codeProjet.setMinimumSize(new Dimension(200, 26));
        codeProjet.setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        panelProjet.add(codeProjet, gridBagConstraints[0]);

        //Sous-titre du panelRigth
        code.setText("Code projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].ipady = 20;
        panelProjet.add(code, gridBagConstraints[0]);
        panelProjet.setBackground(new Color(237, 246, 249));
        panelRight.add(panelProjet);

        //Ajout de panelRigth au panel top
        top.add(panelRight);

        //Ajout du Panel top au pane
        getContentPane().add(top);

        //Création du Panel qui va être affiché en bas
        bottom.setMaximumSize(new Dimension(562, 54));
        bottom.setMinimumSize(new Dimension(562, 54));
        bottom.setPreferredSize(new Dimension(562, 54));
        bottom.setLayout(new GridBagLayout());

        //Création du bouton valider
        valider.setText("Valider");
        valider.setMaximumSize(new Dimension(100, 30));
        valider.setMinimumSize(new Dimension(100, 30));
        valider.setName(""); // NOI18N
        valider.setPreferredSize(new Dimension(100, 30));
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        bottom.add(valider, new GridBagConstraints());

        //Ajout du panel bottom dans le pane
        getContentPane().add(bottom);

        //Fixer la dimension de la fenêtre
        setResizable(false);

        pack();
    }

    /** Ajouter les collaborateurs et le projet  dans la BD
     */
    private void validerActionPerformed(java.awt.event.ActionEvent evt) {

        //Ajout des collaborateurs
        ArrayList <String> nomColabString = new ArrayList<String>();
        if(!nom.getText().equals("")) {
            for (int i = 0; i <= counter; i++) {
                if (!collab.get(i).getText().equals("")) {
                    System.out.println(collab.get(i).getText());
                    nomColabString.add(collab.get(i).getText());
                    //On va effacer le JTextField après l'avoir mis dans une ArrayList
                    collab.get(i).setText("");
                }
            }
            if (!nomColabString.contains(user.getUsername())) {
                nomColabString.add(user.getUsername());
            }
            user.createProject(nom.getText(), nomColabString);
        }

        // Vérification du code du projet;
        if(!codeProjet.getText().equals("")){
            new Code(codeProjet.getText()).codeCompare(codeProjet.getText(), user);
            user.updateProjets();
            listeProjets.updateListeProjet();
            codeProjet.setText("");
            this.dispose();
        }

    }

    // Déclaration des variables
    private javax.swing.JPanel panelProjet;
    private javax.swing.JPanel bottom;
    private javax.swing.JLabel code;
    private javax.swing.JTextField codeProjet;
    private ArrayList <JTextField> collab;
    private javax.swing.JLabel collaborateur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel addColab;
    private javax.swing.JPanel panelCreateProjet;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel panelRight;
    private javax.swing.JTextField nom;
    private javax.swing.JLabel nomProjet;
    private javax.swing.JLabel nouveauProjet;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JLabel projExistant;
    private javax.swing.JPanel top;
    private javax.swing.JButton valider;
    private int counter;
}
