package com.example.minimarioparty.Kniffel;

import com.example.minimarioparty.Minispiel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;


public class KniffelMinispiel_TEST extends Minispiel {

    private Stage stage;
    Pane spielfeldPane = new Pane();


    int punkteSpieler = 0;
    int punkteComputer = 0;
    private boolean computerZug;
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
    Label rundenCounterLabel = new Label("Gespielte Runden: " + rundenCounter);
    Label wuerfelCounterLabel = new Label(wuerfelCounter + " Mal gewuerfelt");
    Label amZugLabel = new Label();
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


        rundenCounterLabel.setLayoutX(25);
        rundenCounterLabel.setLayoutY(0);
        rundenCounterLabel.setPrefWidth(150);
        rundenCounterLabel.setPrefHeight(100);
        rundenCounterLabel.setTextFill(Color.WHITE);


        wuerfelCounterLabel.setLayoutX(5);
        wuerfelCounterLabel.setLayoutY(0);
        wuerfelCounterLabel.setPrefWidth(100);
        wuerfelCounterLabel.setPrefHeight(100);
        wuerfelCounterLabel.setTextFill(Color.WHITE);



        /*amZugLabel.setLayoutX(25);
        amZugLabel.setLayoutY(0);
        amZugLabel.setPrefWidth(150);
        amZugLabel.setPrefHeight(50);
        amZugLabel.setTextFill(Color.WHITE);*/




        Pane runde = new Pane();
        runde.setPrefWidth(150);
        runde.setPrefHeight(100);
        runde.setLayoutX(425);
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


        List<ImageView> wuerfelPlayer = initialisiereWuerfelPlayer();
        ImageView wuerfelSpieler1 = wuerfelPlayer.get(0);
        ImageView wuerfelSpieler2 = wuerfelPlayer.get(1);
        ImageView wuerfelSpieler3 = wuerfelPlayer.get(2);
        ImageView wuerfelSpieler4 = wuerfelPlayer.get(3);
        ImageView wuerfelSpieler5 = wuerfelPlayer.get(4);

        List<ImageView> wuerfelComputer = initialisiereWuerfelComputer();
        ImageView wuerfelComputer1 = wuerfelComputer.get(0);
        ImageView wuerfelComputer2 = wuerfelComputer.get(1);
        ImageView wuerfelComputer3 = wuerfelComputer.get(2);
        ImageView wuerfelComputer4 = wuerfelComputer.get(3);
        ImageView wuerfelComputer5 = wuerfelComputer.get(4);


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

        Pane amZug = new Pane();
        amZug.setPrefWidth(150);
        amZug.setPrefHeight(50);
        amZug.setLayoutX(425);
        amZug.setLayoutY(200);
        amZug.setStyle("-fx-background-color: #8361FF");
        amZug.getChildren().add(amZugLabel);




        // An spielfeldPane übergeben

        spielfeldPane.getChildren().addAll(spielfeld, wuerfeln, beenden, wuerfelSpieler1, wuerfelSpieler2, wuerfelSpieler3, wuerfelSpieler4, wuerfelSpieler5, wuerfelComputer1, wuerfelComputer2, wuerfelComputer3, wuerfelComputer4, wuerfelComputer5, counterWuerfel, punktSpieler, punkteComputer, counterSpieler, counterComputer, runde, amZug);
        //List<Integer> zahlen = new ArrayList<>();
        wuerfeln.setOnAction(actionEvent -> {
            //zahlen.clear();
            if (beendenGedrueckt == false) {
                wuerfelnSpieler();

            } else{
                wuerfelnComputer();
            }
        });

        beenden.setOnAction(ActiveEvent -> {

            autoZaehlen();
            beendenGedrueckt = true;
            spielerZugBeendet();





        });



