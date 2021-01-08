package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {

    /*
    private boolean isServer = true;
    private Controller connection = isServer ? createServer() : createClient();


    private Server createServer(){
        return new Server(5555, data -> {
            Platform.runLater(() -> {
            });
        });
    }

    private Client createClient(){
        return new Client("127.0.0.1", 5555,data -> {
            Platform.runLater(() -> {
            });
        });
    }

 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Gsisi Chat");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);

    }

}
