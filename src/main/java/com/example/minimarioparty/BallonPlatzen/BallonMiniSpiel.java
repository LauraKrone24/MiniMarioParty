package com.example.minimarioparty.BallonPlatzen;

import com.example.minimarioparty.GuterWuerfel;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;

public class BallonMiniSpiel extends Minispiel {
    private final Pane innerPane = new Pane();

    private final int minPunkte = 5000;

    private Label ZeitLabel;

    private int  punkte =0;

    private Label PunkteLabel;
    long Endzeit;

    int ballonarten ;
    int faktor;
    @Override
    public void start(Stage stage) throws IOException {
        if(leicht){
            ballonarten = 2;
            faktor =1;
            minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());
        }else{
            ballonarten = 3;
            faktor = 2;
            minispielrueckgabewert.setWuerfel(new GuterWuerfel());
        }

        Button b  = new Button("Start Game");
        b.setPrefSize(100,100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        b.setOnAction(event->{
            System.out.println("Button pressed ");
            Platform.runLater(()->b.setVisible(false));
            DecimalFormat df = new DecimalFormat("0.0");
            long Startzeit = System.currentTimeMillis();
            Endzeit= Startzeit + 60*1000;
            new Thread(()->{
                try{
                    while(Endzeit>=System.currentTimeMillis()){

                        Platform.runLater(()->ZeitLabel.setText(df.format((Endzeit-System.currentTimeMillis())/1000)));
                        Thread.sleep(100);
                    }
                }catch(InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }).start();
            BallonErzeugen();

        });

        innerPane.setPrefSize(600,700);
        innerPane.setLayoutX(50);
        innerPane.setLayoutY(150);

        ZeitLabel = new Label("60.0");
        ZeitLabel.setPrefSize(100,100);
        ZeitLabel.setLayoutY(75);
        ZeitLabel.setLayoutX(450);
        ZeitLabel.setAlignment(Pos.CENTER);

        PunkteLabel = new Label("/"+minPunkte);
        PunkteLabel.setPrefSize(100,100);
        PunkteLabel.setLayoutY(75);
        PunkteLabel.setLayoutX(900);
        PunkteLabel.setAlignment(Pos.CENTER);


        p.getChildren().addAll(innerPane,b,ZeitLabel, PunkteLabel);

        super.start(stage);
    }
    private void BallonErzeugen(){

        int x = (int) (Math.random()*600+100);
        int y = (int) (Math.random()*500+200);


        Ballon b;
        float ballonart = (float)  Math.random()*ballonarten;

        if(ballonart>2){
            b = new BlackBallon(x,y);
        } else if (ballonart>1.85) {
            b = new GoldBallon(x,y);
        }else{
            b = new NormalerBallon(x,y);
        }


        p.getChildren().add(b);
        b.setOnMouseClicked(e->{
                punkte = punkte + (int) b.getPunkte();
                Platform.runLater(()-> PunkteLabel.setText(punkte+"/"+minPunkte));
                Platform.runLater(()->p.getChildren().remove(b));

        });
        new Thread(()->{
            b.grow(faktor);
            PauseTransition pause = new PauseTransition(Duration.seconds(1/faktor));
            pause.setOnFinished(event -> Platform.runLater(()->p.getChildren().remove(b)));
            pause.play();
        }).start();

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {

            if(Endzeit>=System.currentTimeMillis()){
                BallonErzeugen();
            }
            else{
                System.out.println("Zeit vorbei");
                gewinnauswertung();
            }


        });
        pause.play();

    }

    private void gewinnauswertung() {

        minispielrueckgabewert.setAbbruch(false);
        if(punkte>=minPunkte){
            minispielrueckgabewert.setWinner(spieler[0]);
        }else {
            minispielrueckgabewert.setWinner(spieler[1]);
        }


    }

}
