package org.Vaje2;

import util.Logger;

public class countingTask implements Runnable {
    private Counter counter;
    public countingTask(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        Logger.log("Counting...");
        for (int i = 0; i < 100_000; i++) {
            counter.count++;
        }
        Logger.log("Done counting.");
    }
}
