package com.example.minimarioparty.BallonPlatzen;

import javafx.scene.paint.Paint;

public class BlackBallon extends Ballon {
    public BlackBallon(double x, double y){
        super(x,y, Paint.valueOf("#000000"));
        worth = -5;

    }
}
