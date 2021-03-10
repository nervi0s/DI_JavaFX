/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author CFGS
 */
public class DialogPersonFXMLController implements Initializable {

    //Varaible que apunta a la persna seleccionada para editar o para eliminar;
    public static Persona personaDialog;

    @FXML
    private DialogPane dialogAddPerson;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tFLastName;
    @FXML
    private TextField tfStreet;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfBirdthday;
    @FXML
    private TextField tfPC;

    //Apuntan a los botones del DialogPane
    private Button aceptar;
    private Button cancelar;

    //Apuntan a los atributos que cambian del controlador AddressApp
    Text txtName, txtLastName, txtStreet, txtCity, txtPC, txtBirdthday;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Comprobamos si al llamar a este controlador personaDialog está apuntado a una persona
        //En caso afirmativo rellenamos los campos de texto con su información
        if (personaDialog != null) {
            tfName.setText(personaDialog.getName());
            tFLastName.setText(personaDialog.getLastName());
            tfStreet.setText(personaDialog.getStreet());
            tfCity.setText(personaDialog.getCity());
            tfBirdthday.setText(personaDialog.getBirdthday());
            tfPC.setText(String.valueOf(personaDialog.getCp()));
        }

        //Obetenemos los botones del panel (Aceptar y Cancelar)
        aceptar = (Button) dialogAddPerson.lookupButton(ButtonType.OK);
        cancelar = (Button) dialogAddPerson.lookupButton(ButtonType.CANCEL);

        aceptar.addEventFilter(ActionEvent.ACTION, e -> {//Si algún campo está vacío consumimos el click
            if (!camposRellenos()) {
                e.consume();
            }
        });

        aceptar.setOnAction(e -> {
            //Comprobar si se está añadiendo una persona nueva o editando una persona existente
            if (personaDialog == null) {
                personaDialog = new Persona(tfName.getText(), tFLastName.getText(), tfStreet.getText(), tfCity.getText(), Integer.parseInt(tfPC.getText()), tfBirdthday.getText());
                personaDialog.guardarEnLaLista();
                personaDialog = null;
            } else {
                //personaDialog = new Persona(tfName.getText(), tFLastName.getText(), tfStreet.getText(), tfCity.getText(), Integer.parseInt(tfPC.getText()), tfBirdthday.getText());
                personaDialog.setName(tfName.getText());
                personaDialog.setLastName(tFLastName.getText());
                personaDialog.setStreet(tfStreet.getText());
                personaDialog.setCity(tfCity.getText());
                personaDialog.setCp(Integer.parseInt(tfPC.getText()));
                personaDialog.setBirdthday(tfBirdthday.getText());

                establecerTextosEditados();
                personaDialog = null;
            }
        });

        cancelar.setOnAction(e -> {
            personaDialog = null;
        });
    }

    //true si todos lo campos estan rellenos, false en caso contrario
    private boolean camposRellenos() {
        return !tfName.getText().isEmpty()
                && !tFLastName.getText().isEmpty()
                && !tfStreet.getText().isEmpty()
                && !tfCity.getText().isEmpty()
                && !tfBirdthday.getText().isEmpty()
                && !tfPC.getText().isEmpty();
    }

    public void apuntarATextos(Text name, Text lastName, Text street, Text city, Text pc, Text birdthday) {
        txtName = name;
        txtLastName = lastName;
        txtStreet = street;
        txtCity = city;
        txtPC = pc;
        txtBirdthday = birdthday;
    }

    private void establecerTextosEditados() {
        txtName.setText(personaDialog.getName());
        txtLastName.setText(personaDialog.getLastName());
        txtStreet.setText(personaDialog.getStreet());
        txtCity.setText(personaDialog.getCity());
        txtPC.setText(String.valueOf(personaDialog.getCp()));
        txtBirdthday.setText(personaDialog.getBirdthday());
    }
}
