package dijfx;

import java.awt.Toolkit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Principal extends Application {

    private static int counter = 0;

    @Override
    public void start(Stage stageMain) throws Exception {

        Button bt1 = new Button("OK");

        bt1.setOnAction((event) -> {
            Button btr = new Button("Nuevo Stage");
            Scene sceneRandom = new Scene(btr, 300, 300);
            Stage stageRandom = new Stage();
            stageRandom.setTitle("Stage Ramdon " + (++counter));
            int x = getRandomCoords()[0];
            int y = getRandomCoords()[1];
            stageRandom.setX(x);
            stageRandom.setY(y);
            stageRandom.setScene(sceneRandom);
            stageRandom.show();
        });

        Scene sceneMain = new Scene(bt1, 300, 300);

        stageMain.setTitle("Primary Stage");
        stageMain.setX(200);
        stageMain.setY(200);
        stageMain.setScene(sceneMain);
        stageMain.show();

        Button bt2 = new Button("Nuevo Stage");

        Scene sceneSecondary = new Scene(bt2, 300, 300);

        Stage stageSecondary = new Stage();
        stageSecondary.setTitle("Secondary Stage");
        stageSecondary.setX(600);
        stageSecondary.setY(200);
        stageSecondary.setScene(sceneSecondary);
        stageSecondary.show();

    }

    public int[] getRandomCoords() {
        //Obtenemos las dimensiones de la pantalla
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        int randomX = (int) (Math.random() * (screenWidth + 1));
        int randomY = (int) (Math.random() * (screenHeight + 1));

        int[] dimensions = {randomX, randomY};
        return dimensions;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
