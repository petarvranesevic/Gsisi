package sample;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Controller{
    private static boolean serverRunning = false;
    private int port;


    public Server(int port) throws IOException {
        this.port = port;
        serverRunning = true;
       // createServer(port);
    }



    public static boolean isServerRunning() {
        return serverRunning;
    }


}
