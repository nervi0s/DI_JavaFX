package demos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

public class DemoFlowPane extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        CustomPane pane1 = new CustomPane("Fist Name:");
        CustomPane pane2 = new CustomPane("Middle:");
        CustomPane pane3 = new CustomPane("Last Name:");

        FlowPane panel = new FlowPane(5, 10, pane1, pane2, pane3);
        //panel.setOrientation(Orientation.VERTICAL);//Para cambiar la orientación de los elementos del FlowPane
        panel.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene escena = new Scene(panel, 800, 300);
        stage.setTitle("Demo FlowPane");
        stage.setScene(escena);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    class CustomPane extends HBox {

        private Label label;
        private TextField text;

        public CustomPane(String title) {
            label = new Label(title);
            text = new TextField();
            this.setSpacing(20);
            getChildren().addAll(label, text);
            setPadding(new Insets(11, 12, 13, 14));
            setHgrow(text, Priority.ALWAYS);
            setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

}
