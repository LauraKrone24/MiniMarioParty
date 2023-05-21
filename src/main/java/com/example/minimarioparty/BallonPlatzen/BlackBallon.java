package com.example.minimarioparty.BallonPlatzen;

import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurve;

public class BlackBallon extends Ballon {
    public BlackBallon(double x, double y, CubicCurve line){
        super(x,y, Paint.valueOf("#000000"),line);
        worth = -5;

    }
}
