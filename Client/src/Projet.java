import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Projet {

    private int id;
    private String nom;
    private LinkedList <Message> messages;
    private ArrayList <String> collaborateurs;

    public Projet(int id, String nom, ArrayList<String> collaborateurs, LinkedList<Message> messages){
        this.id=id;
        this.nom=nom;
        this.collaborateurs = collaborateurs;
        this.messages = messages;
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

    public void setMsgs(LinkedList<Message> msg) { this.messages = msg; }

    public void addMsg(Message message) { this.messages.add(message);}

    public boolean equals(Object o){
        if (! (o instanceof Projet)) return false;
        Projet p = (Projet) o;
        if (p.getNom().equals(this.getNom())) {
            return true;
        } else {
            return false;
        }
    }

    public void createCode(String code){
        Code c = new Code(code, id);
        try {
            ConnectionExchange.setCodeOnProject(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
