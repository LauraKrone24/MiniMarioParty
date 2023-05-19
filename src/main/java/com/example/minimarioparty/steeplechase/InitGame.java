package com.example.minimarioparty.steeplechase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InitGame extends JPanel implements KeyListener {
    private PlayerObj p;
    private List<Hurdle> h;
    private boolean isJumping;

    public InitGame() {
        p = new PlayerObj(50, 200, 50, 50);
        h = new ArrayList<>();
        isJumping = false;

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        p.draw(g);

        for (Hurdle hurdle : h) {
            hurdle.draw(g);
        }
    }

    public void moveHurdles() {
        for (Hurdle hurdle : h) {
            hurdle.move();
        }
    }

    public void addHurdle() {
        if (Math.random() < 0.3) {
            int hurdleWidth = 30;
            int hurdleHeight = 50;
            int hurdleX = getWidth();
            int hurdleY = getHeight() - hurdleHeight - 50;

            // Zufälliger Abstand zwischen den Hürden (hier: 100-200 Pixel)
            int hurdleSpacing = (int) (Math.random() * 101) + 200;

            // Überprüfen, ob genug Platz für eine neue Hürde vorhanden ist
            if (h.isEmpty() || (h.get(h.size() - 1).getX() + hurdleSpacing < getWidth())) {
                h.add(new Hurdle(hurdleX, hurdleY, hurdleWidth, hurdleHeight));
            }
        }
    }

    public void removePassedHurdles() {
        List<Hurdle> hurdlesToRemove = new ArrayList<>();

        for (Hurdle hurdle : h) {
            if (hurdle.getX() + hurdle.getWidth() < 0) {
                hurdlesToRemove.add(hurdle);
            }
        }

        h.removeAll(hurdlesToRemove);
    }

    public boolean checkCollision() {
        for (Hurdle hurdle : h) {
            if (p.getRectangle().intersects(hurdle.getRectangle())) {
                return true;
            }
        }
        return false;
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            new Thread(() -> {
                for (int i = 0; i < 30; i++) {
                    p.moveUp(6);
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 30; i++) {
                    p.moveDown(6);
                    repaint();
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

    public void updateGame() {
        moveHurdles();
        removePassedHurdles();
        if (checkCollision()) {
            System.out.println("Spiel vorbei!");
            System.exit(0);
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Steeplechase");
        InitGame game = new InitGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(game);
        frame.setVisible(true);

        while (true) {
            game.addHurdle();
            game.updateGame();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}