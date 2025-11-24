package org.example.samochod; // Zgodnie z Twoim plikiem FXML

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class HelloController {

    @FXML private ComboBox<String> samochodComboBox;
    @FXML private Button dodajSamochodButton;
    @FXML private Button usunSamochodButton;

    @FXML private TextField modelField;
    @FXML private TextField nrRejField;
    @FXML private TextField wagaSamField;
    @FXML private TextField predkoscField;
    @FXML private Button wlaczButton;
    @FXML private Button wylaczButton;
    @FXML private Button inneButton;

    @FXML private TextField skrzyniaNazwaField;
    @FXML private TextField skrzyniaCenaField;
    @FXML private TextField skrzyniaWagaField;
    @FXML private TextField biegField;
    @FXML private Button zwiekszBiegButton;
    @FXML private Button zmniejszBiegButton;

    @FXML private TextField silnikNazwaField;
    @FXML private TextField silnikCenaField;
    @FXML private TextField silnikWagaField;
    @FXML private TextField obrotyField;
    @FXML private Button dodajGazuButton;
    @FXML private Button ujmijGazuButton;

    @FXML private TextField sprzegloNazwaField;
    @FXML private TextField sprzegloCenaField;
    @FXML private TextField sprzegloWagaField;
    @FXML private TextField sprzegloStanField;
    @FXML private Button nacisnijSprzegloButton;
    @FXML private Button zwolnijSprzegloButton;

    private Samochod mojSamochod = new Samochod(...);

    @FXML
    public void initialize() {
        wlaczButton.setOnAction(event -> {

            // TU WYWOŁUJESZ FUNKCJĘ Z INNEGO MODUŁU:
            mojSamochod.wlacz();

            // Opcjonalnie: odświeżasz widok
            System.out.println("Silnik włączony!");
        });
    }

    private void stworzSamochodDomyslny() {

}}