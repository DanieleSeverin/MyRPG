package model;

import javax.swing.*;

public class Boss extends Enemy{

    ImageIcon boss = new ImageIcon("src/resources/boss.png");

    public Boss(int x, int y, int MAX_HP, int hp) {
        super(x, y, MAX_HP, hp);
        this.damage = 2;
        loadImage();
        setDimensions();
    }

    @Override
    public void loadImage(){
        setImage(boss.getImage());
    }

    @Override
    public void setDimensions(){
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }

    @Override
    public void move(PC pc) {
        getPcPosition(pc);

        if(getCanMove()) {
            setX(getX()+getDx());
            setY(getY()+getDy());
        }

        if(getX()<1) setX(1);
        if(getX()>760) setX(760);

        if(getY()<1) setY(1);
        if(getY()>430) setY(430);
    }

    @Override
    public void die(){
        image = death.getImage();
        setWidth(0);
        setHeight(0);
        setCanMove(false);
    }
}
