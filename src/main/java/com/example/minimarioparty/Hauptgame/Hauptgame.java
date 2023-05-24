package com.example.minimarioparty.Hauptgame;

import com.example.minimarioparty.BallonPlatzen.BallonMiniSpiel;
import com.example.minimarioparty.BlackJack.BlackJackMinispiel;
import com.example.minimarioparty.Huerdenlauf.Huerdenlauf;
import com.example.minimarioparty.KniffelMiniSpiel.KniffelMinispiel;
import com.example.minimarioparty.Labyrinth.Labyrinth;
import com.example.minimarioparty.SchiffeVersenken.SchiffeVersenken;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.SchereSteinPapier.SchereSteinPapierMiniSpiel;
import com.example.minimarioparty.TicTacToe.TicTacToeMinispiel;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Hauptgame extends Application {
    private final static Spieler[] spieler = new Spieler[2];
    private static Boolean finished = true;
    private static int aktuellerSpieler;
    private static Stage stage;
    private static boolean gewonnen  = false;
    protected final static Feld[] felder = new Feld[100];
    protected static List<Minispiel> minispielListe = new LinkedList<>();


    private static Ellipse nichtAktuellerSpielerEllipse;
    private static Ellipse aktuellerSpielerEllipse;
    private static ImageView wurfel2ImageView;

    private static Label aktuellerSpielerLable;
    private static Label nichtAktuellerSpielerLable;
    private static Button wuefelbutton;
    private static Label wuerfelSUMLable = new Label();


    private static Ellipse figurSpieler;
    private static Ellipse figurComputer;


    @Override
    public void start(Stage stage) throws IOException {
        //Oberfläche erstellen

        Hauptgame.stage = stage;
        final String SPIELER1FARBE = "#7eb774";
        final String SPIELER2FARBE = "#ed7b84";

        Pane p = new Pane();
        p.setMinSize(1000,800);
        p.setMaxSize(1000,800);
        p.setStyle("-fx-background-color: #ffffff");

        Label MarioParty= new Label("Mini Mario\nParty");
        MarioParty.setLayoutX(800);
        MarioParty.setLayoutY(50);
        MarioParty.setPrefWidth(200);
        MarioParty.setFont(new Font("Arial black",25));
        MarioParty.setTextAlignment(TextAlignment.CENTER);
        p.getChildren().add(MarioParty);

        Label spielerreihenfolge= new Label("Spielerreihenfolge");
        spielerreihenfolge.setLayoutX(800);
        spielerreihenfolge.setLayoutY(150);
        spielerreihenfolge.setPrefWidth(200);
        spielerreihenfolge.setFont(new Font("System",20));
        spielerreihenfolge.setUnderline(true);
        p.getChildren().add(spielerreihenfolge);

        aktuellerSpielerEllipse = new Ellipse(10,10);

        nichtAktuellerSpielerEllipse = new Ellipse(10,10);

        aktuellerSpielerLable = new Label("",aktuellerSpielerEllipse);
        nichtAktuellerSpielerLable = new Label("",nichtAktuellerSpielerEllipse);

        GridPane gp = new GridPane();
        gp.setLayoutX(800);
        gp.setLayoutY(200);
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

        p.getChildren().addAll(wurfel1ImageView, wurfel2ImageView,wuerfelLable,wuefelbutton,wuerfelSUMLable);

        Image hintergrundimage = new Image("Spielbrett.jpg");
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
        //Dialog um Spielernamen eingeben zu lassen
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Gib deinen Namen ein");
        td.showAndWait();
        String spielername = td.getEditor().getText();

        //Spieler erstellen
        spieler[0]  = new Spieler(spielername,false,SPIELER1FARBE);
        spieler[1]  = new Spieler("Computer",true,SPIELER2FARBE);
        //Felder erstellen
        setFelder();

        // Minispiel objekte erstellen
        addMinispiele();

        //Startspieler wählen und Oberfläche updaten
        chooseStartspieler();
        updateOberflache();

        //Spiel anzeigen
        stage.show();

        // ggf. Computerzug starten
        if(aktuellerSpieler==1)zug();
    }

    private static void addMinispiele() {

        minispielListe.add(new Labyrinth());
        minispielListe.add(new Labyrinth());
        minispielListe.add(new Labyrinth());
        minispielListe.add(new Labyrinth());
        minispielListe.add(new BallonMiniSpiel());
        minispielListe.add(new BallonMiniSpiel());
        minispielListe.add(new BallonMiniSpiel());
        minispielListe.add(new BallonMiniSpiel());
        minispielListe.add(new BlackJackMinispiel());
        minispielListe.add(new BlackJackMinispiel());
        minispielListe.add(new BlackJackMinispiel());
        minispielListe.add(new BlackJackMinispiel());
        minispielListe.add(new TicTacToeMinispiel());
        minispielListe.add(new TicTacToeMinispiel());
        minispielListe.add(new TicTacToeMinispiel());
        minispielListe.add(new TicTacToeMinispiel());
        minispielListe.add(new KniffelMinispiel());
        minispielListe.add(new KniffelMinispiel());
        minispielListe.add(new KniffelMinispiel());
        minispielListe.add(new KniffelMinispiel());
        minispielListe.add(new SchereSteinPapierMiniSpiel());
        minispielListe.add(new SchereSteinPapierMiniSpiel());
        minispielListe.add(new SchereSteinPapierMiniSpiel());
        minispielListe.add(new SchereSteinPapierMiniSpiel());
        minispielListe.add(new Huerdenlauf());
        minispielListe.add(new Huerdenlauf());
        minispielListe.add(new Huerdenlauf());
        minispielListe.add(new Huerdenlauf());
        minispielListe.add(new SchiffeVersenken());
        minispielListe.add(new SchiffeVersenken());
        minispielListe.add(new SchiffeVersenken());
        minispielListe.add(new SchiffeVersenken());

    }

    private static void setFelder(){
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
                if(feld.getNumber()!=100){
                    felder[speicher -1] = new Aktionsfeld(speicher,a,b);
                }


            }

        }






    }

    private static void chooseStartspieler(){
        //zufällige Wahl des Startspielers
        double  i = Math.random();
        if(i<=0.5){
            changeSpieler();
        }
    }

    private static void changeSpieler(){
        aktuellerSpieler = (aktuellerSpieler-1)*(aktuellerSpieler-1);
    }

    public static void nextSpieler(){
        finished = true;
        //Spielerwechsel
        changeSpieler();
        //Updated der Oberfläche nach Pause
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> updateOberflache());
        pause.play();
        //Nach Pause Computerzug bzw. Würfelbutton freigeben
        PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
        pause2.setOnFinished(event -> {

            if(aktuellerSpieler==1){
                zug();
            }else{
                wuefelbutton.setVisible(true);
            }

        });
        pause2.play();

    }

    private static void zug(){
        wuefelbutton.setVisible(false);
        //Spieler bewegen
        wuerfelSUMLable.setText(String.valueOf(spieler[aktuellerSpieler].bewegeSpieler()));

        if(aktuellerSpieler==1){
            figurComputer.setLayoutX(spieler[aktuellerSpieler].getPosition().getX()+50);
            figurComputer.setLayoutY(spieler[aktuellerSpieler].getPosition().getY()+50);

        }else{
            figurSpieler.setLayoutX(spieler[aktuellerSpieler].getPosition().getX()+25);
            figurSpieler.setLayoutY(spieler[aktuellerSpieler].getPosition().getY()+25);

        }
        //ggf. Minispiel warten
        if(spieler[aktuellerSpieler].getPosition() instanceof Aktionsfeld){
            finished = false;

            ((Aktionsfeld) spieler[aktuellerSpieler].getPosition()).starteMinispiel();


        }
        //Gewinnabfrage
        if(gewonnen){
            gewinner(spieler[aktuellerSpieler]);
        } else if (finished) {
            nextSpieler();
        }

    }
    private static void gewinner(Spieler gewinner){
        //Ausgabe des Gewinners
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Spiel beendet");

        alert.setHeaderText("Spiel beendet");

        if(gewinner.isComputer()){
            alert.setContentText("Du hast leider verloren. Der Computer war wohl schneller als du!");

            alert.setHeaderText("Verloren");
        }
        else {
            alert.setContentText("Herzlichen Glückwunsch, " + gewinner.getName() + "! Der Computer konnte kaum mit dir mithalten");
            alert.setHeaderText("Gewonnen");
        }
        alert.show();

        //Schließen des Spiels
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event ->  stage.close());
        pause.play();

    }

    private static void updateOberflache(){

        wuerfelSUMLable.setText("");
        wurfel2ImageView.setVisible(false);

        //ggf. zweiten Würfel einblenden
        if(spieler[aktuellerSpieler].getWuerfelList().size()>1){
            wurfel2ImageView.setVisible(true);
            wurfel2ImageView.setImage(spieler[aktuellerSpieler].getWuerfelList().get(1).getBild());
        }
        //Reihenfolge updaten
        aktuellerSpielerEllipse.setFill(spieler[aktuellerSpieler].getFarbe());
        aktuellerSpielerLable.setText(spieler[aktuellerSpieler].getName());
        int naesterSpieler = (aktuellerSpieler-1)*(aktuellerSpieler-1);
        nichtAktuellerSpielerEllipse.setFill(spieler[naesterSpieler].getFarbe());
        nichtAktuellerSpielerLable.setText(spieler[naesterSpieler].getName());


    }

    //getter und setter methoden
    public static Spieler[] getSpieler() {
        return spieler;
    }

    public static void  setGewonnen(boolean gewonnen) {
        Hauptgame.gewonnen = gewonnen;
    }

    public static void main(String[] args) {
        launch();
    }

}