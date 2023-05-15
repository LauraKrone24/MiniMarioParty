package com.example.minimarioparty.TicTacToe;

import com.example.minimarioparty.Minispiel;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeMinispiel extends Minispiel {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        spielanleitungText = "veränderung TicTacToe ist ein Spiel";

        super.start(stage);
    }
}

