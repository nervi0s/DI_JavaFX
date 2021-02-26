package message;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainMessageFX extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("MessageFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("BorderPane");
        stage.setScene(scene);
        stage.show();
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
