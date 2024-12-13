package org.Vaje10;

import util.LogLevel;
import util.Logger;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example1 {

    public static int CORES = Runtime.getRuntime().availableProcessors();
    public static ExecutorService matchPool = Executors.newFixedThreadPool(CORES); //leave some cores for the OS for longer tasks

    public static int PLAYERS = 32;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger.log("Running tournament with callables.", LogLevel.Info);
        long start = System.currentTimeMillis();

        Integer[] playerSeeds = new Integer[PLAYERS];
        for (int i = 0; i < PLAYERS; i++) {
            playerSeeds[i] = i;
        }

        Match match = new Match(playerSeeds);
        Future<Integer> bestSeedFuture = matchPool.submit(match);
        int bestSeed = bestSeedFuture.get();
        Logger.log("Best: " + bestSeed, LogLevel.Info);



        long end = System.currentTimeMillis();
        Logger.log("Took: " + (end-start) + "ms", LogLevel.Info);


    }

}
