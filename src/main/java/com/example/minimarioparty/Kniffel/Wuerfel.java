package com.example.minimarioparty.Kniffel;

import javafx.scene.image.Image;
public class Wuerfel {
    private Image bild;
    private int value;

    public Wuerfel(Image bild, int value){
        this.bild = bild;
        this.value = value;
    }

    public Image getBild(){
        return bild;
    }
    public int getValue(){
        return value;
    }
}
