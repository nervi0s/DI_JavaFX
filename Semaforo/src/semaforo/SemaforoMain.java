package semaforo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SemaforoMain extends Application {

    private Circle circleTop;
    private Circle circleMiddle;
    private Circle circleBotton;

    private Thread hiloSemaforo;

    @Override
    public void start(Stage stage) throws Exception {
        StackPane rootPanel = new StackPane();
        rootPanel.setAlignment(Pos.CENTER);
        rootPanel.setPadding(new Insets(10));

        circleTop = new Circle(50);
        circleMiddle = new Circle(50);
        circleBotton = new Circle(50);

        VBox vboxCircles = new VBox(5, circleTop, circleMiddle, circleBotton);
        vboxCircles.setAlignment(Pos.CENTER);

        Button buttonOn = new Button("ON");
        Button buttonOff = new Button("OFF");
        buttonOn.setPrefSize(50, 100);
        buttonOff.setPrefSize(50, 100);

        VBox vboxButtons = new VBox(20, buttonOn, buttonOff);
        vboxButtons.setAlignment(Pos.CENTER);

        HBox hbox = new HBox(20, vboxCircles, vboxButtons);
        hbox.setAlignment(Pos.CENTER);

        rootPanel.getChildren().add(hbox);

        buttonOn.setOnAction((e) -> {
            empezarSemaforo();
        });

        buttonOff.setOnAction((e) -> {
            detenerSemaforo();
        });

        Scene scene = new Scene(rootPanel);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void empezarSemaforo() {
        hiloSemaforo = SemaforoHilos.getInstance(circleTop, circleMiddle, circleBotton);
        if (!hiloSemaforo.isAlive()) {
            System.out.println("Se ha encendido el semáforo");
            hiloSemaforo.start();
        } else {
            System.out.println("El semáforo está actualmente encendido");
        }
    }

    public void detenerSemaforo() {
        if (hiloSemaforo.isAlive()) {
            System.out.println("Se ha apagado el semáforo");
            hiloSemaforo.interrupt();
        } else {
            System.out.println("El semáforo está actualmente apagado");
        }
    }

}
