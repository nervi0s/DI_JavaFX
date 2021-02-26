/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author wdal9
 */
public class MessageFXMLController implements Initializable {

    @FXML
    private TextField inputText;
    @FXML
    private RadioButton radioBtnRed;
    @FXML
    private RadioButton radioBtnGreen;
    @FXML
    private RadioButton radioBtnBlue;
    @FXML
    private Button btnLeft;
    @FXML
    private Button btnRight;
    @FXML
    private Text textShow;
    @FXML
    private CheckBox CheckBtnBold;
    @FXML
    private CheckBox CheckBtnItalic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileInputStream fis = null;
        try {
            //Añadir imagen a los botones
            File file = new File("./src/message/left.png");
            fis = new FileInputStream(file);
            Image image = new Image(fis);
            ImageView iv = new ImageView(image);

            btnLeft.setGraphic(iv);

            file = new File("./src/message/right.png");
            fis = new FileInputStream(file);
            image = new Image(fis);
            iv = new ImageView(image);

            btnRight.setGraphic(iv);
            //Posicion de la imagen en el boton
            btnRight.setContentDisplay(ContentDisplay.RIGHT);

            btnLeft.setPrefSize(70, 30);
            btnRight.setPrefSize(70, 30);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MessageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(MessageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ToggleGroup tg = new ToggleGroup();
        tg.getToggles().addAll(radioBtnRed, radioBtnGreen, radioBtnBlue);

        radioBtnRed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                textShow.setFill(Color.RED);
            }
        });

        radioBtnGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                textShow.setFill(Color.GREEN);
            }
        });

        radioBtnBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                textShow.setFill(Color.BLUE);
            }
        });

        CheckBtnBold.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                if (CheckBtnBold.isSelected() && CheckBtnItalic.isSelected()) {
                    textShow.setStyle("-fx-font-weight: bold; -fx-font-style: italic;");
                } else if (CheckBtnBold.isSelected()) {
                    textShow.setStyle("-fx-font-weight: bold");
                } else if (CheckBtnItalic.isSelected()) {
                    textShow.setStyle("-fx-font-style: italic");
                } else {
                    textShow.setStyle("-fx-font-weight: normal");

                }
            }
        });

        CheckBtnItalic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (CheckBtnItalic.isSelected() && CheckBtnBold.isSelected()) {
                    textShow.setStyle("-fx-font-style: italic; -fx-font-weight: bold;");
                } else if (CheckBtnItalic.isSelected()) {
                    textShow.setStyle("-fx-font-style: italic");
                } else if (CheckBtnBold.isSelected()) {
                    textShow.setStyle("-fx-font-weight: bold");
                } else {
                    textShow.setStyle("-fx-font-style: normal");
                }
            }
        });

    }

    @FXML
    private void getMessage(KeyEvent event) {
        String message = inputText.getText();
        textShow.setText(message);
    }

    @FXML
    private void moveToLeft(MouseEvent event) {
        if (!textShow.getText().isEmpty()) {
            textShow.setX(textShow.getX() - 10);
            textShow.setTranslateX(textShow.getX());
        }
    }

    @FXML
    private void moveToRight(MouseEvent event) {
        if (!textShow.getText().isEmpty()) {
            textShow.setX(textShow.getX() + 10);
            textShow.setTranslateX(textShow.getX());
        }
    }

}
