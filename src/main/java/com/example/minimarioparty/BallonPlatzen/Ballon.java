package com.example.minimarioparty.BallonPlatzen;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;

public abstract class Ballon extends Ellipse {
     int worth;

     CubicCurve line;

    public void setOnPane(boolean onPane) {
        this.onPane = onPane;
    }

    private boolean onPane = true;

    public  Ballon(double x, double y, Paint c,CubicCurve line){

        super(x,y,4,5);
        this.line = line;
        setFill(c);

        setStroke(Color.BLACK);
    }

    public void grow(int faktor){
        for (int i  = 5; i<50/faktor;i=i+2){
            final int finali = i;

            Platform.runLater(()->{
                setRadiusX((double)finali*4/5);
                setRadiusY(finali);
                moveline();
            });

            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
    public void moveline(){
        line.setStartX(getCenterX());
        line.setStartY(getCenterY()+getRadiusY());
        line.setControlX1(getCenterX()-5);
        line.setControlY1(getCenterY()+getRadiusY()+7);
        line.setControlX2(getCenterX()+5);
        line.setControlY2(getCenterY()+getRadiusY()+10);
        line.setEndX(getCenterX());
        line.setEndY(getCenterY()+getRadiusY()+20);
    }

    public void move () {
        final int direktionX = (int) (Math.random()*3)-1;
        final int direktionY = (int) (Math.random()*3)-1;

        while (onPane){

            final int finalx = (int) (Math.random()*10*direktionX);
            final int finaly = (int) (Math.random()*10*direktionY);
            Platform.runLater(() -> {
                if(getCenterX()+finalx<=850 && getCenterX()+finalx>=50){
                    setCenterX(getCenterX()+finalx);
                }
                if(getCenterY()+finaly<=550 && getCenterY()+finaly>=50){
                    setCenterY(getCenterY()+finaly);
                }
                moveline();

            });

            try {Thread.sleep(150);} catch (InterruptedException ex) {throw new RuntimeException(ex);}

        }
    }

    public double getPunkte(){
        return worth*(105-getRadiusX());
    }

}
