package pasodatos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    //Variable estática para "extraer" el stage principal
    public static Stage st;

    @Override
    public void start(Stage stage) throws Exception {
        st = stage;

        Parent root = FXMLLoader.load(getClass().getResource("../views/VentanaPrincipalFXML.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
