package com.example.minimarioparty.Huerdenlauf;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerObj extends Pane {
    private Rectangle rectangle;

    public PlayerObj(double x, double y, double width, double height, Color color) {
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(color);
        getChildren().add(rectangle);
    }

    public void moveUp(double y) {
        rectangle.setY(rectangle.getY() - y);
    }
    public void moveDown(double y) {
        rectangle.setY(rectangle.getY() + y);
    }
    public javafx.scene.shape.Rectangle getRectangle() {
        return rectangle;
    }
}
