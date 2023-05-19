package com.example.minimarioparty.steeplechase;
import java.awt.*;


public class PlayerObj {
    private int x;
    private int y;
    private int width;
    private int height;

    public PlayerObj(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void moveUp(int x) {
        y -= x;
    }

    public void moveDown(int x) {
        y += x;
    }
}
