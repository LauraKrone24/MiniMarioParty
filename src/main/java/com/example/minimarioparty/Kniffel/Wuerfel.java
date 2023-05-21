package com.example.minimarioparty.Kniffel;

import javafx.scene.image.Image;
public class Wuerfel {
    private Image bild;


    public Wuerfel(Image bild, int value){
        this.bild = bild;
    }

    public Image getBild(){
        return bild;
    }


}
