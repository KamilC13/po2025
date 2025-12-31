package org.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.*;

import java.io.IOException;


public class DodajSamochodController {
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField registrationTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField maxspeedTextField;
    public Button confirmButton;
    public Button cancelButton;

    private HelloController mainController;

    @FXML private ComboBox<Silnik> silnikComboBox;
    @FXML private ComboBox<SkrzyniaBiegow> skrzyniaComboBox;


    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }



    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double weight;
        int maxspeed;
        try {
            weight = Double.parseDouble(weightTextField.getText());
            maxspeed = Integer.parseInt(maxspeedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        Silnik wybranysilnik = silnikComboBox.getValue();
        Sprzeglo sprzeglo = new Sprzeglo();
        SkrzyniaBiegow wybranaskrzynia = skrzyniaComboBox.getValue();
        Pozycja pozycja = new Pozycja(0, 0);

        Samochod nowy = new Samochod(wybranysilnik, wybranaskrzynia, pozycja, registration, model, weight, maxspeed);
        if (mainController != null) {
            mainController.dodajSamochod(nowy);
        }
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        Sprzeglo sprzeglo = new Sprzeglo("Standard", "pindel", 34, 34, false);

        ObservableList<Silnik> silniki = FXCollections.observableArrayList(
                new Silnik("as","342", 234, 24, 10000, 3500, 200, 300),
                new Silnik("43","dqf", 23, 46, 9000, 1000, 160, 250)
        );
        ObservableList<SkrzyniaBiegow> skrzynia = FXCollections.observableArrayList(
                new SkrzyniaBiegow("fdsa",sprzeglo, 43, 432, "wef", 2, 6 ),
                new SkrzyniaBiegow("qf",sprzeglo, 43, 432, "bg", 1, 6 )
        );

        silnikComboBox.setItems(silniki);
        skrzyniaComboBox.setItems(skrzynia);

        cancelButton.setOnAction(event -> {
            onCancelButton();
        });

        confirmButton.setOnAction(event -> {
            onConfirmButton();
        });

    }
}