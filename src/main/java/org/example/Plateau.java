package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {


    private Coordinate down;
    private Coordinate up;

    ArrayList<Vehicle> roverPerFields;

    public Plateau(Coordinate down, Coordinate up) {

        if (verifyRightCoordinates(down, up)) {
            this.down = down;
            this.up = up;
            roverPerFields = new ArrayList<>();
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

    public boolean addRover() {

    }

}
