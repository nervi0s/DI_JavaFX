package demos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GrowPriority_v1 extends Application {

    public static void main(String[] args) {
        //Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button bt1 = new Button("Botón 1");
        Button bt2 = new Button("Botón 2");

        HBox hBox = new HBox(bt1, bt2);

        HBox.setMargin(bt1, new Insets(15));
        HBox.setMargin(bt2, new Insets(20));

        bt2.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(bt1, Priority.NEVER);
        HBox.setHgrow(bt2, Priority.ALWAYS);//Establece la prioridad de crecimiento horizontal del nodo indicado

        hBox.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));

        Button bt3 = new Button("Botón 3");
        Button bt4 = new Button("Botón 4");

        // Nuevo nodo que contendrá al otro
        VBox vBox = new VBox(20, hBox, bt3, bt4);

        VBox.setMargin(hBox, new Insets(50));
        //VBox.setMargin(bt3, new Insets(20));
        //VBox.setMargin(bt4, new Insets(30));

        vBox.setAlignment(Pos.CENTER);

        /*bt4.setMaxHeight(Double.MAX_VALUE);

        VBox.setVgrow(bt4, Priority.ALWAYS);*/
        
        vBox.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene escena = new Scene(vBox, 300, 350);

        stage.setTitle("HBox Grow Priority");
        stage.setScene(escena);
        stage.show();

    }

}
