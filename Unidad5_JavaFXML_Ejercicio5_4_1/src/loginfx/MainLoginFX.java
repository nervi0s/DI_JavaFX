package loginfx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLoginFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("loginfx/estilo_ejercicio.css");

        stage.setTitle("JavaFX Login Form");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    /*private void stageResize(Stage stage) {
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                System.out.println("Width: " + stage.getWidth());
            }
        });

        stage.heightProperty().addListener((o) -> {
            System.out.println("Height: " + stage.getHeight());
        });
    }*/
}
