import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Projet {

    private int id;
    private String nom;
    private LinkedList <Message> messages;
    private ArrayList <String> collaborateurs;

    public Projet(int id, String nom, ArrayList<String> collaborateurs){
        this.id=id;
        this.nom=nom;
        this.collaborateurs = collaborateurs;
        this.messages = null;

    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public int getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }

    public ArrayList<String> getArrayCollaborateurs() {
        return collaborateurs;
    }

    public void setNom(String nom) { this.nom = nom; }

    public void addMsg(Message msg) { messages.add(0, msg); }
}
