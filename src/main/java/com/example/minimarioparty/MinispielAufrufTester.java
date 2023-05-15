package com.example.minimarioparty;

import com.example.minimarioparty.BallonPlatzen.BallonMiniSpiel;
import com.example.minimarioparty.BlackJack.BlackJackMinispiel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MinispielAufrufTester extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane p = new Pane();
        Button startButton  = new Button("Starte Minispiel");
        startButton.setLayoutX(100);
        startButton.setLayoutY(100);
        startButton.setPrefHeight(200);
        startButton.setPrefWidth(200);
        startButton.setOnAction(actionEvent -> {
            Minispiel test = new BlackJackMinispiel(); // Hier Minispielklassennamen zum Testen einfügen
            test.setLeicht(false);
            try{
                test.start(new Stage());
                Minispielrueckgabewert  back = test.getMinispielrueckgabewert();
                System.out.println(back);
            }catch (Exception e){
                System.out.println("Spiel konnte nicht gestartet werden");
                e.printStackTrace();
            }

        });
        p.getChildren().add(startButton);
        Scene scene = new Scene(p,400,400);
        stage.setTitle("Minispiel Tester");
        stage.setScene(scene);
        stage.show();
    }
}
