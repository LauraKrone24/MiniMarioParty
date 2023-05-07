package com.example.minimarioparty.Minispiele.Test2;

import com.example.minimarioparty.Minispiel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestApp2 extends Minispiel {

    @Override
    public void start(Stage primaryStage) throws IOException{
        URL url = new File("src/main/resources/com/example/minimarioparty/test2.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}