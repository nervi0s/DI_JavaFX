package ejercicios;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Unidad5_Ejercicio4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Creamos el GripPane
        GridPane grid = new GridPane();

        //Para Filas
        for (int i = 0; i < 4; i++) {
            RowConstraints rowConstraint = new RowConstraints(25);
            grid.getRowConstraints().add(rowConstraint);
        }
        //Para Columnas
        for (int i = 0; i < 2; i++) {
            ColumnConstraints columnConstraint = new ColumnConstraints();
            grid.getColumnConstraints().add(columnConstraint);
        }
        //Añadimos elementos al grid
        grid.add(new Label("Frist Name:"), 0, 0);
        grid.add(new TextField(), 1, 0);

        grid.add(new Label("MI:"), 0, 1);
        grid.add(new TextField(), 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(new TextField(), 1, 2);

        grid.add(new Button("Add Name"), 1, 3);

        grid.setHgap(20);
        grid.setVgap(35);

        grid.setAlignment(Pos.CENTER);

        grid.getRowConstraints().get(3).setPrefHeight(100);
        grid.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);

        grid.setGridLinesVisible(true);

        Scene escena = new Scene(grid);
        stage.setTitle("Ejercicio 4");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
