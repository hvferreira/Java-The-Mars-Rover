package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    public void checkField() {
        Plateau aux = new Plateau(1, 2);
        Plateau aux1 = new Plateau(1, 2);
    }

    @Test
    public void checkALL() {
        Coordinate coordinatePlateauDown = new Coordinate(0, 0);
        Coordinate coordinatePlateauUp = new Coordinate(2, 2);
        Plateau fildMars = new Plateau(coordinatePlateauDown, coordinatePlateauUp);
        Mars game = new Mars(new Plateau(coordenatiLower, coordinateUp));

    }

}