package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void verifyRightCoordinates() {
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

        assertFalse(plateau.coordinateIsEmpty(new Coordinate(2, 2)));//confirm rover in positon


        assertTrue(plateau.moveVehicle(rover, new Coordinate(1, 1)));//moving rover

        assertTrue(plateau.coordinateIsEmpty(new Coordinate(2, 2)));// old position the rover
        assertFalse(plateau.coordinateIsEmpty(new Coordinate(1, 1)));// new postion the rover

    }

    @Test
    void verifyRoverCoordinateInSidePlateau() {
        Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));

        assertTrue(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(-1, 0)));
        assertTrue(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(5, 6)));
        assertTrue(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(6, 6)));
        assertTrue(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(-1, -1)));
        assertFalse(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(0, 0)));
        assertFalse(plateau.verifyRoverCoordinateInSidePlateau(new Coordinate(5, 5)));

    }
}