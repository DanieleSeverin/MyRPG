package model;

import javax.swing.*;
import java.awt.*;

public class DamageEffect extends Sprite{

    ImageIcon damage = new ImageIcon("src/resources/damage.png");
    private boolean visible = true;

    public DamageEffect(Creature creature) {
        super(creature.getX(), creature.getY());
        loadImage();
    }

    private void loadImage() {
        setImage(damage.getImage());
    }

    public Image getImage() {
        return image;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
    }
}
