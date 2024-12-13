package org.Vaje10;

import util.Logger;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import static org.Vaje10.Example1.matchPool;


public class Match implements Callable<Integer> {

    private Integer[] playerSeeds;

    public Match(Integer[] playerSeeds) {
        this.playerSeeds = playerSeeds;
    }

    @Override
    public Integer call() throws Exception {
        if (playerSeeds.length == 1) {
            return playerSeeds[0];
        }

        if (playerSeeds.length == 2) {
            return play(playerSeeds[0],playerSeeds[1]);
        }

        Integer[] firstHalf = Arrays.copyOfRange(playerSeeds, 0, playerSeeds.length/2);
        Integer[] secondHalf = Arrays.copyOfRange(playerSeeds,  playerSeeds.length/2, playerSeeds.length);

        Match firstMatch = new Match(firstHalf);
        Match secondMatch = new Match(secondHalf);

        Future<Integer> bestFirstFuture = Example1.matchPool.submit(firstMatch);
        Future<Integer> bestSecondFuture = Example1.matchPool.submit(secondMatch);

        //code

        Integer bestFirstHalf = bestFirstFuture.get(); // ends the threads, blocking
        Integer bestSecondHalf = bestSecondFuture.get();

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
