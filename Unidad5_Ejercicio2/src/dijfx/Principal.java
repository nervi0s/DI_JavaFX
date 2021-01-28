package dijfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TextField fieldLeft = new TextField();
        TextField fieldRight = new TextField();

        fieldLeft.setPrefWidth(200);
        fieldRight.setPrefWidth(200);

        fieldLeft.setOnKeyPressed((event -> {
            fieldRight.setText("Key Pressed: " + event.getText());
        }));

        HBox hBox = new HBox(30, fieldLeft, fieldRight);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderLayout = new BorderPane();
        borderLayout.setCenter(hBox);
        borderLayout.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(borderLayout, 600, 300);
        // Se require el foco en el campo de texto izquierdo (Debe estar después de la creación de la escena)
        fieldLeft.requestFocus();

        stage.setTitle("Handling KeyEvent");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
