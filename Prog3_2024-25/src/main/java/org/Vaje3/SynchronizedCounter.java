package org.Vaje3;

public class SynchronizedCounter {
    private int count=0;
    public synchronized void increment() {
        count++;
    }
    public synchronized int get() {
        return count;
    }

}
