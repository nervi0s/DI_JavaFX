package adressapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddressAppMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Cargamos el escenario principal
        Parent root = FXMLLoader.load(getClass().getResource("../views/AddressAppFXML.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Address App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
