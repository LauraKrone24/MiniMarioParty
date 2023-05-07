package com.example.minimarioparty;

public class Minispielrückgabewert {
    private Spieler winner;
    private Wuerfel wuerfel;

    private boolean beendet;
    public Minispielrückgabewert(Spieler winner,Wuerfel wuerfel ){
        this.winner =  winner;
        this.wuerfel = wuerfel;
    }

    public Spieler getWinner() {
        return winner;
    }


    public Wuerfel getWuerfel() {
        return wuerfel;
    }
}
