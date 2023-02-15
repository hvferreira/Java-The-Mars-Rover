package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void verifyRightCoordinates() {// for plateau
        Plateau plateau = new Plateau();
        assertTrue(plateau.verifyRightCoordinates(new Coordinate(0, 0), new Coordinate(1, 1)));
        assertFalse(plateau.verifyRightCoordinates(new Coordinate(0, 0), new Coordinate(0, 0)));
        assertFalse(plateau.verifyRightCoordinates(new Coordinate(0, 0), new Coordinate(0, 1)));
        assertFalse(plateau.verifyRightCoordinates(new Coordinate(0, 0), new Coordinate(-1, -1)));
    }

    @Test
    void addRover() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));
        int size = plateau.sizeVehiclePerFields();
        plateau.addRover(new Vehicle());
        assertEquals(size + 1, plateau.sizeVehiclePerFields());
    }

    @Test
    void sizeVehiclePerFields() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));
        plateau.addRover(new Vehicle());
        plateau.addRover(new Vehicle());
        plateau.addRover(new Vehicle());
        plateau.addRover(new Vehicle());
        plateau.addRover(new Vehicle());
        assertEquals(5, plateau.sizeVehiclePerFields());

    }

    @Test
    void coordinateIsEmpty() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));
        plateau.addRover(new Vehicle(new Coordinate(2, 2)));
        assertTrue(plateau.coordinateIsEmpty(new Coordinate(1, 1)));
        assertTrue(plateau.coordinateIsEmpty(new Coordinate(0, 1)));
        assertFalse(plateau.coordinateIsEmpty(new Coordinate(2, 2)));
    }

    @Test
    void moveVehicle() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));
        Vehicle rover = new Vehicle(new Coordinate(2, 2));
        plateau.addRover(rover);

        assertFalse(plateau.coordinateIsEmpty(new Coordinate(2, 2)));//confirm rover in position

        assertTrue(plateau.moveVehicle(rover, new Coordinate(1, 1)));//moving rover

        assertTrue(plateau.coordinateIsEmpty(new Coordinate(2, 2)));// old position the rover
        assertFalse(plateau.coordinateIsEmpty(new Coordinate(1, 1)));// new position the rover

    }

    @Test
    void verifyRoverCoordinateInSidePlateau() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));

        assertFalse(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(-1, 0)));
        assertFalse(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(5, 6)));
        assertFalse(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(6, 6)));
        assertFalse(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(-1, -1)));

        assertTrue(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(0, 0)));
        assertTrue(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(5, 5)));

    }

    @Test
    void rotateGoForward() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));
        Rover rover = new Rover(Direction.W, new Coordinate(4, 3));

        plateau.rotateGoForward(rover, "MRM");
        assertTrue(rover.getCoordinates().equals(new Coordinate(3, 4)));
        assertTrue(rover.getFacing() == Direction.N);

        plateau.rotateGoForward(rover, "MLMML");
        assertTrue(rover.getCoordinates().equals(new Coordinate(1, 5)));
        assertTrue(rover.getFacing() == Direction.S);

    }
}