
import javax.swing.*;
import java.awt.*;
/**Classe qui va créer l'affichage de la fenêtre indiquant les conditions d'utilisation qu'on doit accepter pour pouvoir créer un conte
 * @author Lena LEHMANN
 */
public class FenetreConditions extends javax.swing.JFrame {

    /**Constructeur
     * */
    public FenetreConditions() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** Initialisation
     */
    private void initComponents() {

        //L'initialisation des variables
        conditions = new javax.swing.JFrame();
        panelContainer = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        labelExit = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        textAreaLegalText = new javax.swing.JTextArea();

        //Définition des propriétés de la page
        javax.swing.GroupLayout ConditionsLayout = new javax.swing.GroupLayout(conditions.getContentPane());
        conditions.getContentPane().setLayout(ConditionsLayout);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        //Définition des proprites du panel
        panelContainer.setBackground(new java.awt.Color(102, 102, 102));
        panelContainer.setForeground(new java.awt.Color(255, 255, 255));

        //Définir les propriétés du titre
        labelTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setText("Legal terms and conditions");
        labelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        labelTitle.setPreferredSize(new java.awt.Dimension(50, 35));

        //Définir les propriétés du bouton de sortie
        labelExit.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelExit.setForeground(new java.awt.Color(255, 255, 255));
        labelExit.setText("X");
        labelExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelExit.setToolTipText("");
        labelExit.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelExit.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        //L'ajout des éléments dans le panel
        javax.swing.GroupLayout jPanelTopContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(jPanelTopContainerLayout);
        jPanelTopContainerLayout.setHorizontalGroup(
                jPanelTopContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTopContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(labelExit)
                                .addContainerGap())
        );
        jPanelTopContainerLayout.setVerticalGroup(
                jPanelTopContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTopContainerLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanelTopContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelExit))
                                .addContainerGap())
        );
        getContentPane().add(panelContainer);

        //Le scroll pane
        scroll.setToolTipText("");
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Definir le texte qui va être affiché
        textAreaLegalText.setEditable(false);
        textAreaLegalText.setText("Nos Conditions et notre Politique de confidentialité mises à jour. Nos Conditions d’utilisation mises à jour expliquent les conditions à respecter pour pouvoir utiliser nos Services. Notre Politique de confidentialité mise à jour explique quelles informations nous recueillons, la manière dont nous les utilisons et dont nous les communiquons, et les différents choix que vous avez, notamment comment gérer vos paramètres de confidentialité, accéder aux informations dont nous disposons à votre sujet et supprimer votre compte. Nous avons conçu Spectrum en adoptant des principes de confidentialité et de sécurité majeurs, comme le chiffrement de bout en bout de vos messages et de vos appels, ce qui signifie que ni nous ni des tierces parties ne pouvons les lire ou les écouter. \n" +
                "\n" +
                "\n• Principes de sécurité et de confidentialité. Depuis que nous avons lancé Spectrum, nous avons développé nos Services en nous appuyant sur des principes de sécurité et de confidentialité solides.\n" +
                "\n• Vous connecter à d'autres personnes. Nous vous offrons la possibilité de communiquer avec d'autres utilisateurs de Spectrum, notamment par messages, appels vocaux et vidéo, en envoyant des images et des vidéos, en montrant votre statut et en partageant votre localisation avec d'autres personnes si vous le souhaitez. Nous pouvons mettre à disposition une plate-forme pratique qui vous permette d'envoyer de l'argent à d'autres utilisateurs de notre plate-forme et d'en recevoir de leur part. Spectrum travaille avec des partenaires, prestataires de services et sociétés affiliées pour vous proposer des moyens d'interagir avec leurs services. Nous utilisons les informations que nous recevons de leur part pour exécuter, fournir et améliorer nos Services.\n" +
                "\n• Méthodes d'amélioration de nos Services. Nous analysons la façon dont vous utilisez Spectrum pour améliorer l'ensemble des aspects de nos Services décrits aux présentes, notamment pour aider les entreprises qui utilisent Spectrum à mesurer l'efficacité et la distribution de leurs services et de leurs messages. Spectrum utilise les informations à sa disposition et travaille également avec des partenaires, prestataires de services et sociétés affiliées dans ce but.\n" +
                "\n• Communication avec des entreprises. Nous mettons à votre disposition et à la disposition de tiers, telles que des entreprises, des moyens de communiquer ensemble en utilisant Spectrum, comme pour des commandes, transactions et informations de rendez-vous, notifications de livraison et d'expédition, des mises à jour de produits et services et du marketing. Les messages comprenant du contenu marketing que vous pourriez recevoir pourraient inclure une offre pour quelque chose susceptible de vous intéresser. Nous ne voulons pas que votre expérience soit gâchée par du contenu indésirable. Comme pour tous vos messages, vous pouvez gérer ces communications, et nous honorerons les choix que vous ferez.\n" +
                "\n• Sécurité. Nous nous efforçons de garantir la sécurité de Spectrum en prenant les mesures nécessaires face aux personnes et activités abusives et aux violations de nos Conditions. Nous interdisons toute utilisation de nos Services à mauvais escient, tout comportement nuisible envers autrui et toute violation de nos Conditions et règlements, et nous réagissons aux situations dans lesquelles nous pouvons soutenir ou protéger notre communauté. Nous développons des systèmes automatisés pour améliorer notre capacité à détecter et à supprimer du service Spectrum les activités et personnes abusives qui pourraient porter atteinte à notre communauté et à la sécurité de nos Services. Si de telles personnes ou activités sont portées à notre connaissance, nous prenons les mesures nécessaires en supprimant du service Spectrum ces personnes ou activités ou en contactant les forces de l'ordre. Nous partageons des informations avec d'autres sociétés affiliées lorsqu'une mauvaise utilisation ou un comportement préjudiciable de la part de quelqu'un qui utilise nos Services est porté à notre connaissance.\n" +
                "\n• Permettre l'accès mondial à nos Services. Pour que notre Service mondial fonctionne, nous devons conserver et distribuer du contenu et des informations dans nos centres de données et nos systèmes dans le monde entier, y compris en dehors de votre pays de résidence. Cette infrastructure peut être détenue ou exploitée par nos prestataires de services ou sociétés affiliées.\n" +
                "\n• Sociétés affiliées. Nous faisons partie des entités Facebook. En tant que membre des entités Facebook, Spectrum reçoit des informations de la part des entités Facebook et partage des informations avec les entités Facebook, selon la description de la Politique de confidentialité de Spectrum. Nous utilisons les informations que nous recevons de leur part pour exécuter, fournir et améliorer nos Services. En savoir plus sur les entités Facebook ainsi que leurs conditions et règlements ici.\n" +
                "\n");
        textAreaLegalText.setLineWrap(true);
        textAreaLegalText.setWrapStyleWord(true);
        textAreaLegalText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll.setViewportView(textAreaLegalText);
        textAreaLegalText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textAreaLegalText.setBackground(new java.awt.Color(255, 255, 255));

        //L'ajout du scroll pane dans la fenêtre
        getContentPane().add(scroll);
        scroll.setMaximumSize(new Dimension(700,500));
        scroll.setMinimumSize(new Dimension(700,500));

        this.getContentPane().setMaximumSize(new Dimension(700,545));
        this.getContentPane().setMinimumSize(new Dimension(700,545));

        pack();
    }

    /** Fermer la fenetre
     */
    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        /* Création et affichage de la forme*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreConditions().setVisible(true);
            }
        });
    }

    // Déclaration des Variables
    private javax.swing.JFrame conditions;
    private javax.swing.JLabel labelExit;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea textAreaLegalText;
}
