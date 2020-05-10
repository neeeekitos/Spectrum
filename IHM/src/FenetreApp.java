/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author vetegan
 */
public class FenetreApp extends JFrame {
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
        EventQueue.invokeLater(new Runnable() {
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

        panel1 = new JPanel();
        exitButton = new JButton();
        panelCalendar = new JPanel();
        name = new JLabel();
        username = new JLabel();
        panelCentral = new Panel();
        jPanel1 = new JPanel();
        projectName = new JLabel();
        scrollMessages = new ScrollPane();
        PanelSend = new JPanel();
        send = new JLabel();
        jTextField1 = new RoundJTextField(20);
        attach = new JLabel();
        panel_rigth = new JPanel();
        jLabel3 = new JLabel();
        logo_image = new JLabel();
        spectrum = new JLabel();
        projet = new JLabel();
        ajouterColab = new JButton();
        msgArea = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        this.setMinimumSize(new Dimension(1150, 810));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 1150/ 2),
                (int) (dimension.getHeight() / 2 - 810 / 2));

        panel1.setBackground(new Color(26, 49, 81));
        panel1.setMaximumSize(new Dimension(80, 1800));
        panel1.setMinimumSize(new Dimension(80, 800));
        panel1.setPreferredSize(new Dimension(80, 800));
        panel1.setRequestFocusEnabled(false);
        panel1.setLayout(new BorderLayout(10, 750));

        exitButton.setIcon(new ImageIcon(this.getClass().getResource("exit.jpeg")));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        panel1.add(exitButton,BorderLayout.PAGE_END);

        getContentPane().add(panel1);

        panelCalendar.setBackground(new Color(69, 123, 157));
        panelCalendar.setMaximumSize(new Dimension(180, 800));
        panelCalendar.setMinimumSize(new Dimension(180, 800));
        panelCalendar.setPreferredSize(new Dimension(180, 800));
        panelCalendar.setLayout(new BoxLayout(panelCalendar, BoxLayout.Y_AXIS));

        panelCalendar.add(Box.createRigidArea(new Dimension(0,60)));

        name.setFont(new Font("Arial", 1, 18)); // NOI18N
        name.setText(user.getNom()+" "+user.getPrenom());
        panelCalendar.add(name);


        username.setText("@"+user.getUsername());
        panelCalendar.add(username);
        panelCalendar.add(Box.createRigidArea(new Dimension(0,70)));


        /*GroupLayout panelCalendarLayout = new GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
                panelCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelCalendarLayout.createSequentialGroup()
                                                .addComponent(username)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.LEADING, panelCalendarLayout.createSequentialGroup()
                                                .addComponent(name)
                                                .addContainerGap())))
        );
        panelCalendarLayout.setVerticalGroup(
                panelCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(name)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(username)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );*/

        getContentPane().add(panelCalendar);


