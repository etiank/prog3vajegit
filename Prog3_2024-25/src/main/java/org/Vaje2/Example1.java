package org.Vaje2;

import util.LogLevel;
import util.Logger;

public class Example1 {
    public static void main(String[] args) {
        Logger.log("Example 1");

        //lambda task thread
        //Thread myThread = new Thread(() -> {Logger.log("I'm a thread, the OS is about to kill me, help please!!",LogLevel.Warn);});
        //myThread.start();

        //extended thread
        Thread helloThread = new HelloThread();
        helloThread.start();

        //thread with task
        Thread taskedThread = new Thread(new HelloTask());
        taskedThread.start();

        try {
            helloThread.join();
            taskedThread.join();
        }catch (InterruptedException e) {
            Logger.log("Something went wrong",LogLevel.Error);
        }

        Logger.log("Done",LogLevel.Success);



    }
}
