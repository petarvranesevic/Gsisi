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
        createServer(port);
    }

    public void createServer(int p) throws IOException {

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                Socket remoteSocket = serverSocket.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /*
    public void connection(ServerSocket serverSocket){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Socket remoteSocket = serverSocket.accept();
                }catch (Exception e){

                }
            }
        });
    }

     */
    public static int getCount() {
        return count;
    }


}
