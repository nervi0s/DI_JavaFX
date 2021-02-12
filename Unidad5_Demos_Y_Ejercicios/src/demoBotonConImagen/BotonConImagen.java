package demoBotonConImagen;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BotonConImagen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        File file = new File("./src/demoBotonConImagen/house.png");
        FileInputStream fis = new FileInputStream(file);

        Image imagen = new Image(fis);
        ImageView imageView = new ImageView(imagen);
        Button boton = new Button("Botón 1", imageView);

        boton.setOnMouseEntered(eh -> {
            int x = (int) (Math.random() * 400);
            int y = (int) (Math.random() * 400);
            stage.setX(x);
            stage.setY(y);
        });

        Scene scene = new Scene(boton, 400, 100);
        stage.setScene(scene);
        stage.setTitle("Demo botón con imagen");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
