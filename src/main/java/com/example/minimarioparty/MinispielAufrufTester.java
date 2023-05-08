package com.example.minimarioparty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Minispiel test = new TestMiniSpiel(); // Hier Minispielklassennamen zumTesten einfügen
                try{test.start(new Stage());
                Minispielrueckgabewert  back = test.getMinispielrueckgabewert();
                    System.out.println(back);
                }catch (Exception e){}

            }
        });
        p.getChildren().add(startButton);
        Scene scene = new Scene(p,400,400);
        stage.setTitle("Minispiel Tester");
        stage.setScene(scene);
        stage.show();
    }
}
