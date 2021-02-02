package demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DemoStackPane extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Creamos el StackPane
        StackPane panel = new StackPane();
        //Creamos los 3 cuadrados
        Rectangle rectBotton = new Rectangle(250, 250);
        rectBotton.setFill(Color.AQUA);
        Rectangle rectMiddle = new Rectangle(200, 200);
        rectMiddle.setFill(Color.CADETBLUE);
        Rectangle rectTop = new Rectangle(150, 150);
        rectTop.setFill(Color.CORAL);
        //Colocamos los cuadrados en el StackPane (el orden importa)
        panel.getChildren().addAll(rectBotton, rectMiddle, rectTop);

        Scene escena = new Scene(panel);
        stage.setTitle("Demo StackPane");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
