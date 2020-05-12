import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/** Represent un projet
 * @author Nikita TEREKHOV
 */
public class Projet {

    private int id;
    private String nom;
    private LinkedList <Message> messages;
    private ArrayList <String> collaborateurs;

    /**Constructeur
     * @param id de projet
     * @param nom de projet
     * @param collaborateurs de projet
     * */
    public Projet(int id, String nom, ArrayList<String> collaborateurs, LinkedList<Message> messages){
        this.id=id;
        this.nom=nom;
        this.collaborateurs = collaborateurs;
        this.messages = messages;
    }

    /** Retourne les messages envoye dans le projet
     * @return messages qu'ont ete envoye dans le projet
     */
    public LinkedList<Message> getMessages() {
        return messages;
    }

    /** Retourne l'id du projet
     * @return id de projet
     */
    public int getId(){
        return this.id;
    }

    /** Retourne le nom du projet
     * @return nom de projet
     */
    public String getNom(){
        return this.nom;
    }

    /** Retourne les collaborateurs du projet
     * @return collaborateurs presents dans le projet
     */
    public ArrayList<String> getArrayCollaborateurs() {
        return collaborateurs;
    }

    /** Setter des messages
     * on va implementer les messages
     */
    public void setMsgs(LinkedList<Message> msg) {
        this.messages = msg;
    }

    /** Ajout de message dans la liste
     * on va implementer le message
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

    /** Creer un code unique pour le projet
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
