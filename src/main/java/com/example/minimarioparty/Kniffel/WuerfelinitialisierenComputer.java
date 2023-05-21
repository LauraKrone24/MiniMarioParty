package com.example.minimarioparty.Kniffel;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class WuerfelinitialisierenComputer {

    List<Wuerfel> wuerfelListeComputer = new ArrayList<>();

    Image einserWuerfelBild = new Image("WuerfelComputer1.png");
    Wuerfel einserWuerfel = new Wuerfel(einserWuerfelBild, 1);

    Image zweierWuerfelBild = new Image("WuerfelComputer2.png");
    Wuerfel zweierWuerfel = new Wuerfel(zweierWuerfelBild, 2);

    Image dreierWuerfelBild = new Image("WuerfelComputer3.png");
    Wuerfel dreierWuerfel = new Wuerfel(dreierWuerfelBild, 3);

    Image viererWuerfelBild = new Image("WuerfelComputer4.png");
    Wuerfel viererWuerfel = new Wuerfel(viererWuerfelBild, 4);

    Image fuenferWuerfelBild = new Image("WuerfelComputer5.png");
    Wuerfel fuenferWuerfel = new Wuerfel(fuenferWuerfelBild, 5);

    Image sechserWuerfelBild = new Image("WuerfelComputer6.png");
    Wuerfel sechserWuerfel = new Wuerfel(sechserWuerfelBild, 6);



    public WuerfelinitialisierenComputer(){
        wuerfelListeComputer.add(einserWuerfel);
        wuerfelListeComputer.add(zweierWuerfel);
        wuerfelListeComputer.add(dreierWuerfel);
        wuerfelListeComputer.add(viererWuerfel);
        wuerfelListeComputer.add(fuenferWuerfel);
        wuerfelListeComputer.add(sechserWuerfel);
    }

    public List<Wuerfel> getWuerfelListeComputer() {
        return wuerfelListeComputer;
    }

}
