package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void getX() {
        Coordinate gps = new Coordinate(2, 1);
        assertEquals(2, gps.getX());
    }

    @Test
    void setX() {
        Coordinate gps = new Coordinate(2, 1);
        int newX = 5;
        gps.setX(newX);
        assertEquals(newX, gps.getX());
    }

    @Test
    void getY() {
        Coordinate gps = new Coordinate(9, 8);
        assertEquals(8, gps.getY());
    }

    @Test
    void setY() {
        Coordinate gps = new Coordinate(9, 8);
        int newY = 5;
        gps.setY(newY);
        assertEquals(newY, gps.getY());
    }

    @Test
    void testEquals() {
        Coordinate gps = new Coordinate(1, 7);
        Coordinate newGps = new Coordinate(1, 7);
        assertTrue(gps.equals(newGps));
        assertFalse(gps.equals(new Coordinate(1, 9)));
        assertFalse(gps.equals(new Coordinate(0, 7)));
        assertFalse(gps.equals(new Coordinate(0, 0)));
    }
}