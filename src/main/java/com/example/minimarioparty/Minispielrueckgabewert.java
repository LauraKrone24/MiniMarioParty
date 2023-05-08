package com.example.minimarioparty;

public class Minispielrueckgabewert {
    private Spieler winner;
    private Wuerfel wuerfel;
    private Boolean abbruch ;

    public Minispielrueckgabewert(Boolean abbruch, Spieler winner,Wuerfel wuerfel){
        this.abbruch = abbruch;
        this.winner =  winner;
        this.wuerfel  = wuerfel;
    }

    @Override
    public String toString() {
        if(winner!= null && wuerfel!= null){
            return winner.getName()+" hat gewonnen und bekommt einen "+wuerfel.getName();
        }
        return "Spiel vorzeitig abgebrochen";


    }
}
