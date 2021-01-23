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
        stage.setTitle("Título de la ventana");
        
        Button button = new Button("OK");

        Scene escena = new Scene(button, 200, 300);
        
        stage.setScene(escena);
        
        stage.show();
        
   }

}
