package demos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DemoGridPane2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        //add​(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
        gridPane.add(new Button("Posición 0,0"), 0, 0, 2, 2);
        gridPane.add(new Button("Posición 1,2"), 1, 2, 1, 1);

        gridPane.add(new Button("Posición 0,2"), 0, 2);
        gridPane.add(new Button("Posición 2,0"), 2, 0);
        gridPane.add(new Button("Posición 2,1"), 2, 1);

        gridPane.add(new Button("Posición Col 9 Fila 2"), 9, 2);

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene escena = new Scene(gridPane);
        stage.setTitle("Demo GridPane");
        stage.setScene(escena);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
