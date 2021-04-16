package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartGame extends JPanel {

    private Game game;
    ImageIcon startGame = new ImageIcon("src/resources/StartGame.png");
    ImageIcon gameOver = new ImageIcon("src/resources/GameOver.png");
    ImageIcon youWin = new ImageIcon("src/resources/YouWin.png");
    Image image;

    public StartGame(Game game) {

        this.game = game;

        image = startGame.getImage();

        addKeyListener(new StartGame.TAdapter());
        setBackground(Color.black);
        setFocusable(true);
    }

    public void switchToGameOver(){
        image = gameOver.getImage();
    }

    public void switchToYouWin() { image = youWin.getImage(); }

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
