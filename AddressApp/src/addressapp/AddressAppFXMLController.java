/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<?, ?> tableColumnLastName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void crearPersona(ActionEvent event) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Pop", "Pop last", "calle 123", "Madrid", 2222, "19/19/19"));
        ObservableList<Persona> lista = FXCollections.observableArrayList(personas);
        tableView.setItems(lista);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @FXML
    private void editarPersona(ActionEvent event) {
    }

    @FXML
    private void EliminarPersona(ActionEvent event) {
    }

}
