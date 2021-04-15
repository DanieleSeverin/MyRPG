package model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Background extends Sprite{

    public Background(ImageIcon imageIcon){
        super(0,0);

        setImage(imageIcon.getImage());
    }
}