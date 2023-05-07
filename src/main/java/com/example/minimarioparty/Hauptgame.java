package com.example.minimarioparty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Hauptgame extends Application {
    private ArrayList<Feld> felder = new ArrayList<Feld>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Hauptgame.class.getResource("hauptgame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000,800);
        stage.setTitle("Mini Mario Party");
        stage.setScene(scene);
        stage.show();
    }

    public void setFelder(){

    };

    public static void main(String[] args) {
        launch();
    }
}