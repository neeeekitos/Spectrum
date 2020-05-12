
/** Représente le message
 * @author Lena LEHMANN
 */
public class Message {
    public String username;
    public String message;
    public String date;
    private Projet projet;

    /** Constructeur
     * @param username
     * @param message qu'on doit envoyer
     * @param date d'envoie du message
     * @param projet dans lequel on doit envoyer le message
     * */
    public Message(String username, String message, String date, Projet projet){
        this.username = username;
        this.message = message;
        this.date = date;
        this.projet = projet;
    }

    /** Retourne le username de l'utilisateur
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /** Retourne le Projet de l'utilisateur
     * @return projet dans lequel on doit envoyer le message
     */
    public Projet getProjet(){
        return projet;
    }

    /** Retourne le message de l'utilisateur
     * @return message qu'on doit envoyer
     */
    public String getMessage(){
        return message;
    }

    /** Retourne la date du message
     * @return date d'envoi du message
     */
    public String getDate(){
        return date;
    }
}
