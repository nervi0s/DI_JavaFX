package controllers;

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
import model.Persona;

/**
 * FXML Controller class
 *
 * @author wdal9
 */
public class DialogPersonFXMLController implements Initializable {

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
    private TextField tfPC;
    @FXML
    private TextField tfBirdthday;

    //Apuntan a los botones del DialogPane
    private Button aceptar;
    private Button cancelar;

    //Apuntan a los atributos que cambian del controlador AddressApp
    Text txtName, txtLastName, txtStreet, txtCity, txtPC, txtBirdthday;

    //Varaible que apunta a la persna seleccionada para editar o para eliminar;
    public static Persona personaDialog;

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
                //Creamos una persona nueva para añadirla a personaDialog que es como un 'handler' temporal de personas
                personaDialog = new Persona(tfName.getText(), tFLastName.getText(), tfStreet.getText(), tfCity.getText(), Integer.parseInt(tfPC.getText()), tfBirdthday.getText());
                //Hacemos que la persona se guarde en la lista con el método guardarEnLaLista()
                personaDialog.guardarEnLaLista();
            } else {
                personaDialog.setName(tfName.getText());
                personaDialog.setLastName(tFLastName.getText());
                personaDialog.setStreet(tfStreet.getText());
                personaDialog.setCity(tfCity.getText());
                personaDialog.setCp(Integer.parseInt(tfPC.getText()));
                personaDialog.setBirdthday(tfBirdthday.getText());
                establecerTextosEditados();;
            }
            //Una vez realizadas las acciones del botón aceptar apuntamos la variable 'handler' a nulo
            personaDialog = null;
        });

        cancelar.setOnAction(e -> {
            personaDialog = null;
        });
    }

    //true si todos lo campos están llenos, false en caso contrario
    private boolean camposRellenos() {
        return !tfName.getText().isEmpty()
                && !tFLastName.getText().isEmpty()
                && !tfStreet.getText().isEmpty()
                && !tfCity.getText().isEmpty()
                && !tfBirdthday.getText().isEmpty()
                && !tfPC.getText().isEmpty();
    }

    //Se crea un método para este controlador pueda recibir objetos desde otro controlador el cual lo llame
    public void apuntarATextos(Text name, Text lastName, Text street, Text city, Text pc, Text birdthday) {
        txtName = name;
        txtLastName = lastName;
        txtStreet = street;
        txtCity = city;
        txtPC = pc;
        txtBirdthday = birdthday;
    }

    //Se usa para mostrar en el controlador principal información actualizada en los campos de la derecha
    private void establecerTextosEditados() {
        txtName.setText(personaDialog.getName());
        txtLastName.setText(personaDialog.getLastName());
        txtStreet.setText(personaDialog.getStreet());
        txtCity.setText(personaDialog.getCity());
        txtPC.setText(String.valueOf(personaDialog.getCp()));
        txtBirdthday.setText(personaDialog.getBirdthday());
    }
}
