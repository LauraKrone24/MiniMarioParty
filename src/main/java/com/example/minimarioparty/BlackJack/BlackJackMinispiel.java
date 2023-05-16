package com.example.minimarioparty.BlackJack;


import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.util.Duration;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class BlackJackMinispiel  extends Minispiel {
    private String a = "a";

    private Stage stage;
    Pane spielfeldPane = new Pane();

    int punktestand = 0;
    int cpunktestand = 0;
    int x = 340;
    int y = 75;
    private int spielstandSpieler = 0;
    private int spielstandComputer = 0;

    double aktuellX = 340;
    double aktuellY = 339;
    Label spielstandSpielerLabel = new Label();
    Label spielstandComputerLabel = new Label();
    Label mitte = new Label("Drücke Card für eine Karte");
    Label punkteAnzahl = new Label("Aktueller Punktestand: " + punktestand);



    Karteninitialisieren test = new Karteninitialisieren();
    List<Spielkarten> kartenListe= test.getKartenListe();
    Label cpunkteAnzahl = new Label("Computer: " + cpunktestand);
    List<ImageView> erstellteComputerkarten = new ArrayList<>();
    List<ImageView> erstellteSpielerkarten = new ArrayList<>();
    Button neueKarte = new Button("Card");
    Button stop = new Button("Stop");
    private Label WinLoseLabel;










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


        neueKarte.setLayoutX(215);
        neueKarte.setLayoutY(576);
        neueKarte.setPrefWidth(150);
        neueKarte.setPrefHeight(50);


        stop.setLayoutX(400);
        stop.setLayoutY(576);
        stop.setPrefWidth(150);
        stop.setPrefHeight(50);







        ImageView ckarte1 = new ImageView();
        ckarte1.setFitWidth(78);
        ckarte1.setFitHeight(123);
        ckarte1.setLayoutX(340);
        ckarte1.setLayoutY(75);


        mitte.setLayoutX(340);
        mitte.setLayoutY(250);
        mitte.setFont(new Font("Arial", 30));
        mitte.setTextFill(Color.WHITE);










        punkteAnzahl.setLayoutX(215);
        punkteAnzahl.setLayoutY(540);
        punkteAnzahl.setFont(new Font("Arial", 30));
        punkteAnzahl.setTextFill(Color.WHITE);


        cpunkteAnzahl.setLayoutX(50);
        cpunkteAnzahl.setLayoutY(100);
        cpunkteAnzahl.setFont(new Font("Arial", 30));
        cpunkteAnzahl.setTextFill(Color.WHITE);

        Pane spielstand = new Pane();
        spielstand.setPrefWidth(200);
        spielstand.setPrefHeight(200);
        spielstand.setLayoutX(800);
        spielstand.setStyle("-fx-background-color: #79cdcd;");

        Label spielstandLabel = new Label("Spielstand");
        spielstandLabel.setLayoutX(33);
        spielstandLabel.setLayoutY(5);
        spielstandLabel.setFont(new Font("Arial", 33));
        spielstand.getChildren().add(spielstandLabel);


        Label spieler =new Label("Spieler");
        spieler.setLayoutX(18);
        spieler.setLayoutY(45);
        spieler.setFont(new Font("Arial", 21));
        spielstand.getChildren().add(spieler);


        spielstandSpielerLabel.setLayoutX(33);
        spielstandSpielerLabel.setLayoutY(85);
        spielstandSpielerLabel.setFont(new Font("Arial", 33));
        spielstand.getChildren().add(spielstandSpielerLabel);
        spielstandSpielerLabel.setText(Integer.toString(spielstandSpieler));

        Label computer =new Label("Computer");
        computer.setLayoutX(100);
        computer.setLayoutY(45);
        computer.setFont(new Font("Arial", 21));
        spielstand.getChildren().add(computer);


        spielstandComputerLabel.setLayoutX(148);
        spielstandComputerLabel.setLayoutY(85);
        spielstandComputerLabel.setFont(new Font("Arial", 33));
        spielstand.getChildren().add(spielstandComputerLabel);

        spielstandComputerLabel.setText(Integer.toString(spielstandComputer));

        spielfeldPane.getChildren().add(spielfeld);
        spielfeldPane.getChildren().add(neueKarte);
        spielfeldPane.getChildren().add(stop);

        spielfeldPane.getChildren().add(ckarte1);
        spielfeldPane.getChildren().add(punkteAnzahl);
        spielfeldPane.getChildren().add(cpunkteAnzahl);
        spielfeldPane.getChildren().add(mitte);
        spielfeldPane.getChildren().add(spielstand);





        neueKarte.setOnAction(actionEvent -> {

            int zahl = (int) (Math.random() * (kartenListe.size() - 1));
            Image kartenBild = kartenListe.get(zahl).getBild();
            ImageView neueKarteerstellen = new ImageView(kartenBild);
            neueKarteerstellen.setFitWidth(78);
            neueKarteerstellen.setFitHeight(123);
            neueKarteerstellen.setLayoutX(aktuellX);
            neueKarteerstellen.setLayoutY(aktuellY);
            aktuellX += 40;

            spielfeldPane.getChildren().add(neueKarteerstellen);
            erstellteSpielerkarten.add(neueKarteerstellen);

            punktestand += kartenListe.get(zahl).getWert();
            kartenListe.remove(kartenListe.get(zahl));

            punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);
            if (kartenListe.size() < 7){}
            kartenListe = test.getKartenListe();
        });



        stop.setOnAction(actionEvent1 -> {
            if (spielstandSpieler < 5 && spielstandComputer < 5) {
                neueKarte.setDisable(true);
                stop.setDisable(true);

                if (spielstandSpieler == 5 || spielstandComputer ==5){
                    neueKarte.setDisable(true);
                    stop.setDisable(true);

                }else {
                    karteZiehenComputer();



                    

                }

            }





        });

        WinLoseLabel = new Label();
        WinLoseLabel.setPrefSize(400,50);
        WinLoseLabel.setFont(new Font(40));
        WinLoseLabel.setLayoutY(400);
        WinLoseLabel.setLayoutX(300);
        WinLoseLabel.setAlignment(Pos.CENTER);
        WinLoseLabel.setVisible(false);
        p.getChildren().add(WinLoseLabel);
        super.start(stage);
    }

    public void gewinnKontrolle(){
        if (punktestand < 22 && ((punktestand > cpunktestand) || (cpunktestand > 21))) {
            spielstandSpieler += 1;
            spielstandSpielerLabel.setText(Integer.toString(spielstandSpieler));
            Platform.runLater(( )->mitte.setText("Du hast gewonnen"));



        } else if ((punktestand > 21 && cpunktestand < 22) || (punktestand < 22 && punktestand < cpunktestand)) {
            spielstandComputer += 1;
            spielstandComputerLabel.setText(Integer.toString(spielstandComputer));
            Platform.runLater(( )->mitte.setText("Du hast verloren"));




        } else {
            mitte.setText("Unentschieden");
            Platform.runLater(( )->mitte.setText("Unentschieden"));
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event ->{
            cpunktestand = 0;
            punktestand = 0;
            punkteAnzahl.setText("Aktueller Punktestand: " + punktestand);
            cpunkteAnzahl.setText("Computer: " + cpunktestand);
            for (ImageView f : erstellteSpielerkarten){
                spielfeldPane.getChildren().remove(f);
            }
            for (ImageView f: erstellteComputerkarten){
                spielfeldPane.getChildren().remove(f);
            }

            erstellteSpielerkarten.clear();
            erstellteComputerkarten.clear();
            aktuellX = 340;
            x = 340;
            Platform.runLater(() -> mitte.setText("Drücke Card für eine Karte"));



            neueKarte.setDisable(false);
            stop.setDisable(false);
        });
        pause.play();

        if (spielstandSpieler > 4 || spielstandComputer > 4){
            p.getChildren().remove(spielfeldPane);
            gewinnauswertung();

        }


    }

    private void gewinnauswertung() {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {

            minispielrueckgabewert.setAbbruch(false);
            minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());

            Platform.runLater(()->WinLoseLabel.setVisible(true));
            if(spielstandSpieler > spielstandComputer){
                minispielrueckgabewert.setWinner(spieler[0]);
                Platform.runLater(()->WinLoseLabel.setText("Du hast gewonnen!!"));


            }else {
                minispielrueckgabewert.setWinner(spieler[1]);

                Platform.runLater(()->WinLoseLabel.setText("Du hast leider verloren"));
            }

            PauseTransition pause2 = new PauseTransition(Duration.seconds(3));
            pause2.setOnFinished(e -> stage.close());
            pause2.play();


        });

        pause.play();
    }



    public  void karteZiehenComputer(){

        // das als Methode für computer karteziehen
        int czahl1 = (int) (Math.random() * (kartenListe.size()));
        ImageView test1 = new ImageView();
        test1.setFitHeight(123);
        test1.setFitWidth(78);
        test1.setLayoutX(x);
        test1.setLayoutY(y);
        spielfeldPane.getChildren().add(test1);
        test1.setImage(kartenListe.get(czahl1).getBild());
        cpunktestand += kartenListe.get(czahl1).getWert();
        kartenListe.remove(kartenListe.get(czahl1));
        cpunkteAnzahl.setText("Computer: " + cpunktestand);
        if (kartenListe.size() < 7){}
        kartenListe = test.getKartenListe();
        x += 40;
        erstellteComputerkarten.add(test1);


        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(actionEvent -> {
            if (cpunktestand < 18) {
                karteZiehenComputer();
            }else {
                gewinnKontrolle();

            }
        });
        pause.play();
    }
}