        super.start(stage);
    }
    private void spielerZugBeendet(){
        wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        computerZug = false;
        wuerfelnComputer();
    }

    private void computerZugBeendet(){
        wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        beendenGedrueckt = false;
        computerZug = true;
        wuerfelnSpieler();
    }
    public void werStartet(){

        if (computerZug == false){

            amZugLabel.setLayoutX(25);
            amZugLabel.setLayoutY(0);
            amZugLabel.setPrefWidth(150);
            amZugLabel.setPrefHeight(50);
            amZugLabel.setTextFill(Color.WHITE);
            amZugLabel.setText("Spieler ist am Zug");
            System.out.println("Spieler ist am Zug");
        } else{

            amZugLabel.setLayoutX(25);
            amZugLabel.setLayoutY(0);
            amZugLabel.setPrefWidth(150);
            amZugLabel.setPrefHeight(50);
            amZugLabel.setTextFill(Color.WHITE);
            amZugLabel.setText("Computer ist am Zug");
            System.out.println("Computer ist am Zug");
        }
    }

    public void punktePruefung(){
        if (punkteSpieler >= 100 && (punkteSpieler > punkteComputer)){
            punkteSpieler = 0;
            punkteComputer = 0;
            countSpieler++;
            punkteComputerLabel.setText("");
            countSpielerLabel.setText("Rundensiege Spieler: " + countSpieler);
            rundenCounter++;
            rundenCounterLabel.setText("Gespielte Runden: " + Integer.toString(rundenCounter));
            wuerfelCounter = 0;
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        }else if (punkteComputer >= 100 && (punkteComputer > punkteSpieler)){
            punkteSpieler = 0;
            punkteComputer = 0;
            countComputer++;
            countComputerLabel.setText("Rundensiege Computer: " + countComputer);
            rundenCounter++;
            rundenCounterLabel.setText("Gespielte Runden: " + Integer.toString(rundenCounter));
            wuerfelCounter = 0;
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        }
    }
    private boolean isBeendenGedrueckt(){

        return beendenGedrueckt;
    }


    private void wuerfelnSpieler(){



                List<ImageView> wuerfelPlayer = initialisiereWuerfelPlayer();
                ImageView wuerfelSpieler1 = wuerfelPlayer.get(0);
                ImageView wuerfelSpieler2 = wuerfelPlayer.get(1);
                ImageView wuerfelSpieler3 = wuerfelPlayer.get(2);
                ImageView wuerfelSpieler4 = wuerfelPlayer.get(3);
                ImageView wuerfelSpieler5 = wuerfelPlayer.get(4);
                spielfeldPane.getChildren().addAll(wuerfelSpieler1, wuerfelSpieler2, wuerfelSpieler3, wuerfelSpieler4, wuerfelSpieler5);

                wuerfelCounter++;


                int zahl1 = (int) (Math.random() * 6) + 1;
                Image wuerfel1 = wuerfelListe.get(zahl1 - 1).getBild();
                wuerfelSpieler1.setImage(wuerfel1);
                wuerfelSpieler1.setVisible(true);
                //System.out.println("Wuerfelliste: ");
                //System.out.println(wuerfelListe.size());
                zahlen.add(zahl1);

                int zahl2 = (int) (Math.random() * 6) + 1;
                Image wuerfel2 = wuerfelListe.get(zahl2 - 1).getBild();
                wuerfelSpieler2.setImage(wuerfel2);
                wuerfelSpieler2.setVisible(true);
                zahlen.add(zahl2);

                int zahl3 = (int) (Math.random() * 6) + 1;
                Image wuerfel3 = wuerfelListe.get(zahl3 - 1).getBild();
                wuerfelSpieler3.setImage(wuerfel3);
                wuerfelSpieler3.setVisible(true);
                zahlen.add(zahl3);

                int zahl4 = (int) (Math.random() * 6) + 1;
                Image wuerfel4 = wuerfelListe.get(zahl4 - 1).getBild();
                wuerfelSpieler4.setImage(wuerfel4);
                wuerfelSpieler4.setVisible(true);
                zahlen.add(zahl4);

                int zahl5 = (int) (Math.random() * 6) + 1;
                Image wuerfel5 = wuerfelListe.get(zahl5 - 1).getBild();
                wuerfelSpieler5.setImage(wuerfel5);
                wuerfelSpieler5.setVisible(true);
                zahlen.add(zahl5);

                System.out.println("Letzte Zahlen Spieler");
                System.out.println(zahlen);
                System.out.println("Spieler -------------------------------------");
                beenden.setVisible(true);
                amZugLabel.setLayoutX(25);
                amZugLabel.setLayoutY(0);
                amZugLabel.setPrefWidth(150);
                amZugLabel.setPrefHeight(50);
                amZugLabel.setTextFill(Color.WHITE);
                amZugLabel.setText("Spieler ist am Zug");
// Kommentar, Logik funktioniert, außer der Counter resettet nicht bei < 3
                if (wuerfelCounter > 3) {
                    wuerfelCounter = 0;
                    System.out.println("funktioniert");
                    if (rundenCounter > 3) {
                        return;
                    }
                } else if (wuerfelCounter == 3) {
                    //System.out.println("testtest");
                    autoZaehlen();
                    zahlen.clear();
                    beendenGedrueckt = true;
                    spielerZugBeendet();


                }
                wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
            }






    public void amZugSetzen(){
        if (beendenGedrueckt == false){
            amZugLabel.setLayoutX(450);
            amZugLabel.setLayoutY(200);
            amZugLabel.setPrefWidth(150);
            amZugLabel.setPrefHeight(50);
            amZugLabel.setTextFill(Color.WHITE);
            amZugLabel.setText("Spieler ist am Zug");
            spielfeldPane.getChildren().add(amZugLabel);
        } else{
            amZugLabel.setLayoutX(450);
            amZugLabel.setLayoutY(200);
            amZugLabel.setPrefWidth(150);
            amZugLabel.setPrefHeight(50);
            amZugLabel.setTextFill(Color.WHITE);
            amZugLabel.setText("Computer ist am Zug");
            spielfeldPane.getChildren().add(amZugLabel);
        }
    }
    private void wuerfelnComputer(){



            List<ImageView> wuerfelComputer = initialisiereWuerfelComputer();
            ImageView wuerfelComputer1 = wuerfelComputer.get(0);
            ImageView wuerfelComputer2 = wuerfelComputer.get(1);
            ImageView wuerfelComputer3 = wuerfelComputer.get(2);
            ImageView wuerfelComputer4 = wuerfelComputer.get(3);
            ImageView wuerfelComputer5 = wuerfelComputer.get(4);
            spielfeldPane.getChildren().add(wuerfelComputer1);
            spielfeldPane.getChildren().add(wuerfelComputer2);
            spielfeldPane.getChildren().add(wuerfelComputer3);
            spielfeldPane.getChildren().add(wuerfelComputer4);
            spielfeldPane.getChildren().add(wuerfelComputer5);

            System.out.println("geht in Computer");





            //wuerfelCounter = 0;
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");

            wuerfelCounter++;


            int zahl1 = (int) (Math.random() * 6) + 1;
            Image wuerfel1 = wuerfelListe.get(zahl1 - 1).getBild();
            wuerfelComputer1.setImage(wuerfel1);
            wuerfelComputer1.setVisible(true);
            //System.out.println("Wuerfelliste: ");
            //System.out.println(wuerfelListe.size());
            zahlen.add(zahl1);

            int zahl2 = (int) (Math.random() * 6) + 1;
            Image wuerfel2 = wuerfelListe.get(zahl2 - 1).getBild();
            wuerfelComputer2.setImage(wuerfel2);
            wuerfelComputer2.setVisible(true);
            zahlen.add(zahl2);

            int zahl3 = (int) (Math.random() * 6) + 1;
            Image wuerfel3 = wuerfelListe.get(zahl3 - 1).getBild();
            wuerfelComputer3.setImage(wuerfel3);
            wuerfelComputer3.setVisible(true);
            zahlen.add(zahl3);

            int zahl4 = (int) (Math.random() * 6) + 1;
            Image wuerfel4 = wuerfelListe.get(zahl4 - 1).getBild();
            wuerfelComputer4.setImage(wuerfel4);
            wuerfelComputer4.setVisible(true);
            zahlen.add(zahl4);

            int zahl5 = (int) (Math.random() * 6) + 1;
            Image wuerfel5 = wuerfelListe.get(zahl5 - 1).getBild();
            wuerfelComputer5.setImage(wuerfel5);
            wuerfelComputer5.setVisible(true);
            zahlen.add(zahl5);

            System.out.println("Letzte Zahlen Computer");
            System.out.println(zahlen);
            System.out.println("Computer -------------------------------------");
            beenden.setVisible(false);
            amZugLabel.setLayoutX(25);
            amZugLabel.setLayoutY(0);
            amZugLabel.setPrefWidth(150);
            amZugLabel.setPrefHeight(50);
            amZugLabel.setTextFill(Color.WHITE);
            amZugLabel.setText("Computer ist am Zug");

            if (wuerfelCounter > 3) {
                wuerfelCounter = 0;
                System.out.println("funktioniert");
                if (rundenCounter > 3) {
                    return;
                }
            } else if (wuerfelCounter == 3) {
                //System.out.println("testtest");
                autoZaehlen();
                zahlen.clear();
                beendenGedrueckt = false;
                computerZugBeendet();


            }
            wuerfelCounterLabel.setText(wuerfelCounter + " Mal gewuerfelt");
        }










    private List<ImageView> initialisiereWuerfelComputer(){

        List<ImageView> imageViewListe = new ArrayList<>();

        ImageView wuerfelComputer1 = new ImageView();
        wuerfelComputer1.setFitWidth(80);
        wuerfelComputer1.setFitHeight(80);
        wuerfelComputer1.setLayoutX(280);
        wuerfelComputer1.setLayoutY(300);
        wuerfelComputer1.setVisible(false);
        imageViewListe.add(wuerfelComputer1);


        ImageView wuerfelComputer2 = new ImageView();
        wuerfelComputer2.setFitWidth(80);
        wuerfelComputer2.setFitHeight(80);
        wuerfelComputer2.setLayoutX(370);
        wuerfelComputer2.setLayoutY(300);
        wuerfelComputer2.setVisible(false);
        imageViewListe.add(wuerfelComputer2);


        ImageView wuerfelComputer3 = new ImageView();
        wuerfelComputer3.setFitWidth(80);
        wuerfelComputer3.setFitHeight(80);
        wuerfelComputer3.setLayoutX(460);
        wuerfelComputer3.setLayoutY(300);
        wuerfelComputer3.setVisible(false);
        imageViewListe.add(wuerfelComputer3);


        ImageView wuerfelComputer4 = new ImageView();
        wuerfelComputer4.setFitWidth(80);
        wuerfelComputer4.setFitHeight(80);
        wuerfelComputer4.setLayoutX(550);
        wuerfelComputer4.setLayoutY(300);
        wuerfelComputer4.setVisible(false);
        imageViewListe.add(wuerfelComputer4);



        ImageView wuerfelComputer5 = new ImageView();
        wuerfelComputer5.setFitWidth(80);
        wuerfelComputer5.setFitHeight(80);
        wuerfelComputer5.setLayoutX(640);
        wuerfelComputer5.setLayoutY(300);
        wuerfelComputer5.setVisible(false);
        imageViewListe.add(wuerfelComputer5);

        return imageViewListe;

    }
    private List<ImageView> initialisiereWuerfelPlayer() {

        List<ImageView> imageViewListe = new ArrayList<>();

        ImageView wuerfelSpieler1 = new ImageView();
        wuerfelSpieler1.setFitWidth(80);
        wuerfelSpieler1.setFitHeight(80);
        wuerfelSpieler1.setLayoutX(280);
        wuerfelSpieler1.setLayoutY(300);
        wuerfelSpieler1.setVisible(false);
        imageViewListe.add(wuerfelSpieler1);


        ImageView wuerfelSpieler2 = new ImageView();
        wuerfelSpieler2.setFitWidth(80);
        wuerfelSpieler2.setFitHeight(80);
        wuerfelSpieler2.setLayoutX(370);
        wuerfelSpieler2.setLayoutY(300);
        wuerfelSpieler2.setVisible(false);
        imageViewListe.add(wuerfelSpieler2);


        ImageView wuerfelSpieler3 = new ImageView();
        wuerfelSpieler3.setFitWidth(80);
        wuerfelSpieler3.setFitHeight(80);
        wuerfelSpieler3.setLayoutX(460);
        wuerfelSpieler3.setLayoutY(300);
        wuerfelSpieler3.setVisible(false);
        imageViewListe.add(wuerfelSpieler3);


        ImageView wuerfelSpieler4 = new ImageView();
        wuerfelSpieler4.setFitWidth(80);
        wuerfelSpieler4.setFitHeight(80);
        wuerfelSpieler4.setLayoutX(550);
        wuerfelSpieler4.setLayoutY(300);
        wuerfelSpieler4.setVisible(false);
        imageViewListe.add(wuerfelSpieler4);



        ImageView wuerfelSpieler5 = new ImageView();
        wuerfelSpieler5.setFitWidth(80);
        wuerfelSpieler5.setFitHeight(80);
        wuerfelSpieler5.setLayoutX(640);
        wuerfelSpieler5.setLayoutY(300);
        wuerfelSpieler5.setVisible(false);
        imageViewListe.add(wuerfelSpieler5);

        return imageViewListe;
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
        wuerfelCounter = 0;
    }

    public int wuerfeln(){
        wuerfelZahl = (int)(Math.random()*6)+1;

        return 0;
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

        if (beendenGedrueckt == false) {
            punkteSpieler += punkte;
            zahlen.clear();
            punktePruefung();


            punkteSpielerLabel.setText("Punkte des Spielers: " + punkteSpieler);
            punkteComputerLabel.setText("Punkte des Computers: " + punkteComputer);
        } else{
            punkteComputer += punkte;
            zahlen.clear();
            punktePruefung();
            punkteSpielerLabel.setText("Punkte des Spielers: " + punkteSpieler);
            punkteComputerLabel.setText("Punkte des Computers: " + punkteComputer);
        }

    }
}
