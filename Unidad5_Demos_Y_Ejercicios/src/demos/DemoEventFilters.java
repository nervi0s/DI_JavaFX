package demos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DemoEventFilters extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Creación del layout principal
        BorderPane root = new BorderPane();

        Text texto = new Text("Manejo de Eventos");
        texto.setFont(new Font(20));
        //Asignamos el texto al root del BorderPane
        root.setTop(texto);
        //Creación de botones
        Button btnValidar = new Button("Validar");
        Button btnLimpiar = new Button("Limpiar");
        //Creamos un Hbox que contendrá los botones
        HBox hboxBotones = new HBox(btnValidar, btnLimpiar);
        hboxBotones.setSpacing(20); //Espaciado entre elementos del HBox
        //Asignamos el contenedor de los botones al root del BorderPane
        root.setBottom(hboxBotones);

        //Vamos con el centro del BorderPane
        //contenido del VBox de la izquierda
        Label lblNombre = new Label("Nombre:");
        TextField txtNombre = new TextField();

        Label lblApellidos = new Label("Apellidos:");
        TextField txtApellidos = new TextField();
        //Creamos el VBox de la izquierda y le asignamos los elementos
        VBox vboxIzquierda = new VBox(lblNombre, txtNombre, lblApellidos, txtApellidos);
        //contenido del VBox de la derecha
        Label lblFijo = new Label("Teléfono fijo:");
        TextField txtFijo = new TextField();

        Label lblMovil = new Label("Teléfono móvil:");
        TextField txtMovil = new TextField();
        //Creamos el VBox de la derecha y le asignamos los elementos
        VBox vboxDerecha = new VBox(lblFijo, txtFijo, lblMovil, txtMovil);

        //Creamos un contenedor de tipo Grid
        GridPane gridCentral = new GridPane();

        //Asignamos los VBoxes al contenedor de tipo Grid
        gridCentral.addColumn(0, vboxIzquierda);
        gridCentral.addColumn(1, vboxDerecha);

        //Asignamos el grid al root del BorderPane
        root.setCenter(gridCentral);

        //----TRATAMIENTO DE EVENTOS----
        //EventFilters
        vboxIzquierda.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (Character.isDigit((e.getCharacter().charAt(0)))) {
                    e.consume();
                }
            }
        });
        vboxDerecha.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (!Character.isDigit((e.getCharacter().charAt(0)))) {
                    e.consume();
                }
            }
        });
        //EventHandlers
        txtMovil.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (txtMovil.getText().length() > 8) {
                    e.consume();
                }
            }
        });

        //----FIN TRATAMIENTO DE EVENTOS----
        Scene escena = new Scene(root);
        stage.setTitle("Demo 10");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
