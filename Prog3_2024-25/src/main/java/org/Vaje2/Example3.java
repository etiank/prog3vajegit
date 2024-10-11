package org.Vaje2;

import util.Logger;

public class Example3 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example3");
        int count = 0;//to ne dela ker da vrednost ne referenco

        Thread t1 = new Thread(new IncorrectCountingTask(count));
        Thread t2 = new Thread(new IncorrectCountingTask(count));
        Thread t3 = new Thread(new IncorrectCountingTask(count));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Logger.log("Count at the end: "+count);


    }
}
