package org.Vaje5_producerConsumer;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Storage {
    private ArrayList<Integer> tickets = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();//reentrant pomeni da lahko zaklenes veckrat
    //to pride prav za rekurzije, da ne moras zaklenit samega sebe

    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public void addTicket(int ticket) {
        writeLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tickets.add(ticket);
        writeLock.unlock();
    }

    public boolean ticketExists(int ticket) {
        readLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean result = tickets.contains(ticket);
        readLock.unlock();
        return result;
    }

    public void removeTicket(int ticket) {
        writeLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int index = tickets.indexOf(ticket);
        tickets.remove(index);
        writeLock.unlock();
    }


}
