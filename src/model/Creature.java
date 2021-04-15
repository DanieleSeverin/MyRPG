package model;

import javax.swing.*;

public abstract class Creature extends SolidObject{
    private int dx = 0;
    private int dy = 0;
    private String direction;
    private int MAX_HP;
    private int hp;
    protected int damage;
    private boolean canMove = true;
    private DamageEffect damageEffect;

    ImageIcon death = new ImageIcon("src/resources/death.png");

    public Creature(int x, int y, int MAX_HP, int hp) {
        super(x, y);
        this.MAX_HP = MAX_HP;
        this.hp = hp;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public abstract void loadImage();

    public abstract void setDimensions();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void getDamaged (Creature creature){
        setHp(getHp() - creature.damage);
        if(getHp() <= 0) die();

        damageEffect = new DamageEffect(this);
    }

    public DamageEffect getDamageEffect() {
        return damageEffect;
    }

    public void setDamageEffectNotVisible(){
        damageEffect.setVisibility(false);
    }



    public void die(){
        image = death.getImage();
        setWidth(0);
        setHeight(0);
        canMove = false;
    }
}
