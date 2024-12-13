package org.Vaje10;

import java.util.Random;

public class Player {

    private Random r;
    public Player(int seed) {
        r = new Random(seed);
    }

    public int produceMove(){
        long start = System.currentTimeMillis();
        int sum = 0;
        while (System.currentTimeMillis() < start + 500 ) {
            sum += r.nextInt(201) - 100;
        }
        return sum;
    }

}
