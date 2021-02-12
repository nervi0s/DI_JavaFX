package demos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DemoContextMenu extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label();

        Circle circulo = new Circle();
        circulo.setRadius(80);
        circulo.setFill(Color.AQUA);

        VBox root = new VBox(label, circulo);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        //Creamos el ContextMenu
        ContextMenu contextMenu = new ContextMenu();

        //Creamos los Item del ContextMenu
        MenuItem item1 = new MenuItem("Hola");
        MenuItem item2 = new MenuItem("Mundo");

        //Manejadores para los Items
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                label.setText("Seleccionado: Hola");
            }
        });

        item2.setOnAction((event) -> {
            label.setText("Seleccionado: Mundo");
        });
        //Manejador para que aparezca el manu contextual al pinchar el circulo
        circulo.setOnContextMenuRequested(e -> {
            contextMenu.show(circulo, e.getScreenX(), e.getScreenY());
        });

        //Añadimos los items al context menu
        contextMenu.getItems().addAll(item1, item2);

        Scene scene = new Scene(root);
        stage.setTitle("Demo Context Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
