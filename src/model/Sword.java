package model;

import javax.swing.*;

public class Sword extends SolidObject{

    private String direction;

    ImageIcon sword_right = new ImageIcon("src/resources/sword_right.jpg");
    ImageIcon sword_left = new ImageIcon("src/resources/sword_left.jpg");
    ImageIcon sword_up = new ImageIcon("src/resources/sword_up.jpg");
    ImageIcon sword_down = new ImageIcon("src/resources/sword_down.jpg");

    public Sword(PC pc) {
        super(pc.getX(), pc.getY());
        direction = pc.getDirection();

        initSword(pc);
    }

    private void initSword(PC pc) {

        loadImage(pc);
        getImageDimensions();
    }

    protected void loadImage(PC pc) {

        setDirection(pc);
    }

    private void setDirection(PC pc){
        if (direction.equals("right")) {
            image = sword_right.getImage();
            setX(x + pc.getWidth());
        }
        if (direction.equals("left")) {
            image = sword_left.getImage();
            setX(x - pc.getWidth());
        }
        if (direction.equals("up")) {
            image = sword_up.getImage();
            setY(y - pc.getHeight());
        }
        if (direction.equals("down")) {
            image = sword_down.getImage();
            setY(y + pc.getHeight());
        }
    }

    protected void getImageDimensions() {
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }
}
