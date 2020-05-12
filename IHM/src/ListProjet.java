
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/** Represente une liste des projets GUI
 * @author Nikita TEREKHOV
 */
class ListProjet extends JFrame
{
    //Declaration des variables
    static JFrame f;
    static JList listScroll;
    static JLabel projetsLabel;
    static JScrollPane scrollpane;
    static JLabel create;
    private FenetreApp fen;
    private DefaultListModel listModel;

    /**
     * Constructeur du client
     * @param fen la fenetre de l'application
     *            dans laquelle on affiche notre liste
     */
    public ListProjet(FenetreApp fen){
        this.fen = fen;
        this.init();
        this.setVisible(true);
    }

    /** Initialisation
     */
    public void init() {

        //Definir les parametres de la pane
        getContentPane().setMinimumSize(new Dimension(300, 200));

        //Afficher le title
        projetsLabel = new JLabel();
        projetsLabel.setText("PROJETS");
        projetsLabel.setHorizontalAlignment(JLabel.CENTER);
        projetsLabel.setMinimumSize(new Dimension(300, 40));
        projetsLabel.setPreferredSize(new Dimension(300, 40));
        projetsLabel.setMaximumSize(new Dimension(300, 40));
        getContentPane().setBackground(new Color(237, 246, 249));

        //Creer un Scroll pane pour afficher la liste des projets
        JPanel panelScroll =new JPanel();
        listModel = new DefaultListModel();
        for (int i = 0; i<fen.user.getProjets().size(); i++) {
            listModel.add(i,fen.user.getProjets().get(i).getNom() );
        }
        listScroll = new JList(listModel);
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    String selectedItem = (String) listScroll.getSelectedValue();
                    // add selectedItem to your second list.
                    DefaultListModel model = (DefaultListModel) listScroll.getModel();
                    System.out.println("on a selectioné "+ selectedItem);
                    fen.updateProjetActif(selectedItem);
                }
            }
        };

        //L'ajout des Listeners pour pouvoir acceder au projet selectionee
        listScroll.addMouseListener(mouseListener);

        //L'ajout de scroll dans la panel et apres du panel dans la fenetre
        listScroll.setSelectedIndex(0);
        panelScroll.setBackground(new Color(255,255,255));
        panelScroll.add(listScroll);
        this.add(panelScroll);

        //Definir les dimensions du frame
        this.setMinimumSize(new Dimension(300,200));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 300/ 2),
                (int) (dimension.getHeight() / 2 - 200/ 2));
        scrollpane = new JScrollPane(panelScroll);

        //Le JLabel avec des ecouteurs qui va nous envoye vers la page pour creer des projets
        //Ou pour pouvoir rejoindre un projet existent
        create = new JLabel();
        create.setText("New Projet");
        create.setHorizontalAlignment(JLabel.CENTER);
        create.setMinimumSize(new Dimension(300, 40));
        create.setPreferredSize(new Dimension(300, 40));
        create.setMaximumSize(new Dimension(300, 40));
        create.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().setBackground(new Color(237, 246, 249));
        create.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                new Create(fen.user, ListProjet.this).setVisible(true);
            }
        });

        //L'ajout dans la Pane des elements
        getContentPane().add(projetsLabel,BorderLayout.PAGE_START);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        getContentPane().add(create,BorderLayout.PAGE_END);

    }
    /**
     * Met à jour la liste des projets
     */
    public void updateListeProjet() {
        listModel.removeAllElements();
        for (int i = 0; i<fen.user.getProjets().size(); i++) {
            listModel.add(i,fen.user.getProjets().get(i).getNom() );
        }
    }

}
