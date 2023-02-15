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
        Coordinate roverCoordinates1 = new Coordinate(2, 3);
        Coordinate roverCoordinates2 = new Coordinate(1, 1);
        Rover rover1 = new Rover(facing, roverCoordinates1);
        Rover rover2 = new Rover(facing, roverCoordinates2);
        Rover rover3 = new Rover(facing, new Coordinate(1, 4));
        plateau.addRover(rover1);
        plateau.addRover(rover2);
        plateau.addRover(rover3);
        plateau.printPlateau();
        plateau.rotateGoForward(rover1, "LM");//(1,3// )
        plateau.rotateGoForward(rover2, "RM");//(2,1)
        plateau.rotateGoForward(rover3, "M");//(1,5)
        plateau.printPlateau();


        plateau.rotateGoForward(rover1, "RRMM");//(3,3)
        assertTrue(rover1.getCoordinates().equals(new Coordinate(3, 3)));
        assertTrue(rover1.getFacing() == Direction.E);//E

        plateau.rotateGoForward(rover2, "MRM");//(1,2)
        assertTrue(rover2.getCoordinates().equals(new Coordinate(3, 0)));
        assertTrue(rover2.getFacing() == Direction.S);

        plateau.rotateGoForward(rover3, "RRMLM");//(2,4)
        assertTrue(rover3.getCoordinates().equals(new Coordinate(2, 4)));
        assertTrue(rover3.getFacing() == Direction.E);
        plateau.printPlateau();

    }
}