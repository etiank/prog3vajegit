package org.Vaje10;

import util.LogLevel;
import util.Logger;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.*;

public class Example2 {

    public static int CORES = Runtime.getRuntime().availableProcessors();
    public static ForkJoinPool forkJoinPool = new ForkJoinPool(CORES);

    public static int PLAYERS = 64;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger.log("Running tournament with ForkJoinPool.", LogLevel.Info);
        long start = System.currentTimeMillis();

        Integer[] playerSeeds = new Integer[PLAYERS];
        for (int i = 0; i < PLAYERS; i++) {
            playerSeeds[i] = i;
        }


        RecursiveMatch match = new RecursiveMatch(playerSeeds);
        Integer bestSeed = forkJoinPool.invoke(match);
        Logger.log("Best seed: " + bestSeed, LogLevel.Info);



        long end = System.currentTimeMillis();
        Logger.log("Took: " + (end-start) + "ms", LogLevel.Info);


    }

}
