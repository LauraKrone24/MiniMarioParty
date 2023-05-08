package com.example.minimarioparty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Hauptgame extends Application {
    private static Spieler[] spieler = new Spieler[2];
    private Spieler aktuellerSpieler;
    private Spieler naesterSpieler;
    private Rectangle wurfel1Rect;
    private Ellipse nichtAktuellerSpielerEllipse;
    private Ellipse aktuellerSpielerEllipse;
    private Rectangle wurfel2Rect;
    protected static ArrayList<Feld> felder = new ArrayList<Feld>();
    private Label aktuellerSpielerLable;
    private Label nichtAktuellerSpielerLable;
    private Button wuefelbutton;
    private Label wuerfelSUMLable;
    public Label wuerfel1Lable;
    public  Label wuerfel2Lable;

    private  Ellipse figurSpieler;
    private Ellipse figurComputer;

    private final String SPIELER1FARBE = "#1e90ff";
    private final String SPIELER2FARBE = "770000";
    @Override
    public void start(Stage stage) throws IOException {

        Pane p = new Pane();

        Label MarioParty= new Label("Mini Mario Party");
        MarioParty.setLayoutX(800);
        MarioParty.setLayoutY(50);
        MarioParty.setPrefWidth(200);
        MarioParty.setFont(new Font("System",25));
        p.getChildren().add(MarioParty);

        Label spielerreihenfolge= new Label("Spielerreihenfolge");
        spielerreihenfolge.setLayoutX(800);
        spielerreihenfolge.setLayoutY(100);
        spielerreihenfolge.setPrefWidth(200);
        spielerreihenfolge.setFont(new Font("System",20));
        p.getChildren().add(spielerreihenfolge);

        aktuellerSpielerEllipse = new Ellipse(10,15); //hier Farbe anpassen

        nichtAktuellerSpielerEllipse = new Ellipse(10,15);// hier Farbe anpassen

         aktuellerSpielerLable = new Label("",aktuellerSpielerEllipse);
         nichtAktuellerSpielerLable = new Label("",nichtAktuellerSpielerEllipse);



        GridPane gp = new GridPane();
        gp.setLayoutX(800);
        gp.setLayoutY(150);
        gp.setPrefWidth(200);
        gp.add(aktuellerSpielerLable,0,0);
        gp.add(nichtAktuellerSpielerLable,0,1);

        p.getChildren().add(gp);

        Label wuerfelLable = new Label("Würfel");
        wuerfelLable.setPrefWidth(200);
        wuerfelLable.setLayoutY(450);
        wuerfelLable.setLayoutX(800);
        wuerfelLable.setFont(new Font("System",24));
        wuerfelLable.setAlignment(Pos.CENTER);

        wurfel1Rect = new Rectangle(50,50);
        wurfel1Rect.setLayoutY(500);
        wurfel1Rect.setLayoutX(820);
        wurfel1Rect.setFill(Paint.valueOf("#1e90ff"));
        wurfel1Rect.setArcHeight(5);
        wurfel1Rect.setArcWidth(5);

        wurfel2Rect = new Rectangle(50,50);
        wurfel2Rect.setLayoutY(500);
        wurfel2Rect.setLayoutX(930);
        wurfel2Rect.setFill(Paint.valueOf("#1e90ff"));
        wurfel2Rect.setArcHeight(5);
        wurfel2Rect.setArcWidth(5);

        wuerfel1Lable = new Label("5");
        wuerfel1Lable.setPrefWidth(50);
        wuerfel1Lable.setPrefWidth(50);
        wuerfel1Lable.setLayoutY(570);
        wuerfel1Lable.setLayoutX(820);
        wuerfel1Lable.setFont(new Font("System",24));
        wuerfel1Lable.setAlignment(Pos.CENTER);

        wuerfel2Lable = new Label("1");
        wuerfel2Lable.setPrefWidth(50);
        wuerfel2Lable.setPrefWidth(50);
        wuerfel2Lable.setLayoutY(570);
        wuerfel2Lable.setLayoutX(930);
        wuerfel2Lable.setFont(new Font("System",24));
        wuerfel2Lable.setAlignment(Pos.CENTER);

        wuerfelSUMLable = new Label("6");
        wuerfelSUMLable.setPrefWidth(75);
        wuerfelSUMLable.setPrefWidth(75);
        wuerfelSUMLable.setLayoutY(600);
        wuerfelSUMLable.setLayoutX(862.5);
        wuerfelSUMLable.setFont(new Font("System",48));
        wuerfelSUMLable.setAlignment(Pos.CENTER);

        wuefelbutton = new Button("Würfeln");
        wuefelbutton.setPrefWidth(60);
        wuefelbutton.setPrefWidth(180);
        wuefelbutton.setLayoutY(690);
        wuefelbutton.setLayoutX(810);
        wuefelbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                zug();
            }
        });

        p.getChildren().addAll(wurfel1Rect,wurfel2Rect,wuerfelLable,wuerfel1Lable,wuerfel2Lable,wuefelbutton);

        //Image hintergrundimage = new Image(""); //Hier wenn vorhanden Bild einfügen
        ImageView spielfeldhintergrund = new ImageView();
        //spielfeldhintergrund.setImage(hintergrundimage);
        spielfeldhintergrund.setFitHeight(750);
        spielfeldhintergrund.setFitWidth(750);
        spielfeldhintergrund.setLayoutX(25);
        spielfeldhintergrund.setLayoutY(25);
        p.getChildren().add(spielfeldhintergrund);


        figurSpieler = new Ellipse(15,15);
        figurSpieler.setLayoutX(40);
        figurSpieler.setLayoutY(715);
        figurSpieler.setFill(Paint.valueOf(SPIELER1FARBE));

        figurComputer = new Ellipse(15,15);
        figurComputer.setLayoutX(70);
        figurComputer.setLayoutY(745);
        figurComputer.setFill(Paint.valueOf(SPIELER2FARBE));

        p.getChildren().addAll(figurSpieler,figurComputer);

        Scene scene = new Scene(p,1000,800);
        stage.setTitle("Mini Mario Party");
        stage.setScene(scene);
        TextInputDialog td = new TextInputDialog("");
        td.setHeaderText("Gib deinen Namen ein");
        td.showAndWait();
        String spielername = td.getEditor().getText();

        aktuellerSpieler = new Spieler(spielername,false,SPIELER1FARBE);
        naesterSpieler = new Spieler("Computer",true,SPIELER2FARBE);
        chooseStartspieler();
        updateOberflache();

        stage.show();

    }

    public void setFelder(){

    };

    public void chooseStartspieler(){
        double  i = Math.random();
        if(i<=0.5){
            changeSpieler();
        }
        nextSpieler();

    };

    public void changeSpieler(){
        Spieler p = naesterSpieler;
        naesterSpieler = aktuellerSpieler;
        aktuellerSpieler = p;
    };

    public void nextSpieler(){
       changeSpieler();
        updateOberflache();
        if(aktuellerSpieler.isComputer()){
            wuefelbutton.setVisible(false);
            try{Thread.sleep(200);}catch (Exception e){}
            zug();
        }
        else {
            wuefelbutton.setVisible(true);
        }
    };

    public void zug(){
        wuerfelSUMLable.setText(String.valueOf(aktuellerSpieler.wuerfeln()));
        try{Thread.sleep(200);}catch (Exception e){}
        if(aktuellerSpieler.isComputer()){
            figurComputer.setLayoutX(aktuellerSpieler.getPosition().getX()+45);
            figurComputer.setLayoutX(aktuellerSpieler.getPosition().getY()+45);
        }else{
            figurSpieler.setLayoutX(aktuellerSpieler.getPosition().getX()+45);
            figurSpieler.setLayoutX(aktuellerSpieler.getPosition().getY()+45);
        }
        try{Thread.sleep(200);}catch (Exception e){}
        if(aktuellerSpieler.getPosition() instanceof Aktionsfeld){
            Minispielrueckgabewert minispielrueckgabewert = ((Aktionsfeld) aktuellerSpieler.getPosition()).starteMinispiel();

        }
        nextSpieler();
    }

    public void updateOberflache(){
        wuerfel1Lable.setText("");
        wuerfel2Lable.setText("");
        wuerfelSUMLable.setText("");

        aktuellerSpielerEllipse.setFill(Paint.valueOf(aktuellerSpieler.getFarbe()));
        aktuellerSpielerLable.setText(aktuellerSpieler.getName());
        nichtAktuellerSpielerEllipse.setFill(Paint.valueOf(naesterSpieler.getFarbe()));
        nichtAktuellerSpielerLable.setText(naesterSpieler.getName());
    };

    public static Spieler[] getSpieler() {
        return spieler;
    }

    public static void main(String[] args) {
        launch();
    }
}