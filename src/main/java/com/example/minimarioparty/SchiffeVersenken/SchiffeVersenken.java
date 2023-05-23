package com.example.minimarioparty.SchiffeVersenken;

import com.example.minimarioparty.Hauptgame.GuterWuerfel;
import com.example.minimarioparty.Hauptgame.SchlechterWuerfel;
import com.example.minimarioparty.Minispiel;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SchiffeVersenken extends Minispiel {


    private static Stage stage;
    private static GridPane Pgame;
    private static GridPane Cgame;
    private static Pane WL;
    private Button[][] Pbuttons;
    private Button[][] Cbuttons;
    public static int Ccounter = 10;
    public static int Pcounter = 10;
    private static Label CcounterL;
    public static Label PcounterL;
    public static Label PlayerL;
    public static Label ComputerL;
    public int[][] Pboats;
    public int[][] Cboats;
    public static Label PlayerLoose;
    public static Label PlayerWins;

    private static Button end;
    public static Label ActionL;
    public int[][] shots = new int[6][6];
    public static boolean Pwin = false;
    public boolean l = leicht;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        System.out.println(leicht);

        MinispielTitleLabel.setText("Schiffe Versenken");

        spielanleitungText =
                "Du spielst den Spielmodus U-Boot-Jagd, dass bedeutet das es nur ein-kästchen schiffe gibt (U-Boote). Die U-Boote werden zu beginn des " +
                "Spiels für dich und den Computer zufällig generiert (Schiffe können direkt an einander liegen). Deine U-Boote sind in Blau gekennzeichnet, verfehlte schüsse mit dem XXX und zerstörte U-Boote in rot." +
                " Du bist als erstes am Zug, klicke auf eines der Felder des gegners (rechtes Spielfeld), triffst du (rote markierung) darfst du erneut feuern während dein " +
                        "Gegner aussetzen muss. Wer zuerst die Flotte des Gegners zerstört gewinnt." +
                        "                                                               VIEL GLÜCK & SPAß!";



        Pcounter = 10;
        Ccounter = 10;

        CcounterL = new Label();
        CcounterL.setText("Verbleibende U-Boote: " + " " + Ccounter);
        CcounterL.setPrefSize(1000,100);
        CcounterL.setLayoutX(560);
        CcounterL.setLayoutY(100);
        CcounterL.setFont(new Font("system",20));
        CcounterL.setTextFill(Color.BLACK);

        PcounterL = new Label();
        PcounterL.setText("Verbleibende U-Boote: " + " " + Pcounter);
        PcounterL.setPrefSize(1000,100);
        PcounterL.setLayoutX(100);
        PcounterL.setLayoutY(100);
        PcounterL.setFont(new Font("system",20));
        PcounterL.setTextFill(Color.BLACK);

        PlayerL = new Label();
        PlayerL.setText("Spieler");
        PlayerL.setPrefSize(1000,100);
        PlayerL.setLayoutX(100);
        PlayerL.setLayoutY(70);
        PlayerL.setFont(new Font("system",20));
        PlayerL.setTextFill(Color.BLACK);

        ComputerL = new Label();
        ComputerL.setText("Computer");
        ComputerL.setPrefSize(1000,100);
        ComputerL.setLayoutX(560);
        ComputerL.setLayoutY(70);
        ComputerL.setFont(new Font("system",20));
        ComputerL.setTextFill(Color.BLACK);

        ActionL = new Label();
        ActionL.setText("DU BIST DRAN!");
        ActionL.setPrefSize(1000, 100);
        ActionL.setLayoutX(100);
        ActionL.setLayoutY(600);
        ActionL.setFont(new Font("system",20));
        ActionL.setTextFill(Color.RED);

        PlayerLoose = new Label();
        PlayerLoose.setText("Du hast verloren und erhältst keinen Würfel!");
        PlayerLoose.setPrefSize(500,100);
        PlayerLoose.setLayoutX(300);
        PlayerLoose.setLayoutY(200);
        PlayerLoose.setFont(new Font("system",20));
        PlayerLoose.setTextFill(Color.BLACK);
        PlayerLoose.setVisible(false);

        PlayerWins = new Label();
        PlayerWins.setText("Du hast gewonnen und erhältst einen schlechten Würfel!");
        PlayerWins.setPrefSize(500,100);
        PlayerWins.setLayoutX(300);
        PlayerWins.setLayoutY(200);
        PlayerWins.setFont(new Font("system",20));
        PlayerWins.setTextFill(Color.BLACK);
        PlayerWins.setVisible(false);

        end = new Button();
        end.setText("Zurück zur Lobby");
        end.setPrefSize(400,100);
        end.setLayoutX(325);
        end.setLayoutY(350);
        end.setFont(new Font("system",20));
        end.setOnAction(EndClickHandler);
        end.setVisible(false);

        generateBoats();
        initPgame();
        initCgame();
        ColorPboats();
        ColorCgame();
        p.getChildren().addAll(CcounterL, PcounterL, PlayerL,ComputerL,PlayerLoose,PlayerWins,end, ActionL);

        super.start(stage);

        }


    private void initPgame(){

        Pgame = new GridPane();
        Pgame.setLayoutX(100);
        Pgame.setLayoutY(200);

        int col = 0;
        int row = 0;
        Pbuttons = new Button[6][6];
        while(col < 6){

            while(row < 6){
                Button button = new Button();
                Pgame.add(button, col, row);
                Pbuttons[row][col] = button;

                Pbuttons[row][col].setStyle("-fx-border-color: black");
                button.setPrefSize(60, 60);
                Pgame.getChildren().addAll();
                row++;
            }
            row = 0;
            col = col + 1;


        }
        p.getChildren().addAll(Pgame);



    }

    EventHandler<ActionEvent> EndClickHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            cancel();
        }
    };

    public void generateBoats(){
        Pboats = new int[6][6];
        Cboats = new int[6][6];
        int i = 0;
        int z = 0;


            while(i < 10 ) {

                int x = (int) (Math.random() * 6);
                int y = (int) (Math.random() * 6);
                if (Pboats[x][y] == 1) {

                    continue;

                } else if (Pboats[x][y] == 0) {
                    Pboats[x][y] = 1;

                    i++;
                }
            }
            while(z < 10){
                int x2 = (int) (Math.random() * 6);
                int y2 = (int) (Math.random() * 6);

                if(Cboats[x2][y2] == 1){

                    continue;

                } else if (Cboats[x2][y2] == 0) {

                    Cboats[x2][y2] = 1;

                    z++;
                }


            }


    }

    public void ColorPboats(){

        int row = 0;
        int col = 0;

        while(col < 6){

            if(Pboats[row][col]==1){

                Pbuttons[row][col].setStyle("-fx-background-color: blue; -fx-border-color: black");
                row++;

            }
            else{
                row++;
            }
            if(!(row < 6)){
                row = 0;
                col++;
            }



        }

    }

    private static class CButtonClickHandler implements EventHandler<ActionEvent> {
        private int row;
        private int column;
        private Label label1;
        private Label label2;
        private Label action;
        private int counter1;
        private int counter2;
        private int[][] Cboats;
        private int[][] Pboats;
        private Button[][] Pbuttons;
        private Button[][] Cbuttons;
        private int[][] shots;
        private boolean l;



        public CButtonClickHandler(int row, int column, Label label1, int counter1, Label label2, int counter2, int[][] Cboats, int[][] Pboats, Button[][] Pbuttons, Button[][] Cbuttons, Label action, int[][] shots, boolean l) {
            this.row = row;
            this.column = column;
            this.label1 = label1;
            this.counter1 = counter1;
            this.label2 = label2;
            this.counter2 = counter2;
            this.Cboats = Cboats;
            this.Pboats = Pboats;
            this.Pbuttons = Pbuttons;
            this.Cbuttons = Cbuttons;
            this.action = action;
            this.shots = shots;
            this.l = l;
        }

        @Override
        public void handle(ActionEvent event) {


                boolean temp = true;
            if(!l) {
                if (Cboats[row][column] == 1) {
                    action.setText("TREFFER! DU DARFST NOCHMAL SCHIEßEN!");
                    Cboats[row][column] = 0;
                    Cbuttons[row][column].setStyle("-fx-background-color: red");
                    SchiffeVersenken.setCcounter(getCcounter() - 1);
                    label2.setText("Verbleibende U-Boote:" + " " + SchiffeVersenken.getCcounter());
                } else {

                    Cbuttons[row][column].setText("XXX");
                    int hits = 0;

                    while (temp) {

                        int x = (int) (Math.random() * 6);
                        int y = (int) (Math.random() * 6);

                        if (Pboats[x][y] == 1) {

                            Pboats[x][y] = 0;
                            Pbuttons[x][y].setStyle("-fx-background-color: red");
                            SchiffeVersenken.setPcounter(getPcounter() - 1);
                            label1.setText("Verbleibende U-Boote:" + " " + SchiffeVersenken.getPcounter());
                            shots[x][y] = 1;
                            hits++;

                        } else if (shots[x][y] == 0) {

                            Pbuttons[x][y].setText("XXX");
                            action.setText("DER COMPUTER HAT" + " " + hits + " " + "MAL GETROFFEN, DU BIST DRAN");
                            shots[x][y] = 1;
                            temp = false;
                        }

                    }


                }
            } else {
            if(Cboats[row][column] == 1){
                action.setText("TREFFER! DU DARFST NOCHMAL SCHIEßEN!");
                Cboats[row][column] = 0;
                Cbuttons[row][column].setStyle("-fx-background-color: red");
                SchiffeVersenken.setCcounter(getCcounter()-1);
                label2.setText("Verbleibende U-Boote:" + " " + SchiffeVersenken.getCcounter());
            }
            else {

                Cbuttons[row][column].setText("XXX");
                int hits = 0;

                while(temp) {

                    int x = (int) (Math.random() * 6);
                    int y = (int) (Math.random() * 6);

                    if(Pboats[x][y] == 1){

                        Pboats[x][y] = 0;
                        Pbuttons[x][y].setStyle("-fx-background-color: red");
                        SchiffeVersenken.setPcounter(getPcounter()-1);
                        label1.setText("Verbleibende U-Boote:" + " " + SchiffeVersenken.getPcounter());

                        hits++;

                    }else{

                        Pbuttons[x][y].setText("XXX");
                        action.setText("DER COMPUTER HAT" + " " + hits + " "+ "MAL GETROFFEN, DU BIST DRAN");

                        temp =false;
                    }

                }


            }





        }
            SchiffeVersenken.Gewinnueberpruefung();
        }

    }


    private void initCgame() {

        Cgame = new GridPane();
        Cgame.setLayoutX(560);
        Cgame.setLayoutY(200);
        int col = 0;
        int row = 0;
        Cbuttons = new Button[6][6];
        while (col < 6) {

            while (row < 6) {
                Button button = new Button();
                Cgame.add(button, col, row);
                Cbuttons[row][col] = button;
                Cbuttons[row][col].setOnAction(new CButtonClickHandler(row, col, PcounterL, Pcounter, CcounterL, Ccounter, Cboats, Pboats, Pbuttons, Cbuttons,ActionL,shots,l));
                Pbuttons[row][col].setStyle("-fx-border-color: black");
                button.setPrefSize(60, 60);
                Cgame.getChildren().addAll();
                row++;
                System.out.println("button" + " " + row + " " + col);
            }
            row = 0;
            col = col + 1;


        }
        p.getChildren().addAll(Cgame);
    }
    public void ColorCgame(){

        int row = 0;
        int col = 0;

        while(col < 6){

                Cbuttons[row][col].setStyle("-fx-border-color: black");
                row++;

            if(!(row < 6)){
                row = 0;
                col++;
            }



        }

    }

    public Label WL(int PlayerWin){




        if(PlayerWin == 1){

            Pgame.setVisible(false);
            Cgame.setVisible(false);
            PcounterL.setVisible(false);
            PlayerL.setVisible(false);
            CcounterL.setVisible(false);

            return PlayerWins;


        }else if(PlayerWin == -1){

            Pgame.setVisible(false);
            Cgame.setVisible(false);

            return PlayerLoose;

        }

        return null;

    }

    public static void Gewinnueberpruefung(){


        if(getPcounter() == 0){

            Pgame.setVisible(false);
            Cgame.setVisible(false);
            PcounterL.setVisible(false);
            PlayerL.setVisible(false);
            ComputerL.setVisible(false);
            CcounterL.setVisible(false);
            PlayerLoose.setVisible(true);
            ActionL.setVisible(false);
            end.setVisible(true);
            System.out.println("Game result:" + " " + "Player looses.");

        } else if (getCcounter() == 0) {

            Pgame.setVisible(false);
            Cgame.setVisible(false);
            PcounterL.setVisible(false);
            PlayerL.setVisible(false);
            ComputerL.setVisible(false);
            CcounterL.setVisible(false);
            PlayerWins.setVisible(true);
            ActionL.setVisible(false);
            end.setVisible(true);
            Pwin = true;
            System.out.println("Game result:" + " " + "Player wins.");



        }
        else{
            System.out.println("game continues...");

        }


    }

    public void cancel(){


        if(Pwin) {
            if (l) {
                minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());
            } else {
                minispielrueckgabewert.setWuerfel(new GuterWuerfel());
                end.setText("Du hast gewonnen und erhältst einen guten Würfel!");
            }
            minispielrueckgabewert.setWinner(spieler[0]);
        }else{
            minispielrueckgabewert.setWinner(spieler[1]);
        }
        minispielrueckgabewert.setAbbruch(false);
        stage.close();
    }

    public static int getCcounter() {
        return Ccounter;
    }

    public static int getPcounter() {
        return Pcounter;
    }

    public static void setCcounter(int ccounter) {
        Ccounter = ccounter;
    }

    public static void setPcounter(int pcounter) {
        Pcounter = pcounter;
    }


}






