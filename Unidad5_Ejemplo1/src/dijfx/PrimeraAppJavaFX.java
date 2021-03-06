package dijfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        //HBox hBox = new HBox(30,bt1, bt2); //Espaciado entre nodos
        //hBox.setSpacing(30); //Espaciado entre nodos

        //HBox.setMargin(bt1, new Insets(30, 50, 30, 30)); //Márgenes alrededor de un nodo (método estático)
        //hBox.setAlignment(Pos.BASELINE_CENTER); //Alineamiento de los nodos hijos dentro del HBox
        
        //HBox.setHgrow(bt2, Priority.ALWAYS); //Establece la prioridad de crecimiento horizontal del nodo indicado
        Scene escena = new Scene(hBox, 300, 350);

        stage.setTitle("HBox");
        stage.setScene(escena);
        stage.show();

    }

}
