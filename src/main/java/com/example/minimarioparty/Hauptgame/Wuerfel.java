package com.example.minimarioparty.Hauptgame;


import javafx.scene.image.Image;

public abstract class Wuerfel {
    private final String name;
    private final int start;
    private final int end;
    private final Image bild;


    public Wuerfel(String name, int start, int end,String bildString){
        this.name = name;
        this.start= start;
        this.end= end;
        this.bild = new Image(bildString);

    }

    public int wuerfeln(){
        int wurf;
        int differenz;
        differenz= end - start;
        wurf= (int)(Math.random()*differenz+start);
        return wurf;

    }

    public Image getBild() {
        return bild;
    }

    public String getName() {
        return name;
    }
}
