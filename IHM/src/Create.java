/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vetegan
 */
public class Create extends javax.swing.JFrame {

    Client user;

    public Create(Client user) {
        this.user=user;
        initComponents();
    }

    /** Initialisation
     * @return void
     */
    private void initComponents() {
        final GridBagConstraints[] gridBagConstraints = new GridBagConstraints[1];

        //Initialisation des components
        top = new JPanel();
        panelCreateProjet = new JPanel();
        nouveauProjet = new JLabel();
        collaborateur = new JLabel();
        nomProjet = new JLabel();
        nom = new JTextField();
        panelRigth = new JPanel();
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


        //Definir la dimension dela fenetre et la position
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setMaximumSize(new Dimension(562,450));
        getContentPane().setMinimumSize(new Dimension(562,450));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 562/ 2),
                (int) (dimension.getHeight() / 2 - 450 / 2));

        //Definir la dimension et layout du panel Top
        top.setMaximumSize(new Dimension(562, 396));
        top.setMinimumSize(new Dimension(562, 396));
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

        //Definir le layout du panel a gauche
        panelCreateProjet.setLayout(new GridBagLayout());

        //Definir le titre Nouveau Projet
        nouveauProjet.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        nouveauProjet.setText("NOUVEAU PROJET");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].ipady = 50;
        panelCreateProjet.add(nouveauProjet, gridBagConstraints[0]);

        //Definir le titre du soutitre Collaboratur
        collaborateur.setText("COLLABORATEUR");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 4;
        gridBagConstraints[0].ipady = 20;
        panelCreateProjet.add(collaborateur, gridBagConstraints[0]);

        //Definir le JLabel Nom Projet
        nomProjet.setText("Nom du projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].fill = GridBagConstraints.VERTICAL;
        gridBagConstraints[0].ipady = 20;
        panelCreateProjet.add(nomProjet, gridBagConstraints[0]);
        panelCreateProjet.setBackground(new Color(69, 123, 157));

        //Definir le JTextFiled que prend le nom du projet pour le mettre dans la BD
        nom.setText("");
        nom.setMaximumSize(new Dimension(200, 26));
        nom.setMinimumSize(new Dimension(200, 26));
        nom.setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        panelCreateProjet.add(nom, gridBagConstraints[0]);

        //Definir un ArrayList de JTextFiled de collaborateurs qu'on va mettre dans la BD
        collab.add(0, new JTextField(""));
        collab.get(0).setMaximumSize(new Dimension(200, 26));
        collab.get(0).setMinimumSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 5;
        panelCreateProjet.add(collab.get(0), gridBagConstraints[0]);

        //Creer le JLabel qui permet de creer plusieurs JTextFiled pour ajouter plusieurs Collab
        addColab = new JLabel();
        addColab.setHorizontalAlignment(JLabel.CENTER);
        addColab.setPreferredSize(new Dimension(200, 40));
        addColab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addColab.setHorizontalAlignment(SwingConstants.LEFT);
        addColab.setIcon(new ImageIcon(this.getClass().getResource("add.png")));

        //Backgound de pane
        getContentPane().setBackground(new Color(237, 246, 249));

        //MouseListener pour Add qui vais afhicher un text quand on passe le mouse en desous
        //Il va creer des JtextFiled quand on click pour pouvoir ajouter plusieurs collab
        addColab.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                addColabMouseExited(evt);
            }

            private void addColabMouseExited(MouseEvent evt) {
                addColab.setText("");
            }

            public void mouseEntered(MouseEvent evt) {
                addColabMouseEntered(evt);
            }

            private void addColabMouseEntered(MouseEvent evt) {
                addColab.setText(" Plus collaborateurs");
            }

            public void mouseClicked(MouseEvent e) {

                //On creer les JTextFiled
                collab.add(counter, new JTextField(""));
                collab.get(counter).setMaximumSize(new Dimension(200, 26));
                collab.get(counter).setMinimumSize(new Dimension(200, 26));
                collab.get(counter).setPreferredSize(new Dimension(200, 26));

                //On les ajoute dans un ArrayList
                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 6+counter;
                panelCreateProjet.add(collab.get(counter),gridBagConstraints[0]);

                //On change la position d'icon qui permet d'ajouter plusieurs collaboratuers
                //Pour pouvoir avoir l'icon tout les temps en bas de JTextFiled
                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 7+counter;
                panelCreateProjet.add(addColab, gridBagConstraints[0]);
                counter++;
                panelCreateProjet.repaint();

            }
        });

        //On ajout le ArrayList dans le panel
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 7;
        panelCreateProjet.add(addColab, gridBagConstraints[0]);

        //On vais creer un ScrollPane pour aficher ça
        scroll = new JScrollPane(panelCreateProjet);

        //Ajouter les collab dans le ScrollPane
        top.add(scroll);

        //Definir les propoiets du Panel a droite
        panelRigth.setMaximumSize(new Dimension(281, 396));
        panelRigth.setMinimumSize(new Dimension(281, 396));
        panelRigth.setLayout(new BoxLayout(panelRigth, BoxLayout.Y_AXIS));
        panelRigth.setBackground(new Color(255,255,255));

        //Definir les Parametres du Panel qui va contenir le Logo
        panelLogo.setMaximumSize(new Dimension(281, 50));
        panelLogo.setMinimumSize(new Dimension(281, 50));
        panelLogo.setPreferredSize(new Dimension(281, 50));
        panelLogo.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Definir le Logo
        jLabel1.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));
        panelLogo.add(jLabel1);
        panelLogo.setBackground(new Color(237, 246, 249));

        //Ajouter le PanelLogo panelRigth
        panelRigth.add(panelLogo);

        //Creer lePanel qui vais prendre un code pour pouvoir nous connecter dans la BD
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

        //Le TextFiled qui pend le code qui permet de nous ajouter nous meme dans un projet
        codeProjet.setText("");
        codeProjet.setMaximumSize(new Dimension(200, 26));
        codeProjet.setMinimumSize(new Dimension(200, 26));
        codeProjet.setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        panelProjet.add(codeProjet, gridBagConstraints[0]);

        //Soutitre du panelRigth
        code.setText("Code projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].ipady = 20;
        panelProjet.add(code, gridBagConstraints[0]);
        panelProjet.setBackground(new Color(237, 246, 249));
        panelRigth.add(panelProjet);

        //Ajout de panelRigth au panel top
        top.add(panelRigth);

        //Ajout du Panel top au pane
        getContentPane().add(top);

        //Creation du Panel qui vais etre aficher en bas
        bottom.setMaximumSize(new Dimension(562, 54));
        bottom.setMinimumSize(new Dimension(562, 54));
        bottom.setPreferredSize(new Dimension(562, 54));
        bottom.setLayout(new GridBagLayout());

        //Creation de bouton valider
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

        //Ajout le panel bottom in the pane
        getContentPane().add(bottom);

        //Fixer la dimension de la fenetre
        setResizable(false);

        pack();
    }

    /** Ajouter les collaborateurs et le projet  dans la BD
     * @return void
     */
    private void validerActionPerformed(java.awt.event.ActionEvent evt) {

        ArrayList <String> nomColabString = new ArrayList<String>();
        for(int i=0;i<=counter;i++){
            if(!collab.get(i).getText().equals("")){
                System.out.println(collab.get(i).getText());
                nomColabString.add(collab.get(i).getText());
            }
        }
        if (!nomColabString.contains(user.getUsername())) {
            nomColabString.add(user.getUsername());
        }
        user.createProject(nom.getText(),nomColabString);

        // Verifier le code du projet;
        if(!codeProjet.getText().equals("")){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String dateVerif = dateFormat.format(new Date());
            new Code(codeProjet.getText(),dateVerif).codeCompare(codeProjet.getText(), user);
            this.dispose();
        }

    }

    // Declaration des variables
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
    private javax.swing.JPanel panelRigth;
    private javax.swing.JTextField nom;
    private javax.swing.JLabel nomProjet;
    private javax.swing.JLabel nouveauProjet;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JLabel projExistant;
    private javax.swing.JPanel top;
    private javax.swing.JButton valider;
    private int counter;
}
