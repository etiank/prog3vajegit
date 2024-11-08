package org.Vaje5_producerConsumer;

import util.LogLevel;
import util.Logger;

public class CreateTicketConsumer extends Thread {
    private EventQueue eventQueue;
    private Storage storage;

    public CreateTicketConsumer(EventQueue eventQueue, Storage storage) {
        this.eventQueue = eventQueue;
        this.storage = storage;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("CreateTicketConsumer");
        while (true) {
            Event eventToHandle = eventQueue.getEventIfType(EventType.CreateTicket);
            if (eventToHandle == null) {
                continue;
            }
            if (storage.ticketExists(eventToHandle.getTicketId())){
                Logger.log("Ticket already exists", LogLevel.Warn);
                continue;
            }else {
                storage.addTicket(eventToHandle.getTicketId());
            }


        }
    }
}
