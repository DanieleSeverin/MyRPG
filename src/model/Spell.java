package model;

import javax.swing.*;

public class Spell extends SolidObject{

    private String direction;
    private int spell_speed_x;
    private int spell_speed_y;
    private final int BOARD_WIDTH_MAX = 800;
    private final int BOARD_WIDTH_0 = -50;
    private final int BOARD_EIGHT_MAX = 500;
    private final int BOARD_EIGHT_0 = -50;
    private boolean visible=true;

    ImageIcon spell_right = new ImageIcon("src/resources/spell_right.png");
    ImageIcon spell_left = new ImageIcon("src/resources/spell_left.png");
    ImageIcon spell_up = new ImageIcon("src/resources/spell_up.png");
    ImageIcon spell_down = new ImageIcon("src/resources/spell_down.png");

    public Spell(int x, int y, String direction) {
        super(x, y);
        this.direction = direction;

        initSpell();
    }

    private void initSpell() {

        loadImage();
        getImageDimensions();
    }

    protected void loadImage() {

        setDirection();

        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }

    private void setDirection(){
        if (direction.equals("right")) {
            setImage(spell_right.getImage());
            spell_speed_x = 5;
            spell_speed_y = 0;
        }
        if (direction.equals("left")) {
            setImage(spell_left.getImage());
            spell_speed_x = -5;
            spell_speed_y = 0;
        }
        if (direction.equals("up")) {
            setImage(spell_up.getImage());
            spell_speed_x = 0;
            spell_speed_y = -5;
        }
        if (direction.equals("down")) {
            setImage(spell_down.getImage());
            spell_speed_x = 0;
            spell_speed_y = 5;
        }
    }

    protected void getImageDimensions() {
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }

    public void move() {

        setX(getX()+spell_speed_x);
        setY(getY()+spell_speed_y);

        if (getX() > BOARD_WIDTH_MAX)
            visible = false;
        if (getX() < BOARD_WIDTH_0)
            visible = false;
        if (getY() > BOARD_EIGHT_MAX)
            visible = false;
        if (getY() < BOARD_EIGHT_0)
            visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
