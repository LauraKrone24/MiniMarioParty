package com.example.minimarioparty.BlackJack;


import com.example.minimarioparty.Minispiel;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;


public class BlackJackMinispiel extends Minispiel {

    private Stage stage;
    Pane spielfeldPane = new Pane();

    List<Spielkarten> kartenListe = new ArrayList<>();




















    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;


        //Spielfeld erstellen
        spielfeldPane.setPrefSize( 1000, 700);
        spielfeldPane.setLayoutY(100);
        p.getChildren().add(spielfeldPane);

        //Hintergrund erstellen
        Image spielfeldBild = new Image("hintergrundblackjack.jpg");
        ImageView spielfeld =  new ImageView();
        spielfeld.setFitWidth(1000);
        spielfeld.setFitHeight(700);
        spielfeld.setImage(spielfeldBild);

        Button neueKarte = new Button("Card");
        neueKarte.setLayoutX(215);
        neueKarte.setLayoutY(576);
        neueKarte.setPrefWidth(150);
        neueKarte.setPrefHeight(50);

        ImageView karte1 = new ImageView();
        karte1.setFitWidth(78);
        karte1.setFitHeight(123);
        karte1.setLayoutX(339);
        karte1.setLayoutY(339);

        neueKarte.setOnAction(actionEvent -> {
            int zahl = (int) (Math.random()*2);


        });






        spielfeldPane.getChildren().add(spielfeld);
        spielfeldPane.getChildren().add(neueKarte);
        spielfeldPane.getChildren().add(karte1);













        super.start(stage);
    }
}
