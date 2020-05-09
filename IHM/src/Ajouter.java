/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author vetegan
 */
public class Ajouter extends JFrame {

    /**
     * Creates new form Ajouter
     */
    public Ajouter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        this.setMaximumSize(new Dimension(562,450));
        this.setMinimumSize(new Dimension(562,450));
        this.setPreferredSize(new Dimension(562,450));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 562/ 2),
                (int) (dimension.getHeight() / 2 - 450 / 2));

        top.setMaximumSize(new Dimension(562, 396));
        top.setMinimumSize(new Dimension(562, 396));
        top.setPreferredSize(new Dimension(562, 396));
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new GridBagLayout());

        collaborateur.setFont(new Font("Lucida Grande", 1, 18)); // NOI18N
        collaborateur.setText("Collaborateurs");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].ipady = 50;
        jPanel1.add(collaborateur, gridBagConstraints[0]);

        collab.add(0, new JTextField(""));
        collab.get(0).setMaximumSize(new Dimension(200, 26));
        collab.get(0).setMinimumSize(new Dimension(200, 26));
        collab.get(0).setPreferredSize(new Dimension(200, 26));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        jPanel1.add(collab.get(0), gridBagConstraints[0]);

        addColab = new JLabel();
        addColab.setHorizontalAlignment(JLabel.CENTER);
        addColab.setPreferredSize(new Dimension(200, 40));
        addColab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addColab.setHorizontalAlignment(SwingConstants.LEFT);
        addColab.setIcon(new ImageIcon(this.getClass().getResource("add.png")));
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 7;
        jPanel1.add(addColab, gridBagConstraints[0]);

        jPanel1.setBackground(new Color(69, 123, 157));

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
                addColab.setText(" Plus colaborateurs");
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

        scroll = new JScrollPane(jPanel1);
        scroll.setBackground(new Color(69, 123, 157));
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
        projExistant.setText("Créer un code pour le projet");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 0;
        gridBagConstraints[0].ipady = 50;
        gridBagConstraints[0].anchor = GridBagConstraints.PAGE_START;
        PanelProjet.add(projExistant, gridBagConstraints[0]);

        codeProjet.setText("...");
        codeProjet.setMaximumSize(new Dimension(200, 26));
        codeProjet.setMinimumSize(new Dimension(200, 26));
        codeProjet.setPreferredSize(new Dimension(200, 26));
       /* codeProjet.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                codeProjet.setText("");
            }
        });*/

        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 2;
        PanelProjet.add(codeProjet, gridBagConstraints[0]);

        code.setText("Le code va expirer dans 10 minutes");
        gridBagConstraints[0] = new GridBagConstraints();
        gridBagConstraints[0].gridx = 0;
        gridBagConstraints[0].gridy = 1;
        gridBagConstraints[0].ipady = 20;
        PanelProjet.add(code, gridBagConstraints[0]);
        PanelProjet.setBackground(new Color(237, 246, 249));
        jPanel3.add(PanelProjet);

        top.add(jPanel3);

        getContentPane().add(top);

        bottom.setMaximumSize(new Dimension(562, 30));
        bottom.setMinimumSize(new Dimension(562, 30));
        bottom.setPreferredSize(new Dimension(562, 30));
        bottom.setLayout(new GridBagLayout());

        valider.setText("Valider");
        valider.setMaximumSize(new Dimension(100, 30));
        valider.setMinimumSize(new Dimension(100, 30));
        valider.setPreferredSize(new Dimension(100, 30));
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                validerActionPerformed(evt);
            }

            private void validerActionPerformed(ActionEvent evt) {
                //Ajouter client
            }
        });
        bottom.add(valider, new GridBagConstraints());

        getContentPane().add(bottom);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajouter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton valider;
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
    private int counter;
    // End of variables declaration//GEN-END:variables
}
