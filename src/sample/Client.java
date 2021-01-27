package sample;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.function.Consumer;

public class Client extends Controller {
    private String ip;
    private int port;
    private String username;

    public Client(String ip, int port, String username) throws IOException {
        this.ip = ip;
        this.port = port;
        this.username = username;
    }
    public static void createClient() throws IOException {

    }



}

