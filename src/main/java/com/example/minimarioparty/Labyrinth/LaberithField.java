package com.example.minimarioparty.Labyrinth;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LaberithField extends Rectangle {
    private int selectValue;

    private static int number = 0;
    private boolean markiert =  false;

    private LaberithField top;
    private LaberithField bottom;
    private LaberithField left;
    public int num;

    private LaberithField right;
    private final HashSet<LaberithField> nachbarn = new HashSet<>();
    private List<LaberithField> suchPfad = new ArrayList<>();
    public LaberithField(int selectvalue,double x,  double y){
        super(30,30);
        number++;
        setStroke(Paint.valueOf("#ffffff"));
        this.selectValue = selectvalue;
        setColor();
        setLayoutX(x);
        setLayoutY(y);
        this.num = number;
    }
    public List<LaberithField> getSuchPfad(){
        return suchPfad;
    }

    public void setSuchPfad(List<LaberithField> suchPfad) {
        this.suchPfad = suchPfad;
    }

    private void setColor(){
        switch (selectValue) {
            case 1 -> {
                setFill(Paint.valueOf("#000000"));
                setMarkiert(true);
            }// Feld = Mauer
            case 2 ->  {
                setFill(Paint.valueOf("#006600"));
                setMarkiert(false);
            }// Feld = Aktuelles Feld
            case 3 ->  {
                setFill(Paint.valueOf("#660000"));
                setMarkiert(false);
            }// Feld = Ziel

            default -> {
                setFill(Paint.valueOf("#ffffff"));
                setMarkiert(false);// Feld = leeres Feld
            }
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

    public int getSelectValue() {
        return selectValue;
    }

    public LaberithField getLeft() {
        return left;
    }

    public void setLeft(LaberithField left) {
        this.left = left;
        if(left!=null){
            nachbarn.add(left);
            left.setRight(this);
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
