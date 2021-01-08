package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
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


    public void createClient(ActionEvent event) throws IOException {
        if (Server.getCount() == 0) {
            Client client = new Client(ip_address_text.getText(), Integer.parseInt(port_text.getText()), username_text.getText());
        }else{
            messages.appendText("Server läuft schon!\n");
        }

    }

    public void createServer(ActionEvent event) throws IOException {
        Server server = new Server(Integer.parseInt(port_text.getText()));
        messages.appendText("Server lauscht auf Port " + Integer.parseInt(port_text.getText()) + "\n");


    }

}

