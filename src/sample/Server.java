package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Controller {
    private static int count = 0;
    private int port;

    {
        count++;
    }

    /*   private int port;

       public Server(int port, Consumer<Serializable> onReceiveCallback) {
           super(onReceiveCallback);
           this.port = port;
       }

       @Override
       protected boolean isServer() {
           return true;
       }

       @Override
       protected String getIP() {
           return null;

       }

       @Override
       protected int getPort() {
           return port;

       }
   */


    public Server(int port) throws IOException {
        this.port = port;
    }

    public void createServer(int p) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
    }


    public void connection(ServerSocket serverSocket){
       /* new Thread(() -> {
            try{
                Socket remoteSocket = serverSocket.accept();
            }catch (Exception e){

            }
        });

        */
    }

    public static int getCount() {
        return count;
    }


}
