/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Persona;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pasodatos.Principal;

/**
 * FXML Controller class
 *
 * @author CFGS
 */
public class VentanaPrincipalFXMLController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCiudad;

    public static Persona persona;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enviarDatos(ActionEvent event) {
        //Ocultar la ventana principal, desde donde se llama a este método enviarDatos()
        Principal.st.hide();

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String ciudad = txtCiudad.getText();

        persona = new Persona(nombre, apellido, ciudad);

        //Creamos un escenario para mostrar la nueva ventana (VentanaSecundaria)
        Stage st = new Stage();

        try {
            Parent p = FXMLLoader.load(getClass().getResource("../views/VentanaSecundariaFXML.fxml"));
            Scene scene = new Scene(p);
            st.setScene(scene);
            st.show();

            //Si salimos de la ventana secundaria volvemos a mostrar la ventana principal
            st.setOnCloseRequest(e -> {
                Principal.st.show();
            });

        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
