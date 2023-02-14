package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
    private Coordinate down;
    private Coordinate up;
    private ArrayList<Vehicle> vehiclePerFields;

    public Plateau(Coordinate down, Coordinate up) {

        if (verifyRightCoordinates(down, up)) {
            this.down = down;
            this.up = up;
            vehiclePerFields = new ArrayList<>();
        } else {
            System.out.println("Plateau not create, Coordinates not Correct");
        }
    }

    public boolean verifyRightCoordinates(Coordinate down, Coordinate up) {

        if (down.equals(up))
            return false;

        if (down.getX() < 0 || down.getY() < 0)
            return false;

        if (up.getX() <= down.getX() || up.getY() <= down.getY())
            return false;

        return true;
    }

    //add rover
    public void addRover(Vehicle rover) {

        vehiclePerFields.add(rover);
    }

    public int sizeVehiclePerFields() {
        return vehiclePerFields.size();
    }

    public boolean coordinateIsEmpty(Coordinate position) {

        boolean positionFull = true;
        for (Vehicle v : vehiclePerFields) {
            if (v.getCoordinates().equals(position)) {
                positionFull = false;
            }
        }
        return positionFull;
    }

    public boolean moveVehicle(Vehicle rover, Coordinate newPosition) {

        if (coordinateIsEmpty(newPosition)) {
            rover.SetCoordinates(newPosition);
        } else {
            System.out.println("Not possible move the Rover");
            return false;
        }
        return true;
    }

    public boolean verifyNewCoordinateInSidePlateau(Coordinate roverCoordinate) {

        if (((down.getX() <= roverCoordinate.getX()) && down.getY() <= roverCoordinate.getY() &&
                (up.getX() >= roverCoordinate.getX()) && (up.getY() >= roverCoordinate.getY()))) {
            return false;
        }

        return true;
    }
}
