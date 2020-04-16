/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        valider = new javax.swing.JButton();
        collab = new javax.swing.JLabel();
        nomColab = new javax.swing.JTextField();
        collaborateur = new javax.swing.JLabel();
        nomProj = new javax.swing.JLabel();
        nameProjet = new javax.swing.JTextField();
        nouveauProjet = new javax.swing.JLabel();
        projExistant = new javax.swing.JLabel();
        codeProjet = new javax.swing.JTextField();
        logo_image = new javax.swing.JLabel();
        ou = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(492, 357));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        valider.setText("Valider");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 18, 27, 0);
        getContentPane().add(valider, gridBagConstraints);

        collab.setText("Ajouter un collaborateur");
        collab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        collab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                collabMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 51, 0, 0);
        getContentPane().add(collab, gridBagConstraints);

        nomColab.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 210;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 68, 0, 69);
        getContentPane().add(nomColab, gridBagConstraints);

        collaborateur.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        collaborateur.setText("COLLABORATEUR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 122, 0, 0);
        getContentPane().add(collaborateur, gridBagConstraints);

        nomProj.setText("Nom du projet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 46, 0, 0);
        getContentPane().add(nomProj, gridBagConstraints);

        nameProjet.setText("...");
        nameProjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameProjetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 210;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 68, 0, 69);
        getContentPane().add(nameProjet, gridBagConstraints);

        nouveauProjet.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        nouveauProjet.setText("NOUVEAU PROJET");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(44, 126, 0, 0);
        getContentPane().add(nouveauProjet, gridBagConstraints);

        projExistant.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        projExistant.setText("Code de projet existant");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 93, 0, 0);
        getContentPane().add(projExistant, gridBagConstraints);

        codeProjet.setText("....");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 228;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 93, 0, 0);
        getContentPane().add(codeProjet, gridBagConstraints);

        logo_image.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        logo_image.setIcon(new javax.swing.ImageIcon("/Users/vetegan/Desktop/Clase online/Algo/triangle logo Spectrum.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 22, 0, 0);
        getContentPane().add(logo_image, gridBagConstraints);

        ou.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ou.setText("OU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 46, 0, 0);
        getContentPane().add(ou, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void collabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_collabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_collabMouseClicked

    private void nameProjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameProjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameProjetActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeProjet;
    private javax.swing.JLabel collab;
    private javax.swing.JLabel collaborateur;
    private javax.swing.JLabel logo_image;
    private javax.swing.JTextField nameProjet;
    private javax.swing.JTextField nomColab;
    private javax.swing.JLabel nomProj;
    private javax.swing.JLabel nouveauProjet;
    private javax.swing.JLabel ou;
    private javax.swing.JLabel projExistant;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
