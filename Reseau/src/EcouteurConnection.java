import java.io.IOException;

public interface EcouteurConnection {

    void connectionReady(ConnectionExchange connection, String username);
    void receiveString(String msg);
    void disconnect(ConnectionExchange connection);
    void exception(ConnectionExchange connection, IOException e);
}
