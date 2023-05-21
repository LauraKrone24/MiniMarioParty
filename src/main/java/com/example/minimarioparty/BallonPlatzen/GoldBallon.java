package com.example.minimarioparty.BallonPlatzen;

import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurve;

public class GoldBallon extends Ballon{
    public GoldBallon(double x, double y, CubicCurve line){
        super(x,y, Paint.valueOf("#d4af37"),line,10);


    }

}
