package com.example.minimarioparty.Kniffel;

import javafx.scene.image.Image;
public class Wuerfel {
    private Image bild;
    private int value;
    private boolean behalten;
    private int spieler;

    public Wuerfel(Image bild, int value){
        this.bild = bild;
        this.value = value;
        this.behalten = false;
    }

    public Image getBild(){
        return bild;
    }
    public int getValue(){
        return value;
    }

    public boolean isBehalten(){
        return behalten;
    }

    public void setBehalten(boolean behalten){
        this.behalten = behalten;
    }

    public int getSpieler(){
        return spieler;
    }

    public void rollen(){
        if (!behalten){
            value = (int)(Math.random()*6)+1;
            String bildOrt = "Wuerfel" + value + ".png";
            bild = new Image(bildOrt);
        }
    }
}
