package org.Vaje10;

import util.Logger;

import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class RecursiveMatch extends RecursiveTask<Integer> {

    private Integer[] playerSeeds;
    public RecursiveMatch(Integer[] playerSeeds) {
        this.playerSeeds = playerSeeds;
    }

    @Override
    protected Integer compute() {
        if (playerSeeds.length == 1) {
            return playerSeeds[0];
        }

        if (playerSeeds.length == 2) {
            return play(playerSeeds[0],playerSeeds[1]);
        }

        Integer[] firstHalf = Arrays.copyOfRange(playerSeeds, 0, playerSeeds.length/2);
        Integer[] secondHalf = Arrays.copyOfRange(playerSeeds,  playerSeeds.length/2, playerSeeds.length);

        RecursiveMatch firstHalfMatch = new RecursiveMatch(firstHalf);
        RecursiveMatch secondHalfMatch = new RecursiveMatch(secondHalf);

        firstHalfMatch.fork();
        secondHalfMatch.fork();

        Integer bestFirstHalf = firstHalfMatch.join();
        Integer bestSecondHalf = secondHalfMatch.join();

        return play(bestFirstHalf,bestSecondHalf);
    }

    private Integer play(Integer playerSeed1, Integer playerSeed2) {
        Player p1 = new Player(playerSeed1);
        Player p2 = new Player(playerSeed2);

        int p1Move = p1.produceMove();
        int p2Move = p2.produceMove();

        Logger.log("Game: " + playerSeed1 +  " " + p1Move + " " + p2Move);

        if (p1Move > p2Move) {
            return playerSeed1;
        }else if (p1Move < p2Move) {
            return playerSeed2;
        } else {
            return play(playerSeed1,playerSeed2);
        }
    }

}
