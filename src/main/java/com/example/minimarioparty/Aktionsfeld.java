package com.example.minimarioparty;

import java.util.List;

public class Aktionsfeld extends Feld{
    private List<Minispiel>  minispielListe = new List<Minispiel>();
    public Aktionsfeld(int number, int x, int y) {
        super(number, x, y);
        // hier muss auch noch die Minispielliste initialisert werden
    }



    public int getMinispielnummer(){
        int x = (int) Math.random()*minispielListe.size();
        return x;
    }

    public void  starteMinispiel(){
        int minispielnummer = getMinispielnummer();
        //hier minispiel Start einfügen
    };
}
