package org.Vaje3;

import util.LogLevel;
import util.Logger;

public class SynchronizedCountingTask implements Runnable {
    private SynchronizedCounter counter;


    public SynchronizedCountingTask(SynchronizedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        Logger.log("Incrementing");
        for (int i = 0; i < 1_000_000; i++) {
            counter.increment();
        }
        Logger.log("Finished", LogLevel.Success);
    }
}
