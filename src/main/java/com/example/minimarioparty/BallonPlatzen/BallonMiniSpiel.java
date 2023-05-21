package com.example.minimarioparty.BallonPlatzen;

import com.example.minimarioparty.Hauptgame.GuterWuerfel;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.Hauptgame.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;

public class BallonMiniSpiel extends Minispiel {
    private final Pane innerPane = new Pane();

    private final int MINPUNKTE = 10000;
    private final int DAUER = 60;

    private Label ZeitLabel;

    private int  punkte =0;

    private Label WinLoseLabel;

    private Label PunkteLabel;
    private long Endzeit;

    private int ballonarten ;
    private int faktor;
    private Stage stage;


    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        spielanleitungText = "Ziel dieses Spiels ist es in 60 Sekunden mehr als die angegebene Punktzahl durch Klicken auf die Ballons zu erreichen\nBallons geben mehr Punkte je kleiner sie sind und goldene Ballons geben Extrapunkte\n";
        MinispielTitleLabel.setText("Ballonplatzen");


        if(leicht){
            ballonarten = 2;
            faktor =1;
            minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());
            MinispielSchwierigkeitLable.setText("Leicht");
        }else{
            ballonarten = 3;
            faktor = 2;
            minispielrueckgabewert.setWuerfel(new GuterWuerfel());
            spielanleitungText+= "Schwarze Ballons geben Punktabzug!";
            MinispielSchwierigkeitLable.setText("Schwer");
        }
        ImageView hintergrund = new ImageView(new Image("himmelbild.jpg"));
        hintergrund.setFitHeight(600);
        hintergrund.setFitWidth(900);
        hintergrund.setLayoutX(50);
        hintergrund.setLayoutY(150);

        Button b  = new Button("Start Game");
        b.setPrefSize(100,100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        b.setOnAction(event->{
            System.out.println("Button pressed ");
            b.setVisible(false);
            spielanleitungButton.setVisible(false);
            DecimalFormat df = new DecimalFormat("0");
            long Startzeit = System.currentTimeMillis();
            Endzeit= Startzeit + DAUER*1000;
            new Thread(()->{
                try{
                    while(Endzeit>=System.currentTimeMillis()){

                        Platform.runLater(()->ZeitLabel.setText(df.format((Endzeit-System.currentTimeMillis())/1000)+" Sekunden"));
                        Thread.sleep(100);

                    }
                }catch(InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }).start();
            ballonErzeugen();

        });

        innerPane.setPrefSize(900,600);
        innerPane.setLayoutX(50);
        innerPane.setLayoutY(150);

        ZeitLabel = new Label(DAUER+" Sekunden");
        ZeitLabel.setPrefSize(200,100);
        ZeitLabel.setLayoutY(75);
        ZeitLabel.setLayoutX(400);
        ZeitLabel.setFont(new Font(22));
        ZeitLabel.setAlignment(Pos.CENTER);

        PunkteLabel = new Label("/"+MINPUNKTE);
        PunkteLabel.setPrefSize(200,100);
        PunkteLabel.setLayoutY(75);
        PunkteLabel.setLayoutX(750);
        PunkteLabel.setFont(new Font(24));
        PunkteLabel.setAlignment(Pos.CENTER_RIGHT);

        WinLoseLabel = new Label();
        WinLoseLabel.setPrefSize(400,50);
        WinLoseLabel.setFont(new Font(40));
        WinLoseLabel.setLayoutY(400);
        WinLoseLabel.setLayoutX(300);
        WinLoseLabel.setAlignment(Pos.CENTER);
        WinLoseLabel.setVisible(false);

        p.getChildren().addAll(hintergrund,innerPane,b,ZeitLabel, PunkteLabel,WinLoseLabel);

        super.start(stage);
    }
    private void ballonErzeugen(){

        int x = (int) (Math.random()*800+50);
        int y = (int) (Math.random()*500+50);

        CubicCurve line = new CubicCurve();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(0.25);
        line.setStartX(x);
        line.setStartY(y+2.5);
        line.setControlX1(x-5);
        line.setControlY1(y+7);
        line.setControlX2(x+5);
        line.setControlY2(y+14);
        line.setEndX(x);
        line.setEndY(y+20);

        Ballon b;

        float ballonart = (float)  Math.random()*ballonarten;

        if(ballonart>2){
            b = new BlackBallon(x,y,line);
        } else if (ballonart>1.85) {
            b = new GoldBallon(x,y,line);
        }else{
            b = new NormalerBallon(x,y,line);
        }


        innerPane.getChildren().addAll(line,b);
        b.setOnMouseClicked(e->{
                punkte = punkte + (int) b.getPunkte();
                Platform.runLater(()-> PunkteLabel.setText(punkte+"/"+MINPUNKTE));
                Platform.runLater(()->innerPane.getChildren().removeAll(b,line));

        });
        if(!leicht){
            new Thread(b::move).start();
        }

        new Thread(()->{
            b.grow(faktor);
            b.setOnPane(false);
            PauseTransition pause = new PauseTransition(Duration.seconds((double)1/faktor));
            pause.setOnFinished(event -> Platform.runLater(()->innerPane.getChildren().removeAll(b,line)));
            pause.play();
        }).start();

        PauseTransition pause = new PauseTransition(Duration.seconds(0.25));
        pause.setOnFinished(event -> {

            if(Endzeit>=System.currentTimeMillis()){
                ballonErzeugen();

            }
            else{
                System.out.println("Zeit vorbei");
                gewinnauswertung();
            }


        });
        pause.play();

    }

    private void gewinnauswertung() {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {

            minispielrueckgabewert.setAbbruch(false);

            Platform.runLater(()->WinLoseLabel.setVisible(true));
            if(punkte>=MINPUNKTE){
                minispielrueckgabewert.setWinner(spieler[0]);
                Platform.runLater(()->WinLoseLabel.setText("Du hast gewonnen!!"));

            }else {
                minispielrueckgabewert.setWinner(spieler[1]);

                Platform.runLater(()->WinLoseLabel.setText("Du hast leider verloren"));
            }

            PauseTransition pause2 = new PauseTransition(Duration.seconds(5));
            pause2.setOnFinished(e -> stage.close());
            pause2.play();


        });

        pause.play();
    }

}
