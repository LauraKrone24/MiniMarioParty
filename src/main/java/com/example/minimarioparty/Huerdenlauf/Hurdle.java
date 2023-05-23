package com.example.minimarioparty.Huerdenlauf;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hurdle extends Pane {
    private Rectangle rectangle;

    public Hurdle(double x, double y, double width, double height) {
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.BLACK);
        getChildren().add(rectangle);
    }

    public void move(int speed) {
        rectangle.setX(rectangle.getX() - speed);
        /*rectangle.setWidth(rectangle.getWidth());
        rectangle.setHeight(rectangle.getHeight());*/
    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }
}
