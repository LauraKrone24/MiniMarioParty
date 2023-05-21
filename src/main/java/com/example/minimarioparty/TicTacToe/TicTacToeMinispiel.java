package com.example.minimarioparty.TicTacToe;

import com.example.minimarioparty.Minispiel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeMinispiel extends Minispiel {

    private Stage stage;
    private Pane spielfeldPane = new Pane();
    private Button button1 = new Button();
    private Button button2 = new Button();
    private Button button3 = new Button();
    private Button button4 = new Button();
    private Button button5 = new Button();
    private Button button6 = new Button();
    private Button button7 = new Button();
    private Button button8 = new Button();

    private Button button9 = new Button();

    private int buttonHeightWidth = 160;
    private int xpx= 400;
    private int computerRandom;

    private boolean spielerDran;
    private boolean unentschieden;
    //private boolean leicht =false;
    private Label startSpieler = new Label();
    private int zug = 0;
    private String moglich;
    private List<Integer> belegteButtons = new ArrayList<>();
    private ArrayList<Button> ButtonList = new ArrayList<>(Arrays.asList(button1,button2, button3, button4, button5,button6,button7,button8,button9));

    //tictactoe schwer
    String spielerX = "X";
    String computerO = "O";
    String nichBelegt = "";
    int computerCalculated;
    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        spielanleitungText = "TicTacToe wird auf einem 3x3 Spielfeld gespielt. \nJeder Spieler setzt nach einander ein Zeichen in ein \nfreies Feld. Wer als erster 3 Zeichen diagonal, \nin einer Spalte oder Zeile hat, hat gewonnen. \nEin Unentschieden ist auch möglich. ";
        MinispielTitleLabel.setText("TicTacToe");
        if(leicht==true){
            MinispielSchwierigkeitLable.setText("leicht");
        }
        else{
            MinispielSchwierigkeitLable.setText("schwer");
        }


        Button b = new Button("Start Game");
        b.setPrefSize(100, 100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        p.getChildren().add(b);
        b.setOnAction(event -> {
            System.out.println("Game started");

            Platform.runLater(() -> {b.setVisible(false);

            spielfeldPane.setLayoutX(xpx);
            spielfeldPane.setLayoutY(200);
            spielfeldPane.setPrefHeight(500);
            spielfeldPane.setPrefWidth(500);
            spielfeldPane.setStyle("-fx-background-color: #121212;");

            startSpieler.setLayoutX(100);
            startSpieler.setLayoutY(300);
            startSpieler.setFont(Font.font("system", 20));

            ButtonList.forEach(ticButton -> {
                ticButton.setPrefHeight(buttonHeightWidth);
                ticButton.setPrefWidth(buttonHeightWidth);
            });

            //kann ich bestimmt noch vereinfachen
            button1.setLayoutX(xpx + 5); //20 px zwischen allen sind 5 px abstand
            button1.setLayoutY(205);


            button2.setLayoutX(xpx + 170);
            button2.setLayoutY(205);


            button3.setLayoutX(xpx + 335);
            button3.setLayoutY(205);

            button4.setLayoutX(xpx + 5);
            button4.setLayoutY(370);


            button5.setLayoutX(xpx + 170);
            button5.setLayoutY(370);

            button6.setLayoutX(xpx + 335);
            button6.setLayoutY(370);

            button7.setLayoutX(xpx + 5);
            button7.setLayoutY(535);


            button8.setLayoutX(xpx + 170);
            button8.setLayoutY(535);


            button9.setLayoutX(xpx + 335);
            button9.setLayoutY(535);


            //kann ich bestimmt noch vereinfachen
            button1.setOnAction(event1 -> {
                zeichenSetzten(button1);
            });

            button2.setOnAction(actionEvent -> {
                zeichenSetzten(button2);
            });

            button3.setOnAction(actionEvent -> {
                zeichenSetzten(button3);
            });

            button4.setOnAction(actionEvent -> {
                zeichenSetzten(button4);
            });

            button5.setOnAction(actionEvent -> {
                zeichenSetzten(button5);
            });

            button6.setOnAction(actionEvent -> {
                zeichenSetzten(button6);
            });

            button7.setOnAction(actionEvent -> {
                zeichenSetzten(button7);
            });

            button8.setOnAction(actionEvent -> {
                zeichenSetzten(button8);
            });

            button9.setOnAction(actionEvent -> {
                zeichenSetzten(button9);
            });



            Button neustart = new Button();
            neustart.setLayoutX(100);
            neustart.setLayoutY(500);
            neustart.setPrefWidth(100);
            neustart.setPrefHeight(50);
            neustart.setText("Neustart");
            neustart.setOnAction(actionEvent -> neuStart());










            p.getChildren().addAll(spielfeldPane, button1, button2, button3, button4, button5, button6, button7, button8, button9, neustart, startSpieler);

            });
            new Thread (() ->{
                if(leicht==true){
                    werStartet();
                    computerSetzen();
                }
                else{
                    spielerDran = true;
                    startSpieler.setText("Spieler beginnt");
                    startSpieler.setTextFill(Paint.valueOf("#000000"));
                    startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#7eb774"), CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("Spieler startet");
                }
            }).start();

        });


        super.start(stage);
    }

    private void werStartet() {

        int starter;
        starter = (int) (Math.random() * 2 + 1);
        if (starter == 1) {
            spielerDran = true;
            startSpieler.setText("Spieler beginnt");
            startSpieler.setTextFill(Paint.valueOf("#000000"));
            startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#7eb774"), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Spieler startet");
        } else {
            spielerDran = false;
            startSpieler.setText("Computer beginnt");
            startSpieler.setTextFill(Paint.valueOf("#000000"));
            startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ed7b84"), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Computer startet");
        }

    }
    private void zeichenSetzten(Button bt){
        if(spielerDran==true && bt.getText().isEmpty()){

                bt.setText("X");
                bt.setTextFill(Paint.valueOf("#7eb774"));
                spielerDran= false;
                System.out.println("Spieler hat gesetzt");
                belegteButtons.add(ButtonList.indexOf(bt));
//button mit koordinaten an algo übergeben e.g. button1 ist [0][0]
                bt.setFont(Font.font("Arial black", 24));
                zug++;
                System.out.println("Zug: " + zug);
                istSpielEnde();
                if(leicht == true) {
                    computerSetzen();
                }
                else{
                    computerSchwerIstDran();
                }



    }
    }

    private void computerSetzen(){
        if(spielerDran==false) {
            while (true) {
                computerRandom = (int) (Math.random() * 9);
                if (!belegteButtons.contains(computerRandom)) {
                    System.out.println("Computerzufallszahl: " + computerRandom);
                    break;
                }
            }
        }
        Button bt = ButtonList.get(computerRandom);


        if(spielerDran==false && bt.getText().isEmpty()){
            Platform.runLater(() ->{
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(actionEvent -> {
                    System.out.println("Computer wählt Feld: " + (computerRandom + 1));
                    bt.setText("O");
                    bt.setTextFill(Paint.valueOf("#ed7b84"));
                    spielerDran=true;
                    System.out.println("Computer hat gesetzt");
                    belegteButtons.add(ButtonList.indexOf(bt));

                    bt.setFont(Font.font("Arial black", 24));
                    zug++;
                    System.out.println("Zug: " + zug);
                    istSpielEnde();

                });
                pause.play();


            });


        }

    }

    private void istSpielEnde(){
        if (zug>0 && zug<=9){
            getErgebnis();
        }
    }

    private void getErgebnis(){

        for(int art= 1; art<=8; art++) {
            moglich = switch (art) {
                case 1 -> button1.getText() + button2.getText() + button3.getText();
                case 2 -> button4.getText() + button5.getText() + button6.getText();
                case 3 -> button7.getText() + button8.getText() + button9.getText();
                case 4 -> button1.getText() + button4.getText() + button7.getText();
                case 5 -> button2.getText() + button5.getText() + button8.getText();
                case 6 -> button3.getText() + button6.getText() + button9.getText();
                case 7 -> button3.getText() + button5.getText() + button7.getText();
                case 8 -> button1.getText() + button5.getText() + button9.getText();
                default -> "";
            };

            if (moglich.equals("XXX")) {
                ButtonList.forEach(ticButton ->{
                    ticButton.setDisable(true);
                });
                spielerDran=true;
                unentschieden=false;
                startSpieler.setText("Du hast gewonnen!");
                startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#121212"), CornerRadii.EMPTY, Insets.EMPTY)));
                startSpieler.setTextFill(Paint.valueOf("#7eb774"));
                System.out.println("Spieler hat gewonnen");
                break;
            }
            else if (moglich.equals("OOO")) {
                ButtonList.forEach(ticButton ->{
                    ticButton.setDisable(true);

                });
                spielerDran=true;
                unentschieden=false;
                startSpieler.setText("Computer hat gewonnen");
                startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#121212"), CornerRadii.EMPTY, Insets.EMPTY)));
                startSpieler.setTextFill(Paint.valueOf("#ed7b84"));
                System.out.println("Computer hat gewonnen");
                break;

            }else if(zug==9){
                unentschieden=true;

            }
        }
        if (unentschieden==true){
            startSpieler.setText("Unentschieden");
            startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#6e44ff"), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Unentschieden");
            spielerDran=true;
        }


    }

    //methoden fuer schweres tictactoe

    private int werteFurComputer(){

        String[] moglichkeit = {spielerX, computerO};
        for (String element : moglichkeit) {

            if (button1.getText() == element && button2.getText() == element && button3.getText() == element ||
                    button4.getText() == element && button5.getText() == element && button6.getText() == element ||
                    button7.getText() == element && button8.getText() == element && button9.getText() == element ||
                    button1.getText() == element && button4.getText() == element && button7.getText() == element ||
                    button2.getText() == element && button5.getText() == element && button8.getText() == element ||
                    button3.getText() == element && button6.getText() == element && button9.getText() == element ||
                    button1.getText() == element && button5.getText() == element && button9.getText() == element ||
                    button3.getText() == element && button5.getText() == element && button7.getText() == element) {
                if (element == spielerX) {
                    return  2;
                } else {
                    return  0;
                }
            }
        }



        for(int bt = 0; bt< ButtonList.size(); bt++){
            Button ticButton = ButtonList.get(bt);
            if(ticButton.getText() == nichBelegt){
                return -1;
            }

        }


        return 1;
    }
    private int max(){
        if (werteFurComputer() != -1 ){
            return werteFurComputer();
        }
        int maxWert = -98767;
        int wert;
        for(int bt = 0; bt < ButtonList.size(); bt++){
            Button ueberpruefeButton = ButtonList.get(bt);
            if(ueberpruefeButton.getText() == nichBelegt){
                ueberpruefeButton.setText(spielerX);
                wert = min();
                if(wert > maxWert){
                    maxWert= wert;
                }
                ueberpruefeButton.setText(nichBelegt);
            }


        }

        return maxWert;
    }

    private int min(){
        if (werteFurComputer() != -1 ){
            return werteFurComputer();
        }
        int minWert = 98767;
        int wert;
        for(int bt = 0; bt < ButtonList.size(); bt++){
            Button ueberpruefeButton = ButtonList.get(bt);
            if(ueberpruefeButton.getText() == nichBelegt){
                ueberpruefeButton.setText(computerO);
                wert = max();
                if(wert < minWert){
                    minWert= wert;
                }
                ueberpruefeButton.setText(nichBelegt);
            }


        }

        return minWert;
    }

    private int minKoordinaten(){
        if (werteFurComputer() != -1 ){
            return werteFurComputer();
        }
        int minWert = 98767;
        int wert;
        for(int bt = 0; bt < ButtonList.size(); bt++){
            Button ueberpruefeButton = ButtonList.get(bt);
            if(ueberpruefeButton.getText() == nichBelegt){
                ueberpruefeButton.setText(computerO);
                wert = max();
                if(wert < minWert){
                    minWert= wert;
                    //if(zug !=1) {
                        computerCalculated = ButtonList.indexOf(ueberpruefeButton);
                    //}
                }
                ueberpruefeButton.setText(nichBelegt);
            }
            //System.out.println("minwert von minKoordinate: " + minWert);


        }

        return minWert;
    }

    private void computerSchwerIstDran(){
        /*if(zug==1){
            minKoordinaten();
            System.out.println("computerCalculated: " + computerCalculated);
            computerCalculated=7;
            min();
        }*/
        //else {
            minKoordinaten();
        //}

        Button bt = ButtonList.get(computerCalculated);

        if(spielerDran==false && bt.getText().isEmpty()){
            Platform.runLater(() ->{
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(actionEvent -> {
                    System.out.println("Computer wählt Feld: " + (computerCalculated+ 1));
                    bt.setText("O");
                    bt.setTextFill(Paint.valueOf("#ed7b84"));
                    spielerDran=true;
                    System.out.println("Computer hat gesetzt");

                    bt.setFont(Font.font("Arial black", 24));
                    zug++;
                    System.out.println("Zug: " + zug);
                    istSpielEnde();

                });
                pause.play();


            });


        }

    }



    private void neuStart(){
        ButtonList.forEach(ticButton -> {
            ticButton.setText("");
            ticButton.setDisable(false);

        });
        zug= 0;
        unentschieden=false;
        belegteButtons.clear();
        if(leicht==true){
        werStartet();
        computerSetzen();}
        else{
            spielerDran = true;
            startSpieler.setText("Spieler beginnt");
            startSpieler.setTextFill(Paint.valueOf("#000000"));
            startSpieler.setBackground(new Background(new BackgroundFill(Paint.valueOf("#7eb774"), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Spieler startet");
        }

    }

    /*private void gewinnAuswertung(){

    }*/


    }





