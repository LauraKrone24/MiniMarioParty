package com.example.minimarioparty;

import com.example.minimarioparty.Hauptgame.GuterWuerfel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class TestMiniSpiel extends Minispiel{
    // Dies ist eine Beispieltestklasse


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
                minispielrueckgabewert = new Minispielrueckgabewert(false,spieler[0],new GuterWuerfel());

                stage.close();
            }
        });
        p.getChildren().addAll(testRect,winButton);

         super.start(stage);
    }


}
