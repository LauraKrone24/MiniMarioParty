package com.example.minimarioparty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Hauptgame extends Application {
    private Spieler[] spieler = new Spieler[2];
    private Spieler aktuellerSpieler;
    private ArrayList<Feld> felder = new ArrayList<Feld>();
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Hauptgame.class.getResource("hauptgame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000,800);
        stage.setTitle("Mini Mario Party");
        stage.setScene(scene);
        stage.show();
        System.out.println("hi");
        String spielername = "hi";
        spieler[0] = new Spieler(spielername,false);
        spieler[1] =  new Spieler("Computer",true);
        aktuellerSpieler = chooseStartspieler();
        System.out.println(aktuellerSpieler.getName());
    }

    public void setFelder(){

    };
    public Spieler chooseStartspieler(){

        return spieler[(int)Math.random()*2];
    };

    public static void main(String[] args) {
        launch();
    }
}