package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        HelloController.addCarToList(model, registration, weight, speed);
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