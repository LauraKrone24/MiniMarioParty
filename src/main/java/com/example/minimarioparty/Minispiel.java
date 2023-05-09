package com.example.minimarioparty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Objects;

public  abstract class Minispiel extends Application {

    protected Minispielrueckgabewert minispielrueckgabewert;
    private boolean leicht;

    protected Pane p= new Pane();

    protected Label MinispielSchwierigkeitLable  = new Label();




    public void start(Stage stage) throws IOException {

        Button zuruckButton = new Button("Zurück");
        zuruckButton.setLayoutX(100);
        zuruckButton.setLayoutY(100);

        MinispielSchwierigkeitLable.setFont(new Font("system",24));
        MinispielSchwierigkeitLable.setLayoutX(20);
        MinispielSchwierigkeitLable.setLayoutY(20);





        zuruckButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                minispielrueckgabewert= new Minispielrueckgabewert(true,null,null);

                Stage stage = (Stage) zuruckButton.getScene().getWindow();
                stage.close();

            }
        });



        p.getChildren().addAll(zuruckButton);
        Scene scene = new Scene(p,1000,800);
        stage.setTitle("Minispiel");
        stage.setScene(scene);
        stage.showAndWait();

    }

    public Minispielrueckgabewert getMinispielrueckgabewert() {
        return minispielrueckgabewert;
    }
}
