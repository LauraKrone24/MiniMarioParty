module com.example.minimarioparty {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.minimarioparty to javafx.fxml;
    exports com.example.minimarioparty;
    exports com.example.minimarioparty.BallonPlatzen;
    opens com.example.minimarioparty.BallonPlatzen to javafx.fxml;
    exports com.example.minimarioparty.Labyrinth;
    opens com.example.minimarioparty.Labyrinth to javafx.fxml;
    exports com.example.minimarioparty.Hauptgame;
    opens com.example.minimarioparty.Hauptgame to javafx.fxml;
}