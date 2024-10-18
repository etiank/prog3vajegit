package org.Vaje3;

public class DoubleCounter {
    private int count1=0;
    private int count2=0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    /*
    public synchronized void incrementC1(){
        count1++;
    }
    public synchronized void incrementC2(){
        count2++;
    }
    */

    //s tem lock premaknemo na druge objekte namesto this, ki zaklene cel doublecounter
    public void incrementC1(){
        synchronized (lock1) {
            count1++;
        }
    }
    public void incrementC2(){
        synchronized (lock2) {
            count2++;
        }
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }
}
