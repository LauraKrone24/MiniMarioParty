package com.example.minimarioparty.Kniffel;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Wuerfelinitialisieren {

    List<Wuerfel> wuerfelListe = new ArrayList<>();

    Image einserWuerfelBild = new Image("Wuerfel1.png");
    Wuerfel einserWuerfel = new Wuerfel(einserWuerfelBild, 1);

    Image zweierWuerfelBild = new Image("Wuerfel2.png");
    Wuerfel zweierWuerfel = new Wuerfel(zweierWuerfelBild, 2);

    Image dreierWuerfelBild = new Image("Wuerfel3.png");
    Wuerfel dreierWuerfel = new Wuerfel(dreierWuerfelBild, 3);

    Image viererWuerfelBild = new Image("Wuerfel4.png");
    Wuerfel viererWuerfel = new Wuerfel(viererWuerfelBild, 4);

    Image fuenferWuerfelBild = new Image("Wuerfel5.png");
    Wuerfel fuenferWuerfel = new Wuerfel(fuenferWuerfelBild, 5);

    Image sechserWuerfelBild = new Image("Wuerfel6.png");
    Wuerfel sechserWuerfel = new Wuerfel(sechserWuerfelBild, 6);



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
