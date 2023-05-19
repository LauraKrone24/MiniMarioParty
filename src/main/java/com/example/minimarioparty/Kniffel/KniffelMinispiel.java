package com.example.minimarioparty.Kniffel;

import com.example.minimarioparty.Minispiel;
import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.application.Platform;
import java.awt.*;
import java.io.IOException;
import java.util.*;
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
    private int wuerfelZahl;
    private boolean beendenGedrueckt = false;
    List<Integer> zahlen = new ArrayList<>();
    private List<Integer> letzteZahlen = new ArrayList<>();

    Label punkteSpielerLabel = new Label("Punkte des Spielers: " + punkteSpieler);

    Label punkteComputerLabel = new Label("Punkte des Computers: " + punkteComputer);

    Label countSpielerLabel = new Label("Rundensiege Spieler: " + countSpieler);
    Label countComputerLabel = new Label("Rundensiege Computer: " + countComputer);
    Label rundenCounterLabel = new Label("Aktuelle Runde: " + rundenCounter);
    Label wuerfelCounterLabel = new Label(wuerfelCounter + " Mal gewuerfelt");
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
        punkteSpielerLabel.setTextFill(Color.WHITE);


        punkteComputerLabel.setLayoutX(10);
        punkteComputerLabel.setLayoutY(0);
        punkteComputerLabel.setPrefWidth(150);
        punkteComputerLabel.setPrefHeight(50);
        punkteComputerLabel.setTextFill(Color.WHITE);


        countSpielerLabel.setLayoutX(10);
        countSpielerLabel.setLayoutY(0);
        countSpielerLabel.setPrefWidth(150);
        countSpielerLabel.setPrefHeight(50);
        countSpielerLabel.setTextFill(Color.WHITE);


        countComputerLabel.setLayoutX(10);
        countComputerLabel.setLayoutY(0);
        countComputerLabel.setPrefWidth(150);
        countComputerLabel.setPrefHeight(50);
        countComputerLabel.setTextFill(Color.WHITE);


        rundenCounterLabel.setLayoutX(5);
        rundenCounterLabel.setLayoutY(0);
        rundenCounterLabel.setPrefWidth(100);
        rundenCounterLabel.setPrefHeight(100);
        rundenCounterLabel.setTextFill(Color.WHITE);


        wuerfelCounterLabel.setLayoutX(5);
        wuerfelCounterLabel.setLayoutY(0);
        wuerfelCounterLabel.setPrefWidth(100);
        wuerfelCounterLabel.setPrefHeight(100);
        wuerfelCounterLabel.setTextFill(Color.WHITE);


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

        Pane punktSpieler = new Pane();
        punktSpieler.setPrefWidth(150);
        punktSpieler.setPrefHeight(50);
        punktSpieler.setLayoutX(50);
        punktSpieler.setLayoutY(50);
        punktSpieler.setStyle("-fx-background-color: #8361FF");
        punktSpieler.getChildren().add(punkteSpielerLabel);

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

        spielfeldPane.getChildren().addAll(spielfeld, wuerfeln, beenden, wuerfelSpieler1, wuerfelSpieler2, wuerfelSpieler3, wuerfelSpieler4, wuerfelSpieler5, runde, counterWuerfel, punktSpieler, punkteComputer, counterSpieler, counterComputer);
        //List<Integer> zahlen = new ArrayList<>();
        wuerfeln.setOnAction(actionEvent -> {
            //zahlen.clear();
            wuerfelCounter++;

            int zahl1 = (int)(Math.random()*6)+1;
            Image wuerfel1 = wuerfelListe.get(zahl1 -1).getBild();
            wuerfelSpieler1.setImage(wuerfel1);
            wuerfelSpieler1.setVisible(true);
            //System.out.println("Wuerfelliste: ");
            //System.out.println(wuerfelListe.size());
            zahlen.add(zahl1);

            int zahl2 = (int)(Math.random()*6)+1;
            Image wuerfel2 = wuerfelListe.get(zahl2 -1).getBild();
            wuerfelSpieler2.setImage(wuerfel2);
            wuerfelSpieler2.setVisible(true);
            zahlen.add(zahl2);

            int zahl3 = (int)(Math.random()*6)+1;
            Image wuerfel3 = wuerfelListe.get(zahl3 -1).getBild();
            wuerfelSpieler3.setImage(wuerfel3);
            wuerfelSpieler3.setVisible(true);
            zahlen.add(zahl3);

            int zahl4 = (int)(Math.random()*6)+1;
            Image wuerfel4 = wuerfelListe.get(zahl4 -1).getBild();
            wuerfelSpieler4.setImage(wuerfel4);
            wuerfelSpieler4.setVisible(true);
            zahlen.add(zahl4);

            int zahl5 = (int)(Math.random()*6)+1;
            Image wuerfel5 = wuerfelListe.get(zahl5 -1).getBild();
            wuerfelSpieler5.setImage(wuerfel5);
            wuerfelSpieler5.setVisible(true);
            zahlen.add(zahl5);


            System.out.println(zahlen);
            System.out.println("-------------------------------------");
// Kommentar, Logik funktioniert, außer der Counter resettet nicht bei < 3
            if (wuerfelCounter > 3){
                wuerfelCounter = 1;
                System.out.println("funktioniert");
                if (rundenCounter > 3) {
                    return;
                }
            } else if (wuerfelCounter == 3 ) {
                //System.out.println("testtest");
                autoZaehlen();


            }
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        });

        beenden.setOnAction(ActiveEvent -> {

            autoZaehlen();
            beendenGedrueckt = true;





        });



        super.start(stage);
    }
    public void punktePruefung(){
        if (punkteSpieler >= 100 && (punkteSpieler > punkteComputer)){
            punkteSpieler = 0;
            countSpieler++;
            countSpielerLabel.setText("Rundensiege Spieler: " + countSpieler);
            rundenCounter++;
            rundenCounterLabel.setText("Aktuelle Runde: " + Integer.toString(rundenCounter));
            wuerfelCounter = 0;
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        }else if (punkteComputer >= 100 && (punkteComputer > punkteSpieler)){
            punkteComputer = 0;
            countComputer++;
            countComputerLabel.setText("Rundensiege Computer: " + countComputer);
            rundenCounter++;
            rundenCounterLabel.setText("Aktuelle Runde: " + Integer.toString(rundenCounter));
            wuerfelCounter = 0;
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");

        }
    }
    private boolean isBeendenGedrueckt(){
        return beendenGedrueckt;
    }

    public void autoZaehlen(){
        if (zahlen.size() >= 5) {
            int index = zahlen.size() - 5;

            for (int i = index; i < zahlen.size(); i++) {
                letzteZahlen.add(zahlen.get(i));
            }
        } zaehlen();
        System.out.println("Letzte Zahlen");
        System.out.println(letzteZahlen);
        letzteZahlen.clear();
    }

    public void wuerfeln(){
        wuerfelZahl = (int)(Math.random()*6)+1;

    }
    public void zaehlen(){

        int punkte = 0;
        boolean klStrasse = false;
        boolean grStrasse = false;

        Set<Integer> individuelleZahlen = new HashSet<>(letzteZahlen);
        // Überprüfung auf Dreierfolge

        for (int i = 0; i <= 4; i++) {
            if (Collections.frequency(letzteZahlen, i) >= 1 && Collections.frequency(letzteZahlen, i + 1) >= 1 && Collections.frequency(letzteZahlen, i + 2) >= 1) {
                klStrasse = true;
                break;
            }
        }

        // Prüfung grosse Strasse

        for (int i = 0; i <= 3; i++) {
            if (Collections.frequency(letzteZahlen, i) >= 1 && Collections.frequency(letzteZahlen, i + 1) >= 1 && Collections.frequency(letzteZahlen, i + 2) >= 1 && Collections.frequency(letzteZahlen, i + 3) >= 1) {
                grStrasse = true;
                break;
            }
        }

        // Punktevergabe
        if (grStrasse) {
            punkte += 50;
        } else if (klStrasse) {
            punkte += 25;
        } else {
            // Überprüfung auf drei gleiche Zahlen
            boolean zweiGleiche = false;
            boolean dreiGleiche = false;
            boolean vierGleiche = false;
            boolean fuenfGleiche = false;

            for (int zahl : letzteZahlen) {
                int anzahl = Collections.frequency(letzteZahlen, zahl);
                if (anzahl >= 5) {
                    fuenfGleiche = true;
                } else if (anzahl == 4) {
                    vierGleiche = true;
                } else if (anzahl == 3) {
                    dreiGleiche = true;
                } else if (anzahl == 2) {
                    zweiGleiche = true;
                }
            }

            if (fuenfGleiche) {
                punkte += 100;
            } else if (zweiGleiche && dreiGleiche) {
                punkte += 15;
            } else if (vierGleiche) {
                punkte += 20;
            } else if (dreiGleiche) {
                punkte += 15;
            } else if (zweiGleiche) {
                punkte += 10;
            }
        }


        punkteSpieler += punkte;
        zahlen.clear();
        punktePruefung();


        punkteSpielerLabel.setText("Punkte des Spielers: " + punkteSpieler);

    }
}
