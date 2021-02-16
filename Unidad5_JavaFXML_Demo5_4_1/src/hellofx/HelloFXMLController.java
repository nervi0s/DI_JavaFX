package hellofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloFXMLController implements Initializable {
    
    @FXML
    private Button miBoton;
    @FXML
    private Label miEtiqueta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void manejarBoton(ActionEvent event) {
        miEtiqueta.setText("Hello world!");
    }
    
}
