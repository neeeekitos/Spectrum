import java.io.IOException;

public interface EcouteurConnection {

    void connectionReady(Connection connection, String username);
    void receiveString(String msg);
    void disconnect(Connection connection);
    void exception(Connection connection, IOException e);
}
