package view;

import controller.Dungeon;
import controller.Game;
import model.PC;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Startgame extends JPanel {

    private Game game;
    ImageIcon startGame = new ImageIcon("src/resources/StartGame.png");
    ImageIcon gameOver = new ImageIcon("src/resources/GameOver.png");
    Image image;

    public Startgame(Game game) {

        this.game = game;

        image = startGame.getImage();

        addKeyListener(new Startgame.TAdapter());
        setBackground(Color.black);
        setFocusable(true);
    }

    public void switchToGameOver(){
        image = gameOver.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            game.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }
}
