package org.Vaje2;

import util.Logger;

public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example4");
        Counter counter = new Counter();

        Thread t1 = new Thread(new countingTask(counter));
        Thread t2 = new Thread(new countingTask(counter));
        Thread t3 = new Thread(new countingTask(counter));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Logger.log("Count at the end: "+counter.count);


    }
}
