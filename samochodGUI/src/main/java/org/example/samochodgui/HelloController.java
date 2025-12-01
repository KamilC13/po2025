package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import symulator.*;

public class HelloController {

    // Komponenty symulatora
    private Samochod mojSamochod;

    // Kontrolki FXML - przyciski
    @FXML private Button WlaczButton;
    @FXML private Button WylaczButton;
    @FXML private Button ZwiekszButton;
    @FXML private Button ZmniejszButton;
    @FXML private Button DodajButton;
    @FXML private Button UjmijButton;
    @FXML private Button NacisnijButton;
    @FXML private Button ZwolnijButton;
    @FXML private ComboBox<String> SamochodComboBox;


    public void initialize() {

        Silnik silnik = new Silnik("AFS", "AB", 10000, 0);
        Sprzeglo sprzeglo = new Sprzeglo("ABC", "Sachs", true);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("ABC",  sprzeglo, "SD", 2, 5);
        Pozycja pozycja = new Pozycja(0, 0);

        mojSamochod = new Samochod(silnik, skrzynia, pozycja);


        System.out.println("HelloController initialized");
        // Load and set the car image
        Image carImage = new Image(getClass().getResource("carImage.jpg").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(30); // Set appropriate
        //dimensions for your image
        carImageView.setFitHeight(20);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);
    }


    @FXML
    protected void onWlaczButton() {
        mojSamochod.wlacz();
        System.out.println("Samochód włączony (Silnik Obroty: " + mojSamochod.getSilnik().getObroty() + ")");
    }

    @FXML
    protected void onWylaczButton() {
        mojSamochod.wylacz();
        System.out.println("Samochód wyłączony (Bieg: " + mojSamochod.getSkrzynia().getAktualnyBieg() + ")");
    }


    @FXML
    protected void onZwiekszButton() {
        mojSamochod.getSkrzynia().ZwiekszBieg();
        System.out.println("Zwiększono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
    }

    @FXML
    protected void onZmniejszButton() {
        mojSamochod.getSkrzynia().ZmiejszBieg();
        System.out.println("Zmniejszono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
    }


    @FXML
    protected void onNacisnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
    }

    @FXML
    protected void onZwolnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
    }

    @FXML
    protected void onDodajButton() {
        System.out.println("Dodano gazu.");
    }

    @FXML
    protected void onUjmijButton() {
        System.out.println("Ujęto gazu.");
    }

}