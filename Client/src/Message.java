import java.util.*;

public class Message {
    public String username;
    public String message;
    public Date date;

    public Message(String username, String message, Date date){|
        this.username=username;
        this.message=message;
        this.date=date;
    }

    public String getUsername(){
        return username;
    }

    public String getMessage(){
        return message;
    }

    public Date getDate(){
        return date;
    }
}
