package com.example.minimarioparty.Labyrinth;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LabyrinthField extends Rectangle {
    private int selectValue;

    private static int number = 0;
    private boolean markiert =  false;

    private LabyrinthField top;
    private LabyrinthField bottom;
    private LabyrinthField left;
    private int num;

    private LabyrinthField right;
    private final HashSet<LabyrinthField> nachbarn = new HashSet<>();
    private List<LabyrinthField> suchPfad = new ArrayList<>();
    public LabyrinthField(int selectvalue, double x, double y){
        super(30,30);
        number++;
        setStroke(Paint.valueOf("#ffffff"));
        this.selectValue = selectvalue;
        setColor();
        setLayoutX(x);
        setLayoutY(y);
        this.num = number;
    }
    public List<LabyrinthField> getSuchPfad(){
        return suchPfad;
    }

    public void setSuchPfad(List<LabyrinthField> suchPfad) {
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

    public LabyrinthField getTop() {
        return top;
    }

    public void setTop(LabyrinthField top) {
        this.top = top;
        if(top!=null){
            nachbarn.add(top);
            top.setBottom(this);
        }

    }

    public LabyrinthField getBottom() {
        return bottom;
    }

    public void setBottom(LabyrinthField bottom) {
        this.bottom = bottom;
        nachbarn.add(bottom);
    }

    public int getSelectValue() {
        return selectValue;
    }

    public LabyrinthField getLeft() {
        return left;
    }

    public void setLeft(LabyrinthField left) {
        this.left = left;
        if(left!=null){
            nachbarn.add(left);
            left.setRight(this);
        }
    }

    public LabyrinthField getRight() {
        return right;
    }

    public void setRight(LabyrinthField right) {
        this.right = right;
        nachbarn.add(right);
    }

    public HashSet<LabyrinthField> getNachbarn() {
        return nachbarn;
    }


    public boolean isMarkiert() {
        return markiert;
    }

    public void setMarkiert(boolean markiert) {
        this.markiert = markiert;
    }

    public int getNum() {return num;}
}
