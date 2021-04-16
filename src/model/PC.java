package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class PC extends Creature{

    private String direction;
    private List<Spell> spells = new ArrayList<>();
    private Sword sword;
    private boolean attacking = false;

    ImageIcon mage_down = new ImageIcon("src/resources/mage-down.png");
    ImageIcon mage_up = new ImageIcon("src/resources/mage-up.png");
    ImageIcon mage_left = new ImageIcon("src/resources/mage-left.png");
    ImageIcon mage_right = new ImageIcon("src/resources/mage-right.png");

    public PC(int x, int y, String direction, int MAX_HP, int hp) {
        super(x, y, MAX_HP, hp);
        this.direction = direction;
        this.damage = 10;
        loadImage();
        setDimensions();
    }

    @Override
    public void loadImage(){
        if(direction.equals("down"))
            setImage(mage_down.getImage());
        if(direction.equals("up"))
            setImage(mage_up.getImage());
        if(direction.equals("left"))
            setImage(mage_left.getImage());
        if(direction.equals("right"))
            setImage(mage_right.getImage());
    }

    @Override
    public void setDimensions(){
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void move(){
        setX(getX()+getDx());
        setY(getY()+getDy());

        if(getX()<1) setX(1);
        if(getX()>760) setX(760);

        if(getY()<1) setY(1);
        if(getY()>430) setY(430);
    }

    public void fire(){
        spells.add(new Spell(getX() + getWidth(), getY() + getHeight() / 2, direction));
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void attack(){
        sword = new Sword(this);
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
