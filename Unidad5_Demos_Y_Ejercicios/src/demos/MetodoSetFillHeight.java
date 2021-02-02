package demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MetodoSetFillHeight extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Button bt1 = new Button("Botón 1");
        bt1.setMaxHeight(Double.MAX_VALUE);//Para que el alto del botón pueda crecer hasta Double.MAX_VALUE píxeles

        HBox hBox = new HBox(bt1);

        hBox.setFillHeight(true);

        Scene escena = new Scene(hBox, 300, 250);
        stage.setTitle("Demo Método SetFillHeight");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
