package com.example.minimarioparty.steeplechase;

import java.awt.*;

public class Hurdle {
    private int x;
    private int y;
    private int width;
    private int height;

    private int speed = 30; ///// je nach schwierigkeits grad?

    public Hurdle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setWidth(int width){
        this.width = width;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void move() {
        x -= speed;
    }
}
