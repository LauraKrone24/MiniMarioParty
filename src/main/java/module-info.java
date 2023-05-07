module com.example.minimarioparty {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.minimarioparty to javafx.fxml;
    exports com.example.minimarioparty;
    exports com.example.minimarioparty.Minispiele.Test;
    opens com.example.minimarioparty.Minispiele.Test to javafx.fxml;

}