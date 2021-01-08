package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Controller extends Main {

    public TextArea messages;
    public TextField write_text;
    public Button startServer_button;
    public TextField username_text;
    public TextField port_text;
    public TextField ip_address_text;
    public Button send_button;
    public Button connect_button;

    /*
        private ConnectionThread cThread = new ConnectionThread();
        private Consumer<Serializable> onReceiveCallback;
    
        public Controller(Consumer<Serializable> onReceiveCallback) {
            this.onReceiveCallback = onReceiveCallback;
        }
    
        public void startConnection() throws Exception {
            cThread.start();
        }
    
        public void send(Serializable data) throws Exception {
            cThread.out.writeObject(data);
        }
    
        public void closeConnection() throws Exception {
            cThread.socket.close();
        }
    
        protected abstract boolean isServer();
    
        protected abstract String getIP();
    
        protected abstract int getPort();
    
        private class ConnectionThread extends Thread {
            private Socket socket;
            private ObjectOutputStream out;
    
            @Override
            public void run() {
                try (ServerSocket server = isServer() ? new ServerSocket(getPort()) : null;
                     Socket socket = isServer() ? server.accept() : new Socket(getIP(), getPort());
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
    
                    this.socket = socket;
                    this.out = out;
    //              socket.setTcpNoDelay(true);
    
                    while (true) {
                        Serializable data = (Serializable) in.readObject();
                        onReceiveCallback.accept(data);
                    }
    
                } catch (Exception e) {
                    onReceiveCallback.accept("Connection closed!");
                }
    

            }
    */
    public void createClient(ActionEvent event) {
        if (Server.getCount() == 0) {
            Client client = new Client(Integer.parseInt(ip_address_text.getText()), Integer.parseInt(port_text.getText()), username_text.getText());
        }
    }

    public void createServer(ActionEvent event) {
        Server server = new Server(Integer.parseInt(port_text.getText()));
        messages.appendText("Server lauscht auf Port " + Integer.parseInt(port_text.getText()) + "\n");

    }

    public void buttonPressed(ActionEvent event) {
        System.out.println("Funkt");

    }
}

