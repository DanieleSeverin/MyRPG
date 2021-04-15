package model;

import java.util.List;

public class Room {

    private Background background;
    private List<SolidObject> objects;
    private List<Enemy> enemies;

    private Door doorUp;
    private Door doorDown;
    private Door doorLeft;
    private Door doorRight;

    private Room roomUp;
    private Room roomDown;
    private Room roomLeft;
    private Room roomRight;

    public Room(Background background, List<SolidObject> objects, List<Enemy> enemies) {

        this.background = background;
        this.objects = objects;
        this.enemies = enemies;
    }

    public void initDoor(Room room, DoorPosition doorPosition) {
        if (doorPosition == DoorPosition.UP) {
            this.roomUp = room;
            doorUp = new Door(350, 0, "up", roomUp);
        }
        if (doorPosition == DoorPosition.RIGHT) {
            this.roomRight = room;
            doorRight = new Door(750, 200, "right", roomRight);
        }
        if (doorPosition == DoorPosition.DOWN) {
            this.roomDown = room;
            doorDown = new Door(350, 420, "down", roomDown);
        }
        if (doorPosition == DoorPosition.LEFT) {
            this.roomLeft = room;
            doorLeft = new Door(0, 200, "left", roomLeft);
        }
    }

    public Background getBackground() {
        return background;
    }

    public List<SolidObject> getObjects() {
        return objects;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Door getDoorUp() {
        return doorUp;
    }

    public Door getDoorDown() {
        return doorDown;
    }

    public Door getDoorLeft() {
        return doorLeft;
    }

    public Door getDoorRight() {
        return doorRight;
    }
}