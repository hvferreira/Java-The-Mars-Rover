package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsTest {

    @Test
    void theMarsRover() {

        Coordinate plateauCoordinatesDown = new Coordinate(0, 0);
        Coordinate plateauCoordinatesUp = new Coordinate(5, 5);
        Plateau plateau = new Plateau(plateauCoordinatesDown, plateauCoordinatesUp);
        Mars mars = new Mars(plateau);

        Direction facing = Direction.N;
        Coordinate roverCoordinates1 = new Coordinate(4, 3);
        Coordinate roverCoordinates2 = new Coordinate(1, 1);
        Rover rover1 = new Rover(facing, roverCoordinates1);
        Rover rover2 = new Rover(facing, roverCoordinates2);
        Rover rover3 = new Rover(facing, new Coordinate(1, 4));
        plateau.addRover(rover1);
        plateau.addRover(rover2);
        plateau.addRover(rover3);
        plateau.printPlateau();
        plateau.rotateGoForward(rover1, "MLMRM");
        plateau.rotateGoForward(rover2, "MMM");
        plateau.rotateGoForward(rover3, "LR");
        plateau.printPlateau();

        //assertEquals(2, rover1.getCoordinates().getX());
        //assertEquals(3, rover1.getCoordinates().getY());
    }
}