import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/** Représente un projet
 * @author Nikita TEREKHOV
 */
public class Projet {

    private int id;
    private String nom;
    private LinkedList <Message> messages;
    private ArrayList <String> collaborateurs;

    /**Constructeur
     * @param id du projet
     * @param nom du projet
     * @param collaborateurs du projet
     * */
    public Projet(int id, String nom, ArrayList<String> collaborateurs, LinkedList<Message> messages){
        this.id=id;
        this.nom=nom;
        this.collaborateurs = collaborateurs;
        this.messages = messages;
    }

    /** Retourne les messages envoyés dans le projet
     * @return messages qui ont été envoyés dans le projet
     */
    public LinkedList<Message> getMessages() {
        return messages;
    }

    /** Retourne l'id du projet
     * @return id du projet
     */
    public int getId(){
        return this.id;
    }

    /** Retourne le nom du projet
     * @return nom du projet
     */
    public String getNom(){
        return this.nom;
    }

    /** Retourne les collaborateurs du projet
     * @return collaborateurs présents dans le projet
     */
    public ArrayList<String> getArrayCollaborateurs() {
        return collaborateurs;
    }

    /** Setter des messages
     * on va implémenter les messages
     */
    public void setMsgs(LinkedList<Message> msg) {
        this.messages = msg;
    }

    /** Ajout des messages dans la liste
     * on va implémenter les messages
     */
    public void addMsg(Message message) {
        this.messages.add(message);
    }

    /** Comparer deux instances
     */
    public boolean equals(Object o){
        if (! (o instanceof Projet)) return false;
        Projet p = (Projet) o;
        if (p.getNom().equals(this.getNom())) {
            return true;
        } else {
            return false;
        }
    }

    /** Créé un code unique pour le projet
     */
    public void createCode(String code){
        Code c = new Code(code, id);
        try {
            ConnectionExchange.setCodeOnProject(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
