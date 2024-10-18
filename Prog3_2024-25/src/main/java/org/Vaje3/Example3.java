package org.Vaje3;

import util.LogLevel;
import util.Logger;

public class Example3 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example3");

        increment();
        incrementBoth();
        incrementSingle();

        Logger.log("Done");

    }

    private static void increment() throws InterruptedException {
        long start = System.currentTimeMillis();
        DoubleCounter counter = new DoubleCounter();
        Thread t1 = new Thread(new DoubleCountingTask(counter,CounterSelector.First));
        Thread t2 = new Thread(new DoubleCountingTask(counter,CounterSelector.First));
        Thread t3 = new Thread(new DoubleCountingTask(counter,CounterSelector.First));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long end = System.currentTimeMillis();
        Logger.log("Time: "+(end-start)+" ms",LogLevel.Status);
        Logger.log("Counter 1 at the end: "+counter.getCount1(), LogLevel.Success);
    }


    private static void incrementBoth() throws InterruptedException {
        long start = System.currentTimeMillis();
        DoubleCounter counter = new DoubleCounter();

        //problem je, da vsak thread zaklene doublecounter v celoti, tudi ce incrementamo dve
        //razlicni spremenljivki v njem je torej ko zaklenemo eno nedostopna tudi druga
        Thread t1 = new Thread(new DoubleCountingTask(counter,CounterSelector.First));
        Thread t2 = new Thread(new DoubleCountingTask(counter,CounterSelector.First));
        Thread t3 = new Thread(new DoubleCountingTask(counter,CounterSelector.First));
        Thread t4 = new Thread(new DoubleCountingTask(counter,CounterSelector.Second));
        Thread t5 = new Thread(new DoubleCountingTask(counter,CounterSelector.Second));
        Thread t6 = new Thread(new DoubleCountingTask(counter,CounterSelector.Second));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        long end = System.currentTimeMillis();
        Logger.log("Time: "+(end-start)+" ms",LogLevel.Status);
        Logger.log("Counter 1 at the end: "+counter.getCount1(), LogLevel.Success);
        Logger.log("Counter 2 at the end: "+counter.getCount2(), LogLevel.Success);

    }

    private static void incrementSingle(){
        long start = System.currentTimeMillis();
        int count=0;
        for (int i = 0; i < 3_000_000; i++) {
            count++;
        }
        long end = System.currentTimeMillis();
        Logger.log("Time: "+(end-start)+" ms",LogLevel.Status);
        Logger.log("Counter at the end: "+count, LogLevel.Success);
    }


}
