/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

/**
 *
 * @author vetegan
 */
public class Create extends javax.swing.JFrame {

    /**
     * Creates new form Create
     */
    Client user;

    public Create(Client user) {
        this.user=user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        final GridBagConstraints[] gridBagConstraints = new GridBagConstraints[1];

        top = new JPanel();
        jPanel1 = new JPanel();
        nouveauProjet = new JLabel();
        collaborateur = new JLabel();
        nomProjet = new JLabel();
        nom = new JTextField();
        jPanel3 = new JPanel();
        panelLogo = new JPanel();
        jLabel1 = new JLabel();
        PanelProjet = new JPanel();
        projExistant = new JLabel();
        codeProjet = new JTextField();
        code = new JLabel();
        bottom = new JPanel();
        valider = new JButton();
        addColab = new JLabel();
        collab = new ArrayList<JTextField>();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setMaximumSize(new Dimension(562,450));

        getContentPane().setMinimumSize(new Dimension(562,450));
        getContentPane().setPreferredSize(new Dimension(562,450));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 562/ 2),
                (int) (dimension.getHeight() / 2 - 450 / 2));

        top.setMaximumSize(new Dimension(562, 396));
        top.setMinimumSize(new Dimension(562, 396));
        top.setPreferredSize(new Dimension(562, 396));
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new GridBagLayout());

        nouveauProjet.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        nouveauProjet.setText("NOUVEAU PROJET");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].ipady = 50;
        jPanel1.add(nouveauProjet, gridBagConstraints[0]);

        collaborateur.setText("COLLABORATEUR");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 4;
        gridBagConstraints[0].ipady = 20;
        jPanel1.add(collaborateur, gridBagConstraints[0]);

        nomProjet.setText("Nom du projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].fill = GridBagConstraints.VERTICAL;
        gridBagConstraints[0].ipady = 20;
        jPanel1.add(nomProjet, gridBagConstraints[0]);
        jPanel1.setBackground(new Color(69, 123, 157));

        nom.setText("");
        nom.setMaximumSize(new Dimension(200, 26));
        nom.setMinimumSize(new Dimension(200, 26));
        nom.setPreferredSize(new Dimension(200, 26));
        /*nom.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                nom.setText("");
            }
        });*/
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        jPanel1.add(nom, gridBagConstraints[0]);

        collab.add(0, new JTextField(""));
        collab.get(0).setMaximumSize(new Dimension(200, 26));
        collab.get(0).setMinimumSize(new Dimension(200, 26));
        collab.get(0).setPreferredSize(new Dimension(200, 26));

        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 5;
        jPanel1.add(collab.get(0), gridBagConstraints[0]);

        addColab = new JLabel();
        addColab.setHorizontalAlignment(JLabel.CENTER);
        addColab.setPreferredSize(new Dimension(200, 40));
        addColab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addColab.setHorizontalAlignment(SwingConstants.LEFT);
        addColab.setIcon(new ImageIcon(this.getClass().getResource("add.png")));

        getContentPane().setBackground(new Color(237, 246, 249));

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
                collab.add(counter, new JTextField(""));
                collab.get(counter).setMaximumSize(new Dimension(200, 26));
                collab.get(counter).setMinimumSize(new Dimension(200, 26));
                collab.get(counter).setPreferredSize(new Dimension(200, 26));

                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 6+counter;
                jPanel1.add(collab.get(counter),gridBagConstraints[0]);

                gridBagConstraints[0] = new GridBagConstraints();
                gridBagConstraints[0].gridx = 0;
                gridBagConstraints[0].gridy = 7+counter;
                jPanel1.add(addColab, gridBagConstraints[0]);
                /*collab.get(counter).addFocusListener(new FocusAdapter() {
                    public void focusGained(FocusEvent e) {
                        collab.get(counter).setText("");
                    }
                });*/
                counter++;
                jPanel1.repaint();

            }
        });
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 7;
        jPanel1.add(addColab, gridBagConstraints[0]);


        scroll = new JScrollPane(jPanel1);


        top.add(scroll);


        jPanel3.setMaximumSize(new Dimension(281, 396));
        jPanel3.setMinimumSize(new Dimension(281, 396));
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
        jPanel3.setBackground(new Color(255,255,255));

        panelLogo.setMaximumSize(new Dimension(281, 50));
        panelLogo.setMinimumSize(new Dimension(281, 50));
        panelLogo.setPreferredSize(new Dimension(281, 50));
        panelLogo.setLayout(new FlowLayout(FlowLayout.RIGHT));

        jLabel1.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));
        panelLogo.add(jLabel1);
        panelLogo.setBackground(new Color(237, 246, 249));

        jPanel3.add(panelLogo);

        PanelProjet.setLayout(new GridBagLayout());

        projExistant.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        projExistant.setText("Projet existant");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 0;
        gridBagConstraints[0].ipady = 50;
        gridBagConstraints[0].anchor = GridBagConstraints.PAGE_START;
        PanelProjet.add(projExistant, gridBagConstraints[0]);

        codeProjet.setText("");
        codeProjet.setMaximumSize(new Dimension(200, 26));
        codeProjet.setMinimumSize(new Dimension(200, 26));
        codeProjet.setPreferredSize(new Dimension(200, 26));
        /*codeProjet.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                codeProjet.setText("");
            }
        });*/

        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        PanelProjet.add(codeProjet, gridBagConstraints[0]);

        code.setText("Code projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].ipady = 20;
        PanelProjet.add(code, gridBagConstraints[0]);
        PanelProjet.setBackground(new Color(237, 246, 249));

        jPanel3.add(PanelProjet);

        top.add(jPanel3);

        getContentPane().add(top);

        bottom.setMaximumSize(new Dimension(562, 54));
        bottom.setMinimumSize(new Dimension(562, 54));
        bottom.setPreferredSize(new Dimension(562, 54));
        bottom.setLayout(new GridBagLayout());

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

        getContentPane().add(bottom);
        setResizable(false);
        pack();
    }// </editor-fold>

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
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel PanelProjet;
    private javax.swing.JPanel bottom;
    private javax.swing.JLabel code;
    private javax.swing.JTextField codeProjet;
    private ArrayList <JTextField> collab;
    private javax.swing.JLabel collaborateur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel addColab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nom;
    private javax.swing.JLabel nomProjet;
    private javax.swing.JLabel nouveauProjet;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JLabel projExistant;
    private javax.swing.JPanel top;
    private javax.swing.JButton valider;
    private int counter;
    // End of variables declaration
}
