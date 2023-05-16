package com.example.minimarioparty.Kniffel;

import com.example.minimarioparty.Minispiel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KniffelMiniSpiel extends Minispiel {
    private Stage stage;
    private final Pane spielfeldPane = new Pane();
    private int punkteSpieler = 0;
    private int punkteComuter = 0;



    // Label Tabelle Geruest
    Label einerLabel = new Label("Einer");
    Label zweierLabel = new Label("Zweier");
    Label dreierLabel = new Label("Dreier");
    Label viererLabel = new Label("Vierer");
    Label fuenferLabel = new Label("Fuenfer");
    Label sechserLabel = new Label("Sechser");
    Label zwischensummeLabel1 = new Label("Zwischensumme 1");
    Label drillingLabel = new Label("Drilling");
    Label vierlingLabel = new Label("Vierling");
    Label fullHouseLabel = new Label("Full House");
    Label kleineStrasseLabel = new Label("Kleine Straße");
    Label grosseStrasseLabel = new Label("Große Straße");
    Label kniffelLabel = new Label("Fünf Mal gleiche Augenzahl");
    Label zwischensummeLabel2 = new Label("Zwischensumme 2");
    Label endsummeLabel = new Label("Endsumme");

    // Label Tabelle fuer Spieler
    Label einerLabelSpieler = new Label();
    Label zweierLabelSpieler = new Label();
    Label dreierLabelSpieler = new Label();
    Label viererLabelSpieler = new Label();
    Label fuenferLabelSpieler = new Label();
    Label sechserLabelSpieler = new Label();
    Label zwischensummeLabel1Spieler = new Label();
    Label drillingLabelSpieler = new Label();
    Label vierlingLabelSpieler = new Label();
    Label fullHouseLabelSpieler = new Label();
    Label kleineStrasseLabelSpieler = new Label();
    Label grosseStrasseLabelSpieler = new Label();
    Label kniffelLabelSpieler = new Label();
    Label zwischensummeLabel2Spieler = new Label();
    Label endsummeLabelSpieler = new Label();

    // Label Tabelle fuer Computer
    Label einerLabelComputer = new Label();
    Label zweierLabelComputer = new Label();
    Label dreierLabelComputer = new Label();
    Label viererLabelComputer = new Label();
    Label fuenferLabelComputer = new Label();
    Label sechserLabelComputer = new Label();
    Label zwischensummeLabel1Computer = new Label();
    Label drillingLabelComputer = new Label();
    Label vierlingLabelComputer = new Label();
    Label fullHouseLabelComputer = new Label();
    Label kleineStrasseLabelComputer = new Label();
    Label grosseStrasseLabelComputer = new Label();
    Label kniffelLabelComputer = new Label();
    Label zwischensummeLabel2Computer = new Label();
    Label endsummeLabelComputer = new Label();


    Wuerfelinitialisieren test = new Wuerfelinitialisieren();
    List<Wuerfel> wuerfelListe = test.getWuerfelListe();
    List<ImageView> erstellteWuerfelSpieler = new ArrayList<>();
    List<ImageView> erstellteWuerfelComputer = new ArrayList<>();
    Button wuerfeln = new Button("wuerfeln");
    Button behalten = new Button("behalten");
    Button weiterWuerfeln = new Button("weiter");
    Button beenden = new Button("Zug beenden");
    @Override
    public void start(Stage stage) throws IOException{
      this.stage = stage;

      // Spielfeld
      spielfeldPane.setPrefSize(1000, 700);
      spielfeldPane.setStyle("-fx-background-color: #000000");
      spielfeldPane.setLayoutY(100);
      p.getChildren().add(spielfeldPane);


      // Hintergrund
      Image spielfeldBild = new Image("kniffelHintergrund.jpg");
      ImageView spielfeld = new ImageView();
      spielfeld.setFitHeight(1000);
      spielfeld.setFitHeight(800);
      spielfeld.setImage(spielfeldBild);


      wuerfeln.setLayoutX(200);
      wuerfeln.setLayoutY(500);
      wuerfeln.setPrefWidth(150);
      wuerfeln.setPrefHeight(50);


      behalten.setLayoutX(300);
      behalten.setLayoutY(500);
      behalten.setPrefWidth(150);
      behalten.setPrefHeight(50);


      einerLabel.setLayoutX(100);
      einerLabel.setLayoutY(100);
      einerLabel.setPrefWidth(150);
      einerLabel.setPrefHeight(50);

      zweierLabel.setLayoutX(110);
      zweierLabel.setLayoutY(110);
      zweierLabel.setPrefWidth(150);
      zweierLabel.setPrefHeight(50);


      ImageView wuerfelC1 = new ImageView();
      wuerfelC1.setFitWidth(80);
      wuerfelC1.setFitHeight(120);
      wuerfelC1.setLayoutX(350);
      wuerfelC1.setLayoutY(75);

      // Labels, Buttons etc. dem Spielfeld hinzufügen
      p.getChildren().addAll(einerLabel,zweierLabel); //,dreierLabel,viererLabel,fuenferLabel,sechserLabel,zwischensummeLabel1, drillingLabel, viererLabel, fullHouseLabel, kleineStrasseLabel, grosseStrasseLabel, kniffelLabel, zwischensummeLabel2, endsummeLabel);
      //p.getChildren().addAll(einerLabelSpieler,zweierLabelSpieler,dreierLabelSpieler,viererLabelSpieler,fuenferLabelSpieler,sechserLabelSpieler,zwischensummeLabel1Spieler, drillingLabelSpieler, viererLabelSpieler, fullHouseLabelSpieler, kleineStrasseLabelSpieler, grosseStrasseLabelSpieler, kniffelLabelSpieler, zwischensummeLabel2Spieler, endsummeLabelSpieler);
      //p.getChildren().addAll(einerLabelComputer,zweierLabelComputer,dreierLabelComputer,viererLabelComputer,fuenferLabelComputer,sechserLabelComputer,zwischensummeLabel1Computer, drillingLabelComputer, viererLabelComputer, fullHouseLabelComputer, kleineStrasseLabelComputer, grosseStrasseLabelComputer, kniffelLabelComputer, zwischensummeLabel2Computer, endsummeLabelComputer);
      //p.getChildren().addAll(wuerfeln, behalten, weiterWuerfeln, beenden);
      //p.getChildren().addAll(erstellteWuerfelSpieler);
      //p.getChildren().addAll(erstellteWuerfelComputer);
      p.getChildren().addAll(spielfeld);





      super.start(stage);

  }

}
