package org.example.samochodgui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import symulator.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;



public class HelloController {

    //public static List<Samochod> samochody = new ArrayList<>();

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
    @FXML private ComboBox<Samochod> samochodComboBox;
    private ObservableList<Samochod> samochody = FXCollections.observableArrayList();
    @FXML private Button RefreshButton;
    @FXML private Slider GazSlider;

    // Samochód
    @FXML private TextField ModelField;
    @FXML private TextField NrRejField;
    @FXML private TextField WagaSamField;
    @FXML private TextField PredkoscField;

    // Skrzynia
    @FXML private TextField SkrzyniaNazwaField;
    @FXML private TextField SkrzyniaCenaField;
    @FXML private TextField SrzyniaWagaField;
    @FXML private TextField BiegField;

    // Silnik
    @FXML private TextField SilnikNazwaField;
    @FXML private TextField SilnikCenaField;
    @FXML private TextField SilnikWagaField;
    @FXML private TextField ObrotyField;

    // Sprzęgło
    @FXML private TextField sprzegloNazwaField;
    @FXML private TextField sprzegloCenaField;
    @FXML private TextField sprzegloWagaField;
    @FXML private TextField sprzegloStanField;

    @FXML public Button dodajSamochodButton;
    @FXML private Button usunSamochodButton;
    @FXML private AnchorPane mapaPane;
    @FXML private ImageView carImageView;


    public void initialize() {

        /*Silnik silnik = new Silnik("AFS", "AB", 2000, 10, 10000, 0, 100, 1000);
        Sprzeglo sprzeglo = new Sprzeglo("ABC", "Sachs", 1000, 1000, true);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("ABC",  sprzeglo, 2300,  50000,"SD", 2, 5);
        Pozycja pozycja = new Pozycja(0, 0);
        String nrRjst="KK 12345";
        int wagaAuta=1500;
        String model="Corolla";*/

        mojSamochod = new Samochod();


        System.out.println("HelloController initialized");
        // Load and set the car image
        Image carImage = new Image(getClass().getResource("carImage.jpg").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());

        WagaSamField.setOnAction(e -> {
            mojSamochod.setWagaAuta(Integer.parseInt(WagaSamField.getText()));
            refresh();
        });
        ModelField.setOnAction(e -> {
            mojSamochod.setModelAuta(String.valueOf(ModelField.getText()));
            refresh();
        });
        NrRejField.setOnAction(e-> {
            mojSamochod.setNrRjst(String.valueOf(NrRejField.getText()));
            refresh();
        });
        dodajSamochodButton.setOnAction(event -> {
            try {
                openAddCarWindow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        samochodComboBox.setOnAction(e -> {
            Samochod selected = samochodComboBox.getSelectionModel().getSelectedItem();
            if (selected != null) {
                // odpinamy listener od starego auta
                if (mojSamochod != null) {
                    mojSamochod.setListener(null);
                }

                mojSamochod = selected;

                // podpinamy listener do nowego auta
                mojSamochod.setListener(() ->
                        Platform.runLater(this::refresh)
                );
            }
        });
        samochodComboBox.setItems(samochody);

        mojSamochod.setListener(() -> {
            Platform.runLater(this::refresh);
        });

        mapaPane.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            Pozycja nowaPozycja = new Pozycja(x, y);
            mojSamochod.jedzDo(nowaPozycja);
        });
    }
    @FXML
    public void openAddCarWindow() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());

        DodajSamochodController ctrl = loader.getController();
        ctrl.setMainController(this);

        stage.setScene(scene);
        stage.setTitle("Dodaj nowy samochód");
        stage.showAndWait();

        refresh();
    }
    @FXML
    public void onUsunSamochod() {
        Samochod doUsuniecia = samochodComboBox.getSelectionModel().getSelectedItem();
        samochody.remove(doUsuniecia);
        mojSamochod = new Samochod();
        refresh();
    }


    @FXML
    public void dodajSamochod(Samochod nowy) {
        samochody.add(nowy);
        samochodComboBox.getSelectionModel().select(nowy);
        mojSamochod = nowy;
        refresh();
    }


    @FXML
    protected void onWlaczButton() {
        mojSamochod.wlacz();
        System.out.println("Samochód włączony (Silnik Obroty: " + mojSamochod.getSilnik().getObroty() + ")");
        refresh();
    }

    @FXML
    protected void onWylaczButton() {
        mojSamochod.wylacz();
        System.out.println("Samochód wyłączony (Bieg: " + mojSamochod.getSkrzynia().getAktualnyBieg() + ")");
        refresh();
    }


    @FXML
    protected void onZwiekszButton() {
        mojSamochod.getSkrzynia().ZwiekszBieg();
        System.out.println("Zwiększono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
        refresh();
    }

    @FXML
    protected void onZmniejszButton() {
        mojSamochod.getSkrzynia().ZmiejszBieg();
        System.out.println("Zmniejszono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
        refresh();
    }


    @FXML
    protected void onNacisnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
        refresh();
    }

    @FXML
    protected void onZwolnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
        refresh();
    }

    @FXML
    protected void onDodajButton() {
        int ile = (int) GazSlider.getValue();
        mojSamochod.getSilnik().ZwiekszV(ile);
        refresh();
    }

    @FXML
    protected void onUjmijButton() {
        int ile = (int) GazSlider.getValue();
        mojSamochod.getSilnik().ZmniejszV(ile);
        refresh();
    }
    @FXML
    protected void onRefreshButton() {
        refresh();
    }

    private void refresh() {


        ModelField.setText(String.valueOf(mojSamochod.getModel()));
        NrRejField.setText(String.valueOf(mojSamochod.getNrRjst()));
        WagaSamField.setText(String.valueOf(mojSamochod.getWagaAuta()));
        PredkoscField.setText(String.valueOf(mojSamochod.getSilnik().getPredkosc()));

        SilnikNazwaField.setText(String.valueOf(mojSamochod.getSilnik().getModel()));
        SilnikCenaField.setText(String.valueOf(mojSamochod.getSilnik().getCena()));
        SilnikWagaField.setText(String.valueOf(mojSamochod.getSilnik().getWaga()));
        ObrotyField.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));

        SkrzyniaNazwaField.setText(String.valueOf(mojSamochod.getSkrzynia().getModel()));
        SkrzyniaCenaField.setText(String.valueOf(mojSamochod.getSkrzynia().getCena()));
        SrzyniaWagaField.setText(String.valueOf(mojSamochod.getSkrzynia().getWaga()));
        BiegField.setText(String.valueOf(mojSamochod.getSkrzynia().getAktualnyBieg()));

        sprzegloNazwaField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getModel()));
        sprzegloCenaField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getCena()));
        sprzegloWagaField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getWaga()));
        sprzegloStanField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla()));

        Platform.runLater(() -> {
            // Używamy setTranslateX/Y zgodnie z instrukcją
            if (mojSamochod.getPozycja() != null) {
                carImageView.setTranslateX(mojSamochod.getPozycja().getX());
                carImageView.setTranslateY(mojSamochod.getPozycja().getY());
            }
    });



}
}