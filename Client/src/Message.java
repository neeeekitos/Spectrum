import java.time.LocalDateTime;
import java.util.*;

public class Message {
    public String username;
    public String message;
    public LocalDateTime date;
    private ArrayList<String> destinateurs;

    public Message(String username, String message, LocalDateTime date, ArrayList<String> destinateurs){
        this.username = username;
        this.message = message;
        this.date = date;
        this.destinateurs = destinateurs;
    }

    public String getUsername(){
        return username;
    }

    public String getDestinateurs(){
        return username;
    }

    public String getMessage(){
        return message;
    }

    public LocalDateTime getDate(){
        return date;
    }
}
