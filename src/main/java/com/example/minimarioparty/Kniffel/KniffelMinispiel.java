package com.example.minimarioparty.Kniffel;

import com.example.minimarioparty.Minispiel;
import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.application.Platform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KniffelMinispiel extends Minispiel {

    private Stage stage;
    Pane spielfeldPane = new Pane();


    int punkteSpieler = 0;
    int punkteComputer = 0;
    private int aktuellerSpieler = 0;
    private int countSpieler = 0;
    private int countComputer = 0;
    private int rundenCounter = 0;
    private int wuerfelCounter = 0;

    Label punkteSpielerLabel = new Label("Punkte des Spielers: " + punkteSpieler);

    Label punkteComputerLabel = new Label("Punkte des Computers: " + punkteComputer);

    Label countSpielerLabel = new Label("Rundensiege Spieler: " + countSpieler);
    Label countComputerLabel = new Label("Rundensiege Computer: " + countComputer);
    Label rundenCounterLabel = new Label("Aktuelle Runde: " + rundenCounter);
    Label wuerfelCounterLabel = new Label(wuerfelCounter + " Mal gewürfelt");
    private Label winLoseLabel;

    Wuerfelinitialisieren test = new Wuerfelinitialisieren();

    List<Wuerfel> wuerfelListe = test.getWuerfelListe();

    List<ImageView> gewuerfelteWuerfelSpieler = new ArrayList<>();
    List<ImageView> gewuerfelteWuerfelComputer = new ArrayList<>();
    Button wuerfeln = new Button("wuerfeln");
    //Button behalten = new Button("behalten");
    Button beenden = new Button("Punkte zaehlen");


    @Override
    public void start(Stage stage) throws IOException{

        this.stage = stage;


        // Spielfeld

        spielfeldPane.setPrefSize(1000, 700);
        spielfeldPane.setLayoutY(100);
        p.getChildren().add(spielfeldPane);


        // Hintergrund

        Image spielfeldHintergrund = new Image("kniffelHintergrund_test2.jpg");
        ImageView spielfeld = new ImageView();
        spielfeld.setFitWidth(1000);
        spielfeld.setFitHeight(700);
        spielfeld.setImage(spielfeldHintergrund);


        wuerfeln.setLayoutX(225);
        wuerfeln.setLayoutY(600);
        wuerfeln.setPrefWidth(150);
        wuerfeln.setPrefHeight(50);



        beenden.setLayoutX(625);
        beenden.setLayoutY(600);
        beenden.setPrefWidth(150);
        beenden.setPrefHeight(50);


        punkteSpielerLabel.setLayoutX(10);
        punkteSpielerLabel.setLayoutY(0);
        punkteSpielerLabel.setPrefWidth(150);
        punkteSpielerLabel.setPrefHeight(50);


        punkteComputerLabel.setLayoutX(10);
        punkteComputerLabel.setLayoutY(0);
        punkteComputerLabel.setPrefWidth(150);
        punkteComputerLabel.setPrefHeight(50);


        countSpielerLabel.setLayoutX(10);
        countSpielerLabel.setLayoutY(0);
        countSpielerLabel.setPrefWidth(150);
        countSpielerLabel.setPrefHeight(50);


        countComputerLabel.setLayoutX(10);
        countComputerLabel.setLayoutY(0);
        countComputerLabel.setPrefWidth(150);
        countComputerLabel.setPrefHeight(50);


        rundenCounterLabel.setLayoutX(5);
        rundenCounterLabel.setLayoutY(0);
        rundenCounterLabel.setPrefWidth(100);
        rundenCounterLabel.setPrefHeight(100);


        wuerfelCounterLabel.setLayoutX(5);
        wuerfelCounterLabel.setLayoutY(0);
        wuerfelCounterLabel.setPrefWidth(100);
        wuerfelCounterLabel.setPrefHeight(100);


        ImageView wuerfelSpieler1 = new ImageView();
        wuerfelSpieler1.setFitWidth(80);
        wuerfelSpieler1.setFitHeight(80);
        wuerfelSpieler1.setLayoutX(280);
        wuerfelSpieler1.setLayoutY(300);
        wuerfelSpieler1.setVisible(false);


        ImageView wuerfelSpieler2 = new ImageView();
        wuerfelSpieler2.setFitWidth(80);
        wuerfelSpieler2.setFitHeight(80);
        wuerfelSpieler2.setLayoutX(370);
        wuerfelSpieler2.setLayoutY(300);
        wuerfelSpieler2.setVisible(false);


        ImageView wuerfelSpieler3 = new ImageView();
        wuerfelSpieler3.setFitWidth(80);
        wuerfelSpieler3.setFitHeight(80);
        wuerfelSpieler3.setLayoutX(460);
        wuerfelSpieler3.setLayoutY(300);
        wuerfelSpieler3.setVisible(false);


        ImageView wuerfelSpieler4 = new ImageView();
        wuerfelSpieler4.setFitWidth(80);
        wuerfelSpieler4.setFitHeight(80);
        wuerfelSpieler4.setLayoutX(550);
        wuerfelSpieler4.setLayoutY(300);
        wuerfelSpieler4.setVisible(false);



        ImageView wuerfelSpieler5 = new ImageView();
        wuerfelSpieler5.setFitWidth(80);
        wuerfelSpieler5.setFitHeight(80);
        wuerfelSpieler5.setLayoutX(640);
        wuerfelSpieler5.setLayoutY(300);
        wuerfelSpieler5.setVisible(false);



        Pane runde = new Pane();
        runde.setPrefWidth(100);
        runde.setPrefHeight(100);
        runde.setLayoutX(450);
        runde.setLayoutY(50);
        runde.setStyle("-fx-background-color: #8361FF");
        runde.getChildren().add(rundenCounterLabel);

        Pane counterWuerfel = new Pane();
        counterWuerfel.setPrefWidth(100);
        counterWuerfel.setPrefHeight(100);
        counterWuerfel.setLayoutX(450);
        counterWuerfel.setLayoutY(500);
        counterWuerfel.setStyle("-fx-background-color: #8361FF");
        counterWuerfel.getChildren().add(wuerfelCounterLabel);

        Pane punkteSpieler = new Pane();
        punkteSpieler.setPrefWidth(150);
        punkteSpieler.setPrefHeight(50);
        punkteSpieler.setLayoutX(50);
        punkteSpieler.setLayoutY(50);
        punkteSpieler.setStyle("-fx-background-color: #8361FF");
        punkteSpieler.getChildren().add(punkteSpielerLabel);

        Pane punkteComputer = new Pane();
        punkteComputer.setPrefWidth(150);
        punkteComputer.setPrefHeight(50);
        punkteComputer.setLayoutX(250);
        punkteComputer.setLayoutY(50);
        punkteComputer.setStyle("-fx-background-color: #8361FF");
        punkteComputer.getChildren().add(punkteComputerLabel);


        Pane counterSpieler = new Pane();
        counterSpieler.setPrefWidth(150);
        counterSpieler.setPrefHeight(50);
        counterSpieler.setLayoutX(600);
        counterSpieler.setLayoutY(50);
        counterSpieler.setStyle("-fx-background-color: #8361FF");
        counterSpieler.getChildren().add(countSpielerLabel);

        Pane counterComputer = new Pane();
        counterComputer.setPrefWidth(150);
        counterComputer.setPrefHeight(50);
        counterComputer.setLayoutX(800);
        counterComputer.setLayoutY(50);
        counterComputer.setStyle("-fx-background-color: #8361FF");
        counterComputer.getChildren().add(countComputerLabel);




        // An spielfeldPane übergeben

        spielfeldPane.getChildren().addAll(spielfeld, wuerfeln, beenden, wuerfelSpieler1, wuerfelSpieler2, wuerfelSpieler3, wuerfelSpieler4, wuerfelSpieler5, runde, counterWuerfel, punkteSpieler, punkteComputer, counterSpieler, counterComputer);

        wuerfeln.setOnAction(actionEvent -> {

            int zahl1 = (int)(Math.random()*(wuerfelListe.size()-1));
            Image wuerfel1 = wuerfelListe.get(zahl1).getBild();
            wuerfelSpieler1.setImage(wuerfel1);
            wuerfelSpieler1.setVisible(true);

            int zahl2 = (int)(Math.random()*(wuerfelListe.size()-1));
            Image wuerfel2 = wuerfelListe.get(zahl2).getBild();
            wuerfelSpieler2.setImage(wuerfel2);
            wuerfelSpieler2.setVisible(true);

            int zahl3 = (int)(Math.random()*(wuerfelListe.size()-1));
            Image wuerfel3 = wuerfelListe.get(zahl3).getBild();
            wuerfelSpieler3.setImage(wuerfel3);
            wuerfelSpieler3.setVisible(true);

            int zahl4 = (int)(Math.random()*(wuerfelListe.size()-1));
            Image wuerfel4 = wuerfelListe.get(zahl4).getBild();
            wuerfelSpieler4.setImage(wuerfel4);
            wuerfelSpieler4.setVisible(true);

            int zahl5 = (int)(Math.random()*(wuerfelListe.size()-1));
            Image wuerfel5 = wuerfelListe.get(zahl5).getBild();
            wuerfelSpieler5.setImage(wuerfel5);
            wuerfelSpieler5.setVisible(true);

            if (aktuellerSpieler == 0) {
                for (Wuerfel wuerfel : wuerfelListe){
                    wuerfel.rollen();
                    aktuellerSpieler = 1;}}
            else {
                for (Wuerfel wuerfel : wuerfelListe){
                        wuerfel.rollen();
                        aktuellerSpieler = 0;
                }

            }

            spielfeldPane.getChildren().removeAll(gewuerfelteWuerfelSpieler);
            spielfeldPane.getChildren().removeAll(gewuerfelteWuerfelComputer);

            gewuerfelteWuerfelSpieler.clear();
            gewuerfelteWuerfelComputer.clear();

            for (Wuerfel wuerfel : wuerfelListe) {
                ImageView imageView = new ImageView(wuerfel.getBild());
                imageView.setFitWidth(80);
                imageView.setFitHeight(120);
                imageView.setLayoutX(350);
                imageView.setLayoutY(75);

                if (wuerfel.isBehalten()) {
                    if (wuerfel.getSpieler() == 0) {
                        gewuerfelteWuerfelSpieler.add(imageView);
                    } else {
                        gewuerfelteWuerfelComputer.add(imageView);
                    }
                }
            }


        });



        super.start(stage);
    }

}
