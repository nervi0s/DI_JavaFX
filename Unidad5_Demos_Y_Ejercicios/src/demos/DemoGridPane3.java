package demos;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DemoGridPane3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        //Para Filas
        for (int i = 0; i < 10; i++) {
            RowConstraints rowConstraint = new RowConstraints(25);
            gridPane.getRowConstraints().add(rowConstraint);
        }
        //Para Columnas
        //ColumnConstraints​(double minWidth, double prefWidth, double maxWidth, Priority hgrow, HPos halignment, boolean fillWidth)
        for (int i = 0; i < 10; i++) {
            ColumnConstraints columnConstraint = new ColumnConstraints(60, 60, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true);
            gridPane.getColumnConstraints().add(columnConstraint);
        }

        //add​(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
        gridPane.add(new Button("Posición 0,0"), 0, 0, 2, 2);
        gridPane.add(new Button("Posición 1,2"), 1, 2, 1, 1);
        
        gridPane.add(new Button("Posición 0,2"), 0, 2);
        gridPane.add(new Button("Posición 2,0"), 2, 0);
        gridPane.add(new Button("Posición 2,1"), 2, 1);
        
        gridPane.add(new Button("Posición Col 9 Fila 2"), 9, 2);
        
        gridPane.getRowConstraints().get(1).setPrefHeight(100);
        gridPane.getColumnConstraints().get(2).setPrefWidth(200);
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        //gridPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setGridLinesVisible(true);
        Scene escena = new Scene(gridPane);
        stage.setTitle("Demo GridPane");
        stage.setScene(escena);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
