package com.example.minimarioparty;

import com.example.minimarioparty.Hauptgame.Hauptgame;
import com.example.minimarioparty.Hauptgame.Spieler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public  abstract class Minispiel extends Application {

    protected Minispielrueckgabewert minispielrueckgabewert = new Minispielrueckgabewert(true, null, null);
    protected boolean leicht;

    protected Pane p = new Pane();

    protected  Spieler[] spieler = new Spieler[2];
    protected Rectangle menuRectangle = new Rectangle();

    protected Label MinispielSchwierigkeitLable  = new Label("Schwierigkeit");
    protected Label MinispielTitleLabel = new Label("Minispieltitel");
    protected Button spielanleitungButton = new Button("Spielanleitung");

    protected String hauptfarbe = "#8361FF";

    protected String spielanleitungText = "";

    private static boolean pauseGame= false;
    protected Stage stage;




    public void start(Stage stage) throws IOException {
        this.stage = stage;

        menuRectangle.setLayoutX(0);
        menuRectangle.setLayoutY(0);
        menuRectangle.setWidth(1000);
        menuRectangle.setHeight(100);
        menuRectangle.setFill(Paint.valueOf(hauptfarbe));

        spieler  =  Hauptgame.getSpieler();

        Button zuruckButton = new Button("Zurück");
        zuruckButton.setLayoutX(25);
        zuruckButton.setLayoutY(35);
        zuruckButton.prefWidth(100);
        zuruckButton.prefHeight(50);

        MinispielSchwierigkeitLable.setFont(new Font("system",20));
        MinispielSchwierigkeitLable.setLayoutX(450);
        MinispielSchwierigkeitLable.setLayoutY(60);
        MinispielSchwierigkeitLable.prefWidth(150);
        MinispielSchwierigkeitLable.prefHeight(55);
        MinispielSchwierigkeitLable.setTextFill(Paint.valueOf("#ffffff"));

        spielanleitungButton.setLayoutX(875);
        spielanleitungButton.setLayoutY(35);

        MinispielTitleLabel.setFont(new Font("Arial black", 24));
        MinispielTitleLabel.setLayoutX(450);
        MinispielTitleLabel.setLayoutY(25);
        MinispielTitleLabel.prefWidth(150);
        MinispielTitleLabel.prefHeight(55);
        MinispielTitleLabel.setTextFill(Paint.valueOf("#ffffff"));






        zuruckButton.setOnAction(actionEvent -> {
            minispielrueckgabewert= new Minispielrueckgabewert(true,null,null);

            Stage stage1 = (Stage) zuruckButton.getScene().getWindow();
            stage1.close();

        });

        spielanleitungButton.setOnAction(actionEvent -> {
            pauseGame = true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Spielanleitung");
            alert.setHeaderText("Spielanleitung");
            alert.setContentText(spielanleitungText);
            alert.showAndWait();
            pauseGame = false;

        });




        p.getChildren().addAll(menuRectangle);
        p.getChildren().addAll(zuruckButton, spielanleitungButton, MinispielTitleLabel, MinispielSchwierigkeitLable);
        //ende vom code, danach nichts mehr einfügen
        Scene scene = new Scene(p,1000,800);
        stage.setTitle("Minispiel");
        stage.setScene(scene);
        stage.showAndWait();

    }

    public void setLeicht(boolean leicht) {
        this.leicht = leicht;
    }

    public Minispielrueckgabewert getMinispielrueckgabewert() {
        return minispielrueckgabewert;
    }

    public static boolean isPauseGame() {
        return pauseGame;
    }
}
