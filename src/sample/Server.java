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


    public Server(int port) {
        this.port = port;
        createServer(port);
    }

    public void createServer(int p) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
/*
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");

            }

 */
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static int getCount(){
        return count;
    }


}
