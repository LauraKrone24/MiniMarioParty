package com.example.minimarioparty;

import com.example.minimarioparty.Hauptgame.Spieler;
import com.example.minimarioparty.Hauptgame.Wuerfel;

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
        if(!abbruch){
            return winner.getName()+" hat gewonnen und bekommt einen "+wuerfel.getName();
        }
        return "Spiel vorzeitig abgebrochen";


    }

    public void setWinner(Spieler winner) {
        this.winner = winner;
    }

    public void setWuerfel(Wuerfel wuerfel) {
        this.wuerfel = wuerfel;
    }

    public void setAbbruch(Boolean abbruch) {
        this.abbruch = abbruch;
    }

    public Spieler getWinner() {
        return winner;
    }

    public Wuerfel getWuerfel() {
        return wuerfel;
    }

    public Boolean getAbbruch() {
        return abbruch;
    }
}
