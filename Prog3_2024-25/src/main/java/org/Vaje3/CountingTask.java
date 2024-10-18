package org.Vaje3;

import util.LogLevel;
import util.Logger;

public class CountingTask implements Runnable {
    private Counter counter;

    public CountingTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        Logger.log("Incrementing...");
        for (int i = 0; i < 1_000_000; i++) {
            counter.count.getAndIncrement();
        }
        Logger.log("Done",LogLevel.Success);
    }
}
