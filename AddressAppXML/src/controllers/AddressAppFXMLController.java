package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Persona;
import utils.FileHandler;

/**
 * FXML Controller class
 *
 * @author wdal9
 */
public class AddressAppFXMLController implements Initializable {

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
    @FXML
    private Button buttonNew;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private MenuItem menuItemSave;

    //Lista observable para targetear los objetos que vamos añadiendo o modificando
    public static ObservableList<Persona> lista;
    //Utilidad para trabajar con el fichero XML de las personas
    private FileHandler fileHandler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileHandler = new FileHandler("./personas.xml");

        if (fileHandler.fileHandlerExist()) {//Si existe el fichero con personas guardadas, lo cargamos en la lista
            System.out.println("Archivo XML de personas encontrado");
            lista = FXCollections.observableArrayList(fileHandler.leerListaPersonas());
        } else {//Si no existe fichero, asignamos a la lista un observableArrayList() vacío
            System.out.println("Archivo XML de personas NO encontrado");
            lista = FXCollections.observableArrayList();
        }

        tableView.setItems(lista);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Comprobamos si la lista está vacía al inciar el programa para desactivar o no el botón de editar 
        buttonEdit.setDisable(lista.isEmpty());
        //Comprobamos si la lista está vacía al inciar el programa para desactivar o no el botón de eliminar 
        buttonDelete.setDisable(lista.isEmpty());

        //Se establece un listener para escuchar cuando se cambia el foco de una celda, con la finalidad de
        //cambiar datos de la pantalla en función del foco (obtenemos la persona seleccionada)
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

        //Se añade un listener a la lista para desactivar el botón Edit y Delete en caso de que esté vacía, de lo contrario se vuelven clickeables
        lista.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> change) {
                /*if (lista.isEmpty()) {
                    buttonEdit.setDisable(true);
                    buttonDelete.setDisable(true);
                } else {
                    buttonEdit.setDisable(false);
                    buttonDelete.setDisable(false);
                }*/
                buttonEdit.setDisable(lista.isEmpty());
                buttonDelete.setDisable(lista.isEmpty());
                //Si la lista se queda vacía borramos los textos
                if (lista.isEmpty()) {
                    txtName.setText("");
                    txtLastName.setText("");
                    txtStreet.setText("");
                    txtCity.setText("");
                    txtPC.setText(String.valueOf(""));
                    txtBirdthday.setText("");
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
            System.out.println("Debe seleccionar una persona para editar");
        }
    }

    @FXML
    private void EliminarPersona(ActionEvent event) {
        Persona personaSeleccionada = tableView.getSelectionModel().getSelectedItem();

        if (personaSeleccionada != null) {
            lista.remove(personaSeleccionada);
        } else {
            System.out.println("Debe seleccionar una persona para eliminar");
        }
    }

    @FXML
    private void guardarDatosTabla(ActionEvent event) {
        if (!lista.isEmpty()) {
            ArrayList<Persona> personasParaGuardar = new ArrayList<>();
            lista.forEach(persona -> {
                personasParaGuardar.add(persona);//Se guarda cada item de la lista en un ArrayList
            });
            try {
                fileHandler.escribirListaXMLPersonas(personasParaGuardar);
            } catch (IOException ex) {
                Logger.getLogger(AddressAppFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("La lista está vacía, no hay datos para guardar");
        }
    }

    //Para mostrar la ventana de diálogo vacía
    private void showDialog() {
        try {
            DialogPane dialogPane = FXMLLoader.load(getClass().getResource("../views/DialogPersonFXML.fxml"));

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/DialogPersonFXML.fxml"));
            DialogPane dialogPane = loader.load();

            DialogPersonFXMLController dialogPersonController = loader.getController();
            dialogPersonController.apuntarATextos(txtName, txtLastName, txtStreet, txtCity, txtPC, txtBirdthday);

            Dialog dialogWindow = new Dialog();

            dialogWindow.setDialogPane(dialogPane);
            dialogWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(AddressAppFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
