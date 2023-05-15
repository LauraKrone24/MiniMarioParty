package com.example.minimarioparty.BlackJack;

import com.example.minimarioparty.Minispiel;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackJackMinispiel extends Minispiel {

    private Stage stage;







    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        super.start(stage);
    }
}
