package com.example.minimarioparty.SchereSteinPapier;

import com.example.minimarioparty.GuterWuerfel;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchereSteinPapierMiniSpiel extends Minispiel {

    private Stage stage;
    private  final Pane spielfeld = new Pane();
    private final Pane spielstandPane = new Pane();

    private int spielstandSpieler = 0;
    private int spielstandComputer = 0;
    private Image schereBild = new Image("Schere.jpg");
    private Image steinBild = new Image("Stein.jpg");
    private Image papierBild = new Image("Papier.jpg");

    private Pane endPane = new Pane();

    private Label startText = new Label("Bitte wähle Schere, Stein oder Papier");
    private Label WinLoseLabel;

    ArrayList <Image> computerAuswahlListe = new ArrayList<>(Arrays.asList(schereBild,steinBild, papierBild));

    private int spielerAuswahl;












    @Override
    public void start(Stage stage) throws IOException{

        this.stage = stage;

        spielanleitungText = "Schere, Stein, Papier oder auch Schnick, Schnack, Schnuck ist ein beliebtes und super einfaches Kinderspiel. Du benötigst nur deine Finger um das gewünschte Symbol auszuwählen und einen Gegner und schon kann der Spaß beginnen.\n" +
                "\n" +
                "Das Spiel beinhaltet in seiner Ursprungsform drei Gesten: für Schere, Stein, Papier. Diese werden als Symbole mit der Hand dargestellt. \n" +
                "\n" +
                "Das Ziel der Spieler:innen liegt darin, eine höherwertige Geste als der Gegner zu spielen. So ist die Rangfolge:\n" +
                "\n" +
                "Stein schlägt Schere (Denn der Stein kann die Schere schleifen.)\n" +
                "Schere schlägt Papier (Denn die Schere kann das Papier schneiden.) \n" +
                "Papier schlägt Stein (Denn das Papier kann den Stein einwickeln.)\n" +
                "Du wählst nun ein Symbol aus und der Computer wird über ein Zufallssystem sein Symbol auswählen\n" +
                "\n" +
                "Jedes Symbol verliert oder gewinnt gegen jeweils ein anderes Symbol. Oft werden mehrere Runden hintereinander gespielt und der Spieler mit den meisten Siegen am Ende gewinnt.";



        Button b = new Button("Starte Game");
        b.setPrefSize(100, 100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        p.getChildren().add(b);
        b.setOnAction(event -> {
            System.out.println("Button wurde gedrückt");
            Platform.runLater(()->b.setVisible(false));

            spielfeld.setPrefSize(700, 600);
            spielfeld.setLayoutX(75);
            spielfeld.setLayoutY(150);
            spielfeld.setStyle("-fx-background-color: #b4cdcd;");
            p.getChildren().add(spielfeld);

            Button schere = new Button("Schere");
            schere.setLayoutX(51);
            schere.setLayoutY(491);
            schere.setPrefWidth(150);
            schere.setPrefHeight(40);
            spielfeld.getChildren().add(schere);

            Button stein = new Button("Stein");
            stein.setLayoutX(275);
            stein.setLayoutY(491);
            stein.setPrefWidth(150);
            stein.setPrefHeight(40);
            spielfeld.getChildren().add(stein);

            Button papier = new Button("Papier");
            papier.setLayoutX(495);
            papier.setLayoutY(491);
            papier.setPrefWidth(150);
            papier.setPrefHeight(40);
            spielfeld.getChildren().add(papier);

            spielstandPane.setPrefSize(200, 200);
            spielstandPane.setLayoutX(786);
            spielstandPane.setLayoutY(150);
            spielstandPane.setStyle("-fx-background-color: #79cdcd;");
            p.getChildren().add(spielstandPane);

            Label spielstand = new Label("Spielstand");
            spielstand.setPrefWidth(200);
            spielstand.setPrefHeight(50);
            spielstand.setFont(new Font("Arial", 30));
            spielstand.setAlignment(Pos.CENTER);
            spielstandPane.getChildren().add(spielstand);

            Pane innerPaneSpielstand = new Pane();
            innerPaneSpielstand.setLayoutY(50);
            innerPaneSpielstand.setPrefWidth(200);
            innerPaneSpielstand.setPrefHeight(150);
            innerPaneSpielstand.setStyle("-fx-background-color: #b4cdcd;");
            spielstandPane.getChildren().add(innerPaneSpielstand);



            Label spieler =new Label("Spieler");
            spieler.setLayoutX(18);
            spieler.setLayoutY(15);
            spieler.setFont(new Font("Arial", 21));
            innerPaneSpielstand.getChildren().add(spieler);

            Label computer =new Label("Computer");
            computer.setLayoutX(100);
            computer.setLayoutY(15);
            computer.setFont(new Font("Arial", 21));
            innerPaneSpielstand.getChildren().add(computer);

            Label spielstandSpielerLabel = new Label();
            spielstandSpielerLabel.setLayoutX(33);
            spielstandSpielerLabel.setLayoutY(67);
            spielstandSpielerLabel.setFont(new Font("Arial", 33));
            innerPaneSpielstand.getChildren().add(spielstandSpielerLabel);


            spielstandSpielerLabel.setText(Integer.toString(spielstandSpieler));

            Label spielstandComputerLabel = new Label();
            spielstandComputerLabel.setLayoutX(148);
            spielstandComputerLabel.setLayoutY(67);
            spielstandComputerLabel.setFont(new Font("Arial", 33));
            innerPaneSpielstand.getChildren().add(spielstandComputerLabel);

            spielstandComputerLabel.setText(Integer.toString(spielstandComputer));


            ImageView spielerBild = new ImageView();
            spielerBild.setLayoutX(262);
            spielerBild.setLayoutY(262);

            ImageView computerBild = new ImageView();
            computerBild.setLayoutX(262);
            computerBild.setLayoutY(40);


            startText.setLayoutX(108);
            startText.setLayoutY(227);
            startText.setFont(new Font("Arial", 30));

            Label ueberschrift = new Label("Wer zuerst fünf mal gewonnen hat, gewinnt das Spiel");
            p.getChildren().add(ueberschrift);
            ueberschrift.setLayoutY(110);
            ueberschrift.setLayoutX(100);
            ueberschrift.setFont(new Font("Arial", 30));

            spielfeld.getChildren().add(computerBild);
            spielfeld.getChildren().add(spielerBild);
            spielfeld.getChildren().add(startText);

            schere.setOnAction(event1 ->{

                spielerBild.setImage(schereBild);
                int zufallszahl = (int) (Math.random()*3);
                computerBild.setImage(computerAuswahlListe.get(zufallszahl));
                if (zufallszahl == 0 ){
                    startText.setText("Unentschieden");
                    startText.setLayoutX(257);
                } else if (zufallszahl == 1) {
                    startText.setText("Du hast verloren");
                    startText.setLayoutX(257);
                    spielstandComputer += 1;
                    spielstandComputerLabel.setText(Integer.toString(spielstandComputer));
                    if (spielstandComputer > 4){
                        schere.setDisable(true);
                        stein.setDisable(true);
                        papier.setDisable(true);
                        p.getChildren().remove(spielfeld);
                        gewinnauswertung();
                    }

                } else {
                    startText.setText("Du hast gewonnen");
                    startText.setLayoutX(257);
                    spielstandSpieler +=1;
                    spielstandSpielerLabel.setText(Integer.toString(spielstandSpieler));
                    if (spielstandSpieler > 4){
                        schere.setDisable(true);
                        stein.setDisable(true);
                        papier.setDisable(true);
                        p.getChildren().remove(spielfeld);
                        gewinnauswertung();
                    }
                }


            });

            stein.setOnAction(event2 ->{

                spielerBild.setImage(steinBild);
                int zufallszahl = (int) (Math.random()*3);
                computerBild.setImage(computerAuswahlListe.get(zufallszahl));
                if (zufallszahl == 0 ){
                    startText.setText("Du hast gewonnen");
                    startText.setLayoutX(257);
                    spielstandSpieler +=1;
                    spielstandSpielerLabel.setText(Integer.toString(spielstandSpieler));
                    if (spielstandSpieler > 4){
                        schere.setDisable(true);
                        stein.setDisable(true);
                        papier.setDisable(true);
                        p.getChildren().remove(spielfeld);
                        gewinnauswertung();
                    }
                } else if (zufallszahl == 1) {
                    startText.setText("Unentschieden");
                    startText.setLayoutX(257);
                } else {
                    startText.setText("Du hast verloren");
                    startText.setLayoutX(257);
                    spielstandComputer += 1;
                    spielstandComputerLabel.setText(Integer.toString(spielstandComputer));
                    if (spielstandComputer > 4){
                        schere.setDisable(true);
                        stein.setDisable(true);
                        papier.setDisable(true);
                        p.getChildren().remove(spielfeld);
                        gewinnauswertung();
                    }

                }
            });

            papier.setOnAction(event3 ->{

                spielerBild.setImage(papierBild);
                int zufallszahl = (int) (Math.random()*3);
                computerBild.setImage(computerAuswahlListe.get(zufallszahl));
                if (zufallszahl == 0 ){
                    startText.setText("Du hast verloren");
                    startText.setLayoutX(257);
                    spielstandComputer +=1;
                    spielstandComputerLabel.setText(Integer.toString(spielstandComputer));
                    if (spielstandComputer > 4){
                        schere.setDisable(true);
                        stein.setDisable(true);
                        papier.setDisable(true);
                        p.getChildren().remove(spielfeld);
                        gewinnauswertung();
                    }

                } else if (zufallszahl == 1) {
                    startText.setText("Du hast gewonnen");
                    startText.setLayoutX(257);
                    spielstandSpieler += 1;
                    spielstandSpielerLabel.setText(Integer.toString(spielstandSpieler));
                    if (spielstandSpieler > 4){
                        schere.setDisable(true);
                        stein.setDisable(true);
                        papier.setDisable(true);
                        p.getChildren().remove(spielfeld);
                        gewinnauswertung();
                    }
                } else {
                    startText.setText("Unentschieden");
                    startText.setLayoutX(257);
                }
            });









        } );

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




}
