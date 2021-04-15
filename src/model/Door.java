package model;

import javax.swing.*;

public class Door extends SolidObject{

    private String direction;
    private Room nextRoom;

    ImageIcon door_up = new ImageIcon("src/resources/door_up.png");
    ImageIcon door_down = new ImageIcon("src/resources/door_down.png");
    ImageIcon door_right = new ImageIcon("src/resources/door_right.png");
    ImageIcon door_left = new ImageIcon("src/resources/door_left.png");

    public Door(int x, int y, String direction, Room room) {
        super(x, y);
        this.direction = direction;
        nextRoom = room;
        initDoor();
    }

    private void initDoor() {

        loadImage();
        getImageDimensions();
    }

    protected void loadImage() {
        setDirection();
    }

    private void setDirection(){
        if (direction.equals("right")) {
            setImage(door_right.getImage());
        }
        if (direction.equals("left")) {
            setImage(door_left.getImage());
        }
        if (direction.equals("up")) {
            setImage(door_up.getImage());
        }
        if (direction.equals("down")) {
            setImage(door_down.getImage());
        }
    }

    protected void getImageDimensions() {
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }

    public Room getNextRoom() {
        return nextRoom;
    }
}
