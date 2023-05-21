package com.example.minimarioparty.Hauptgame;

import com.example.minimarioparty.Labyrinth.Labyrinth;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.TestMiniSpiel;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Hauptgame extends Application {
    private final static Spieler[] spieler = new Spieler[2];
    public static Boolean finished = true;
    private static Spieler aktuellerSpieler;
    private static Spieler naesterSpieler;
    private static Ellipse nichtAktuellerSpielerEllipse;
    private static Ellipse aktuellerSpielerEllipse;
    private static ImageView wurfel2ImageView;
    protected static Feld[] felder = new Feld[100];
    private static Label aktuellerSpielerLable;
    private static Label nichtAktuellerSpielerLable;
    private static Button wuefelbutton;
    private static Label wuerfelSUMLable = new Label();
    private static Label wuerfel1Lable = new Label();
    private static Label wuerfel2Lable = new Label();

    private static Ellipse figurSpieler;
    private static Ellipse figurComputer;
    public static List<Minispiel> minispielListe = new LinkedList<>();


    @Override
    public void start(Stage stage) throws IOException {
        final String SPIELER1FARBE = "#7eb774";
        final String SPIELER2FARBE = "ed7b84";

        Pane p = new Pane();
        p.setMaxSize(1000,800);

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

        ImageView wurfel1ImageView = new ImageView(new Image("NormalerWurfelBild.JPG"));
        wurfel1ImageView.setFitWidth(50);
        wurfel1ImageView.setFitHeight(50);
        wurfel1ImageView.setLayoutY(500);
        wurfel1ImageView.setLayoutX(820);

        wurfel2ImageView = new ImageView();
        wurfel2ImageView.setLayoutY(500);
        wurfel2ImageView.setLayoutX(930);
        wurfel2ImageView.setFitWidth(50);
        wurfel2ImageView.setFitHeight(50);

        wuerfel1Lable = new Label("");
        wuerfel1Lable.setPrefWidth(50);
        wuerfel1Lable.setPrefWidth(50);
        wuerfel1Lable.setLayoutY(570);
        wuerfel1Lable.setLayoutX(820);
        wuerfel1Lable.setFont(new Font("System",24));
        wuerfel1Lable.setAlignment(Pos.CENTER);

        wuerfel2Lable = new Label("");
        wuerfel2Lable.setPrefWidth(50);
        wuerfel2Lable.setPrefWidth(50);
        wuerfel2Lable.setLayoutY(570);
        wuerfel2Lable.setLayoutX(930);
        wuerfel2Lable.setFont(new Font("System",24));
        wuerfel2Lable.setAlignment(Pos.CENTER);

        wuerfelSUMLable = new Label("");
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
        wuefelbutton.setOnAction(event-> zug());

        p.getChildren().addAll(wurfel1ImageView, wurfel2ImageView,wuerfelLable,wuerfel1Lable,wuerfel2Lable,wuefelbutton,wuerfelSUMLable);

        Image hintergrundimage = new Image("Spielbrett.jpg"); //Hier wenn vorhanden Bild einfügen
        ImageView spielfeldhintergrund = new ImageView();
        spielfeldhintergrund.setImage(hintergrundimage);
        spielfeldhintergrund.setFitHeight(750);
        spielfeldhintergrund.setFitWidth(750);
        spielfeldhintergrund.setLayoutX(25);
        spielfeldhintergrund.setLayoutY(25);
        p.getChildren().add(spielfeldhintergrund);


        figurSpieler = new Ellipse(15,15);
        figurSpieler.setLayoutX(50);
        figurSpieler.setLayoutY(725);
        figurSpieler.setFill(Paint.valueOf(SPIELER1FARBE));

        figurComputer = new Ellipse(15,15);
        figurComputer.setLayoutX(75);
        figurComputer.setLayoutY(750);
        figurComputer.setFill(Paint.valueOf(SPIELER2FARBE));

        p.getChildren().addAll(figurSpieler,figurComputer);

        Scene scene = new Scene(p,1000,800);
        stage.setTitle("Mini Mario Party");
        stage.setScene(scene);
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Gib deinen Namen ein");
        td.showAndWait();
        String spielername = td.getEditor().getText();

        aktuellerSpieler = new Spieler(spielername,false,SPIELER1FARBE);
        naesterSpieler = new Spieler("Computer",true,SPIELER2FARBE);
        spieler[0]  = aktuellerSpieler;
        spieler[1]  = naesterSpieler;
        setFelder();

        addMinispiele();


        chooseStartspieler();
        updateOberflache();

        stage.show();

        if(aktuellerSpieler.isComputer())zug();




    }

    private void addMinispiele() {

        minispielListe.add(new Labyrinth());
        minispielListe.add(new Labyrinth());
        minispielListe.add(new Labyrinth());
        minispielListe.add(new TestMiniSpiel());
    }

    public void setFelder(){
        int x = 25;
        int y = 700;
        for (int i = 0; i <= 9; i++) {
            felder[i] = new Feld(i+1, x, y);
            x += 75;
        }
        x -=75;
        y -= 75;
        for (int i = 10; i <= 18; i++) {
            felder[i] = new Feld(i+1, x, y);
            y -= 75;
        }
        y +=75;
        x -= 75;
        for (int i = 19; i <= 27; i++) {
            felder[i] = new Feld(i+1, x, y);
            x -= 75;
        }
        x +=75;
        y += 75;
        for (int i = 28; i <= 35; i++) {
            felder[i] = new Feld(i+1, x, y);
            y += 75;
        }
        y -=75;
        x += 75;
        for (int i = 36; i <= 43; i++) {
            felder[i] = new Feld(i+1, x, y);
            x += 75;
        }
        x -=75;
        y -= 75;
        for (int i = 44; i <= 50; i++) {
            felder[i] = new Feld(i+1, x, y);
            y -= 75;
        }
        y+=75;
        x -= 75;
        for (int i = 51; i <= 57; i++) {
            felder[i] = new Feld(i+1, x, y);
            x -= 75;
        }
        x +=75;
        y += 75;
        for (int i = 58; i <= 63; i++) {
            felder[i] = new Feld(i+1, x, y);
            y += 75;
        }
        y-=75;
        x += 75;
        for (int i = 64; i <= 69; i++) {
            felder[i] = new Feld(i+1, x, y);
            x += 75;
        }
        x -=75;
        y -= 75;
        for (int i = 70; i <= 74; i++) {
            felder[i] = new Feld(i+1, x, y);
            y -= 75;
        }
        y+=75;
        x -= 75;
        for (int i = 75; i <= 79; i++) {
            felder[i] = new Feld(i+1, x, y);
            x -= 75;
        }
        x+=75;
        y += 75;
        for (int i = 80; i <= 83; i++) {
            felder[i] = new Feld(i+1, x, y);
            y += 75;
        }
        y -=75;

        x += 75;
        for (int i = 84; i <= 87; i++) {
            felder[i] = new Feld(i+1, x, y);
            x += 75;
        }
        x -=75;

        y -= 75;
        for (int i = 88; i <= 90; i++) {
            felder[i] = new Feld(i+1, x, y);
            y -= 75;
        }
        y+=75;

        x -= 75;
        for (int i = 91; i <= 93; i++) {
            felder[i] = new Feld(i+1, x, y);
            x -= 75;
        }
        x+=75;

        y += 75;
        for (int i = 94; i <= 95; i++) {
            felder[i] = new Feld(i+1, x, y);
            y += 75;
        }
        y -=75;

        x += 75;
        for (int i = 96; i <= 97; i++) {
            felder[i] = new Feld(i+1, x, y);
            x += 75;
        }
        x -=75;

        y -= 75;
        for (int i = 98; i <= 98; i++) {
            felder[i] = new Feld(i+1, x, y);

        }


        x -= 75;
        for (int i = 99; i <= 99; i++) {
            felder[i] = new Feld(i+1, x, y);

        }

        for (Feld feld: felder){
            if (feld.getNumber()% 5 == 0){
                int speicher = feld.getNumber();
                int a = feld.getX();
                int b = feld.getY();
                felder[speicher -1] = new Aktionsfeld(speicher,a,b);

            }

        }






    }

    public void chooseStartspieler(){
        double  i = Math.random();
        if(i<=0.5){
            changeSpieler();
        }
    }

    public static void changeSpieler(){
        Spieler p = naesterSpieler;
        naesterSpieler = aktuellerSpieler;
        aktuellerSpieler = p;
    }

    public static void nextSpieler(){
        finished = true;
        changeSpieler();
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> updateOberflache());
        pause.play();
        PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
        pause2.setOnFinished(event -> {

            if(aktuellerSpieler.isComputer()){
                zug();
            }else{
                wuefelbutton.setVisible(true);
            }

        });
        pause2.play();

    }



    public static void zug(){
        wuefelbutton.setVisible(false);

        wuerfelSUMLable.setText(String.valueOf(aktuellerSpieler.bewegeSpieler()));

        if(aktuellerSpieler.isComputer()){
            figurComputer.setLayoutX(aktuellerSpieler.getPosition().getX()+50);
            figurComputer.setLayoutY(aktuellerSpieler.getPosition().getY()+50);

        }else{
            figurSpieler.setLayoutX(aktuellerSpieler.getPosition().getX()+25);
            figurSpieler.setLayoutY(aktuellerSpieler.getPosition().getY()+25);

        }

        if(aktuellerSpieler.getPosition() instanceof Aktionsfeld){
            finished = false;

            System.out.println("start"+System.currentTimeMillis());

                ((Aktionsfeld) aktuellerSpieler.getPosition()).starteMinispiel();


        }

        if(finished){
            nextSpieler();
        }


    }

    public static void updateOberflache(){
        wuerfel1Lable.setText("");
        wuerfel2Lable.setText("");
        wuerfelSUMLable.setText("");
        wurfel2ImageView.setVisible(false);

        if(aktuellerSpieler.getWuerfelList().size()>1){
            wurfel2ImageView.setVisible(true);
            wurfel2ImageView.setImage(aktuellerSpieler.getWuerfelList().get(1).getBild());
        }

        aktuellerSpielerEllipse.setFill(aktuellerSpieler.getFarbe());
        aktuellerSpielerLable.setText(aktuellerSpieler.getName());
        nichtAktuellerSpielerEllipse.setFill(naesterSpieler.getFarbe());
        nichtAktuellerSpielerLable.setText(naesterSpieler.getName());


    }

    public static Spieler[] getSpieler() {
        return spieler;
    }

    public static void main(String[] args) {
        launch();
    }

}