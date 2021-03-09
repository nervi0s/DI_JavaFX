/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author CFGS
 */
public class AddressAppFXMLController implements Initializable {

    @FXML
    private Button buttonNew;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private TableView<Persona> tableView;
    @FXML
    private TableColumn<Persona, String> tableColumnName;
    @FXML
    private TableColumn<Persona, String> tableColumnLastName;
    @FXML
    private Text txtName;
    @FXML
    private Text txtLastName;
    @FXML
    private Text txtStreet;
    @FXML
    private Text txtCity;
    @FXML
    private Text txtPC;
    @FXML
    private Text txtBirdthday;

    public static ObservableList<Persona> lista = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setItems(lista);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getFocusModel().focusedCellProperty().addListener((e) -> {
            Persona personaSeleccionada = tableView.getSelectionModel().getSelectedItem();

            if (personaSeleccionada != null) {//Si seleccionamos a una persona de la lista
                int id = personaSeleccionada.getId();
                String name = personaSeleccionada.getName();
                String lastName = personaSeleccionada.getLastName();
                String street = personaSeleccionada.getStreet();
                String city = personaSeleccionada.getCity();
                int pc = personaSeleccionada.getCp();
                String birdthday = personaSeleccionada.getBirdthday();

                txtName.setText(name + " " + id);
                txtLastName.setText(lastName);
                txtStreet.setText(street);
                txtCity.setText(city);
                txtPC.setText(String.valueOf(pc));
                txtBirdthday.setText(birdthday);
            }

        });

        //Comprobamos si la lista está vacía
        buttonEdit.setDisable(lista.isEmpty());

        //Añado un listener a la lista para desactivar el botón Edit en caso de que esté vacía, de lo contrario se vuelve clickable
        lista.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> change) {
                if (lista.isEmpty()) {
                    buttonEdit.setDisable(true);
                } else {
                    buttonEdit.setDisable(false);
                }
            }
        });
    }

    @FXML
    private void crearPersona(ActionEvent event) {
        showDialog();
    }

    @FXML
    private void editarPersona(ActionEvent event) {
        Persona personaSeleccionada = tableView.getSelectionModel().getSelectedItem();

        if (personaSeleccionada != null) {
            showDialog(personaSeleccionada);
        } else {
            System.out.println("debe seleccionar para editar");
        }
    }

    @FXML
    private void EliminarPersona(ActionEvent event) {
    }

    //Para mostrar la ventana de diálogo vacía
    private void showDialog() {
        try {
            DialogPane dialogPane = FXMLLoader.load(getClass().getResource("./views/DialogPersonFXML.fxml"));

            Dialog dialogWindow = new Dialog();

            dialogWindow.setDialogPane(dialogPane);
            dialogWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(AddressAppFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Para mostrar la ventana de diálogo con los campos llenos
    private void showDialog(Persona persona) {

        try {
            DialogPersonFXMLController.personaDialog = persona;

            DialogPane dialogPane = FXMLLoader.load(getClass().getResource("./views/DialogPersonFXML.fxml"));

            Dialog dialogWindow = new Dialog();

            dialogWindow.setDialogPane(dialogPane);
            dialogWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(AddressAppFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
