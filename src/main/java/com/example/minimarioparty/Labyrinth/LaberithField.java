package com.example.minimarioparty.Labyrinth;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;

public class LaberithField extends Rectangle {
    private int selectValue;
    private boolean markiert =  false;

    private LaberithField top;
    private LaberithField bottom;
    private LaberithField left;

    private LaberithField right;
    private HashSet<LaberithField> nachbarn = new HashSet<>();
    public LaberithField(int selectvalue,double x,  double y){
        super(30,30);
        setStroke(Paint.valueOf("#ffffff"));
        this.selectValue = selectvalue;
        setColor();
        setLayoutX(x);
        setLayoutY(y);
    }

    private void setColor(){
        switch (selectValue) {
            case 1 -> setFill(Paint.valueOf("#000000"));// Feld = Mauer
            case 2 -> setFill(Paint.valueOf("#006600"));// Feld = Startfeld
            case 3 -> setFill(Paint.valueOf("#660000"));// Feld = Ziel
            case 4 -> setFill(Paint.valueOf("#000066"));// Feld = Aktuelles Feld
            default -> setFill(Paint.valueOf("#ffffff"));// Feld = leeres Feld
        }
    }
    public void changeSelectvalue(int s){
        this.selectValue = s;
        setColor();
    }

    public LaberithField getTop() {
        return top;
    }

    public void setTop(LaberithField top) {
        this.top = top;
        if(top!=null){
            nachbarn.add(top);
            top.setBottom(this);
        }

    }

    public LaberithField getBottom() {
        return bottom;
    }

    public void setBottom(LaberithField bottom) {
        this.bottom = bottom;
        nachbarn.add(bottom);
    }

    public LaberithField getLeft() {
        return left;
    }

    public void setLeft(LaberithField left) {
        this.left = left;
        if(left!=null){
            nachbarn.add(left);
            left.setBottom(this);
        }
    }

    public LaberithField getRight() {
        return right;
    }

    public void setRight(LaberithField right) {
        this.right = right;
        nachbarn.add(right);
    }

    public HashSet<LaberithField> getNachbarn() {
        return nachbarn;
    }


    public boolean isMarkiert() {
        return markiert;
    }

    public void setMarkiert(boolean markiert) {
        this.markiert = markiert;
    }
}
