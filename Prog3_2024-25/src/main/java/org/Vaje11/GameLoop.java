package org.Vaje11;

import util.Logger;

import javax.swing.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class GameLoop implements Runnable {

    public static Queue<Character> events = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
        Timer timer = new Timer(10, e -> tick());
        timer.start();
    }

    private void tick() {
        // coin collecting
        Location toRemove = null;
        for(Location coin : Map.coins){
            if (Map.player.location.getX() == coin.getX() && Map.player.location.getY() == coin.getY()) {
                toRemove = coin;
            }
        }

        if (toRemove != null) {
            Map.coins.remove(toRemove);
        }
        // CHECK WIN CONDITION
        if (Map.coins.isEmpty()) {
            Logger.log("Won game in " + Map.player.steps + " steps");
            Map.coins.add(Location.random());
        }

        // MOVEMENT
        Character key = events.poll();
        if (key == null) {
            return;
        }

        if (key == 'w'){
            int newCoord = (Map.player.location.getY() - 1 + Map.HEIGHT) % Map.HEIGHT;
            Map.player.location.setY(newCoord);
            Map.player.steps++;
        }
        if (key == 's'){
            int newCoord = (Map.player.location.getY() + 1 + Map.HEIGHT) % Map.HEIGHT;
            Map.player.location.setY(newCoord);
            Map.player.steps++;
        }
        if (key == 'a'){
            int newCoord = (Map.player.location.getX() - 1 + Map.WIDTH) % Map.WIDTH;
            Map.player.location.setX(newCoord);
            Map.player.steps++;
        }
        if (key == 'd'){
            int newCoord = (Map.player.location.getX() + 1 + Map.WIDTH) % Map.WIDTH;
            Map.player.location.setX(newCoord);
            Map.player.steps++;
        }

        int targetPortal = -1;

        if (key == '0'){
            targetPortal = 0;
        }
        if (key == '1'){
            targetPortal = 1;
        }
        if (key == '2'){
            targetPortal = 2;
        }
        if (key == '3'){
            targetPortal = 3;
        }
        if (key == '4'){
            targetPortal = 4;
        }
        if (targetPortal != -1){
            for (int portalIndex = 0; portalIndex < Map.portals.size(); portalIndex++) {
                if (
                        Map.portals.get(portalIndex).getX() == Map.player.location.getX() &&
                        Map.portals.get(portalIndex).getY() == Map.player.location.getY() &&
                        Map.portalMap[portalIndex][targetPortal] == 1
                ){
                    Map.player.location.setX(Map.portals.get(targetPortal).getX());
                    Map.player.location.setY(Map.portals.get(targetPortal).getY());
                }
            }
        }
    }
}
