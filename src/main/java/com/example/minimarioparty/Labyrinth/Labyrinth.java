package com.example.minimarioparty.Labyrinth;

import com.example.minimarioparty.Hauptgame.GuterWuerfel;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.Hauptgame.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Labyrinth extends Minispiel {
    private  LabyrinthField[][] feld = new LabyrinthField[21][21];
    private LabyrinthField aktuellesFeldComputer;
    private LabyrinthField zielFeld;
    private Label countDownWin;
    private Rectangle hideRect;
    private LabyrinthField aktuellesFeldSpieler;
    private List<LabyrinthField> computerpfad;
    private Boolean gewonnen = false;
    private int direction=2;

    @Override

    public void start(Stage stage) throws IOException {
        //Setzten der Werte für Leicht bzw. Schwer

        if(leicht){
            minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());
            MinispielSchwierigkeitLable.setText("Leicht");
        }else {
            minispielrueckgabewert.setWuerfel(new GuterWuerfel());
            MinispielSchwierigkeitLable.setText("Schwer");
        }

        //OberflächenAttribute
        Pane gamePane = new Pane();
        gamePane.setPrefSize(630,630);
        gamePane.setLayoutX(200);
        gamePane.setLayoutY(150);

        MinispielTitleLabel.setText("Labyrinth Minispiel");
        spielanleitungText = "Ziel des Spiels ist es schneller als der Computer durch das Laberinth zum roten Zielfeld in der Mitte zu gelangen. Steuere dafür über die Tasten a,w,s und d. ";


        // Erstellen des Labyrinths
        List<LabyrinthField> spielerpfad;
        do{
            createFeld();
            spielerpfad =  BreitensucheImLabyrinth.findWay(aktuellesFeldSpieler,zielFeld);
            zielFeld.setMarkiert(false);
            zielFeld.setSuchPfad(new ArrayList<>());
            computerpfad = BreitensucheImLabyrinth.findWay(aktuellesFeldComputer,zielFeld);

        }while(spielerpfad.isEmpty()||computerpfad.isEmpty());


        for(LabyrinthField[] a: Arrays.stream(feld).toList()){
            for(LabyrinthField b: a){
                if(b.getSelectValue()!=1){b.setMarkiert(false);}
                gamePane.getChildren().add(b);
            }
        }
        p.getChildren().addAll(gamePane);


        //Startoberfläche bauen
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
            //Countdown zum Start
            for(int i = 3;i>0;i--){
                int finalI = i;
                Platform.runLater(()->countDownWin.setText(String.valueOf(finalI)));
                try{Thread.sleep(1000);}catch(Exception e){System.out.println("Sleep wurde unterbrochen");}
                warten();
            }
            try{Thread.sleep(1000);}catch(Exception e){System.out.println("Sleep wurde unterbrochen");}
            warten();
            Platform.runLater(()->countDownWin.setText("Start"));
            try{Thread.sleep(500);}catch(Exception e){System.out.println("Sleep wurde unterbrochen");}
            Platform.runLater(()->{
                countDownWin.setVisible(false);
                hideRect.setVisible(false);
                //aktiveren der Spielerbewegung
                p.setOnKeyPressed(e -> {
                switch (e.getCode()){
                    case A -> setAktuellesSpielerFeld(aktuellesFeldSpieler.getLeft());
                    case W -> setAktuellesSpielerFeld(aktuellesFeldSpieler.getTop());
                    case S -> setAktuellesSpielerFeld(aktuellesFeldSpieler.getBottom());
                    case D -> setAktuellesSpielerFeld(aktuellesFeldSpieler.getRight());

                }

                });
             });
            // Computer starten
            computermove();

        }).start();
        super.start(stage);

    }

    private void computermove() {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.setOnFinished(event->{


            if(((aktuellesFeldComputer.getNum()!=zielFeld.getNum())&&(!gewonnen) &&(!computerpfad.isEmpty()))){
                if(leicht){ // Computer nutzt Linke Hand Regel
                    linkeHandAlgorithmusZug();
                }else{ // Computer kennt den Weg durch vorherige Breitensuche

                    Platform.runLater(()->{
                        aktuellesFeldComputer.changeSelectvalue(0);
                        aktuellesFeldComputer = computerpfad.remove(0);
                        aktuellesFeldComputer.changeSelectvalue(4);
                    });

                }
                // Warten, wenn Spielanleitung geöffnet
                new Thread(()->{
                    warten();
                    computermove();
                }).start();

            }else{
                if(aktuellesFeldComputer.getNum()==zielFeld.getNum()){
                    win(false);
                }
            }
        });
        pause.play();


    }

    private void linkeHandAlgorithmusZug(){

        LabyrinthField choosenFeld;
        // Abfrage, ob das Feld links von der aktuellen Richtung frei ist
        if(chooseField(direction+1)!=null &&!chooseField(direction+1).isMarkiert()){
            direction= direction+1;
            if(direction ==4)direction=0;
        }
        // drehen nach rechts bis in die richtung ein freies Feld ist
        do{
            choosenFeld = chooseField(direction);
            if(chooseField(direction)==null||choosenFeld.isMarkiert()){
                direction--;
                if(direction ==-1)direction=3;
            }
        }while(choosenFeld==null||choosenFeld.isMarkiert());

        // setzten des nächsten Computerfelds
        LabyrinthField finalChoosenFeld = choosenFeld;
        Platform.runLater(()->{
            aktuellesFeldComputer.changeSelectvalue(0);
            aktuellesFeldComputer = finalChoosenFeld;
            aktuellesFeldComputer.changeSelectvalue(4);
        });

    }

    private LabyrinthField chooseField(int d){
        // Rückgabe des Feldes für den Linken-Hand-Algorithmus abhängig von der übergebenen Richtung
        LabyrinthField choosenFeld;
        choosenFeld = switch (d%4){
            case 1-> aktuellesFeldComputer.getRight();
            case 2-> aktuellesFeldComputer.getTop();
            case 3-> aktuellesFeldComputer.getLeft();
            case 0-> aktuellesFeldComputer.getBottom();
            default -> null;
        };
        return choosenFeld;
    }
    private void setAktuellesSpielerFeld(LabyrinthField neuesFeld){
        // Setzten des aktuellen Spielerfelds, wenn möglich
        if(neuesFeld!=null){
            if(neuesFeld.getSelectValue()!=1){
                Platform.runLater(()->{
                    aktuellesFeldSpieler.changeSelectvalue(0);
                    aktuellesFeldSpieler = neuesFeld;
                    aktuellesFeldSpieler.changeSelectvalue(2);
                    //Abfrage, ob Ziel erreicht ist
                    if(aktuellesFeldSpieler.getNum()==zielFeld.getNum()){
                        win(true);
                        gewonnen = true;

                    }
                });

            }
        }

    }
    private void win(Boolean win){
        // Ausgabe des Gewinners
        Platform.runLater(()->{
            p.setOnKeyPressed(e -> {});
            minispielrueckgabewert.setAbbruch(false);
            countDownWin.setVisible(true);
            countDownWin.setFont(new Font(30));
            hideRect.setVisible(true);

            if(win){
                minispielrueckgabewert.setWinner(spieler[0]);
                countDownWin.setText("Du hast gewonnen");
                countDownWin.setVisible(true);
            }
            else{
                minispielrueckgabewert.setWinner(spieler[1]);
                countDownWin.setText("Du hast verloren");
            }
        });
        // Beenden des Spiels
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event -> stage.close());
        pause.play();

    }

    private void warten(){
        //Methode zum Warten, wenn Minispiel anleitung offen ist.
        while(isPauseGame()){ try{Thread.sleep(100);}catch(Exception e){System.out.println("Sleep wurde unterbrochen");}}
    }



    // Funktionen zum Spielfeld erstellen
    private void createFeld(){
        feld = new LabyrinthField[21][21];

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
        aktuellesFeldSpieler = feld[20][0];
        aktuellesFeldSpieler.changeSelectvalue(2);

        aktuellesFeldComputer = feld[0][20];
        aktuellesFeldComputer.changeSelectvalue(4);
        zielFeld = feld[10][10];
        zielFeld.changeSelectvalue(3);
        feld[10][9].changeSelectvalue(0);
        feld[10][11].changeSelectvalue(0);



    }
    private void feldHinzufuegen(int x, int y, int value){

        feld[x][y] = new LabyrinthField(value,x*30,y*30);
        try{
            feld[x][y].setTop(feld[x][y-1]);
        }catch (Exception e){/*Feld existiert nicht*/}
        try{
            feld[x][y].setLeft(feld[x-1][y]);
        }catch (Exception e){/*Feld existiert nicht*/}
    }
}
