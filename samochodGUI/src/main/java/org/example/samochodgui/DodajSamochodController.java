package org.example.samochodgui;

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
    private TextField speedTextField;
    public Button confirmButton;
    public Button cancelButton;

    private HelloController mainController;

    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }



    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double weight;
        int speed;
        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        Silnik silnik = new Silnik("AFS", "AB", 2000, 10, 10000, 0, speed, 400);
        Sprzeglo sprzeglo = new Sprzeglo("ABC", "Sachs", 1000, 1000, true);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("ABC", sprzeglo, 2300, 50000, "SD", 2, 5);
        Pozycja pozycja = new Pozycja(0, 0);

        Samochod nowy = new Samochod(silnik, skrzynia, pozycja, registration, model, weight, speed);
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
        cancelButton.setOnAction(event -> {
            onCancelButton();
        });

        confirmButton.setOnAction(event -> {
            onConfirmButton();
        });

    }
}