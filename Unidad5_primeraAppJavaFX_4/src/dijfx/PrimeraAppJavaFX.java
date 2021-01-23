package dijfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimeraAppJavaFX extends Application {

    public static void main(String[] args) {
        //Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World!");
        stage.centerOnScreen();
        stage.setOpacity(1);

        VBox vbox = new VBox(); //Nodo raiz
        vbox.setAlignment(Pos.CENTER);
        // Group grupo = new Group(); //Nodo raiz
        // BorderPane root = new BorderPane();

        Button button = new Button("Say 'Hello World'");
        Label label = new Label();

        vbox.getChildren().addAll(button, label);
        //grupo.getChildren().addAll(button, label);

        //Asociamos un manejador de eventos al boton
        
        //Opción 1: clase manejadora
        /*EventHandler<ActionEvent> manejador = new MiClaseManejadora();
        button.addEventHandler(javafx.event.ActionEvent.ACTION, manejador);*/
        
        //Opción 2: utilizar una clase anónima
        /*EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Hello World");
            }
        };
        button.addEventHandler(javafx.event.ActionEvent.ACTION, manejador);*/
        
        //Opción 3: utilizar una método de conveniencia (convenience method) de la clase Button
         /*EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Hello World");
            }
        };
        button.setOnAction(manejador);*/
         
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Hello World");
            }
        });*/
        
        //Opción 4: expresión lambda (a partir de Java 8)
        /*button.setOnAction((ActionEvent evento) -> {
            System.out.println("Hello World");
        });*/
        
        button.setOnAction((evento) -> {
            System.out.println("Hello World");
        });
        
        
        //root.setCenter(button);

        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Hello World");
                label.setText("Hello World :)");
            }
        });*/
        
        //Scene escena = new Scene(root, 300, 250);
        Scene escena = new Scene(vbox, 500, 300);
        
        stage.setScene(escena);
        stage.show();
    }
} // Fin de la Clase PrimeraAppJavaFX

class MiClaseManejadora implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
        System.out.println("Hello World");
    }

} // Fin de la Clase MiClaseManejadora
