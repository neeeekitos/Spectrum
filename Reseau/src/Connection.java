import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

public class Connection {

    private final Socket connection;
    private final BufferedWriter out;
    private final BufferedReader in;
    private final Thread cnThread;
    private final EcouteurConnection eventEcouteur;


    public Connection(EcouteurConnection eventEcouteur, String ip, int port) throws IOException{
        this(eventEcouteur, new Socket(ip, port));
    }

    public Connection(EcouteurConnection eventEcouteur, Socket connection) throws IOException {
        this.eventEcouteur = eventEcouteur;
        this.connection = connection;

        OutputStream output = connection.getOutputStream();
        InputStream input = connection.getInputStream();

        //conversion du string en bytes, puis mettre cela dans le buffer
        out = new BufferedWriter(new OutputStreamWriter(output, Charset.forName("UTF-8")));
        in = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        cnThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventEcouteur.connectionReady(Connection.this);
                    while(!cnThread.isInterrupted()){
                        eventEcouteur.receiveString(Connection.this, in.readLine());
                    }
                } catch (IOException e) {
                    eventEcouteur.exception(Connection.this, e);
                } finally {
                    eventEcouteur.disconnect(Connection.this);
                }
            }
        });
        cnThread.start();
    }

    @Override
    public String toString(){
        return "Connection: " + connection.getInetAddress() + ": " + connection.getPort();
    }

    //syncronisé pour la securité
    public synchronized void sendString(String msg){
        try {
            out.write(msg + "\r\n");
            out.flush(); //pour envoyer de Buffer au client

            //ajouter l'envoie du message dans la DB
        } catch (IOException e){
            eventEcouteur.exception(Connection.this, e);
            disconnect();
        }
    }

    public synchronized void disconnect() {
        cnThread.interrupt();
        try {
            connection.close();
        } catch (IOException e){
            eventEcouteur.exception(Connection.this, e);
        }
    }
}