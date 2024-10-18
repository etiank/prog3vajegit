package org.Vaje3;

import util.LogLevel;
import util.Logger;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example2");

        SynchronizedCounter counter = new SynchronizedCounter();

        Thread t1 = new Thread(new SynchronizedCountingTask(counter));
        Thread t2 = new Thread(new SynchronizedCountingTask(counter));
        Thread t3 = new Thread(new SynchronizedCountingTask(counter));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Logger.log("Final value: "+counter.get(), LogLevel.Success);
    }
}
