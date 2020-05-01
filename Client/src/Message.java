import java.time.LocalDateTime;
import java.util.*;

public class Message {
    public String username;
    public String message;
    public String date;
    private Projet projet;

    public Message(String username, String message, String date, Projet projet){
        this.username = username;
        this.message = message;
        this.date = date;
        this.projet = projet;
    }

    public String getUsername(){
        return username;
    }

    public Projet getProjet(){
        return projet;
    }

    public String getMessage(){
        return message;
    }

    public String getDate(){
        return date;
    }
}
