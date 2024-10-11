package org.Vaje2;

import util.Logger;

public class Worker extends Thread {
    //volatile pomeni da za njo ne uporabi cache-a ampak jo bere vedno iz spomina
    private volatile boolean running = true;
    @Override
    public void run() {
        Logger.log("Worker started working...");
        while (running) {

        }
        Logger.log("Worker stopped working!");
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
}
