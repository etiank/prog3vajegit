package org.Vaje2;

import util.LogLevel;
import util.Logger;

public class HelloTask implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("Hello task");
        Logger.log("I will die now", LogLevel.Warn);
    }
}
