package com.example.minimarioparty.SchiffeVersenken;

import com.example.minimarioparty.Minispiel;


import java.io.IOException;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.Hauptgame.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchiffeVersenken extends Minispiel {


    private  Stage stage;
    int Ppunktestand = 0;
    int Cpunktestand = 0;
    private GridPane Pgame;
    private GridPane Cgame;
    private Button[][] Pbuttons;
    private Button[][] Cbuttons;
    private int Ccounter;
    public int Pcounter;
    private Label CcounterL;
    public Label PcounterL;
    public int[][] Pboats;
    public int[][] Cboats;


    @Override
    public void start(Stage stage) throws IOException {


        MinispielTitleLabel.setText("Schiffe Versenken");

        spielanleitungText = "";


        Pcounter = 4;
        Ccounter = 4;

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
        initPgame();
        initCgame();
        generateBoats();

        p.getChildren().addAll(CcounterL, PcounterL);
        super.start(stage);




        }


    private void initPgame(){

        Pgame = new GridPane();
        Pgame.setLayoutX(100);
        Pgame.setLayoutY(200);
        PButtonClickHandler handler = new PButtonClickHandler();
        int col = 0;
        int row = 0;
        Pbuttons = new Button[6][6];
        while(col < 6){

            while(row < 6){
                Button button = new Button();
                Pgame.add(button, col, row);
                Pbuttons[row][col] = button;
                Pbuttons[row][col].setOnAction(new PButtonClickHandler(row, col, PcounterL, Pcounter));
                button.setPrefSize(60, 60);
                Pgame.getChildren().addAll();
                row++;
            }
            row = 0;
            col = col + 1;


        }
        p.getChildren().addAll(Pgame);



    }

    private static class PButtonClickHandler implements EventHandler<ActionEvent> {
        private int row;
        private int column;
        private Label label;
        private int counter;

        public PButtonClickHandler(int row, int column, Label label, int counter) {
            this.row = row;
            this.column = column;
            this.label = label;
            this.counter = counter;
        }
        public PButtonClickHandler(){

        }

        @Override
        public void handle(ActionEvent event) {

            System.out.println("Button at row " + row + ", column " + column + " clicked");
            counter = counter -1;
            label.setText("Verbleibende U-Boote:" + " " + counter);
        }

    }
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
                    Pbuttons[x][y].setStyle("-fx-background-color: blue; -fx-border-color: black");
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
                    Cbuttons[x2][y2].setStyle("-fx-background-color: blue; -fx-border-color: black");
                    z++;
                }


            }

    }

    private static class CButtonClickHandler implements EventHandler<ActionEvent> {
        private int row;
        private int column;

        public CButtonClickHandler(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public void handle(ActionEvent event) {
            // Handle button click
            System.out.println("Button at row " + row + ", column " + column + " clicked");

        }
    }

    public void ChangeText(Label l, String s){

        l.setText(s);

    }
    private void initCgame(){

        Cgame = new GridPane();
        Cgame.setLayoutX(560);
        Cgame.setLayoutY(200);
        int col = 0;
        int row = 0;
        Cbuttons = new Button[6][6];
        while(col < 6){

            while(row < 6){
                Button button = new Button();
                Cgame.add(button, col, row);
                Cbuttons[row][col] = button;
                Cbuttons[row][col].setOnAction(new CButtonClickHandler(row, col));
                button.setPrefSize(60, 60);
                Cgame.getChildren().addAll();
                row++;
                System.out.println("button"+" "+row+" "+col);
            }
            row = 0;
            col = col + 1;


        }
        p.getChildren().addAll(Cgame);


    }
}




