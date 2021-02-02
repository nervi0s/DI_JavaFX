package ejercicios;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Unidad5_Ejercicio3 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Creamos el StackPane
        StackPane panel = new StackPane();
        //Creamos las 3 formas
        Rectangle rectBotton = new Rectangle(400, 400);
        rectBotton.setFill(Color.BLACK);
        Circle circleMiddle = new Circle(100);
        circleMiddle.setFill(Color.RED);
        Rectangle rectTop = new Rectangle(100, 40);
        rectTop.setFill(Color.WHITE);
        //Colocamos las figuras en el StackPane (el orden importa)
        panel.getChildren().addAll(rectBotton, circleMiddle, rectTop);

        Scene escena = new Scene(panel);
        stage.setTitle("Ejercicio 3");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
