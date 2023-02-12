package org.example;

import java.util.HashMap;

public class Plateau {

    //ArrayList<ArrayList<Character>> field;

    //List of Rovers
    //maps(Coordinate,veicule) a key n pode mudar
    //map (veicule, coordinate)
    HashMap<Coordinate, Integer> mapa;

    public Plateau(Coordinate down, Coordinate up) {

        mapa = new HashMap<>();
        mapa.put(new Coordinate(2, 2), 0);
        Coordinate ola = new Coordinate(2, 2);
        Coordinate Hello = new Coordinate(2, 2);

 
        System.out.println(ola.equals(Hello));
        System.out.println();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (x == i && y == j) {
                    System.out.print("X");
                } else {
                    System.out.print("-");
                }

            }
            System.out.println();
        }

    }

    private void print() {

    }
}
