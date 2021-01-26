package dijfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimeraAppJavaFX extends Application {

    public static void main(String[] args) {
        //Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //HBox hBox = new HBox();
        Button bt1 = new Button("Botón 1");
        Button bt2 = new Button("Botón 2");

        HBox hBox = new HBox(bt1, bt2);

        Scene escena = new Scene(hBox, 300, 350);

        stage.setTitle("HBox");
        stage.setScene(escena);
        stage.show();

    }

}
