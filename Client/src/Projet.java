import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Projet {

    private String id;
    private String nom;
    private Date date;
    private LinkedList <Message> messages;
    private ArrayList <String> collaborateurs;

    public Projet(String id, String nom, Date date, LinkedList<Message> messages, ArrayList<String> collaborateurs){
        this.id=id;
        this.nom=nom;
        this.date=date;
        this.collaborateurs = collaborateurs;
        this.messages = messages;

    }

    public String getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }
    public ArrayList <String> getCollaborateurs(){
        return this.getCollaborateurs();
    }

    public Date getDate() {
        return date;
    }

}
