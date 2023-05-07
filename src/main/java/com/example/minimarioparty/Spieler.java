package com.example.minimarioparty;

import java.util.List;

public class Spieler {
    private String name;
    private boolean computer;
    private List<Wuerfel> wuerfelList;
    //hier Grafik einfügen

    public Spieler(String name, boolean computer){
        this.name = name;
        this.computer = computer;

    }


    public String getName() {
        return name;
    }

    public int wuerfeln(){
        int ergebnis = 0;

        return ergebnis;
    }

    public void bewegeSpieler(){


    }

}
