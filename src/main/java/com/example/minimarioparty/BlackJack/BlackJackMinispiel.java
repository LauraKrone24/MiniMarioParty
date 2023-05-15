package com.example.minimarioparty.BlackJack;


import com.example.minimarioparty.Minispiel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;


public class BlackJackMinispiel extends Minispiel {

    private Stage stage;
    Pane spielfeldPane = new Pane();

    int punktestand = 0;
    int cpunktestand = 0;










    @Override
    public void start(Stage stage) throws IOException {

        Karteninitialisieren test = new Karteninitialisieren();
        List<Spielkarten> kartenListe= test.getKartenListe();



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

        Button stop = new Button("Stop");
        stop.setLayoutX(400);
        stop.setLayoutY(576);
        stop.setPrefWidth(150);
        stop.setPrefHeight(50);



        ImageView karte1 = new ImageView();
        karte1.setFitWidth(78);
        karte1.setFitHeight(123);
        karte1.setLayoutX(340);
        karte1.setLayoutY(339);

        ImageView karte2 = new ImageView();
        karte2.setFitWidth(78);
        karte2.setFitHeight(123);
        karte2.setLayoutX(380);
        karte2.setLayoutY(339);

        ImageView karte3 = new ImageView();
        karte3.setFitWidth(78);
        karte3.setFitHeight(123);
        karte3.setLayoutX(420);
        karte3.setLayoutY(339);

        ImageView karte4 = new ImageView();
        karte4.setFitWidth(78);
        karte4.setFitHeight(123);
        karte4.setLayoutX(460);
        karte4.setLayoutY(339);

        ImageView karte5 = new ImageView();
        karte5.setFitWidth(78);
        karte5.setFitHeight(123);
        karte5.setLayoutX(500);
        karte5.setLayoutY(339);

        ImageView ckarte1 = new ImageView();
        ckarte1.setFitWidth(78);
        ckarte1.setFitHeight(123);
        ckarte1.setLayoutX(340);
        ckarte1.setLayoutY(75);

        Label mitte = new Label("Drücke Card für eine Karte");
        mitte.setLayoutX(340);
        mitte.setLayoutY(250);
        mitte.setFont(new Font("Arial", 30));
        mitte.setTextFill(Color.WHITE);









        Label punkteAnzahl = new Label("Aktueller Punktestand: " + punktestand);
        punkteAnzahl.setLayoutX(215);
        punkteAnzahl.setLayoutY(540);
        punkteAnzahl.setFont(new Font("Arial", 30));
        punkteAnzahl.setTextFill(Color.WHITE);

        Label cpunkteAnzahl = new Label("Computer: " + cpunktestand);
        cpunkteAnzahl.setLayoutX(50);
        cpunkteAnzahl.setLayoutY(100);
        cpunkteAnzahl.setFont(new Font("Arial", 30));
        cpunkteAnzahl.setTextFill(Color.WHITE);



        neueKarte.setOnAction(actionEvent -> {
            int zahl = (int) (Math.random()*(kartenListe.size()-1));
            karte1.setImage(kartenListe.get(zahl).getBild());
            punktestand += kartenListe.get(zahl).getWert();
            punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);


            neueKarte.setOnAction(actionEvent1 -> {
                int zahl1 = (int) (Math.random()*(kartenListe.size()-1));
                karte2.setImage(kartenListe.get(zahl1).getBild());
                punktestand += kartenListe.get(zahl1).getWert();
                punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);

                neueKarte.setOnAction(actionEvent2 -> {
                    int zahl2 = (int) (Math.random()*(kartenListe.size()-1));
                    karte3.setImage(kartenListe.get(zahl2).getBild());
                    punktestand += kartenListe.get(zahl2).getWert();
                    punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);

                    neueKarte.setOnAction(actionEvent4 -> {
                        int zahl3 = (int) (Math.random()*(kartenListe.size()-1));
                        karte4.setImage(kartenListe.get(zahl3).getBild());
                        punktestand += kartenListe.get(zahl3).getWert();
                        punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);

                        neueKarte.setOnAction(actionEvent5 -> {
                            int zahl4 = (int) (Math.random()*(kartenListe.size()-1));
                            karte5.setImage(kartenListe.get(zahl4).getBild());
                            punktestand += kartenListe.get(zahl4).getWert();
                            punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);
                            neueKarte.setOnAction(actionEvent6 -> {
                                Label fertig = new Label("Du kannst keine weitere Karte mehr nehmen");
                                fertig.setLayoutX(215);
                                fertig.setLayoutY(25);
                                fertig.setFont(new Font("Arial", 30));
                                fertig.setTextFill(Color.WHITE);
                                spielfeldPane.getChildren().add(fertig);


                            });
                        });
                    });
                });
            });

            stop.setOnAction(actionEvent1 -> {
                neueKarte.setDisable(true);
                stop.setDisable(true);
                int czahl = (int) (Math.random()*(kartenListe.size()));
                ckarte1.setImage(kartenListe.get(czahl).getBild());
                cpunktestand += kartenListe.get(czahl).getWert();
                cpunkteAnzahl.setText("Computer: " + cpunktestand);
                int x = 380;
                int y = 75;
                while (cpunktestand < 18){
                    int czahl1 = (int) (Math.random()*(kartenListe.size()));
                    ImageView test1 = new ImageView();
                    test1.setFitHeight(123);
                    test1.setFitWidth(78);
                    test1.setLayoutX(x);
                    test1.setLayoutY(y);
                    spielfeldPane.getChildren().add(test1);
                    test1.setImage(kartenListe.get(czahl1).getBild());
                    cpunktestand += kartenListe.get(czahl1).getWert();
                    cpunkteAnzahl.setText("Computer: " + cpunktestand);

                    x += 40;
                }
                if (punktestand > cpunktestand && punktestand <= 21){
                    mitte.setText("Du hast gewonnen");
                    spielfeldPane.getChildren().add(mitte);

                } else if (cpunktestand == punktestand) {
                    mitte.setText("Unentschieden");
                    spielfeldPane.getChildren().add(mitte);
                } else if (cpunktestand <= 21 && punktestand > 21) {
                    mitte.setText("Du hast verloren");
                    spielfeldPane.getChildren().add(mitte);
                } else if (cpunktestand > 21 && punktestand > 21) {
                    mitte.setText("Unentschieden");
                    spielfeldPane.getChildren().add(mitte);
                }


            });



        });






        spielfeldPane.getChildren().add(spielfeld);
        spielfeldPane.getChildren().add(neueKarte);
        spielfeldPane.getChildren().add(stop);
        spielfeldPane.getChildren().add(karte1);
        spielfeldPane.getChildren().add(karte2);
        spielfeldPane.getChildren().add(karte3);
        spielfeldPane.getChildren().add(karte4);
        spielfeldPane.getChildren().add(karte5);
        spielfeldPane.getChildren().add(ckarte1);
        spielfeldPane.getChildren().add(punkteAnzahl);
        spielfeldPane.getChildren().add(cpunkteAnzahl);
        spielfeldPane.getChildren().add(mitte);













        super.start(stage);
    }
}



