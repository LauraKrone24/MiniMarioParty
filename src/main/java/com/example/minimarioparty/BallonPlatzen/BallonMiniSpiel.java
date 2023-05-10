package com.example.minimarioparty.BallonPlatzen;

import com.example.minimarioparty.Minispiel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
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
    long Endzeit;
    @Override
    public void start(Stage stage) throws IOException {

        Button b  = new Button("Start Game");
        b.setPrefSize(100,100);
        b.setLayoutX(350);
        b.setLayoutY(400);
        b.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("Button pressed ");
                Platform.runLater(()->b.setVisible(false));
                DecimalFormat df = new DecimalFormat("0.0");
                long Startzeit = System.currentTimeMillis();
                 Endzeit= Startzeit + 60*1000;
                BallonErzeugen();

            }

        });
        innerPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //System.out.println("Maus gedrückt an Position:"+e.getX()+", "+e.getY());

            }
        });

        innerPane.setPrefSize(600,700);
        innerPane.setLayoutX(50);
        innerPane.setLayoutY(150);

        Zeitlable = new Label();

        p.getChildren().addAll(innerPane,b);

        super.start(stage);
    }
    private void BallonErzeugen(){

        int x = (int) (Math.random()*600+100);
        int y = (int) (Math.random()*500+200);
        System.out.println(x);

        Ballon b = new GoldBallon(x,y);
        b.setStroke(Color.BLACK);
        p.getChildren().add(b);
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Kreis gedrückt gedrückt an Position:"+e.getX()+", "+e.getY());
                Platform.runLater(()->p.getChildren().remove(b));

            }
        });
        new Thread(){
            public void run(){
                b.grow();
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
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
            }


        });
        pause.play();

    }

}
