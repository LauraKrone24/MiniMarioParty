module com.example.minimarioparty {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.minimarioparty to javafx.fxml;
    exports com.example.minimarioparty;
}