/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author CFGS
 */
public class VentanaSecundariaFXMLController implements Initializable {

    @FXML
    private Label labelNombre;
    @FXML
    private Label labelApellido;
    @FXML
    private Label labelCiudad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Persona p = VentanaPrincipalFXMLController.persona;
        labelNombre.setText(p.getNombre());
        labelApellido.setText(p.getApellido());
        labelCiudad.setText(p.getCiudad());
        
    }

}
