package com.example.minimarioparty.Kniffel;

import javafx.scene.image.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

public class Wuerfelinitialisieren {

    List<Wuerfel> wuerfelListe = new ArrayList<>();

    Image einserWuerfelBild = new Image("einserWuerfel.png");
    Wuerfel einserWuerfel = new Wuerfel(einserWuerfelBild, 1);

    Image zweierWuerfelBild = new Image("zweierWuerfel.png");
    Wuerfel zweierWuerfel = new Wuerfel(zweierWuerfelBild, 2);

    Image dreierWuerfelBild = new Image("dreierWuerfel.png");
    Wuerfel dreierWuerfel = new Wuerfel(dreierWuerfelBild, 3);

    Image viererWuerfelBild = new Image("viererWuerfel.png");
    Wuerfel viererWuerfel = new Wuerfel(viererWuerfelBild, 4);

    Image fuenferWuerfelBild = new Image("fuenferWuerfel.png");
    Wuerfel fuenferWuerfel = new Wuerfel(fuenferWuerfelBild, 5);

    Image sechserWuerfelBild = new Image("sechserWuerfel.png");
    Wuerfel sechserWuerfel = new Wuerfel(sechserWuerfelBild, 6);
    String test = "test";




    public Wuerfelinitialisieren(){
        wuerfelListe.add(einserWuerfel);
        wuerfelListe.add(zweierWuerfel);
        wuerfelListe.add(dreierWuerfel);
        wuerfelListe.add(viererWuerfel);
        wuerfelListe.add(fuenferWuerfel);
        wuerfelListe.add(sechserWuerfel);
    }

    public List<Wuerfel> getWuerfelListe() {
        return wuerfelListe;
    }
}
