package com.example.minimarioparty.Huerdenlauf;

import com.example.minimarioparty.Hauptgame.GuterWuerfel;
import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.Hauptgame.Normalerwuerfel;
import com.example.minimarioparty.Hauptgame.SchlechterWuerfel;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    private Pane playerPane;
    private Pane computerPane;
    private AnimationTimer playerGame;
    private AnimationTimer comGame;
    private int playerCount = 0;
    private int comCount = 0;
    private Label playerCounterLabel;
    private Label comCounterLabel;
    private Label startCounter;
    private Label winLoseLabel;
    private boolean pGameStopped = false;
    private boolean cGameStopped = false;


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        spielanleitungText = "Das Spiel ist ein Hürdenlauf, bei dem du als blauer Spieler über die Hürden springen musst. " +
                "Schaffe es, 5 Hürden weiter als der Computer zu kommen, um einen normalen Würfel zu erhalten. " +
                "Bei 10 Hürden mehr erhältst du einen guten Würfel, sonst einen schlechten Würfel. ";
        MinispielTitleLabel.setText("HürdenLauf");
        MinispielSchwierigkeitLable.setText("");

        startCounter = new Label();
        startCounter.setPrefSize(400, 50);
        startCounter.setFont(new Font(40));
        startCounter.setLayoutY(400);
        startCounter.setLayoutX(300);
        startCounter.setAlignment(Pos.CENTER);

        startCounter.setText("3");
        PauseTransition countdown3 = new PauseTransition(Duration.seconds(1));
        countdown3.setOnFinished(event -> {
            startCounter.setText("2");
            PauseTransition countdown2 = new PauseTransition(Duration.seconds(1));
            countdown2.setOnFinished(e -> {
                startCounter.setText("1");
                PauseTransition countdown1 = new PauseTransition(Duration.seconds(1));
                countdown1.setOnFinished(ev -> {
                    startCounter.setText("Los!");
                    PauseTransition countdownGo = new PauseTransition(Duration.seconds(1));
                    countdownGo.setOnFinished(evt -> {
                        initializePlayerPane();
                        initializeComputerPane();
                        playerGame.start();
                        comGame.start();
                    });
                    countdownGo.play();
                });
                countdown1.play();
            });
            countdown2.play();
        });
        countdown3.play();

        p.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W && player != null) {
                System.out.println("Key Pressed");
                Platform.runLater(() -> player.jump());
            }
        });

        winLoseLabel = new Label();
        winLoseLabel.setPrefSize(400,50);
        winLoseLabel.setFont(new Font(40));
        winLoseLabel.setLayoutY(400);
        winLoseLabel.setLayoutX(300);
        winLoseLabel.setAlignment(Pos.CENTER);
        winLoseLabel.setVisible(false);

        p.getChildren().addAll(startCounter,winLoseLabel);
        super.start(stage);
    }

    private void initializePlayerPane() {
        playerPane = createGamePane(100, 1000, 350);
        player = new PlayerObj(50, 250, 50, 50, Color.BLUE);
        pHurdles = new ArrayList<>();
        playerCount = 0;
        playerCounterLabel = createCounterLabel(playerPane, playerCount);

        Label jumpLabel = new Label("Press W to jump");
        jumpLabel.setLayoutX(playerPane.getPrefWidth() - jumpLabel.getWidth() - 150);
        jumpLabel.setLayoutY(10);
        jumpLabel.setFont(new Font(17));

        playerPane.getChildren().addAll(player, playerCounterLabel, jumpLabel);
        p.getChildren().add(playerPane);

        playerGame = createPlayerAnimationTimer();
    }

    private void initializeComputerPane() {
        computerPane = createGamePane(450, 1000, 350);
        com = new PlayerObj(50, 250, 50, 50, Color.BLACK);
        cHurdles = new ArrayList<>();
        comCount = 0;
        comCounterLabel = createCounterLabel(computerPane, comCount);

        computerPane.getChildren().addAll(com, comCounterLabel);
        p.getChildren().add(computerPane);

        comGame = createComputerAnimationTimer();
    }

    private Pane createGamePane(double layoutY, double prefWidth, double prefHeight) {
        Pane pane = new Pane();
        pane.setPrefSize(prefWidth, prefHeight);
        pane.setStyle("-fx-background-color: white;");
        pane.setLayoutY(layoutY);
        return pane;
    }

    private Label createCounterLabel(Pane pane, int count) {
        Label counterLabel = new Label(String.valueOf(count));
        counterLabel.setLayoutX(pane.getPrefWidth() / 2 - 10);
        counterLabel.setLayoutY(10);
        counterLabel.setFont(new Font(20));

        return counterLabel;
    }

    private AnimationTimer createPlayerAnimationTimer() {
        return new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 850_000) {
                    handlePlayerGame();
                    lastUpdate = now;
                }
            }
        };
    }

    private AnimationTimer createComputerAnimationTimer() {
        return new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 850_000) {
                    handleComGame();
                    lastUpdate = now;
                }
            }
        };
    }
    private void handlePlayerGame() {
        Platform.runLater(() -> {
            addHurdles(pHurdles, playerPane);
            moveHurdles(pHurdles);
            hurdleAhead(pHurdles, true, () -> {
                playerCounterLabel.setText(Integer.toString(++playerCount));
            });

            if (checkCollision(player, pHurdles)) {
                stopGame(true);
                gewinnauswertung();
            }
        });
    }
    private void handleComGame() {
        Platform.runLater(() -> {
            addHurdles(cHurdles, computerPane);
            moveHurdles(cHurdles);

            int randomJumpLimit = (int) (Math.random() * 11) + 10; // com Range 10 to 20

            if (comCount >= randomJumpLimit) {
            } else {
                hurdleAhead(cHurdles, false, () -> {
                    Platform.runLater(() -> com.jump());
                    comCounterLabel.setText(Integer.toString(++comCount));
                });
            }

            if (checkCollision(com, cHurdles)) {
                stopGame(false);
            }
        });
    }
    private void hurdleAhead(List<Hurdle> hurdles, boolean pGame, Runnable collisionAction) {
        PlayerObj obj = pGame ? player : com;
        Iterator<Hurdle> iterator = hurdles.iterator();
        while (iterator.hasNext()) {
            Hurdle hurdle = iterator.next();
            if ( hurdle.getX() == obj.getX() + 110) {
                collisionAction.run();
            }
        }
    }
    private void addHurdles(List<Hurdle> hurdles, Pane pane) {
        if (Math.random() < 0.2) {
            int hurdleWidth = 30;
            int hurdleHeight = 50;
            int hurdleX = (int) pane.getWidth();
            int hurdleY = (int) (pane.getHeight() - hurdleHeight - 50);

            int hurdleSpacing = (int) (Math.random() * 301) + 250;

            if (hurdles.isEmpty() || (hurdles.get(hurdles.size() - 1).getX() + hurdleSpacing < pane.getWidth())) {
                Hurdle newHurdle = new Hurdle(hurdleX, hurdleY, hurdleWidth, hurdleHeight);
                hurdles.add(newHurdle);
                pane.getChildren().add(newHurdle);
            }
        }
    }
    private void moveHurdles(List<Hurdle> hurdles) {
        for (Hurdle hurdle : hurdles) {
            Platform.runLater(() -> hurdle.move(4)); //15-20
        }
    }
    public boolean checkCollision(PlayerObj playerObj, List<Hurdle> hurdles) {
        for (Hurdle hurdle : hurdles) {
            if (playerObj.getRectangle().intersects(hurdle.getX(), hurdle.getY(), hurdle.getWidth(), hurdle.getHeight())) {
                return true;
            }
        }
        return false;
    }
    public void stopGame(boolean pGame) {
        if (pGame) {
            playerGame.stop();
            pGameStopped = true;
            System.out.println("Player Game Over!");
        }
        if (!pGame) {
            comGame.stop();
            cGameStopped = true;
            System.out.println("Computer Game Over!");
        }
    }
    private void gewinnauswertung() {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {

            minispielrueckgabewert.setAbbruch(false);
            minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());

            Platform.runLater(() -> winLoseLabel.setVisible(true));
            Platform.runLater(() -> playerPane.setVisible(false));
            Platform.runLater(() -> computerPane.setVisible(false));
            Platform.runLater(() -> startCounter.setVisible(false));
            if(cGameStopped){
                minispielrueckgabewert.setWinner(spieler[0]);
                Platform.runLater(() -> winLoseLabel.setText("Du hast gewonnen!!"));
                System.out.println("win");
            } else {
                minispielrueckgabewert.setWinner(spieler[1]);
                Platform.runLater(() -> winLoseLabel.setText("Du hast leider verloren"));
                System.out.println("lose");
            }

            if(playerCount - comCount >= 10){
                minispielrueckgabewert.setWuerfel(new GuterWuerfel());
            } else if(playerCount - comCount >= 5){
                minispielrueckgabewert.setWuerfel(new Normalerwuerfel());
            } else {
                minispielrueckgabewert.setWuerfel(new SchlechterWuerfel());
            }
            PauseTransition pause2 = new PauseTransition(Duration.seconds(3));
            pause2.setOnFinished(e -> stage.close());
            pause2.play();
        });
        pause.play();
    }
}