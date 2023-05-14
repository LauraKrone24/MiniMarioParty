package com.example.minimarioparty.Labyrinth;

import com.example.minimarioparty.Minispiel;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Labyrinth extends Minispiel {
    LaberithField[][] feld = new LaberithField[21][21];
    LaberithField startfeldSpieler;
    LaberithField startfeldComputer;
    LaberithField zielFeld;
    @Override
    public void start(Stage stage) throws IOException {

        Pane gamePane = new Pane();
        gamePane.setPrefSize(630,630);
        gamePane.setLayoutX(200);
        gamePane.setLayoutY(150);

        createFeld();



        for(LaberithField[] a: Arrays.stream(feld).toList()){
            for(LaberithField b: a){
                gamePane.getChildren().add(b);
            }
        }
        p.getChildren().addAll(gamePane);
        super.start(stage);
    }

    private void createFeld(){

        for(int YCounter = 0; YCounter<10; YCounter++){
            for(int XCounter = 0;XCounter<21; XCounter++){
                feldHinzufügen(XCounter,YCounter,(int)(Math.random()*2));
            }
        }
        for(int XCounter = 0;XCounter<21; XCounter++){
            feldHinzufügen(XCounter,10,1);
        }
        for(int YCounter = 11; YCounter<21; YCounter++) {
            for (int XCounter = 0; XCounter < 21; XCounter++) {
                feldHinzufügen(XCounter,YCounter,(int)(Math.random()*2));
            }
        }
        startfeldSpieler = feld[20][0];
        startfeldSpieler.changeSelectvalue(2);
        startfeldComputer = feld[0][20];
        startfeldComputer.changeSelectvalue(2);
        zielFeld = feld[10][10];
        zielFeld.changeSelectvalue(3);

    }
    private void feldHinzufügen(int x, int y, int value){
        feld[x][y] = new LaberithField(value,x*30,y*30);
        try{
            feld[x][y].setTop(feld[x][y-1]);
        }catch (Exception e){System.out.println("Feld existiert nicht");}
        try{
            feld[x][y].setLeft(feld[x-1][y]);
        }catch (Exception e){System.out.println("Feld existiert nicht");}
    }
}
