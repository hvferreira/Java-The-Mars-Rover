package org.example;

public class Rover extends Vehicle {

    private Direction facing;

    public Rover(Direction facing, Coordinate gps) {
        super(gps);//acho q falta aqui coordenadas
        this.facing = facing;
    }
}
