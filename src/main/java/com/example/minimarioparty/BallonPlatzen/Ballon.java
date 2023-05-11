package com.example.minimarioparty.BallonPlatzen;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public abstract class Ballon extends Circle {
    int worth;

    public  Ballon(double x, double y, Paint c){
        super(x,y,5,c);
        setStroke(Color.BLACK);
    }

    public void grow(int faktor){
        for (int i  = 5; i<50/faktor;i=i+2){
            final int finali = i;
            Platform.runLater(()->setRadius(finali));

            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    public double getPunkte(){
        double punkte = worth*(105-getRadius());
        return punkte;
    }

}
