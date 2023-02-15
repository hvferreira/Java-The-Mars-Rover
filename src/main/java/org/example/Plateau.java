package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
    private Coordinate down;
    private Coordinate up;
    private ArrayList<Vehicle> vehiclePerFields;

    public Plateau() {
    }

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

        if (coordinateIsEmpty(newPosition) && verifyRoverCoordinateInSidePlateau(newPosition)) {
            rover.SetCoordinates(newPosition);
        } else {
            System.out.println("Not possible move the Rover");
            return false;
        }
        return true;
    }

    public boolean verifyRoverCoordinateInSidePlateau(Coordinate roverCoordinate) {

        if (((down.getX() <= roverCoordinate.getX()) && down.getY() <= roverCoordinate.getY() &&
                (up.getX() >= roverCoordinate.getX()) && (up.getY() >= roverCoordinate.getY()))) {
            return true;
        }
        return false;
    }

    public void printPlateau() {
        for (int i = up.getY(); i >= down.getY(); i--) {
            for (int j = down.getX(); j <= up.getX(); j++) {
                if (coordinateIsEmpty(new Coordinate(j, i))) {
                    System.out.print("\t" + "-");
                } else {
                    System.out.print("\t" + "X");
                }
            }
            System.out.println();
        }
    }

    public void rotateGoForward(Rover rover, String orientation) {

        int i = 0;
        while (i < orientation.length()) {

            if (orientation.charAt(i) == 'L') {
                directionL(rover);
            } else if (orientation.charAt(i) == 'R') {
                directionR(rover);
            } else if (orientation.charAt(i) == 'M') {

                if (directionM(rover)) {
                    System.out.println("Rover Moved with Success");
                } else {
                    System.out.println("Not possible move Rover");
                    i = orientation.length();
                }
            }
            i++;
        }
    }

    private void directionL(Rover rover) {

        switch (rover.getFacing()) {
            case N -> rover.setFacing(Direction.W);
            case W -> rover.setFacing(Direction.S);
            case S -> rover.setFacing(Direction.E);
            case E -> rover.setFacing(Direction.N);

        }
    }

    private void directionR(Rover rover) {

        switch (rover.getFacing()) {
            case N -> rover.setFacing(Direction.E);
            case W -> rover.setFacing(Direction.N);
            case S -> rover.setFacing(Direction.W);
            case E -> rover.setFacing(Direction.S);

        }
    }

    private boolean directionM(Rover rover) {

        return switch (rover.getFacing()) {//move rover
            case N ->
                    moveVehicle(rover, new Coordinate(rover.getCoordinates().getX(), rover.getCoordinates().getY() + 1));
            case W ->
                    moveVehicle(rover, new Coordinate(rover.getCoordinates().getX() - 1, rover.getCoordinates().getY()));
            case S ->
                    moveVehicle(rover, new Coordinate(rover.getCoordinates().getX(), rover.getCoordinates().getY() - 1));
            case E ->
                    moveVehicle(rover, new Coordinate(rover.getCoordinates().getX() + 1, rover.getCoordinates().getY()));
        };
    }
}
