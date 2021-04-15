package model;

import javax.swing.*;
import java.awt.*;

public class Tree extends SolidObject{

    ImageIcon tree = new ImageIcon("src/resources/tree.png");

    public Tree(int x, int y) {
        super(x, y);
        loadImage();
        setDimensions();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX()+30, getY()+60, getWidth()-70, getHeight()-65);
    }

    public void loadImage(){
            setImage(tree.getImage());
    }

    public void setDimensions(){
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }
}
