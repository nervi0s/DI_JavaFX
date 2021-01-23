package dijfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrimeraAppJavaFX extends Application {

    public static void main(String[] args) {
        //Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Demo 2");

        stage.setWidth(700);
        stage.setHeight(500);

        stage.setMinWidth(500);
        stage.setMinHeight(300);

        stage.setMaxWidth(800);
        stage.setMaxHeight(600);

        //stage.setX(250);
        //stage.setY(0);
        stage.centerOnScreen();
        
        stage.setOpacity(0.5);
        
        stage.setResizable(false);
        
        /*   Button button = new Button("OK");

        Scene escena = new Scene(button, 200, 300);
        
        stage.setScene(escena);*/
        stage.show();

    }

}
