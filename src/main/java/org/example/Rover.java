package org.example;

public class Rover extends Vehicle {

    private Direction facing;

    public Rover(Direction facing, Coordinate gps) {
        super(gps);
        this.facing = facing;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
