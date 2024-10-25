package org.Vaje4;

import util.LogLevel;
import util.Logger;

import java.awt.*;
import java.util.Random;

public class Example1 {
    public static final int NUM_OF_THREADS=5;
    public static void main(String[] args) throws InterruptedException {

        GUI gui = new GUI();


        long start = System.currentTimeMillis();
        long endTime = start+1000;

        int totalHits=0;
        int finalTotal=0;

        DartThrower[] threads = new DartThrower[NUM_OF_THREADS];
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            threads[i]=new DartThrower(endTime,gui);
            threads[i].start();
        }

        for(DartThrower thread : threads) {
            thread.join();
            totalHits+=thread.getHits();
            finalTotal+=thread.getTotal();
        }

        double calculatedPI= 4.0*totalHits/finalTotal;
        Logger.log("Calculated PI: "+calculatedPI,LogLevel.Success);
        Logger.log("Error: "+ (calculatedPI-Math.PI),LogLevel.Error);
        Logger.log("Total: "+String.format("%,d",finalTotal),LogLevel.Success);
        gui.close();
    }
}
