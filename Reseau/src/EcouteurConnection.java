import java.io.IOException;

public interface EcouteurConnection {

    void connectionReady(Connection connection);
    void receiveString(Connection connection, String msg);
    void disconnect(Connection connection);
    void exception(Connection connection, IOException e);
}
