package com.example.minimarioparty.BlackJack;

import com.example.minimarioparty.Minispiel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class BlackJackMinispiel extends Minispiel {

    private Stage stage;
    Pane spielfeldPane = new Pane();







    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        //Spielfeld erstellen
        spielfeldPane.setPrefSize( 1000, 700);
        spielfeldPane.setLayoutY(100);
        p.getChildren().add(spielfeldPane);

        //Hintergrund erstellen
        Image spielfeldBild = new Image("hintergrundblackjack.jpg");
        ImageView spielfeld =  new ImageView();
        spielfeld.setFitWidth(1000);
        spielfeld.setFitHeight(700);
        spielfeld.setImage(spielfeldBild);


        spielfeldPane.getChildren().add(spielfeld);













        super.start(stage);
    }
}
