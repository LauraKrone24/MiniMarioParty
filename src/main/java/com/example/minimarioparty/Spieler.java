package com.example.minimarioparty;

import java.util.ArrayList;
import java.util.List;

public class Spieler {

    private final String name;
    private final boolean computer;

    private final String farbe;
    private final List<Wuerfel> wuerfelList =  new ArrayList<>();
    private Feld position;
    //hier Grafik einfügen

    public Spieler(String name, boolean computer,String  farbe){
        this.name = name;
        this.computer = computer;
        this.farbe = farbe;
        this.position = new Feld(1,25,700);//Hauptgame.felder.get(0)
        wuerfelList.add(new Normalerwuerfel());

    }



    // getter Methoden
    public String getName() {
        return name;
    }
    public String getFarbe() {return farbe;}

    public List<Wuerfel> getWuerfelList() { return wuerfelList;}
    public Feld getPosition() {
        return position;
    }

    public void fuegeWuerfelhinzu(Wuerfel wuerfel){
        wuerfelList.add(wuerfel);

    }

    public boolean isComputer() {
        return computer;
    }

    //Methoden
    public int wuerfeln(){
        int ergebnis = 0;
        for (Wuerfel w : wuerfelList){
            ergebnis = ergebnis + w.wuerfeln();
        }
        if (wuerfelList.size()==2){
            wuerfelList.remove(1);
        }

        return ergebnis;
    }

    public int bewegeSpieler(){
        int wuerfeln  = wuerfeln();
        int ergebnis = this.position.getNumber() + wuerfeln;
        if (ergebnis<99){
            this.position= Hauptgame.felder[ergebnis-1];
            System.out.println(name+ " Bewegt zu "+ergebnis);

        }else {
            this.position = Hauptgame.felder[99];
            System.out.println("Du hast gewonnen");
        }

        return wuerfeln;
    }



}
