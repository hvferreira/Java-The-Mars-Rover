package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    public void checkField() {
        Coordinate coordinatePlateauDown = new Coordinate(0, 0);
        Coordinate coordinatePlateauUp = new Coordinate(1, 0);
        Plateau aux = new Plateau(coordinatePlateauDown, coordinatePlateauUp);
        assertTrue(aux.verifyRightCoordinates(coordinatePlateauDown, coordinatePlateauUp));
    }

    @Test
    public void checkALL() {
        Coordinate coordinatePlateauDown = new Coordinate(0, 0);
        Coordinate coordinatePlateauUp = new Coordinate(2, 2);
        Plateau fildMars = new Plateau(coordinatePlateauDown, coordinatePlateauUp);
        Mars game = new Mars(new Plateau(coordinatePlateauDown, coordinatePlateauUp));
    }
}