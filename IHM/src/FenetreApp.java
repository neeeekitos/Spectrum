
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author vetegan
 */
public class FenetreApp extends JFrame {

    protected Client user;

    public FenetreApp(Client user) {
        this.user=user;
        initComponents();
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenetreApp(null).setVisible(true);
            }
        });
    }

    /** Initialisation
     * @return void
     */
    private void initComponents() {

        //Initialisation des variables
        panelExit = new JPanel();
        exitButton = new JButton();
        panelUtilisateur = new JPanel();
        name = new JLabel();
        username = new JLabel();
        panelCentral = new Panel();
        panelNomProjet = new JPanel();
        projectName = new JLabel();
        panelSend = new JPanel();
        send = new JLabel();
        messageTextFiled = new RoundJTextField(20);
        panelRigth = new JPanel();
        logoImage = new JLabel();
        spectrum = new JLabel();
        projet = new JLabel();
        ajouterColab = new JButton();
        msgArea = new JTextArea();

        //Ajout des parametres et position pour la ferentre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        this.setPreferredSize(new Dimension(1170, 810));
        this.setMinimumSize(new Dimension(1170, 810));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 1150/ 2),
                (int) (dimension.getHeight() / 2 - 810 / 2));


        //Creation du panel  qui contient le bouton exit
        panelExit.setBackground(new Color(26, 49, 81));
        panelExit.setMaximumSize(new Dimension(80, 1800));
        panelExit.setMinimumSize(new Dimension(80, 800));
        panelExit.setPreferredSize(new Dimension(80, 800));
        panelExit.setRequestFocusEnabled(false);
        panelExit.setLayout(new BorderLayout(10, 750));

        //creation du button exit
        exitButton.setIcon(new ImageIcon(this.getClass().getResource("exit.jpeg")));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        panelExit.add(exitButton,BorderLayout.PAGE_END);

        //Ajouter le panelExit au pane
        getContentPane().add(panelExit);

        //Creer le panel avec les information d'utilisateur et de colaborateurs
        panelUtilisateur.setBackground(new Color(69, 123, 157));
        panelUtilisateur.setMaximumSize(new Dimension(200, 2000));
        panelUtilisateur.setMinimumSize(new Dimension(200, 800));
        panelUtilisateur.setLayout(new BoxLayout(panelUtilisateur, BoxLayout.Y_AXIS));
        panelUtilisateur.add(Box.createRigidArea(new Dimension(0,60)));

        //Afficher le nom et prenom du utilisateur
        name.setFont(new Font("Arial", 1, 18)); // NOI18N
        name.setText(user.getNom()+" "+user.getPrenom());
        panelUtilisateur.add(name);

        //Afficher le username d'utilisateur
        username.setText("@"+user.getUsername());
        panelUtilisateur.add(username);
        panelUtilisateur.add(Box.createRigidArea(new Dimension(0,70)));
        getContentPane().add(panelUtilisateur);

        //Creation du panel central
        panelCentral.setPreferredSize(new Dimension(690, 800));
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        //Panel en haut ou on afiche le nom du projet actif
        panelNomProjet.setMaximumSize(new Dimension(690, 50));
        panelNomProjet.setMinimumSize(new Dimension(690, 50));
        panelNomProjet.setPreferredSize(new Dimension(690, 50));
        panelNomProjet.setLayout(new BorderLayout());
        panelNomProjet.setBackground(new Color(224,224,226));

        //Prendre le nom du projet actif
        projectName.setFont(new Font("Arial", 3, 24));
        if (user.getProjets().size() != 0) {
            projectName.setText(user.getProjets().get(0).getNom());
        } else {
            projectName.setText("");
        }
        projectName.setHorizontalAlignment(JLabel.CENTER);
        projectName.setMaximumSize(new Dimension(690, 50));
        panelNomProjet.add(projectName, BorderLayout.CENTER);

        //Ajour du panel du nom au panel central
        panelCentral.add(panelNomProjet);
        panelCentral.setBackground(new Color(224,224,226));

        //Creation de scroll panel avec des messages
        addedItems = new MessageListModel();
        list = new JList(addedItems);
        list.setCellRenderer(new ListItemRenderer());
        list.ensureIndexIsVisible(list.getLastVisibleIndex());

        scrollMessages = new JScrollPane(list);
        scrollMessages.setMinimumSize(new Dimension(690, 540));
        scrollMessages.setPreferredSize(new Dimension(690, 540));
        scrollMessages.setBackground(new Color(255,255,255));
        scrollMessages.add(msgArea);
        panelCentral.add(scrollMessages);

        //Creatin de panel ou on peut ecrire et envoye les messages
        panelSend.setMaximumSize(new Dimension(690, 50));
        panelSend.setMinimumSize(new Dimension(690, 50));
        panelSend.setPreferredSize(new Dimension(690, 50));
        panelSend.setBackground(new Color(224,224,226));
        panelSend.setLayout(new BoxLayout(panelSend, BoxLayout.LINE_AXIS));

        //Le text filed ou on peut ecrire nos messages
        messageTextFiled.setText("Tapez votre message ici");
        messageTextFiled.setMaximumSize(new Dimension(620, 30));
        messageTextFiled.setMinimumSize(new Dimension(620, 30));
        messageTextFiled.setPreferredSize(new Dimension(620, 30));
        messageTextFiled.setSize(600, 30);
        messageTextFiled.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                messageTextFiled.setText("");
            }
        });
        LineBorder lineBorder =new LineBorder(Color.white, 8, true);
        //jTextField1.setBorder(lineBorder );
        panelSend.add(messageTextFiled);

        //Le Icon sur laquelle on doit appuye pour envoye les messages
        send.setIcon(new ImageIcon(this.getClass().getResource("envoyer.png")));
        send.setCursor(new Cursor(Cursor.HAND_CURSOR));
        send.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });
        panelSend.add(send);

        //L'ajout du panelSend au panelCentral
        panelCentral.add(panelSend);
        getContentPane().add(panelCentral);

        //Creation du panel_rigth
        panelRigth.setBackground(new Color(237, 246, 249));
        panelRigth.setMaximumSize(new Dimension(200, 1800));
        panelRigth.setMinimumSize(new Dimension(200, 800));
        panelRigth.setPreferredSize(new Dimension(200, 800));

        //les Parametres su Logo
        logoImage.setFont(new Font("Arial", 0, 18)); // NOI18N
        logoImage.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));

        //Les parametres du nom de notre projet
        spectrum.setFont(new Font("Arial", 1, 14)); // NOI18N
        spectrum.setText("SPECTRUM");

        //Les parametres du JLabel du quel on peut ouvrir une fentere ListProjet
        projet.setFont(new Font("Arial", 1, 18)); // NOI18N
        projet.setText(" Projets");
        projet.setIcon(new ImageIcon(this.getClass().getResource("droping.png")));
        projet.setCursor(new Cursor(Cursor.HAND_CURSOR));
        projet.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                projetMouseClicked(evt);
            }
        });

        //Un button qui ouvre un fenetre qui permet d'ajouter des colaborateurs
        ajouterColab.setText("Ajouter collaborateurs");
        ajouterColab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ajouterColabMouseClicked(evt);
            }
        });

        //Ajout des ellements dans le panel_rigth
        GroupLayout panel_rigthLayout = new GroupLayout(panelRigth);
        panelRigth.setLayout(panel_rigthLayout);
        panel_rigthLayout.setHorizontalGroup(
                panel_rigthLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(logoImage))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(spectrum))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(ajouterColab, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(projet))
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(70, 70, 70))
        );
        panel_rigthLayout.setVerticalGroup(
                panel_rigthLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel_rigthLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoImage)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spectrum)
                                .addGap(51, 51, 51)
                                .addComponent(ajouterColab)
                                .addGap(18, 18, 18)
                                .addComponent(projet)
                                .addGap(30, 30, 30)
                                .addContainerGap(592, Short.MAX_VALUE))
        );
        getContentPane().add(panelRigth);
        JLabel colab = new JLabel("Collaborateurs:",JLabel.LEFT);
        colab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);


        //La creation du liste des Collaboratuers dans un JScrollPane
        panelUtilisateur.add(colab, Component.LEFT_ALIGNMENT);
        panelUtilisateur.add(Box.createRigidArea(new Dimension(0,10)));

        listModel = new DefaultListModel();

        //On va updater la liste des collaborateur avant qu'on l'afiche
        updateCollaborateurs();

        listCollab = new JList(listModel);
        panelCollabScroll = new JPanel();
        listCollab.setSelectedIndex(0);
        listCollab.setBackground(new Color(69, 123, 157));
        panelCollabScroll.setBackground(new Color(69, 123, 157));
        panelCollabScroll.add(listCollab);

        //Quand on click sur le nom d'un collaborateur on peut voir ces informations et on peut l'effacer
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();

                if (mouseEvent.getClickCount() >= 1) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        InformationsCollab informationsCollab = new InformationsCollab(o.toString(),user);
                        informationsCollab.setVisible(true);
                        System.out.println("Clicked on: " + o.toString());

                    }

                }
            }
        };
        listCollab.addMouseListener(mouseListener);

        panelUtilisateur.add(panelCollabScroll,Component.LEFT_ALIGNMENT);

        pack();
    }

    /** Sortir de l'application
     * @return void
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {

        System.exit(0);
    }

    /** Ajouter les collaborateurs dans le projet
     * Si on n'est pas connecter dans un projet(la premiere authetification) on vais pas pouvoir ajouter des collaborateurs
     * @return void
     */
    private void ajouterColabMouseClicked(java.awt.event.MouseEvent evt) {

        if (!projectName.getText().equals("")) {
            new Ajouter(user, user.getProjectByName(projectName.getText()).getNom()).setVisible(true);
        } else {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane usernameFalse = new JOptionPane();
            usernameFalse.showMessageDialog(null, "Vous n'avez pas projets actifs", "Attention",JOptionPane.ERROR_MESSAGE, img);
        }
    }

    /**Syncronisé car on l'utilise du thread EDT (fenetre) ainsi que de la classe Client
     * @return
     */
    public synchronized void scrollOnTheBottom() {
        int lastIndex = list.getModel().getSize() - 1;
        if (lastIndex >= 0) {
            list.ensureIndexIsVisible(lastIndex);
        }
    }

    /**  Envoye le message dans la BD et il l'afiche sur l'ecran
     * @return void
     */
    private void sendMouseClicked(java.awt.event.MouseEvent evt) {
        String msg= messageTextFiled.getText();
        //Si un message a ete ecrit
        if (!msg.equals("")){
            if(!projectName.getText().equals("")) {
                user.sendMessage(msg, user.getProjectByName(projectName.getText()));
                this.printMsg(msg, true);
                scrollOnTheBottom();
                this.repaint();
            } else {
                ImageIcon img = new ImageIcon("images/attention.png");
                JOptionPane usernameFalse = new JOptionPane();
                usernameFalse.showMessageDialog(null, "choose your project", "Attention",JOptionPane.ERROR_MESSAGE, img);
            }

            //On vais effacer le message apres il a ete envoye
            projectName.setText("");
        }
    }

    /** Ouvrir la liste des projets dans laquelles on est connecter
     * @return void
     */
    private void projetMouseClicked(java.awt.event.MouseEvent evt) {
        new ListProjet(this).setVisible(true);
    }

    /** Ajout des messages
     * @return void
     */
    public synchronized void printMsg(String msg, boolean myMessage) {
        addedItems.add(addedItems.getSize(), new ListItem(msg, myMessage));
    }

    //Creer un classe pour avoir les bords ronds
    public class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false);
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

    /**Updater le project avec le Jlabel, les Messages et la liste de collaborateurs
     * @return void
     */
    public void updateProjetActif(String nomProjetActif) {
        //changer le JLabel
        projectName.setText(nomProjetActif);

        //changer les collaborateurs
        updateCollaborateurs();

        //effacer les messages
        addedItems = new MessageListModel();
        list.setModel(addedItems);

        //charger les messages
        user.loadMessages(user.getProjectByName(nomProjetActif));

    }

    /** Updater les collaborateurs
     * @return void
     */
    public void updateCollaborateurs() {
        listModel.removeAllElements();
        String projetString = projectName.getText();
        if (!projetString.equals("")) {
            for (int j = 0; j < (user.getProjectByName(projectName.getText()).getArrayCollaborateurs().size()); j++) {
                listModel.add(j, user.getProjectByName(projectName.getText()).getArrayCollaborateurs().get(j));
            }
        }
    }

    //Declaration des variables
    private JTextArea msgArea;
    private JPanel panelSend;
    private JButton ajouterColab;
    private JLabel  send;
    private JButton exitButton;
    private JPanel panelNomProjet;
    private RoundJTextField messageTextFiled;
    private JLabel logoImage;
    private JLabel name;
    private JPanel panelExit;
    private JPanel panelUtilisateur;
    private Panel panelCentral;
    private JPanel panelRigth;
    private JLabel projectName;
    private JLabel projet;
    private JScrollPane scrollMessages;
    private JLabel spectrum;
    private JLabel username;
    private DefaultListModel listModel;
    private MessageListModel addedItems;
    private JList<ListItem> list;
    private JList listCollab;
    private JPanel panelCollabScroll;
}
