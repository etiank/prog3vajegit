package org.Vaje3;

import util.LogLevel;
import util.Logger;

public class DoubleCountingTask implements Runnable {
    private DoubleCounter counter;
    private CounterSelector selector;
    public DoubleCountingTask(DoubleCounter counter,CounterSelector selector) {
        this.counter = counter;
        this.selector = selector;
    }

    @Override
    public void run() {
        Logger.log("Incrementing...");
        for (int i = 0; i < 1_000_000; i++) {
            if (selector==CounterSelector.First){
                counter.incrementC1();
            }
            if (selector==CounterSelector.Second){
                counter.incrementC2();
            }
        }
        Logger.log("Done", LogLevel.Success);
    }
}
