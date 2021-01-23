package dijfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimeraAppJavaFX extends Application {

    public static void main(String[] args) {
        //Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Demo 3");
        //stage.setWidth(300);
        //stage.setHeight(300);
        stage.centerOnScreen();
        stage.setOpacity(1);

        Group grupo = new Group(); //Nodo raiz

        Scene escena = new Scene(grupo, 700, 500);
        escena.setFill(Color.GREEN);

        Circle circulo = new Circle(350, 250, 30, Color.AQUA);
        
        Text texto = new Text(100, 50, "GG");
        texto.setFill(Color.RED);
        texto.setFont(new Font(35));
        
        
        grupo.getChildren().addAll(circulo, texto);
        

        /*   Button button = new Button("OK");

        Scene escena = new Scene(button, 200, 300);
        
        stage.setScene(escena);*/
        stage.setScene(escena);

        stage.show();
   
    }

}
