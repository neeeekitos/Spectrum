/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author vetegan
 */
public class Create extends javax.swing.JFrame {

    /**
     * Creates new form Create
     */
    public Create() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        top = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nouveauProjet = new javax.swing.JLabel();
        collaborateur = new javax.swing.JLabel();
        nomProjet = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        collab = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        panelLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelProjet = new javax.swing.JPanel();
        projExistant = new javax.swing.JLabel();
        codeProjet = new javax.swing.JTextField();
        code = new javax.swing.JLabel();
        bottom = new javax.swing.JPanel();
        valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));
        this.setMaximumSize(new java.awt.Dimension(562,450));
        this.setMinimumSize(new java.awt.Dimension(562,450));
        this.setPreferredSize(new java.awt.Dimension(562,450));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 562/ 2),
                (int) (dimension.getHeight() / 2 - 450 / 2));

        top.setMaximumSize(new java.awt.Dimension(562, 396));
        top.setMinimumSize(new java.awt.Dimension(562, 396));
        top.setPreferredSize(new java.awt.Dimension(562, 396));
        top.setLayout(new javax.swing.BoxLayout(top, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(281, 396));
        jPanel1.setMinimumSize(new java.awt.Dimension(281, 396));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        nouveauProjet.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        nouveauProjet.setText("NOUVEAU PROJET");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 50;
        jPanel1.add(nouveauProjet, gridBagConstraints);

        collaborateur.setText("COLLABORATEUR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 20;
        jPanel1.add(collaborateur, gridBagConstraints);

        nomProjet.setText("Nom du projet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 20;
        jPanel1.add(nomProjet, gridBagConstraints);
        jPanel1.setBackground(new Color(69, 123, 157));

        nom.setText("....");
        nom.setMaximumSize(new java.awt.Dimension(200, 26));
        nom.setMinimumSize(new java.awt.Dimension(200, 26));
        nom.setPreferredSize(new java.awt.Dimension(200, 26));
        nom.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                nom.setText("");
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel1.add(nom, gridBagConstraints);

        collab.setText("....");
        collab.setMaximumSize(new java.awt.Dimension(200, 26));
        collab.setMinimumSize(new java.awt.Dimension(200, 26));
        collab.setPreferredSize(new java.awt.Dimension(200, 26));
        collab.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                collab.setText("");
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(collab, gridBagConstraints);

        top.add(jPanel1);

        jPanel3.setMaximumSize(new java.awt.Dimension(281, 396));
        jPanel3.setMinimumSize(new java.awt.Dimension(281, 396));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        jPanel3.setBackground(new Color(255,255,255));

        panelLogo.setMaximumSize(new java.awt.Dimension(281, 50));
        panelLogo.setMinimumSize(new java.awt.Dimension(281, 50));
        panelLogo.setPreferredSize(new java.awt.Dimension(281, 50));
        panelLogo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));
        panelLogo.add(jLabel1);
        panelLogo.setBackground(new Color(237, 246, 249));

        jPanel3.add(panelLogo);

        PanelProjet.setLayout(new java.awt.GridBagLayout());

        projExistant.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        projExistant.setText("Projet existant");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        PanelProjet.add(projExistant, gridBagConstraints);

        codeProjet.setText("....");
        codeProjet.setMaximumSize(new java.awt.Dimension(200, 26));
        codeProjet.setMinimumSize(new java.awt.Dimension(200, 26));
        codeProjet.setPreferredSize(new java.awt.Dimension(200, 26));
        codeProjet.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                codeProjet.setText("");
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        PanelProjet.add(codeProjet, gridBagConstraints);

        code.setText("Code projet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        PanelProjet.add(code, gridBagConstraints);
        PanelProjet.setBackground(new Color(237, 246, 249));

        jPanel3.add(PanelProjet);

        top.add(jPanel3);

        getContentPane().add(top);

        bottom.setMaximumSize(new java.awt.Dimension(562, 30));
        bottom.setMinimumSize(new java.awt.Dimension(562, 30));
        bottom.setPreferredSize(new java.awt.Dimension(562, 30));
        bottom.setLayout(new java.awt.GridBagLayout());

        valider.setText("Valider");
        valider.setMaximumSize(new java.awt.Dimension(100, 30));
        valider.setMinimumSize(new java.awt.Dimension(100, 30));
        valider.setName(""); // NOI18N
        valider.setPreferredSize(new java.awt.Dimension(100, 30));
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        bottom.add(valider, new java.awt.GridBagConstraints());

        getContentPane().add(bottom);

        pack();
    }// </editor-fold>

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel PanelProjet;
    private javax.swing.JPanel bottom;
    private javax.swing.JLabel code;
    private javax.swing.JTextField codeProjet;
    private javax.swing.JTextField collab;
    private javax.swing.JLabel collaborateur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nom;
    private javax.swing.JLabel nomProjet;
    private javax.swing.JLabel nouveauProjet;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JLabel projExistant;
    private javax.swing.JPanel top;
    private javax.swing.JButton valider;
    // End of variables declaration
}
