package model;

import java.awt.*;

public abstract class Sprite {

    protected int x;
    protected int y;

    protected Image image;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {

        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