        panelCentral.setPreferredSize(new Dimension(690, 800));
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new Dimension(690, 50));
        jPanel1.setMinimumSize(new Dimension(690, 50));
        jPanel1.setPreferredSize(new Dimension(690, 50));
        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(new Color(224,224,226));

        projectName.setFont(new Font("Arial", 3, 24));
        if (user.getProjets().size() != 0) {
            projectName.setText(user.getProjets().get(0).getNom());
        }
        projectName.setHorizontalAlignment(JLabel.CENTER);
        projectName.setMaximumSize(new Dimension(690, 50));
        jPanel1.add(projectName, BorderLayout.CENTER);

        panelCentral.add(jPanel1);
        panelCentral.setBackground(new Color(224,224,226));


        scrollMessages.setMinimumSize(new Dimension(690, 540));
        scrollMessages.setPreferredSize(new Dimension(690, 540));
        scrollMessages.setBackground(new Color(255,255,255));
        scrollMessages.add(msgArea);
        panelCentral.add(scrollMessages);

        PanelSend.setMaximumSize(new Dimension(690, 100));
        PanelSend.setMinimumSize(new Dimension(690, 100));
        PanelSend.setPreferredSize(new Dimension(690, 100));
        PanelSend.setBackground(new Color(224,224,226));
        PanelSend.setLayout(new BoxLayout(PanelSend, BoxLayout.LINE_AXIS));

        attach.setIcon(new ImageIcon(this.getClass().getResource("attach.png")));
        PanelSend.add(attach);
        attach.setCursor(new Cursor(Cursor.HAND_CURSOR));
        attach.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                attachMouseClicked(evt);
            }
        });

        jTextField1.setText("Tapez votre message ici");
        jTextField1.setMaximumSize(new Dimension(600, 50));
        jTextField1.setMinimumSize(new Dimension(600, 50));
        jTextField1.setPreferredSize(new Dimension(600, 50));
        jTextField1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                jTextField1.setText("");
            }
        });
        LineBorder lineBorder =new LineBorder(Color.white, 8, true);
        jTextField1.setBorder(lineBorder );

        PanelSend.add(jTextField1);


        send.setIcon(new ImageIcon(this.getClass().getResource("envoyer.png")));
        send.setCursor(new Cursor(Cursor.HAND_CURSOR));
        send.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });
        PanelSend.add(send);

        panelCentral.add(PanelSend);

        getContentPane().add(panelCentral);

        panel_rigth.setBackground(new Color(237, 246, 249));
        panel_rigth.setMaximumSize(new Dimension(200, 1800));
        panel_rigth.setMinimumSize(new Dimension(200, 800));
        panel_rigth.setPreferredSize(new Dimension(200, 800));

        logo_image.setFont(new Font("Arial", 0, 18)); // NOI18N
        logo_image.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));


        spectrum.setFont(new Font("Arial", 1, 14)); // NOI18N
        spectrum.setText("SPECTRUM");

        projet.setFont(new Font("Arial", 1, 18)); // NOI18N
        projet.setText(" Projets");
        projet.setIcon(new ImageIcon(this.getClass().getResource("droping.png")));
        projet.setCursor(new Cursor(Cursor.HAND_CURSOR));
        projet.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                projetMouseClicked(evt);
            }
        });

        ajouterColab.setText("Ajouter un colaborator");
        ajouterColab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ajouterColabMouseClicked(evt);
            }
        });

        GroupLayout panel_rigthLayout = new GroupLayout(panel_rigth);
        panel_rigth.setLayout(panel_rigthLayout);
        panel_rigthLayout.setHorizontalGroup(
                panel_rigthLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                                .addComponent(ajouterColab, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(projet))
        );
        panel_rigthLayout.setVerticalGroup(
                panel_rigthLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logo_image)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spectrum)
                                .addGap(51, 51, 51)
                                .addComponent(ajouterColab)
                                .addGap(18, 18, 18)
                                .addComponent(projet)
                                .addContainerGap(592, Short.MAX_VALUE))
        );


        //Layout  background
        JLabel colab = new JLabel("Collaborateurs:",JLabel.LEFT);
        //colab.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        colab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        //colab.setMaximumSize(new java.awt.Dimension(180, 30));
        //colab.setMinimumSize(new java.awt.Dimension(180, 30));
        //colab.setPreferredSize(new java.awt.Dimension(180, 30));

        panelCalendar.add(colab, Component.LEFT_ALIGNMENT);
        panelCalendar.add(Box.createRigidArea(new Dimension(0,10)));



        DefaultListModel listModel = new DefaultListModel();


        for(int j=0; j<(user.getProjectByName(projectName.getText()).getArrayCollaborateurs().size());j++) {
            listModel.add(j,user.getProjectByName(projectName.getText()).getArrayCollaborateurs().get(j));
        }

        b = new JList(listModel);
        p = new JPanel();
    //    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        b.setSelectedIndex(0);
        b.setBackground(new Color(69, 123, 157));

        p.setBackground(new Color(69, 123, 157));
        p.add(b);
        //p.setBorder(BorderFactory.createLineBorder(Color.red, 5));

        panelCalendar.add(p,Component.LEFT_ALIGNMENT); //


        getContentPane().add(panel_rigth);

        pack();
    }// </editor-fold>

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //changer
        System.exit(0);
    }

    private void ajouterColabMouseClicked(java.awt.event.MouseEvent evt) {
        new Ajouter().setVisible(true);
    }

    private void attachMouseClicked(java.awt.event.MouseEvent evt) {
        JFileChooser fileChooser =  new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( " 4 Extensions Supported", "jpg", "png", "jpeg", "gif");
        fileChooser.setFileFilter(filter);
        int selected = fileChooser.showOpenDialog(null);
        if(selected == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            String getselectedImage = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null, getselectedImage);
            ImageIcon imIcon = new ImageIcon(getselectedImage);
            //attach.setIcon(imIcon);
        }
    }


    private void sendMouseClicked(java.awt.event.MouseEvent evt) {
        String msg= jTextField1.getText();
        if (!msg.equals("")){
            if(!projectName.getText().equals("")) {
                user.sendMessage(msg, user.getProjectByName(projectName.getText()));
                msgArea.append("\r\n" + user.getUsername() + " : " + msg);
                this.repaint();
            } else {
                ImageIcon img = new ImageIcon("images/attention.png");
                JOptionPane usernameFalse = new JOptionPane();
                usernameFalse.showMessageDialog(null, "choose your project", "Attention",JOptionPane.ERROR_MESSAGE, img);
            }
        }
    }

    private void projetMouseClicked(java.awt.event.MouseEvent evt) {
        new Solve(user).setVisible(true);
    }

    public synchronized void printMsg(String msg) {
        msgArea.append(msg);
    }



    public class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

    //Declaration des variables

    private JTextArea msgArea;
    private JPanel PanelSend;
    private JButton ajouterColab;
    private JLabel  send;
    private JButton exitButton;
    private JLabel   attach;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private RoundJTextField jTextField1;
    private JLabel logo_image;
    private JLabel name;
    private JPanel panel1;
    private JPanel panelCalendar;
    private Panel panelCentral;
    private JPanel panel_rigth;
    private JLabel projectName;
    private JLabel projet;
    private ScrollPane scrollMessages;
    private JLabel spectrum;
    private JLabel username;
    private JList b;
    private JPanel p;

    // Fin de declaration des variables
}
