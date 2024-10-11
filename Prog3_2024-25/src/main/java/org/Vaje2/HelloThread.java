package org.Vaje2;

import util.LogLevel;
import util.Logger;

public class HelloThread extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("Hello thread");
        Logger.log("I'am about to be killed by the OS", LogLevel.Warn);
    }

    @Override
    public void start() {
        super.start();
    }
}
