package com.example.minimarioparty.BlackJack;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Karteninitialisieren {

    List<Spielkarten> kartenListe = new ArrayList<>();

    Image zweiKreuzBild = new Image("zweiKreuz.png");
    Spielkarten zweiKreuz = new Spielkarten(zweiKreuzBild, 2);

    Image dreiKreuzBild = new Image("dreiKreuz.png");
    Spielkarten dreiKreuz = new Spielkarten(dreiKreuzBild, 3);

    Image vierKreuzBild = new Image("vierKreuz.png");
    Spielkarten vierKreuz = new Spielkarten(vierKreuzBild, 4);

    Image fünfKreuzBild = new Image("fünfKreuz.png");
    Spielkarten fünfKreuz = new Spielkarten(fünfKreuzBild, 5);

    Image sechsKreuzBild = new Image("sechsKreuz.png");
    Spielkarten sechsKreuz = new Spielkarten(sechsKreuzBild, 6);
    Image siebenKreuzBild = new Image("siebenKreuz.png");
    Spielkarten siebenKreuz = new Spielkarten(siebenKreuzBild, 7);
    Image achtKreuzBild = new Image("achtKreuz.png");
    Spielkarten achtKreuz  = new Spielkarten(achtKreuzBild, 8);
    Image neunKreuzBild = new Image("neunKreuz.png");
    Spielkarten neunKreuz = new Spielkarten(neunKreuzBild, 9);
    Image zehnKreuzBild = new Image("zehnKreuz.png");
    Spielkarten zehnKreuz = new Spielkarten(zehnKreuzBild, 9);
    Image bubeKreuzBild = new Image("bubeKreuz.png");
    Spielkarten bubeKreuz = new Spielkarten(bubeKreuzBild, 10);
    Image dameKreuzBild = new Image("dameKreuz.png");
    Spielkarten dameKreuz = new Spielkarten(dameKreuzBild, 10);
    Image königKreuzBild = new Image("königKreuz.png");
    Spielkarten königKreuz = new Spielkarten(königKreuzBild, 10);

    public  Karteninitialisieren(){
        kartenListe.add(zweiKreuz);
        kartenListe.add(dreiKreuz);
        kartenListe.add(vierKreuz);
        kartenListe.add(fünfKreuz);
        kartenListe.add(sechsKreuz);
        kartenListe.add(siebenKreuz);
        kartenListe.add(achtKreuz);
        kartenListe.add(neunKreuz);
        kartenListe.add(zehnKreuz);
        kartenListe.add(bubeKreuz);
        kartenListe.add(dameKreuz);
        kartenListe.add(königKreuz);


    }

    public  List<Spielkarten> getKartenListe(){
        return kartenListe;
    }

}
