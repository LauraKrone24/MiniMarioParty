package com.example.minimarioparty.BallonPlatzen;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurve;

public class NormalerBallon extends Ballon{
    public NormalerBallon(double x, double y, CubicCurve line){
        super(x,y, Paint.valueOf("#6e44ff"),line);
        worth = 1;

    }

}
