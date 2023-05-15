package com.example.minimarioparty.Labyrinth;

import com.example.minimarioparty.Minispiel;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Labyrinth extends Minispiel {
    LaberithField[][] feld = new LaberithField[21][21];
    LaberithField startfeldSpieler;
    LaberithField startfeldComputer;
    LaberithField zielFeld;

    Label countDownWin;

    Rectangle hideRect;

    LaberithField aktuellesFeld;
    @Override
    public void start(Stage stage) throws IOException {

        Pane gamePane = new Pane();
        gamePane.setPrefSize(630,630);
        gamePane.setLayoutX(200);
        gamePane.setLayoutY(150);
        List<LaberithField> computerpfad;
        List<LaberithField> spielerpfad;
        MinispielTitleLabel.setText("Labyrinth Minispiel");
        MinispielSchwierigkeitLable.setText("");
        spielanleitungText = "Ziel des Spiels ist es schneller als der Computer durch das Laberinth zum roten Zielfeld in der Mitte zu gelangen. Steuere dafür über die Tasten a,w,s und d. ";

        do{
            createFeld();
            spielerpfad =  BreitensucheFelder.findePfad(startfeldSpieler,zielFeld);
            zielFeld.setMarkiert(false);
            computerpfad = BreitensucheFelder.findePfad(startfeldComputer,zielFeld);

        }while(spielerpfad.isEmpty()||computerpfad.isEmpty());





        for(LaberithField[] a: Arrays.stream(feld).toList()){
            for(LaberithField b: a){
                gamePane.getChildren().add(b);
            }
        }
        p.getChildren().addAll(gamePane);


        countDownWin = new Label("3");
        countDownWin.setFont(new Font(100));
        countDownWin.setLayoutX(350);
        countDownWin.setLayoutY(400);
        countDownWin.setPrefSize(300,100);
        countDownWin.setAlignment(Pos.CENTER);

        hideRect = new Rectangle(630,630);
        hideRect.setLayoutY(150);
        hideRect.setLayoutX(200);
        hideRect.setOpacity(0.95);
        hideRect.setFill(Paint.valueOf("#ffffff"));

        p.getChildren().addAll(hideRect,countDownWin);
        new Thread(()->{
            for(int i = 3;i>0;i--){
                int finalI = i;
                Platform.runLater(()->countDownWin.setText(String.valueOf(finalI)));
                try{Thread.sleep(1000);}catch(Exception e){}
            }
            try{Thread.sleep(1000);}catch(Exception e){}
            Platform.runLater(()->countDownWin.setText("Start"));
            try{Thread.sleep(500);}catch(Exception e){}
            Platform.runLater(()->{
                countDownWin.setVisible(false);
                hideRect.setVisible(false);
                p.setOnKeyPressed(e -> {
                switch (e.getCode()){
                    case A -> setAktuellesFeld(aktuellesFeld.getLeft());
                    case W -> setAktuellesFeld(aktuellesFeld.getTop());
                    case S -> setAktuellesFeld(aktuellesFeld.getBottom());
                    case D -> setAktuellesFeld(aktuellesFeld.getRight());

                }

                });
             });
            computermove();

        }).start();
        super.start(stage);

    }

    private void computermove() {

    }

    public void setAktuellesFeld(LaberithField neuesFeld){
        if(neuesFeld!=null){
            if(neuesFeld.getSelectValue()!=1){
                Platform.runLater(()->{
                    aktuellesFeld.changeSelectvalue(0);
                    aktuellesFeld = neuesFeld;
                    aktuellesFeld.changeSelectvalue(2);
                });

            }
        }

        if(aktuellesFeld == zielFeld){
            System.out.println("win");
        }


    }

    private void createFeld(){
        feld = new LaberithField[21][21];

        for(int YCounter = 0; YCounter<10; YCounter++){
            for(int XCounter = 0;XCounter<21; XCounter++){
                int value;
                if(Math.random()*3<2)value = 0;
                else value = 1;
                feldHinzufuegen(XCounter,YCounter,value);
            }
        }
        for(int XCounter = 0;XCounter<21; XCounter++){
            feldHinzufuegen(XCounter,10,1);
        }
        for(int YCounter = 11; YCounter<21; YCounter++) {
            for (int XCounter = 0; XCounter < 21; XCounter++) {
                int value;
                if(Math.random()*3<2)value = 0;
                else value = 1;
                feldHinzufuegen(XCounter,YCounter,value);
            }
        }
        startfeldSpieler = feld[20][0];
        startfeldSpieler.changeSelectvalue(2);
        aktuellesFeld = startfeldSpieler;
        startfeldComputer = feld[0][20];
        startfeldComputer.changeSelectvalue(2);
        zielFeld = feld[10][10];
        zielFeld.changeSelectvalue(3);
        feld[10][9].changeSelectvalue(0);
        feld[10][11].changeSelectvalue(0);



    }
    private void feldHinzufuegen(int x, int y, int value){

        feld[x][y] = new LaberithField(value,x*30,y*30);
        try{
            feld[x][y].setTop(feld[x][y-1]);
        }catch (Exception e){//System.out.println("Feld existiert nicht");
             }
        try{
            feld[x][y].setLeft(feld[x-1][y]);
        }catch (Exception e){//System.out.println("Feld existiert nicht");
             }
    }
}
