package org.Vaje3;

import util.LogLevel;
import util.Logger;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example 1");
        Counter counter = new Counter();
        Thread t1 = new Thread(new CountingTask(counter));
        Thread t2 = new Thread(new CountingTask(counter));
        Thread t3 = new Thread(new CountingTask(counter));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Logger.log("Count at the end: "+counter.count, LogLevel.Success);
    }


}
