package com.example.minimarioparty;

import java.util.ArrayList;

public abstract class Wuerfel {
    private String name;
    int start;
    int end;
    String color;

    public Wuerfel(String name, int start, int end,String color){
        this.name = name;
        this.start= start;
        this.end= end;
        this.color = color;

    }

    public int wuerfeln(){
        int wurf;
        int differenz;
        differenz= end - start;
        wurf= (int)(Math.random()*differenz+start);
        return wurf;

    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
