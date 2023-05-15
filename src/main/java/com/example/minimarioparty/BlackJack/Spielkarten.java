package com.example.minimarioparty.BlackJack;

import javafx.scene.image.Image;

public class Spielkarten {

    private Image bild;
    private int wert;

    public Spielkarten(Image bild, int wert){
        this.bild = bild;
        this.wert = wert;
    }

    public Image getBild(){
        return bild;
    }

    public int getWert(){
        return wert;
    }



    Image zweiKreuzBild = new Image("zweiKreuz.png");
    Spielkarten zweiKreuz = new Spielkarten(zweiKreuzBild, 2);
    Image dreiKreuzBild = new Image("dreiKreuz.png");
    Spielkarten dreiKreuz = new Spielkarten(dreiKreuzBild, 2);
}
