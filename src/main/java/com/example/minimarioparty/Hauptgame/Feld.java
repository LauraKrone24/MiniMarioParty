package com.example.minimarioparty.Hauptgame;

public class Feld {
    private final int number;
    private final int x;
    private final int y;
    public Feld(int number,int x, int y ){
        this.number = number;
        this.y = y;
        this.x = x;
    }

    public int getNumber() {
        return number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}