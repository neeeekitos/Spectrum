import java.io.IOException;

/** Interface qui caractérise une connection
 * @author Nikita TEREKHOV
 * @author Valentina ETEGAN
 */
public interface EcouteurConnection {

    void connectionReady(ConnectionExchange connection, String username);
    void receiveString(String msg);
    void disconnect(ConnectionExchange connection);
    void exception(ConnectionExchange connection, IOException e);
}
