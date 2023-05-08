package com.example.minimarioparty;

import java.util.ArrayList;

public class Wuerfel {
    private String name;
    int start;
    int end;

    public Wuerfel(String name, int start, int end){
        this.name = name;
        this.start= start;
        this.end= end;

    }

    public int wuerfeln(){
        int wurf;
        int differenz;
        differenz= end - start;
        wurf= (int)(Math.random()*differenz+start);
        return wurf;

    }

    public String getName() {
        return name;
    }
}
