package com.example.minimarioparty.TicTacToe;

import com.example.minimarioparty.Minispiel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    private boolean buttonBelegt = false;
    private boolean spielerDran;
    private int zug = 0;
    private String moglich;
    private ArrayList<Button> ButtonList = new ArrayList<>(Arrays.asList(button1,button2, button3, button4, button5,button6,button7,button8,button9));
    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        spielanleitungText = "TicTacToe wird auf einem 3x3 Spielfeld gespielt. \nJeder Spieler setzt nach einander ein Zeichen in ein \nfreies Feld. Wer als erster 3 Zeichen diagonal, \nin einer Spalte oder Zeile hat, hat gewonnen. \nEin Unentschieden ist auch möglich. ";
        MinispielTitleLabel.setText("TicTacToe");
        MinispielSchwierigkeitLable.setText("leicht");

        Button b = new Button("Start Game");
        b.setPrefSize(100, 100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        p.getChildren().add(b);
        b.setOnAction(event -> {
            System.out.println("Game started");
            Platform.runLater(() -> b.setVisible(false));

            spielfeldPane.setLayoutX(xpx);
            spielfeldPane.setLayoutY(200);
            spielfeldPane.setPrefHeight(500);
            spielfeldPane.setPrefWidth(500);
            spielfeldPane.setStyle("-fx-background-color: #121212;");

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



            System.out.println(ButtonList);

            Button neustart = new Button();
            neustart.setLayoutX(100);
            neustart.setLayoutY(500);
            neustart.setPrefWidth(100);
            neustart.setPrefHeight(50);
            neustart.setText("Neustart");
            neustart.setOnAction(actionEvent -> neuStart());

            werStartet();

            computerSetzen();








            p.getChildren().addAll(spielfeldPane, button1, button2, button3, button4, button5, button6, button7, button8, button9, neustart);



        });

        super.start(stage);
    }

    private void werStartet(){
        int starter;
        starter = (int)(Math.random()*2 +1);
        if(starter == 1){
            spielerDran=true;
            System.out.println("Spieler startet");
        }
        else{
            spielerDran=false;
            System.out.println("Computer startet");
        }
    }
    private void zeichenSetzten(Button bt){
        if(spielerDran==true && bt.getText().isEmpty()){

            bt.setText("X");
            bt.setTextFill(Paint.valueOf("#7eb774"));
            spielerDran= false;
            System.out.println("Spieler hat gesetzt");


        bt.setFont(Font.font("Arial black", 20));
        zug++;
        System.out.println(zug);
        istSpielEnde();
        computerSetzen();
    }
    }

    private void computerSetzen(){
        while(true){
        computerRandom = (int)(Math.random()*9 +1);
        Button bt = ButtonList.get(computerRandom - 1);

        if(spielerDran==false && bt.getText().isEmpty()){
            System.out.println("Computer wählt " + computerRandom);
            bt.setText("O");
            bt.setTextFill(Paint.valueOf("#ed7b84"));
            spielerDran=true;
            System.out.println("Computer hat gesetzt");

            bt.setFont(Font.font("Arial black", 20));
            zug++;
            System.out.println(zug);
            istSpielEnde();
            break;
        }



        }

    }

    private void istSpielEnde(){
        if (zug==9){
            System.out.println("Unentschieden");
        } else if (zug<9){
            getErgebnis();
        }
    }

    private void getErgebnis(){
        for(int art= 1; 1<=8; art++) {
            moglich = switch (art) {
                case 1 -> button1.getText() + button2.getText() + button3.getText();
                case 2 -> button4.getText() + button5.getText() + button6.getText();
                case 3 -> button7.getText() + button8.getText() + button9.getText();
                case 4 -> button1.getText() + button4.getText() + button7.getText();
                case 5 -> button2.getText() + button5.getText() + button8.getText();
                case 6 -> button3.getText() + button6.getText() + button9.getText();
                case 7 -> button3.getText() + button5.getText() + button7.getText();
                case 8 -> button1.getText() + button5.getText() + button9.getText();
                default -> null;
            };
            if (moglich.equals("XXX")) {
                ButtonList.forEach(ticButton ->{
                    if (ticButton.getText().equals("")){
                    ticButton.setOnAction(actionEvent -> {
                        ticButton.setText("");
                    });
                }});
                System.out.println("Spieler hat gewonnen");
            } else if (moglich.equals("OOO")) {
                ButtonList.forEach(ticButton ->{if (ticButton.getText().equals("")){
                    ticButton.setOnAction(actionEvent -> {
                        ticButton.setText("");
                    });
                }

                });

                System.out.println("Computer hat gewonnen");

            }
        }
    }


    private void neuStart(){
        ButtonList.forEach(ticButton -> {
            ticButton.setText("");
            zug= 0;
        });
    }

    /*private void gewinnAuswertung(){

    }*/


    }


