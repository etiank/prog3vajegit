package org.Vaje11;

import java.util.Random;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Location random(){

        Random r = new Random();
        return new Location(r.nextInt(Map.WIDTH),r.nextInt(Map.HEIGHT));

    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public synchronized int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }
}
