package com.example.minimarioparty.Huerdenlauf;

import com.example.minimarioparty.Minispiel;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Huerdenlauf extends Minispiel {
    private Stage stage;
    private PlayerObj player;
    private PlayerObj com;
    private List<Hurdle> pHurdles;
    private List<Hurdle> cHurdles;
    Pane playerPane = new Pane();
    Pane computerPane = new Pane();
    private AnimationTimer playerGame;
    private AnimationTimer comGame;
    private boolean isJumping = false;
    private int playerCount;
    private int comCount;
    private Label playerCounterLabel;
    private Label comCounterLabel;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        spielanleitungText = "TestAnleitung. ";
        MinispielTitleLabel.setText("TestTitel");
        MinispielSchwierigkeitLable.setText("leicht");

        Button b = new Button("Ready?");
        b.setPrefSize(100, 100);
        b.setLayoutX(450);
        b.setLayoutY(400);
        b.setOnAction(event -> {
            System.out.println("Button pressed");
            b.setVisible(false);

            playerPane.setPrefSize(850, 350);
            playerPane.setStyle("-fx-background-color: white;");
            playerPane.setLayoutY(100);

            player = new PlayerObj(50, 250, 50, 50,Color.BLUE);
            pHurdles = new ArrayList<>();

            playerPane.getChildren().add(player);
            playerCount = 0;
            playerCounterLabel = new Label(Integer.toString(playerCount)); // Initialwert des Counters
            playerCounterLabel.setLayoutX(playerPane.getPrefWidth() / 2 - 10); // Position des Labels in der Mitte oben
            playerCounterLabel.setLayoutY(10);

            playerPane.getChildren().add(playerCounterLabel);

            p.getChildren().add(playerPane); // PlayerPane zur Haupt-Pane hinzufügen
            playerGame = new AnimationTimer() {
                private long lastUpdate = 0;
                @Override
                public void handle(long now) {
                    if (now - lastUpdate >= 100_000_000) { // 100 Millisekunden in Nanosekunden
                        addHurdles(playerPane,pHurdles);
                        updateGame(playerPane,pHurdles);
                        lastUpdate = now;
                    }
                }
            };


            computerPane.setPrefSize(850, 350);
            computerPane.setStyle("-fx-background-color: white;");
            computerPane.setLayoutY(450);

            com = new PlayerObj(50, 250, 50, 50, Color.BLACK);
            cHurdles  = new ArrayList<>();

            computerPane.getChildren().add(com);
            comCount = 0;
            comCounterLabel = new Label(Integer.toString(comCount)); // Initialwert des Counters
            comCounterLabel.setLayoutX(computerPane.getPrefWidth() / 2 - 10); // Position des Labels in der Mitte oben
            comCounterLabel.setLayoutY(10);
            computerPane.getChildren().add(comCounterLabel);

            p.getChildren().add(computerPane); // PlayerPane zur Haupt-Pane hinzufügen

            comGame = new AnimationTimer() {
                private long lastUpdate = 0;
                @Override
                public void handle(long now) {
                    if (now - lastUpdate >= 100_000_000) { // 100 Millisekunden in Nanosekunden
                        addHurdles(computerPane, cHurdles);
                        updateGame(computerPane, cHurdles);
                        lastUpdate = now;
                    }
                }
            };


            playerGame.start();
            comGame.start();

        });

        // Erfassen der Tastatureingaben
        p.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SHIFT && player != null) {
                System.out.println("Key Pressed");
                jump(player);
            }
        });

        p.getChildren().addAll(b); // Nur den Button zur Haupt-Pane hinzufügen
        super.start(stage);
    }

    public void updateGame(Pane pane, List<Hurdle> hurdles) {
        boolean pGame;
        if (pane == playerPane){
             pGame= true;
        } else
            pGame = false;

        moveHurdles(hurdles);
        removePassedHurdles(pane,hurdles,pGame);
        if (checkCollision(hurdles,pGame)) {
            stopGame(pGame);
        }
        Platform.runLater(() -> p.requestLayout());
    }

    public void moveHurdles(List<Hurdle> hurdles) {
        for (Hurdle hurdle : hurdles) {
            hurdle.move(25); // 25 schwer 30 einfach
        }
    }

    public void removePassedHurdles(Pane pane, List<Hurdle> hurdles, boolean pGame) {
        int removedHurdleCount = 0; // Variable zum Zählen der entfernten Hürden
        Iterator<Hurdle> iterator = hurdles.iterator();
        while (iterator.hasNext()) {
            Hurdle hurdle = iterator.next();
            if (hurdle.getX() + hurdle.getWidth() < 90 && hurdle.getX() > -20) {
                iterator.remove();
                Platform.runLater(() -> pane.getChildren().remove(hurdle));
                removedHurdleCount++; // Anzahl der entfernten Hürden erhöhen
            }
        }

        // Zähler separat aktualisieren, basierend auf der Anzahl der entfernten Hürden
        if (pGame && removedHurdleCount  > 0) {
            playerCount += removedHurdleCount;
            playerCounterLabel.setText(Integer.toString(playerCount));
        }
        if (!pGame && removedHurdleCount > 0){
            comCount += removedHurdleCount;
            comCounterLabel.setText(Integer.toString(comCount));
        }
    }

    public boolean checkCollision(List<Hurdle> hurdles,boolean pGame) {
        PlayerObj playerObj = pGame ? player : com;
        for (Hurdle hurdle : hurdles) {
            if (playerObj.getRectangle().intersects(hurdle.getX(), hurdle.getY(), hurdle.getWidth(), hurdle.getHeight())) {
                return true; // Kollision gefunden
            }
        }
        return false; // Keine Kollision gefunden
    }

    public void addHurdles(Pane pane, List<Hurdle> hurdles) {
        if (Math.random() < 0.3) {
            int hurdleWidth = 30;
            int hurdleHeight = 50;
            int hurdleX = (int) pane.getWidth() ;
            int hurdleY = (int) (pane.getHeight() - hurdleHeight - 50);

            int hurdleSpacing = (int) (Math.random() * 101) + 200;

            if (hurdles.isEmpty() || (hurdles.get(hurdles.size() - 1).getX() + hurdleSpacing < pane.getWidth())) {
                Hurdle newHurdle = new Hurdle(hurdleX, hurdleY, hurdleWidth, hurdleHeight);
                hurdles.add(newHurdle);

                Platform.runLater(() -> pane.getChildren().add(newHurdle));
            }
        }
    }

    public void jump(PlayerObj o) {
        if (!isJumping && o != null) {
            isJumping = true;
            new Thread(() -> {
                for (int i = 0; i < 30; i++) {
                    o.moveUp(6);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 30; i++) {
                    o.moveDown(6);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isJumping = false;
            }).start();
        }
    }

    public void stopGame(boolean pGame) {
        if(pGame){
            playerGame.stop();
            System.out.println("Player Game Over!");
        }
        if(!pGame){
            comGame.stop();
            System.out.println("Computer Game Over!");}
    }
}
