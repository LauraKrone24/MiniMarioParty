package com.example.minimarioparty.BallonPlatzen;

import com.example.minimarioparty.Minispiel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;

public class BallonMiniSpiel extends Minispiel {
    private Pane innerPane = new Pane();

    private Label Zeitlable;

    private int  punkte =0;

    private Label Punktelable;
    long Endzeit;

    int ballonarten ;
    int faktor;
    @Override
    public void start(Stage stage) throws IOException {
        if(leicht == true){
            ballonarten = 2;
            faktor =1;
        }else{
            ballonarten = 3;
            faktor = 2;
        }

        Button b  = new Button("Start Game");
        b.setPrefSize(100,100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        b.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("Button pressed ");
                Platform.runLater(()->b.setVisible(false));
                DecimalFormat df = new DecimalFormat("0.0");
                long Startzeit = System.currentTimeMillis();
                Endzeit= Startzeit + 60*1000;
                new Thread(()->{
                    try{
                        while(Endzeit>=System.currentTimeMillis()){

                            Platform.runLater(()->Zeitlable.setText(df.format((Endzeit-System.currentTimeMillis())/1000)));
                            Thread.sleep(100);
                        }
                    }catch(InterruptedException e){}
                }).start();
                BallonErzeugen();

            }

        });

        innerPane.setPrefSize(600,700);
        innerPane.setLayoutX(50);
        innerPane.setLayoutY(150);

        Zeitlable = new Label("60.0");
        Zeitlable.setPrefSize(100,100);
        Zeitlable.setLayoutY(75);
        Zeitlable.setLayoutX(450);
        Zeitlable.setAlignment(Pos.CENTER);

        Punktelable = new Label("/3000");
        Punktelable.setPrefSize(100,100);
        Punktelable.setLayoutY(75);
        Punktelable.setLayoutX(900);
        Punktelable.setAlignment(Pos.CENTER);


        p.getChildren().addAll(innerPane,b,Zeitlable,Punktelable);

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
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                punkte = punkte + (int) b.getPunkte();
                Platform.runLater(()->Punktelable.setText(punkte+"/5000"));
                Platform.runLater(()->p.getChildren().remove(b));

            }
        });
        new Thread(){
            public void run(){
                b.grow(faktor);
                PauseTransition pause = new PauseTransition(Duration.seconds(1/faktor));
                pause.setOnFinished(event -> {
                    Platform.runLater(()->p.getChildren().remove(b));
                });
                pause.play();

            }

        }.start();

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

    }

}
