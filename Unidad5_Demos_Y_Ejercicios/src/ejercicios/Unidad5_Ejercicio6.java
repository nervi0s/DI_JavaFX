package ejercicios;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Unidad5_Ejercicio6 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Creamos el root pane
        BorderPane root = new BorderPane();
        //creamos los hbox
        HBox hBoxArriba = new HBox();
        HBox hBoxAbajo = new HBox();
        //creamos los vbox
        VBox vBoxMedio = new VBox();
        VBox vBoxAbajo = new VBox();
        //Creamos los elementos sueltos
        Text title = new Text("Plese Login:");
        title.setId("titulo"); //ID para CSS
        Text botton = new Text("");
        botton.setId("mensaje"); //ID para CSS
        Label labelUser = new Label("User Name:");
        Label labelPassword = new Label("Password:");
        TextField textUser = new TextField();
        PasswordField textPassword = new PasswordField();
        Button sign = new Button("Sign in");
        //Añadismo nodos a los paneles:
        hBoxArriba.getChildren().addAll(labelUser, textUser);
        hBoxAbajo.getChildren().addAll(labelPassword, textPassword);

        vBoxMedio.getChildren().addAll(hBoxArriba, hBoxAbajo);

        vBoxAbajo.getChildren().addAll(sign, botton);

        //Añadimos paneles al root:
        root.setTop(title);
        root.setCenter(vBoxMedio);
        root.setBottom(vBoxAbajo);

        //detalles:
        vBoxMedio.setSpacing(15);
        vBoxMedio.setPadding(new Insets(20, 0, 0, 0));

        labelUser.setPrefWidth(75);
        labelPassword.setPrefWidth(75);

        BorderPane.setMargin(title, new Insets(70, 40, 0, 40));
        BorderPane.setMargin(vBoxMedio, new Insets(0, 40, 0, 40));
        BorderPane.setMargin(vBoxAbajo, new Insets(30, 40, 5, 40));

        //.setAlignment(root, Pos.CENTER);
        title.setFont(new Font(20));
        title.setStyle("-fx-font-weight: bold");
        //title.setFont(Font.font(STYLESHEET_MODENA, FontWeight.EXTRA_BOLD, 35));

        vBoxAbajo.setAlignment(Pos.CENTER_RIGHT);
        VBox.setMargin(botton, new Insets(20, 20, 30, 0));

        //Funcionalidad Botón
        sign.setOnAction((ev) -> {
            botton.setText("Botón Sig in pulsado");
            botton.setFill(Color.RED);
        });

        Scene escena = new Scene(root);
        
        escena.getStylesheets().add("ejercicios/estilo_ejercicio6.css");
        stage.setTitle("Ejercicio 5");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
