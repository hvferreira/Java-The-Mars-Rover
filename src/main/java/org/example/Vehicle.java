package org.example;

public class Vehicle {

    private Coordinate gps;

    public Vehicle(Coordinate gps) {
        this.gps = gps;
    }

    public Vehicle() {

    }

    public Coordinate getCoordinates() {
        return gps;
    }

    public void SetCoordinates(Coordinate newPosition) {
        this.gps = newPosition;
    }
}
