package com.example.minimarioparty.Huerdenlauf;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerObj extends Pane {
    boolean isJumping = false;
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
    public void jump() {
        if (!isJumping) {
            isJumping = true;

            new Thread(() -> {
                for (int i = 0; i < 30; i++) {
                    Platform.runLater(() -> moveUp(6));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 30; i++) {
                    Platform.runLater(() -> moveDown(6));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                isJumping = false;
            }).start();
        }
    }


    public double getX() {
        return rectangle.getX();
    }

    public double getY() {return  rectangle.getY(); }
    public javafx.scene.shape.Rectangle getRectangle() {
        return rectangle;
    }
}
