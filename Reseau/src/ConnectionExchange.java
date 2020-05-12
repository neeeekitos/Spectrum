import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/** Représente une connection avec un Socket et des flux entrant et sortant
 * @author Nikita TEREKHOV
 * @author Valentina ETEGAN
 */
public class ConnectionExchange {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/spectrum?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final Socket connection;
    private final BufferedWriter out;
    private final BufferedReader in;
    private final Thread cnThread;
    private final EcouteurConnection eventEcouteur;
    private String username;
    private Connection connDb;

    /**
     * Constructeur 1 sans Socket
     * @param eventEcouteur l'interface
     * @param ip IP adresse du serveur
     * @param port le port de serveur
     * @param username username de l'utilisateur
     */
    public ConnectionExchange(EcouteurConnection eventEcouteur, String ip, int port, String username) throws IOException {
        this(eventEcouteur, new Socket(ip, port), username);
    }

    /**
     * Constructeur 2 avec Socket
     * @param eventEcouteur l'interface
     * @param connection le Socket
     * @param username username de l'utilisateur
     */
    public ConnectionExchange(EcouteurConnection eventEcouteur, Socket connection, String username) throws IOException {
        this.eventEcouteur = eventEcouteur;
        this.connection = connection;
        this.username = username;
        this.connDb = connectToDb();

        OutputStream output = connection.getOutputStream();
        InputStream input = connection.getInputStream();

        //conversion du string en bytes, puis mettre cela dans le buffer
        out = new BufferedWriter(new OutputStreamWriter(output, Charset.forName("UTF-8")));
        in = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        cnThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventEcouteur.connectionReady(ConnectionExchange.this, username);
                    String line = "";
                    while (!cnThread.isInterrupted()) {
                        if ((line = in.readLine())!=null)  {
                            eventEcouteur.receiveString(line);
                        }
                    }
                } catch (IOException e) {
                    eventEcouteur.exception(ConnectionExchange.this, e);
                } finally {
                    eventEcouteur.disconnect(ConnectionExchange.this);
                }
            }
        });
        cnThread.start();
    }

    @Override
    public String toString() {
        return "Connection: " + connection.getInetAddress() + ": " + connection.getPort();
    }

    /** Retourne username
     * @return username d'utilisateur
     */
    public String getUsername() {
        return username;
    }


    /** Disconnect sockets
     * Synchronisé, car s'utilise dans plusieurs threads
     */
    public synchronized void disconnect() {
        cnThread.interrupt();
        try {
            connection.close();
            System.out.println("Le client @" + username + " est déconnecté");
        } catch (IOException e) {
            eventEcouteur.exception(ConnectionExchange.this, e);
        }
    }

    /** Envoie la chaine de caratères, synchronisée pour la sécurité
     * car est utilisé dans les threads différents
     * @return Connection connDb
     * @throws SQLException
     */
    public synchronized void sendString(String msg) {
        try {
            out.write(msg + "\r\n");
            out.flush(); //pour envoyer de Buffer à client/serveur

            //ajouter l'envoi du message dans la DB
        } catch (IOException e) {
            eventEcouteur.exception(ConnectionExchange.this, e);
            eventEcouteur.disconnect(this);
        }
    }

    /** Se connecte à la BD
     * @return Connection connDb
     * @throws SQLException
     */
    public static synchronized Connection connectToDb() {
        Connection connDb = null;
        try {
            connDb = DriverManager.getConnection(JDBC_URL, "root", "root");
            System.out.println("Connecté à la BD");

        } catch (SQLException e) {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane existingProject = new JOptionPane();
            existingProject.showMessageDialog(null, "Erreur de connexion à la BD", "Attention", JOptionPane.ERROR_MESSAGE, img);
            throw new Error("Erreur de connexion à la BD", e);
        }
        return connDb;
    }

    /** Sign-in dans la BD
     * @param password
     * @param username
     * @return boolean
     * @throws SQLException
     */
    public static boolean loginDb(String username, String password) throws SQLException {
        Connection connDB = connectToDb();

        ResultSet result = null;
        String requeteCheck = "SELECT * FROM users as u WHERE u.username=?";

        PreparedStatement preparedStmt = connDB.prepareStatement(requeteCheck);
        preparedStmt.setString(1, username);
        result = preparedStmt.executeQuery();

        //vérifions si on a qqch dans un result
        if (result.next()) {

            String usernameDb = result.getString(2);
            String passwordDb = result.getString(6);

            if (password.equals(passwordDb)) {
                JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
                String prenom = result.getString(3);
                String nom = result.getString(4);

                //Comme on ne peut pas appeler invokeAndWait (dans la classe client) de thread EDT
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new Client(username, prenom, nom);
                    }
                }).start();

                return true;
            } else {
                JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
        }

        connDB.close();
        return false;
    }

    /** Sign-in dans la BD
     * @param prenom
     * @param nom
     * @param password
     * @param username
     * @return boolean
     * @throws SQLException
     */
    public static boolean signinDB(String prenom, String nom, String username, String email, String password) throws SQLException {

        Connection connDB = connectToDb();
        ResultSet result = null;

        //requête qui verifie si ce username est déjà utilisé
        String requeteCheck = "SELECT * FROM users as u WHERE u.username=?";

        PreparedStatement preparedStmt = connDB.prepareStatement(requeteCheck);
        preparedStmt.setString(1, username);
        result = preparedStmt.executeQuery();

        //vérifions si on a qqch dans un result
        if (!result.next()) {

            //création d'insert statement
            String requete = " INSERT INTO users (username, prenom, nom, email, mdp) VALUES (?, ?, ?, ?, ?)";
            preparedStmt = connDB.prepareStatement(requete);

            // ajouter les valeurs sql insert
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, prenom);
            preparedStmt.setString(3, nom);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, password);

            // executer
            return(preparedStmt.execute());
        } else { return false; }
    }

    /** Permet de mettre à jour tous les projets de l'utilisateur
     * @return LinkedList<Projet> la liste des projet de notre utilisateur
     * @throws SQLException
     */
    public synchronized LinkedList<Projet> updateProjects() throws SQLException {
        ResultSet resultProjetID = null;
        ResultSet resultNomProjet = null;
        ResultSet resultCollaborateurs = null;

        LinkedList<Projet> projets = new LinkedList<>();
        int projectID;
        ArrayList <String> collaborateurs = new ArrayList<>();
        String nomProjet = "";


        //requête qui apporte tous les ID des projets où notre utilisateur est présent
        String requete1 = "SELECT * FROM projetassociation as p WHERE p.username=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete1);
        preparedStmt.setString(1, username);
        resultProjetID = preparedStmt.executeQuery();

        System.out.println("=================================");
        System.out.println("Chargement des projets de BD : ");
        while (resultProjetID.next()) {

            projectID = resultProjetID.getInt("projectID");

            //obtenir le nom du projet
            String requete2 = "SELECT * FROM projets as p WHERE p.projectID=?";
            preparedStmt = connDb.prepareStatement(requete2);
            preparedStmt.setInt(1, projectID);
            resultNomProjet = preparedStmt.executeQuery();
            if (resultNomProjet.next()) {
                nomProjet = resultNomProjet.getString("nom");
            }

            //obtenir tous les collaborateurs dans le même projet
            String requete3 = "SELECT * FROM projetassociation as p WHERE p.projectID=?";
            preparedStmt = connDb.prepareStatement(requete3);
            preparedStmt.setInt(1, projectID);
            resultCollaborateurs = preparedStmt.executeQuery();
            while (resultCollaborateurs.next()) {
                collaborateurs.add(resultCollaborateurs.getString("username"));
            }

            //créer le projet et ajouter dans la liste
            Projet projet = new Projet(projectID, nomProjet, collaborateurs, new LinkedList<>());
            projets.add(projet);
            System.out.println(nomProjet);

            //vider l'ArrayList pour ajouter des collaborateurs des autres projets
            collaborateurs = new ArrayList<>();
        }
        System.out.println("=================================");
        return projets;
    }

    /** Permet d'envoyer le message dans la BD
     * @param projet l'instance du Projet
     * @return LinkedList<Message> la liste des messages
     * @throws SQLException
     */
    public synchronized LinkedList<Message> updateMessages(Projet projet) throws SQLException {

        ResultSet result;
        LinkedList<Message> messages = new LinkedList<>();
        Message msg;

        String date;
        String textMsg;
        String usernameMsg;

        String requete = "SELECT * FROM messages as m WHERE m.projectID=? ORDER BY msgID DESC";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete);
        preparedStmt.setInt(1, projet.getId());
        result = preparedStmt.executeQuery();

        while (result.next()) {
            textMsg = result.getString("message");
            date = result.getString("dateMsg");
            usernameMsg = result.getString("username");
            messages.add(new Message(usernameMsg, textMsg, date, projet));
        }

        return messages;
    }

    /** Permet d'envoyer le message dans la BD
     * @param message l'instance de Message à envoyer, contient
     *                le projet auquel elle appartient
     * @return boolean
     * @throws SQLException
     */
    public synchronized boolean addMessageToDB(Message message) throws SQLException{
        ResultSet result = null;

        String requeteCheck = "SELECT * FROM messages as m WHERE m.projectID=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requeteCheck);
        preparedStmt.setInt(1, message.getProjet().getId());
        result = preparedStmt.executeQuery();

        //vérifions si on a qqch dans un result
        if (result != null) {

            //création d'insert statement
            String requete = " INSERT INTO messages (projectID, username, message, dateMsg) VALUES (?, ?, ?, ?)";
            preparedStmt = connDb.prepareStatement(requete);

            // ajouter les valeurs sql insert
            preparedStmt.setInt(1, message.getProjet().getId());
            preparedStmt.setString(2, message.getUsername());
            preparedStmt.setString(3, message.getMessage());
            preparedStmt.setString(4, message.getDate());

            // éxecuter
            return preparedStmt.execute();
        } else {
            System.out.println("L'envoi du message dans la BD n'est pas reussi : " + message.getMessage());
            return false;
        }
    }

    /** Insère le nouveau projet la BD :
     * Premièrement on insère le projet dans projets, puis dans la table qui associe chaque projet avec
     * chaque utilisateur
     * @param projet le projet à ajouter dans la BD
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public synchronized void addProjectToDB(Projet projet) throws SQLException {

        //vérifions si le projet n'est pas encore dans la BD associé avec notre utilisateur qui appelle cette méthode
        boolean checkCollabPresent = checkProjectExists(username, projet.getId());
        if (!checkCollabPresent) {
            //création d'insert statement
            String requete1 = " INSERT INTO projets (projectID, nom) VALUES (?, ?)";
            PreparedStatement preparedStmt1 = connDb.prepareStatement(requete1);

            // ajouter les valeurs sql insert
            preparedStmt1.setInt(1, projet.getId());
            preparedStmt1.setString(2, projet.getNom());

            preparedStmt1.execute();

            //ajouter dans un tableau projetAssociation
            for (String usernameCollaborateur : projet.getArrayCollaborateurs()) {
                addCollabInProject(usernameCollaborateur, projet.getId());

            }
        }
    }

    /** Ajoute le collaborateur dans le projet par son username
     * @param usernameCollaborateur en String
     * @param projetID en int le projet dans lequel on ajotera notre user
     * @throws SQLException
     */
    public void addCollabInProject(String usernameCollaborateur, int projetID) throws SQLException{

        //vérifions si ce username existe dans la DB
        boolean usernameExists = checkUsernameExists(usernameCollaborateur);

        //vérifions si le collab est déjà présent dans ce projet
        boolean checkCollabPresent = checkProjectExists(usernameCollaborateur, projetID);

        if ((!checkCollabPresent) && usernameExists) {
            //création d'insert statement
            String requeteAssociation = " INSERT INTO projetassociation (username, projectID) VALUES (?, ?)";
            PreparedStatement preparedStmt2 = connDb.prepareStatement(requeteAssociation);

            // ajouter les valeurs sql insert
            preparedStmt2.setString(1, usernameCollaborateur);
            preparedStmt2.setInt(2, projetID);

            preparedStmt2.execute();
            System.out.println("l'utilisateur @" + usernameCollaborateur + " a été ajouté dans le projet");
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane existingProject = new JOptionPane();
            existingProject.showMessageDialog(null, "l'utilisateur @" + usernameCollaborateur + " a été ajouté dans le projet id = " + projetID, "Attention", JOptionPane.ERROR_MESSAGE, img);
        } else {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane existingProject = new JOptionPane();
            existingProject.showMessageDialog(null, "Ce membre est déjà présent dans de projet / Cet username n'existe pas", "Attention", JOptionPane.ERROR_MESSAGE, img);
        }
    }

    /** Vérifie si l'utilisateur est associé au projet donné
     * @param usernameToCheck en String
     * @param projectID en int le projet dans lequel on vérifie la présence
     * @throws SQLException
     */
    public boolean checkProjectExists(String usernameToCheck, int projectID) throws SQLException {
        ResultSet resultCheck;
        //requete qui verifie si ce username est déjà utilisé
        String requete1 = "SELECT * FROM projetassociation as p WHERE p.username=? AND p.projectID=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete1);
        preparedStmt.setString(1, usernameToCheck);
        preparedStmt.setInt(2, projectID);
        resultCheck = preparedStmt.executeQuery();

        boolean resultat = resultCheck.next();
        System.out.println("ce membre est présent dans le projet déjà: " + resultat);
        return resultat; //false si projet n'existe pas pour cet username
    }

    /** Vérifie si l'utilisateur existe
     * @param usernameToCheck en String
     * @throws SQLException
     */
    public boolean checkUsernameExists(String usernameToCheck) throws SQLException {
        ResultSet resultCheck;
        //requete qui verifie si ce username est déjà utilisé
        String requete1 = "SELECT * FROM users as u WHERE u.username=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete1);
        preparedStmt.setString(1, usernameToCheck);
        resultCheck = preparedStmt.executeQuery();
        boolean resultat = resultCheck.next();
        System.out.println("cet username existe : " + resultat);
        return resultat; //false si username n'exite pas
    }

    /** Permet d'envoyer le message dans la BD et au serveur
     * @return lastProjectID le dernier projectID unique récupéré de la BD
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public int getLastIdProject() throws SQLException {
        ResultSet result;
        int lastProjectID = 0;
        String requete = "SELECT * FROM projets ORDER BY projectID DESC";
        PreparedStatement preparedStmt = connDb.prepareStatement(requete);
        result = preparedStmt.executeQuery();

        if (result.next()) {
            lastProjectID = result.getInt("projectID");
        }

        return lastProjectID;
    }

    /** Permet d'obtenir les informations sur l'utilisateur grâсe à son username
     * @return String array avec le prenom, nom et email de l'utilisateur
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public String[] getUserInfosByUsername(String usernameInfos) throws SQLException {

        ResultSet result;

        String requete = "SELECT * FROM users as u WHERE u.username=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete);
        preparedStmt.setString(1, usernameInfos);
        result = preparedStmt.executeQuery();

        String prenom = "";
        String nom = "";
        String email = "";

        if (result.next()) {
            prenom = result.getString("prenom");
            nom = result.getString("nom");
            email = result.getString("email");
            System.out.println("C'est notre " + prenom);
            return new String[]{prenom, nom, email};
        } else {
            return null;
        }
    }

    /** Retourne les informations sur le code du projet et permet
     * ainsi de vérifier si le code du projet existe
     * @param code en String
     * @return code du type Code avec la date de création et le projetID auquel appartient
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public static Code getCodeIfExists(String code) throws SQLException {
        Connection connDb = connectToDb();
        ResultSet result;
        //requete qui verifie si ce username est déjà utilisé
        String requete1 = "SELECT * FROM codeprojets as c WHERE c.code=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete1);
        preparedStmt.setString(1, code);
        result = preparedStmt.executeQuery();

        String dateCreation = "";
        int projectID;

        if (result.next()) {
            dateCreation = result.getString("dateCreation");
            projectID = result.getInt("projectID");
            System.out.println("Le code est : " + code);
            return new Code(code, dateCreation, projectID);
        }

        return null; //returns null if no code
    }

    /** Set le code d'invitation pour le projet donné
     * @param c du type Code qui contient la date de la création du code et l'id du projet
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public static void setCodeOnProject(Code c) throws SQLException{

        Connection connDb = connectToDb();
        ResultSet result;
        String requete1 = "SELECT * FROM codeprojets as c WHERE c.projectID=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requete1);
        preparedStmt.setInt(1, c.getProjectID());
        result = preparedStmt.executeQuery();

        if (result.next()) {
            deleteCodeProject(result.getString("code"),  connDb);
        }

        String requeteAssociation = " INSERT INTO codeprojets (projectID, code, dateCreation) VALUES (?, ?, ?)";
        PreparedStatement preparedStmt2 = connDb.prepareStatement(requeteAssociation);

        // ajouter les valeurs sql insert
        preparedStmt2.setInt(1, c.getProjectID());
        preparedStmt2.setString(2, c.getCode());
        preparedStmt2.setString(3, c.getDate());

        preparedStmt2.execute();
        ImageIcon img = new ImageIcon("images/attention.png");
        JOptionPane usernameFalse = new JOptionPane();
        usernameFalse.showMessageDialog(null, "le code " + c.getCode() + " a été ajouté dans le projet", "Attention",JOptionPane.ERROR_MESSAGE, img);
        System.out.println("le code " + c.getCode() + " a été ajouté dans le projet");
    }

    /** Efface le membre du projet
     * @param usernameToDelete le username à effacer du projet
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public void deleteMemberFromProject(String usernameToDelete) throws SQLException {

        String requeteDelete = " DELETE FROM projetassociation WHERE username=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requeteDelete);
        preparedStmt.setString(1, usernameToDelete);
        int quantityRowsUpdated = preparedStmt.executeUpdate();
        if (quantityRowsUpdated > 0) {
            System.out.println("L'utilisateur @" + usernameToDelete + " a été supprimé du projet");
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane usernameFalse = new JOptionPane();
            usernameFalse.showMessageDialog(null, "L'utilisateur @" + usernameToDelete + " a été supprimé du projet", "Attention",JOptionPane.ERROR_MESSAGE, img);
        } else {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane usernameFalse = new JOptionPane();
            usernameFalse.showMessageDialog(null, "L'utilisateur @" + usernameToDelete + " n'a pas été supprimé du projet", "Attention",JOptionPane.ERROR_MESSAGE, img);
        }
    }

    /** Efface le code du projet
     * @param codeToDelete
     * @throws SQLException si jamais on a un problème avec la BD
     */
    public static void deleteCodeProject(String codeToDelete, Connection connDb) throws SQLException {

        String requeteDelete = " DELETE FROM codeprojets WHERE code=?";

        PreparedStatement preparedStmt = connDb.prepareStatement(requeteDelete);
        preparedStmt.setString(1, codeToDelete);
        int quantityRowsUpdated = preparedStmt.executeUpdate();
        if (quantityRowsUpdated > 0) {
            System.out.println("Le code " + codeToDelete + " a été supprimé du projet");
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane usernameFalse = new JOptionPane();
            usernameFalse.showMessageDialog(null, "Le code " + codeToDelete + " a été supprimé du projet", "Attention",JOptionPane.ERROR_MESSAGE, img);
        } else {
            ImageIcon img = new ImageIcon("images/attention.png");
            JOptionPane usernameFalse = new JOptionPane();
            usernameFalse.showMessageDialog(null, "Le code " + codeToDelete + " n'a pas été supprimé du projet", "Attention",JOptionPane.ERROR_MESSAGE, img);
        }
    }

}