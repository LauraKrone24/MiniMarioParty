package com.example.minimarioparty.steeplechase;

import com.example.minimarioparty.Minispiel;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class Steeplechase extends Minispiel {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        spielanleitungText = "TestAnleitung. ";
        MinispielTitleLabel.setText("TestTitel");
        MinispielSchwierigkeitLable.setText("leicht");

        // start button
        Button start = new Button("Ready?");
        start.setPrefSize(100,100);
        start.setLayoutX(450);
        start.setLayoutY(400);
        p.getChildren().add(start);
        start.setOnAction(event->{
            System.out.println("TEST");

            // new Threhad
            //initializeGamePlayer(); 4
                //drawMap()### 1
                // Thread - Player move -- Eingabe 2

            // new Thread.start()
            //initializeGameComputer(); 4
                // drawMap()### 1
                // Thread - Computer move -- Algorithm 3

        });
        super.start(stage);
    }








}
