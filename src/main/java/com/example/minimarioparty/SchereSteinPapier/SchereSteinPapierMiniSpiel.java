package com.example.minimarioparty.SchereSteinPapier;

import com.example.minimarioparty.GuterWuerfel;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.SchlechterWuerfel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.text.DecimalFormat;

public class SchereSteinPapierMiniSpiel extends Minispiel {

    private Stage stage;
    private  final Pane spielfeld = new Pane();
    private final Pane spielstandPane = new Pane();




    @Override
    public void start(Stage stage) throws IOException{

        this.stage = stage;

        spielanleitungText = "Schere, Stein, Papier oder auch Schnick, Schnack, Schnuck ist ein beliebtes und super einfaches Kinderspiel. Du benötigst nur deine Finger um das gewünschte Symbol auszuwählen und einen Gegner und schon kann der Spaß beginnen.\n" +
                "\n" +
                "Das Spiel beinhaltet in seiner Ursprungsform drei Gesten: für Schere, Stein, Papier. Diese werden als Symbole mit der Hand dargestellt. \n" +
                "\n" +
                "Das Ziel der Spieler:innen liegt darin, eine höherwertige Geste als der Gegner zu spielen. So ist die Rangfolge:\n" +
                "\n" +
                "Stein schlägt Schere (Denn der Stein kann die Schere schleifen.)\n" +
                "Schere schlägt Papier (Denn die Schere kann das Papier schneiden.)\n" +
                "Papier schlägt Stein (Denn das Papier kann den Stein einwickeln.)\n" +
                "Du wählst nun ein Symbol aus und der Computer wird über ein Zufallssystem sein Symbol auswählen\n" +
                "\n" +
                "Jedes Symbol verliert oder gewinnt gegen jeweils ein anderes Symbol. Oft werden mehrere Runden hintereinander gespielt und der Spieler mit den meisten Siegen am Ende gewinnt.";


        Button b = new Button("Starte Game");
        b.setPrefSize(100, 100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        p.getChildren().add(b);
        b.setOnAction(event -> {
            System.out.println("Button wurde gedrückt");
            Platform.runLater(()->b.setVisible(false));

            spielfeld.setPrefSize(700, 600);
            spielfeld.setLayoutX(75);
            spielfeld.setLayoutY(150);
            spielfeld.setStyle("-fx-background-color: #3f888f;");
            p.getChildren().add(spielfeld);

            Button schere = new Button("Schere");
            schere.setLayoutX(51);
            schere.setLayoutY(491);
            schere.setPrefWidth(150);
            schere.setPrefHeight(40);
            spielfeld.getChildren().add(schere);

            Button stein = new Button("Stein");
            stein.setLayoutX(275);
            stein.setLayoutY(491);
            stein.setPrefWidth(150);
            stein.setPrefHeight(40);
            spielfeld.getChildren().add(stein);

            Button papier = new Button("Papier");
            papier.setLayoutX(495);
            papier.setLayoutY(491);
            papier.setPrefWidth(150);
            papier.setPrefHeight(40);
            spielfeld.getChildren().add(papier);

            spielstandPane.setPrefSize(200, 200);
            spielstandPane.setLayoutX(786);
            spielstandPane.setLayoutY(150);
            spielstandPane.setStyle("-fx-background-color: #a1cf9a;");
            p.getChildren().add(spielstandPane);

            Label spielstand = new Label("Spielstand");
            spielstand.setPrefWidth(200);
            spielstand.setPrefHeight(50);
            spielstand.setFont(new Font("Arial", 30));
            spielstand.setAlignment(Pos.CENTER);
            spielstandPane.getChildren().add(spielstand);

            Pane innerPaneSpielstand = new Pane();
            innerPaneSpielstand.setLayoutY(50);
            innerPaneSpielstand.setPrefWidth(200);
            innerPaneSpielstand.setPrefHeight(150);
            innerPaneSpielstand.setStyle("-fx-background-color: #000000;");
            spielstandPane.getChildren().add(innerPaneSpielstand);



            Label spieler =new Label("Spieler");
            spieler.setLayoutX(18);
            spieler.setLayoutY(15);
            spieler.setFont(new Font("Arial", 21));
            innerPaneSpielstand.getChildren().add(spieler);

            Label computer =new Label("Computer");
            computer.setLayoutX(134);
            computer.setLayoutY(15);
            computer.setFont(new Font("Arial", 21));
            innerPaneSpielstand.getChildren().add(computer);






        } );













        super.start(stage);


    }


}
