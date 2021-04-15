package view;

import controller.Game;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class View extends JPanel {

    private Game game;
    private Room room;
    private PC pc;

    public View(Game game, Room room, PC pc) {

        this.game = game;
        this.room = room;
        this.pc = pc;

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        drawBackground(g);
        drawDoors(g);
        drawEnemies(g);
        drawPC(g);
        drawDamageEffect(g);
        drawObjects(g);
        drawSpells(g);
        drawSword(g);

        g.drawString("HP:  " + pc.getHp(), 300, 15);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(room.getBackground().getImage(), room.getBackground().getX(),
                room.getBackground().getY(), this);
    }

    private void drawDoors(Graphics g) {
        if(room.getDoorUp() != null){
            g.drawImage(room.getDoorUp().getImage(), room.getDoorUp().getX(),
                    room.getDoorUp().getY(), this);
        }
        if(room.getDoorDown() != null){
            g.drawImage(room.getDoorDown().getImage(), room.getDoorDown().getX(),
                    room.getDoorDown().getY(), this);
        }
        if(room.getDoorLeft() != null){
            g.drawImage(room.getDoorLeft().getImage(), room.getDoorLeft().getX(),
                    room.getDoorLeft().getY(), this);
        }
        if(room.getDoorRight() != null){
            g.drawImage(room.getDoorRight().getImage(), room.getDoorRight().getX(),
                    room.getDoorRight().getY(), this);
        }
    }

    private void drawPC(Graphics g){
        g.drawImage(pc.getImage(), pc.getX(), pc.getY(), this);
    }

    private void drawObjects(Graphics g){
        for (SolidObject obj : room.getObjects()){
            g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);
        }
    }

    private void drawEnemies(Graphics g){
        for (Enemy obj : room.getEnemies()){
            g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);
        }
    }

    private void drawDamageEffect(Graphics g){
        DamageEffect de = pc.getDamageEffect();
        if (de != null && de.isVisible())
            g.drawImage(de.getImage(), de.getX(), de.getY(), this);

        for (Enemy enemy : room.getEnemies()) {
            DamageEffect da = enemy.getDamageEffect();
            if (da != null && da.isVisible())
                g.drawImage(da.getImage(), da.getX(), da.getY(), this);
        }
    }

    private void drawSpells(Graphics g){
        List<Spell> sp = pc.getSpells();
        for (Spell spell : sp) {
            if (spell.isVisible()) {
                g.drawImage(spell.getImage(), spell.getX(),
                        spell.getY(), this);
            }
        }
    }

    private void drawSword(Graphics g){
        Sword sword = pc.getSword();
        if (pc.isAttacking())
            g.drawImage(sword.getImage(), sword.getX(),
                    sword.getY(), this);
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

