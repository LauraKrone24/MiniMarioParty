package com.example.minimarioparty;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class TestMiniSpiel extends Minispiel{
    // Dies ist eine Beispiel Testklasse


    @Override
    public void start(Stage stage) throws IOException{

        Rectangle testRect = new Rectangle(10,10);
        testRect.setLayoutY(10);
        testRect.setLayoutY(10);

        Button winButton = new Button("Pretend win");
        winButton.setLayoutX(100);
        winButton.setLayoutY(100);
        winButton.setPrefHeight(200);
        winButton.setPrefWidth(200);
        winButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                minispielrueckgabewert = new Minispielrueckgabewert(false,new Spieler("TestSpieler",false,"red"),new Wuerfel("testwürfel",1,3));
                stage.close();
            }
        });
        p.getChildren().addAll(testRect,winButton);

         super.start(stage);
    }


}
