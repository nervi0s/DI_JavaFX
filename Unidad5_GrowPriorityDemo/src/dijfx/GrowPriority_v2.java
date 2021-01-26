package dijfx;

import javafx.application.Application;
import javafx.geometry.Insets;
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

public class GrowPriority_v2 extends Application {

    public static void main(String[] args) {
        //Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button bt1 = new Button("Botón 1");
        Button bt2 = new Button("Botón 2");
        Button bt3 = new Button("Botón 3");
        Button bt4 = new Button("Botón 4");

        HBox hBoxIzq = new HBox(10, bt1, bt2);
        HBox hBoxDcha = new HBox(10, bt3, bt4);

        HBox.setMargin(bt1, new Insets(10));
        HBox.setMargin(bt2, new Insets(10));
        HBox.setMargin(bt3, new Insets(10));
        HBox.setMargin(bt4, new Insets(10));

        hBoxIzq.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        hBoxDcha.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox.setHgrow(hBoxIzq, Priority.ALWAYS);
        HBox.setHgrow(hBoxDcha, Priority.SOMETIMES);

        HBox hBoxGeneral = new HBox(20, hBoxIzq, hBoxDcha);
        //HBox.setMargin(hBoxGeneral, new Insets(50));
        hBoxGeneral.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        Button bt5 = new Button("Botón 5");
        Button bt6 = new Button("Botón 6");
        // Nuevo nodo que contendrá a los otros
        VBox vBox = new VBox(20, hBoxGeneral, bt5, bt6);

        //vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene escena = new Scene(vBox, 500, 650);

        stage.setTitle("Grow Priority");
        stage.setScene(escena);
        stage.show();

    }

}
