
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/** Client de la messagerie
 * @author Valentina ETEGAN
 * @author Nikita TEREKHOV
 */
public class Client implements EcouteurConnection {

    private static final String IP_ADDR = "127.0.0.1";
    private static final int PORT = 8190;
    private ConnectionExchange connection;
    protected FenetreApp fenetre;

    private String nom;
    private String prenom;
    private String username;
    private LinkedList<Projet> projets;

    //sans passer par login
    public static void main(String[] args){
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
        new Client("lena", "Lena", "LEHMANN");
    }

    /**
     * Constructeur du client
     * @param username le username de l'utilisateur
     * @param prenom
     * @param nom
     */
    public Client(String username, String prenom, String nom){

        this.username = username;
        this.nom = nom;
        this.prenom = prenom;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("connection on local IP : "+ inetAddress.toString());
            connection = new ConnectionExchange(this,IP_ADDR, PORT, username);
            connection.sendString(username);
        } catch (IOException e) {
            System.out.println("exception de connexion " + e);
            e.printStackTrace();
        }

        //charger les projets
        projets = new LinkedList<>();
        try {
            projets = connection.updateProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* créer une fenêtre dans un thread edt
         * ici on utilisera plutôt invokeAndWait
         * car avec invokeLater la fenêtre sera créée de façon asynchrone et
         * l'affichage des messages (le chargement des messages) va nous donner comme résultat une exception
         * vu que la fenêtre n'était pas encore prête
         */
        try {
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    fenetre = new FenetreApp(Client.this);
                    fenetre.setVisible(true);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //charger les messages du 1er projet
        if (projets.size() > 0) {
            loadMessages(projets.get(0));
        }
    }

    @Override
    public void connectionReady(ConnectionExchange connection, String username) {
        System.out.println("connexion établie avec " + username);
    }

    @Override
    public void receiveString(String msg) {
        //on décompose notre chaine de caractères
        String[] parts = msg.split("###");
        String sender = parts[0];
        String nomProjet = parts[1];
        String textMessage = parts[2];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date = dateFormat.format(new Date());

        this.getProjectByName(nomProjet).addMsg(new Message(sender, textMessage, date, getProjectByName(nomProjet)));

        fenetre.printMsg("@" + sender + " : "  + "\r\n" + textMessage, false);//false = not my message => will be placed on the left area
        fenetre.scrollOnTheBottom();

        System.out.println("message reçu : " + textMessage);

    }

    @Override
    public void disconnect(ConnectionExchange connection) {
        connection.disconnect();
        ImageIcon img = new ImageIcon("images/attention.png");
        JOptionPane existingProject = new JOptionPane();
        existingProject.showMessageDialog(null, "Connection interrompue", "Attention", JOptionPane.ERROR_MESSAGE, img);
    }

    @Override
    public void exception(ConnectionExchange connection, IOException e) {
        System.out.println("Exception de connection " + e);
    }

    /** met à jour la liste des projets
     */
    public void updateProjets() {
        projets = new LinkedList<>();
        try {
            projets = connection.updateProjects();
            fenetre.updateCollaborateurs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Retourne le username de l'utilisateur
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /** Retourne le prénom de l'utilisateur
     * @return prenom
     */
    public String getPrenom(){
        return prenom;
    }

    /** Retourne le nom de l'utilisateur
     * @return nom
     */
    public String getNom() { return nom; }

    /** Retourne l'instance ConnectionExchange de l'utilisateur
     * @return connection
     */
    public ConnectionExchange getConnectionExchange() { return connection; }

    /** Retourne la liste de projets de l'utilisateur
     * @return projets
     */
    public LinkedList<Projet> getProjets(){
        return projets;
    }

    /** Va créer un nouveau projet pour notre utilisateur :
     * tout d'abord on récupère le dernier projectID de la BD (qui est unique),
     * ensuite on va créer le nouveau projet en utilisant l'ID = projectID + 1, puis on l'ajoute dans la BD,
     * enfin, on rajoute ce projet localement dans la liste des projets
     * @param nom le nom du projet, qui est unique dans la liste des projets de chaque client,
     *            on le vérifie avec une méthode contains(), qui utilise equals (méthode equals est redéfinie
     *            pour comparer les noms des projets)
     * @param collaborateurs les collaborateurs du projet
     */
    public void createProject(String nom, ArrayList<String> collaborateurs) {
        int id = 0;
        try {
            id = connection.getLastIdProject();
            id++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //nouveau projet + vérier si le nom est déjà présent dans la liste des projets de notre user
        Projet projet = new Projet(id, nom, collaborateurs, new LinkedList<>());
        if (!projets.contains(projet)) {
            //ajouter dans DB
            try {
                connection.addProjectToDB(projet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //ajouter localement
            projets.add(projet);
        } else {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane existingProject = new JOptionPane();
            existingProject.showMessageDialog(null, "Ce nom de projet existe déjà", "Attention", JOptionPane.ERROR_MESSAGE, img);
        }
    }

    /** Ajoute le collaborateur dans le projet
     * @param usernameCollab le collaborateur qu'on veut ajouter dans le projet
     * @param projetID l'id du projet dans lequel on ajoute notre collaborateur
     */
    public void ajouterCollab(String usernameCollab, int projetID){
        try {
            connection.addCollabInProject(usernameCollab, projetID);
            updateProjets();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Charge les messages du projet
     * @param projet l'instance du projet dans lequel
     *               on va charger les messages
     */
    public void loadMessages(Projet projet) {
        if (projet != null) {
            LinkedList<Message> messages = new LinkedList<>();
            try {
                messages = connection.updateMessages(projet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            projet.setMsgs(messages);
            this.printMessages(messages);
        }
    }

    /** Retourne l'instance Projet de l'utilisateur en le trouvant grâce au nom du projet fourni
     * @param name le nom du projet
     * @return projet l'instance Projet
     */
    public Projet getProjectByName(String name) {
        for (Projet projet : projets) {
            if (projet.getNom().equals(name)) {
                return projet;
            }
        }
        return null;
    }

    /** Permet d'envoyer le message dans la BD et au serveur
     * @param msg le message à envoyer
     * @param projet l'instance Projet à laquelle appartient le message
     */
    public void sendMessage(String msg, Projet projet) {

        //sendToDB
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date = dateFormat.format(new Date());
        Message message = new Message(username, msg, date, projet);
        projet.addMsg(message);
        try {
            System.out.println("Envoie du message dans la BD : " + msg);
            connection.addMessageToDB(message);
        } catch (SQLException e) {
            System.out.println("Erreur d'envoi du message dans la BD : ");
            e.printStackTrace();
        }

        /* sendString to all users from a project
         * collabStr: usernames separated by ###*
         */
        String collabStr = "";
        for (int i = 0; i < projet.getArrayCollaborateurs().size(); i++) {
            String usernameCollab = projet.getArrayCollaborateurs().get(i);
            if (!this.username.equals(usernameCollab)) {
                collabStr += usernameCollab + "###";
            }
        }

        String str = this.username + "###" + projet.getNom() + "###" + msg + "###" + collabStr;
        connection.sendString(str);
    }

    /** Permet d'afficher la liste des messages dans JScrollPane dans la FenetreApp
     * @param messages la liste de messages LinkedList
     */
    public synchronized void printMessages(LinkedList<Message> messages){
        //print dans un ordre inversé
        for (int i = messages.size() - 1; i>=0; i--) {
            //2th argument "myMessage" shows if it is my message (to be placed on the right area) or not
            boolean myMessage = messages.get(i).getUsername().equals(username);
            //si le message est le mien, on ne va pas afficher @username
            fenetre.printMsg((!myMessage ? "@" + messages.get(i).getUsername() + " :" + "\r\n" : "") + messages.get(i).getMessage(), myMessage);
        }
        fenetre.scrollOnTheBottom();
    }
}
