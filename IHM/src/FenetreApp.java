/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vetegan
 */
public class FenetreApp extends javax.swing.JFrame {
    Client user;
    /**
     * Creates new form FenetreApp2
     */
    public FenetreApp(Client user) {
        this.user=user;
        initComponents();
    }

    public static void main(String[] args){
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenetreApp(null).setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        panelCalendar = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        panelCentral = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        projectName = new javax.swing.JLabel();
        scrollMessages = new java.awt.ScrollPane();
        PanelSend = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        attach = new javax.swing.JLabel();
        panel_rigth = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        logo_image = new javax.swing.JLabel();
        spectrum = new javax.swing.JLabel();
        projet = new javax.swing.JLabel();
        ajouterColab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));
        this.setMinimumSize(new java.awt.Dimension(1150, 810));

        panel1.setBackground(new java.awt.Color(61,42,42));
        panel1.setMaximumSize(new java.awt.Dimension(80, 1800));
        panel1.setMinimumSize(new java.awt.Dimension(80, 800));
        panel1.setPreferredSize(new java.awt.Dimension(80, 800));
        panel1.setRequestFocusEnabled(false);
        panel1.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 10, 750));

        exitButton.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("exit.jpeg")));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        panel1.add(exitButton);

        getContentPane().add(panel1);

        panelCalendar.setBackground(new java.awt.Color(153,102,102));
        panelCalendar.setMaximumSize(new java.awt.Dimension(180, 1800));
        panelCalendar.setMinimumSize(new java.awt.Dimension(180, 800));
        panelCalendar.setPreferredSize(new java.awt.Dimension(180, 800));

        name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        name.setText("Nom Prenom");
        name.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                nameInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        username.setText("Username");
        username.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                usernameInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
                panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelCalendarLayout.createSequentialGroup()
                                                .addComponent(username)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCalendarLayout.createSequentialGroup()
                                                .addComponent(name)
                                                .addContainerGap())))
        );
        panelCalendarLayout.setVerticalGroup(
                panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(username)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelCalendar);

       // panelCentral.setMaximumSize(new java.awt.Dimension(690, 800));
       // panelCentral.setMinimumSize(new java.awt.Dimension(690, 800));
        panelCentral.setPreferredSize(new java.awt.Dimension(690, 800));
        panelCentral.setLayout(new javax.swing.BoxLayout(panelCentral, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(690, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(690, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.setBackground(new java.awt.Color(224,224,226));

        projectName.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        projectName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectName.setText("PROJECT");
        projectName.setMaximumSize(new java.awt.Dimension(690, 50));
        projectName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                projectNameInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel1.add(projectName, java.awt.BorderLayout.CENTER);

        panelCentral.add(jPanel1);
        panelCentral.setBackground(new java.awt.Color(224,224,226));


        scrollMessages.setMinimumSize(new java.awt.Dimension(690, 540));
        scrollMessages.setPreferredSize(new java.awt.Dimension(690, 540));
        scrollMessages.setBackground(new java.awt.Color(204,204,204));
        panelCentral.add(scrollMessages);

        PanelSend.setMaximumSize(new java.awt.Dimension(690, 100));
        PanelSend.setMinimumSize(new java.awt.Dimension(690, 100));
        PanelSend.setPreferredSize(new java.awt.Dimension(690, 100));
        PanelSend.setBackground(new java.awt.Color(224,224,226));
        PanelSend.setLayout(new javax.swing.BoxLayout(PanelSend, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("attach.jpeg")));
        PanelSend.add(jLabel1);

        jTextField1.setText("jTextField1");
        jTextField1.setMaximumSize(new java.awt.Dimension(600, 50));
        jTextField1.setMinimumSize(new java.awt.Dimension(600, 50));
        jTextField1.setPreferredSize(new java.awt.Dimension(600, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        PanelSend.add(jTextField1);


        attach.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("send.png")));
        PanelSend.add(attach);

        panelCentral.add(PanelSend);

        getContentPane().add(panelCentral);

        panel_rigth.setBackground(new java.awt.Color(255, 255, 255));
        panel_rigth.setMaximumSize(new java.awt.Dimension(200, 1800));
        panel_rigth.setMinimumSize(new java.awt.Dimension(200, 800));
        panel_rigth.setPreferredSize(new java.awt.Dimension(200, 800));

        logo_image.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        logo_image.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("triangle.png")));

        spectrum.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        spectrum.setText("SPECTRUM");

        projet.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        projet.setText(" Projets");
        projet.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("drop.png")));
        projet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projetMouseClicked(evt);
            }
        });
        projet.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                projetPropertyChange(evt);
            }
        });

        ajouterColab.setText("Ajouter un colaborator");

        javax.swing.GroupLayout panel_rigthLayout = new javax.swing.GroupLayout(panel_rigth);
        panel_rigth.setLayout(panel_rigthLayout);
        panel_rigthLayout.setHorizontalGroup(
                panel_rigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(568, 568, 568)
                                .addComponent(jLabel3))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(logo_image))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(spectrum))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(ajouterColab, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(projet))
        );
        panel_rigthLayout.setVerticalGroup(
                panel_rigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logo_image)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spectrum)
                                .addGap(51, 51, 51)
                                .addComponent(ajouterColab)
                                .addGap(18, 18, 18)
                                .addComponent(projet)
                                .addContainerGap(592, Short.MAX_VALUE))
        );

        getContentPane().add(panel_rigth);

        pack();
    }// </editor-fold>

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //changer
        System.exit(0);
    }

    private void nameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {


    }

    private void usernameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {

        // Change the username;
    }

    private void projetMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void projetPropertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO add your handling code here:
    }

    private void projectNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        // TO DO add your handling code here:
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public String printMsg(String message) {
        return message;
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JPanel PanelSend;
    private javax.swing.JButton ajouterColab;
    private javax.swing.JLabel attach;        //"Send"
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;       //"Attach"
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel logo_image;
    private javax.swing.JLabel name;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panelCalendar;
    private java.awt.Panel panelCentral;
    private javax.swing.JPanel panel_rigth;
    private javax.swing.JLabel projectName;
    private javax.swing.JLabel projet;
    private java.awt.ScrollPane scrollMessages;
    private javax.swing.JLabel spectrum;
    private javax.swing.JLabel username;
    // End of variables declaration
}
