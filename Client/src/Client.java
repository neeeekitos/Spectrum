import java.io.IOException;

public class Client implements EcouteurConnection{

    private static final String IP_ADDR = "99.222.158.232";
    private static final int PORT = 8728;
    private Connection connection;

    public static void main(String[] args) {
        //attention avec swing on peut travailler que de Thread edt
        new Client();
    }

    private Client(){
        try {
            connection = new Connection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            printMsg("exception de connexion " + e);
            e.printStackTrace();
        }
    }

    public void sendString(String msg){
        connection.sendString(msg);
    }


    @Override
    public void connectionReady(Connection connection) {
        printMsg("connection établie");
    }

    @Override
    public void receiveString(Connection connection, String msg) {
        printMsg(msg);
    }

    @Override
    public void disconnect(Connection connection) {
        printMsg("Connection fermée");
    }

    @Override
    public void exception(Connection connection, IOException e) {
        printMsg("Exception de connection " + e);
    }

    public synchronized void printMsg(String msg){ //тк работаем из потока окошка и соединения
        System.out.println(msg);
    }
}
