module org.example.samochodgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.net.http;

    opens org.example.samochodgui to javafx.fxml;
    exports org.example.samochodgui;
}