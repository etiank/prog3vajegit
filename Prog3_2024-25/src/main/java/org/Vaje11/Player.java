package org.Vaje11;

public class Player {

    public Location location;
    public int steps;

    public Player(){
        this.steps = 0;
        this.location = Location.random();
        // health bar, inventory ...
    }

}
