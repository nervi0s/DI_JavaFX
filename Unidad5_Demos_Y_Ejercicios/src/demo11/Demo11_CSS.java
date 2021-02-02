package demo11;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Demo11_CSS extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        HBox hbox = new HBox(5);

        Scene scene = new Scene(hbox, 300, 250);
        File f = new File("./");
        System.out.println(f.getAbsolutePath());
        scene.getStylesheets().add("./demo11/mystyle.css");

        Pane panelIzquierdo = new Pane();

        Circle c1 = new Circle(50, 50, 30);
        Circle c2 = new Circle(150, 50, 30);
        Circle c3 = new Circle(100, 100, 30);
        Circle c4 = new Circle(100, 100, 30);

        panelIzquierdo.getChildren().addAll(c1, c2, c3);

        //Asociamos un selector de clase css de JavaFX a los elementos
        panelIzquierdo.getStyleClass().add("border");
        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        //Asociamos un ID al círculo
        c3.setId("redcircle");
        //Asociamos varios selectores de clase a un elemento
        c4.getStyleClass().addAll("circleborder", "plaincircle");

        Pane panelDerecho = new Pane();
        panelDerecho.getChildren().add(c4);
        //Asociamos un selector de clase css de JavaFX a los elementos
        panelDerecho.getStyleClass().add("border");

        hbox.getChildren().addAll(panelIzquierdo, panelDerecho);

        stage.setTitle("Demo 11");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
