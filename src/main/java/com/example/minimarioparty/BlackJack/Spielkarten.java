package com.example.minimarioparty.BlackJack;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Spielkarten {

    private Image  bild;
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





}
