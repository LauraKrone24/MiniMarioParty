package com.example.minimarioparty.BlackJack;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Karteninitialisieren {

    List<Spielkarten> kartenListe = new ArrayList<>();


    //Karten Kreuz
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
    Spielkarten zehnKreuz = new Spielkarten(zehnKreuzBild, 10);
    Image bubeKreuzBild = new Image("bubeKreuz.png");
    Spielkarten bubeKreuz = new Spielkarten(bubeKreuzBild, 10);
    Image dameKreuzBild = new Image("dameKreuz.png");
    Spielkarten dameKreuz = new Spielkarten(dameKreuzBild, 10);
    Image königKreuzBild = new Image("königKreuz.png");
    Spielkarten königKreuz = new Spielkarten(königKreuzBild, 10);



    //Karten Karo
    Image zweiKaroBild = new Image("zweiKaro.png");
    Spielkarten zweiKaro = new Spielkarten(zweiKaroBild, 2);

    Image dreiKaroBild = new Image("dreiKaro.png");
    Spielkarten dreiKaro = new Spielkarten(dreiKaroBild, 3);

    Image vierKarozBild = new Image("vierKaro.png");
    Spielkarten vierKaro = new Spielkarten(vierKarozBild, 4);

    Image fünfKaroBild = new Image("fünfKaro.png");
    Spielkarten fünfKaro = new Spielkarten(fünfKaroBild, 5);

    Image sechsKaroBild = new Image("sechsKaro.png");
    Spielkarten sechsKaro = new Spielkarten(sechsKaroBild, 6);
    Image siebenKaroBild = new Image("siebenKaro.png");
    Spielkarten siebenKaro = new Spielkarten(siebenKaroBild, 7);
    Image achtKaroBild = new Image("achtKaro.png");
    Spielkarten achtKaro  = new Spielkarten(achtKaroBild, 8);
    Image neunKaroBild = new Image("neunKaro.png");
    Spielkarten neunKaro = new Spielkarten(neunKaroBild, 9);
    Image zehnKaroBild = new Image("zehnKaro.png");
    Spielkarten zehnKaro= new Spielkarten(zehnKaroBild, 10);
    Image bubeKaroBild = new Image("bubeKaro.png");
    Spielkarten bubeKaro = new Spielkarten(bubeKaroBild, 10);
    Image dameKaroBild = new Image("dameKaro.png");
    Spielkarten dameKaro = new Spielkarten(dameKaroBild, 10);
    Image königKaroBild = new Image("königKaro.png");
    Spielkarten königKaro = new Spielkarten(königKaroBild, 10);

    //Karten Herz
    Image zweiHerzBild = new Image("zweiHerz.png");
    Spielkarten zweiHerz = new Spielkarten(zweiHerzBild, 2);

    Image dreiHerzBild = new Image("dreiHerz.png");
    Spielkarten dreiHerz = new Spielkarten(dreiHerzBild, 3);

    Image vierHerzBild = new Image("vierHerz.png");
    Spielkarten vierHerz = new Spielkarten(vierHerzBild, 4);

    Image fünfHerzBild = new Image("fünfHerz.png");
    Spielkarten fünfHerz = new Spielkarten(fünfHerzBild, 5);

    Image sechsHerzBild = new Image("sechsHerz.png");
    Spielkarten sechsHerz = new Spielkarten(sechsHerzBild, 6);
    Image siebenHerzBild = new Image("siebenHerz.png");
    Spielkarten siebenHerz = new Spielkarten(siebenHerzBild, 7);
    Image achtHerzBild = new Image("achtHerz.png");
    Spielkarten achtHerz  = new Spielkarten(achtHerzBild, 8);
    Image neunHerzBild = new Image("neunHerz.png");
    Spielkarten neunHerz = new Spielkarten(neunHerzBild, 9);
    Image zehnHerzBild = new Image("zehnHerz.png");
    Spielkarten zehnHerz = new Spielkarten(zehnHerzBild, 10);
    Image bubeHerzBild = new Image("bubeHerz.png");
    Spielkarten bubeHerz = new Spielkarten(bubeHerzBild, 10);
    Image dameHerzBild = new Image("dameHerz.png");
    Spielkarten dameHerz = new Spielkarten(dameHerzBild, 10);
    Image königHerzBild = new Image("königHerz.png");
    Spielkarten königHerz = new Spielkarten(königHerzBild, 10);


    //Karten Pig
    Image zweiPigBild = new Image("zweiPig.png");
    Spielkarten zweiPig = new Spielkarten(zweiPigBild, 2);

    Image dreiPigBild = new Image("dreiPig.png");
    Spielkarten dreiPig = new Spielkarten(dreiPigBild, 3);

    Image vierPigBild = new Image("vierPig.png");
    Spielkarten vierPig = new Spielkarten(vierPigBild, 4);

    Image fünfPigBild = new Image("fünfPig.png");
    Spielkarten fünfPig = new Spielkarten(fünfPigBild, 5);

    Image sechsPigBild = new Image("sechsPig.png");
    Spielkarten sechsPig = new Spielkarten(sechsPigBild, 6);
    Image siebenPigBild = new Image("siebenPig.png");
    Spielkarten siebenPig = new Spielkarten(siebenPigBild, 7);
    Image achtPigBild = new Image("achtPig.png");
    Spielkarten achtPig  = new Spielkarten(achtPigBild, 8);
    Image neunPigBild = new Image("neunPig.png");
    Spielkarten neunPig = new Spielkarten(neunPigBild, 9);
    Image zehnPigBild = new Image("zehnPig.png");
    Spielkarten zehnPig = new Spielkarten(zehnPigBild, 10);
    Image bubePigBild = new Image("bubePig.png");
    Spielkarten bubePig = new Spielkarten(bubePigBild, 10);
    Image damePigBild = new Image("damePig.png");
    Spielkarten damePig = new Spielkarten(damePigBild, 10);
    Image königPigBild = new Image("königPig.png");
    Spielkarten königPig = new Spielkarten(königPigBild, 10);



    public  Karteninitialisieren(){
        //Kreuz
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
        //Karo
        kartenListe.add(zweiKaro);
        kartenListe.add(dreiKaro);
        kartenListe.add(vierKaro);
        kartenListe.add(fünfKaro);
        kartenListe.add(sechsKaro);
        kartenListe.add(siebenKaro);
        kartenListe.add(achtKaro);
        kartenListe.add(neunKaro);
        kartenListe.add(zehnKaro);
        kartenListe.add(bubeKaro);
        kartenListe.add(dameKaro);
        kartenListe.add(königKaro);
        //Herz
        kartenListe.add(zweiHerz);
        kartenListe.add(dreiHerz);
        kartenListe.add(vierHerz);
        kartenListe.add(fünfHerz);
        kartenListe.add(sechsHerz);
        kartenListe.add(siebenHerz);
        kartenListe.add(achtHerz);
        kartenListe.add(neunHerz);
        kartenListe.add(zehnHerz);
        kartenListe.add(bubeHerz);
        kartenListe.add(dameHerz);
        kartenListe.add(königHerz);
        //Pig
        kartenListe.add(zweiPig);
        kartenListe.add(dreiPig);
        kartenListe.add(vierPig);
        kartenListe.add(fünfPig);
        kartenListe.add(sechsPig);
        kartenListe.add(siebenPig);
        kartenListe.add(achtPig);
        kartenListe.add(neunPig);
        kartenListe.add(zehnPig);
        kartenListe.add(bubePig);
        kartenListe.add(damePig);
        kartenListe.add(königPig);
        //Kreuz
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
        //Karo
        kartenListe.add(zweiKaro);
        kartenListe.add(dreiKaro);
        kartenListe.add(vierKaro);
        kartenListe.add(fünfKaro);
        kartenListe.add(sechsKaro);
        kartenListe.add(siebenKaro);
        kartenListe.add(achtKaro);
        kartenListe.add(neunKaro);
        kartenListe.add(zehnKaro);
        kartenListe.add(bubeKaro);
        kartenListe.add(dameKaro);
        kartenListe.add(königKaro);
        //Herz
        kartenListe.add(zweiHerz);
        kartenListe.add(dreiHerz);
        kartenListe.add(vierHerz);
        kartenListe.add(fünfHerz);
        kartenListe.add(sechsHerz);
        kartenListe.add(siebenHerz);
        kartenListe.add(achtHerz);
        kartenListe.add(neunHerz);
        kartenListe.add(zehnHerz);
        kartenListe.add(bubeHerz);
        kartenListe.add(dameHerz);
        kartenListe.add(königHerz);
        //Pig
        kartenListe.add(zweiPig);
        kartenListe.add(dreiPig);
        kartenListe.add(vierPig);
        kartenListe.add(fünfPig);
        kartenListe.add(sechsPig);
        kartenListe.add(siebenPig);
        kartenListe.add(achtPig);
        kartenListe.add(neunPig);
        kartenListe.add(zehnPig);
        kartenListe.add(bubePig);
        kartenListe.add(damePig);
        kartenListe.add(königPig);



    }

    public  List<Spielkarten> getKartenListe(){
        return kartenListe;
    }

}
