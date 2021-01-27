package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Controller {

    public TextArea messages;
    public TextField write_text;
    public Button startServer_button;
    public TextField username_text;
    public TextField port_text;
    public TextField ip_address_text;
    public Button send_button;
    public Button connect_button;

    public String str = "test";
    public Socket s;
    public ServerSocket ss;
    public Socket clientSocket;
    public String msgin = "";
    public String msgout = "";

    public void createClient(ActionEvent event) throws IOException {
        if (!Server.isServerRunning()) {
            Client client = new Client(ip_address_text.getText(), Integer.parseInt(port_text.getText()), username_text.getText());
            clientSocket = new Socket(ip_address_text.getText(), Integer.parseInt(port_text.getText()));
            messages.setText("Verbunden!");
        } else {
            messages.appendText("Server läuft schon!\n");
        }

    }

    public void createServer(ActionEvent event) throws IOException {
        Server server = new Server(Integer.parseInt(port_text.getText().trim()));
        try {
            ss = new ServerSocket(Integer.parseInt(port_text.getText()));
            s = ss.accept();
            System.out.println("Verbunden");
            messages.setText("Verbunden!");
        } catch (Exception e) {

        }
    }

    public void sendMsg(ActionEvent event) throws IOException {

        if (Server.isServerRunning()) {                                                  //Wenn Server läuft
            new Thread(() -> {
                try {
                    DataInputStream din = new DataInputStream(s.getInputStream());
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                    while (!msgin.equals("exit")) {
                        msgin = din.readUTF();
                        messages.appendText(msgin); //print client msg
                        msgout = write_text.getText();
                        dout.writeUTF(msgout);
                        dout.flush();
                    }
                } catch (IOException e ) { e.printStackTrace(); }
            }).start();



        } else {
            new Thread(() -> {
                try {
                    //Wenn Client läuft
                    DataInputStream din = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());

                    while (!msgin.equals("exit")) {
                        msgout = write_text.getText();
                        dout.writeUTF(msgout);
                        dout.flush();
                        msgin = din.readUTF();
                        messages.appendText(msgin); // print server msg
                    }
                } catch (IOException e ) { e.printStackTrace(); }
            }).start();

        }
    }

}

