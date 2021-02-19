/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5_4_2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author CFGS
 */
public class Ejercicio5_4_2FXMLController implements Initializable {

    @FXML
    private Button buttonAddTask;
    @FXML
    private Button buttonDeleteTask;
    @FXML
    private Button buttonExit;
    @FXML
    private ListView<String> listViewList;
    @FXML
    private TextField textInput;

    private ObservableList<String> observableItems = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //listViewList.setItems(ol);
    }

    @FXML
    private void addTask(ActionEvent event) {
        if (!textInput.getText().isEmpty()) {
            observableItems.add(textInput.getText());
            listViewList.setItems(observableItems);
        }
    }

    @FXML
    private void deleteTask(ActionEvent event) {
        String item = listViewList.getSelectionModel().getSelectedItem();

        if (item != null) {
            observableItems.remove(item);
        }

    }

    @FXML
    private void exit(ActionEvent event) {
        //System.exit(0);
        Platform.exit();
    }

}
