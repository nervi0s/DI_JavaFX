package ejercicios;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Unidad5_Ejercicio5 extends Application {

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
        Text botton = new Text("asdasd");
        Label labelUser = new Label("User Name:");
        Label labelPassword = new Label("Password:");
        TextField textUser = new TextField();
        TextField textPassword = new TextField();
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

        Scene escena = new Scene(root);
        stage.setTitle("Ejercicio 4");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
