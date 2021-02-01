package demos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DemoBorderPane extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        /*Label lb1 = new Label("Top");
        Label lb2 = new Label("Right");
        Label lb3 = new Label("Botton");
        Label lb4 = new Label("Left");
        Label lb5 = new Label("Center");*/
        BorderPane panel = new BorderPane(new CustomPane("Center"), new CustomPane("Top"), new CustomPane("Right"), new CustomPane("Botton"), new CustomPane("Left"));

        //lb4.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        /*BorderPane.setAlignment(lb1, Pos.CENTER);
        BorderPane.setAlignment(lb3, Pos.CENTER);
        BorderPane.setAlignment(lb4, Pos.CENTER);
        BorderPane.setAlignment(lb2, Pos.CENTER);*/
        Scene escena = new Scene(panel, 400, 250);
        stage.setTitle("Demo BorderPane");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class CustomPane extends StackPane {

        public CustomPane(String title) {
            getChildren().add(new Label(title));
            //setStyle("-fx-border-color: red");//Una forma de darle borde
            setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            setPadding(new Insets(10, 12, 14, 16));
        }
    }
}
