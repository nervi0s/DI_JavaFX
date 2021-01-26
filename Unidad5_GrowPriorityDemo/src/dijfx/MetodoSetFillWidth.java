package dijfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MetodoSetFillWidth extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Button bt1 = new Button("Botón 1");
        bt1.setMaxWidth(Double.MAX_VALUE);//Para que el ancho del botón pueda crecer hasta Double.MAX_VALUE píxeles

        VBox vBox = new VBox(bt1);

        vBox.setFillWidth(false);

        Scene escena = new Scene(vBox, 300, 250);
        stage.setTitle("Demo Método SetFillHeight");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
