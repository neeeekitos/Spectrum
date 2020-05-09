// java Program to create a simple JList
import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;
class Solve extends JFrame
{

    //frame
    static JFrame f;

    //lists
    static JList b;

     static JLabel jLabel1;
    //main class

    static JScrollPane scrollpane;

    public static void main(String[] args){
        new Solve(new Client("JAJAJA","hihihi","LALALA"));
     }

    Client user;

    public Solve(Client user){
        this.user = user;
        this.init();
        this.setVisible(true);
    }


    public void init() {


        jLabel1 = new JLabel();
        jLabel1.setText("PROJETS");
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setPreferredSize(new Dimension(300, 40));
        getContentPane().setBackground(new Color(237, 246, 249));

        //create a panel
        JPanel p =new JPanel();

        //create a new label
        JLabel l= new JLabel("select the day of the week");

        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i<user.getProjets().size(); i++) {

            listModel.add(i,user.getProjets().get(i).getNom() );

        }

        //create list

        b = new JList(listModel);
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {


                    String selectedItem = (String) b.getSelectedValue();
                    // add selectedItem to your second list.
                    DefaultListModel model = (DefaultListModel) b.getModel();
                    System.out.println("on a selectionée "+ selectedItem);

                }
            }
        };
        b.addMouseListener(mouseListener);


        //set a selected index
        b.setSelectedIndex(0);

        p.setBackground(new Color(255,255,255));
        //add list to panel
        p.add(b);

        this.add(p);

        //set the size of frame
        this.setSize(300,200);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2 - 300/ 2),
                (int) (dimension.getHeight() / 2 - 200/ 2));


        scrollpane = new JScrollPane(p);
        getContentPane().add(jLabel1,BorderLayout.PAGE_START);
        getContentPane().add(scrollpane, BorderLayout.CENTER);


    }


}
