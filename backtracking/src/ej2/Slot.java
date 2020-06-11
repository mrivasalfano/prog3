package ej2;

public class Slot {
    int value;
    boolean east;
    boolean north;
    boolean west;
    boolean south;

    public Slot (int value, boolean north, boolean east, boolean west, boolean south) {
        this.value = value;
        this.north = north;
        this.west = west;
        this.south = south;
        this.east = east;
    }

    public int getValue() {
        return value;
    }

    public boolean goToEast() {
        return east;
    }

    public boolean goToNorth() {
        return north;
    }

    public boolean goToSouth() {
        return south;
    }

    public boolean goToWest() {
        return west;
    }
}
