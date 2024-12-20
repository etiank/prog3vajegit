package org.Vaje11;

import java.util.ArrayList;

public class Map {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int COINS = 5;
    public static final int PORTALS = 5;

    public static Player player;
    public static ArrayList<Location> coins;
    public static ArrayList<Location> portals;

    public static int[][] portalMap ={ //let's make 5 portals
            {0,1,0,0,1},
            {1,0,1,0,0},
            {0,1,0,1,0},
            {0,0,1,0,1},
            {1,0,0,1,0},
    };

    public static void init(){
        player = new Player();
        coins = new ArrayList<>();
        portals = new ArrayList<>();

        for (int i = 0; i < COINS; i++) {
            coins.add(Location.random());
        }

        for (int i = 0; i < PORTALS; i++) {
            portals.add(Location.random());
        }
    }

}
