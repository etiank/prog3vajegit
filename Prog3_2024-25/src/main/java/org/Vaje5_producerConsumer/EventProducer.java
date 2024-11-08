package org.Vaje5_producerConsumer;

import java.util.Random;

public class EventProducer extends Thread {
    private EventQueue eventQueue;

    public EventProducer(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("EventProducer");
        Random random = new Random();
        EventType[] possibleEventTypes = EventType.values();
        for (int i = 0; i < 1000; i++) {
            int ticketId = random.nextInt(100);
            int randomEventindex = random.nextInt(possibleEventTypes.length);
            EventType randomEventType = possibleEventTypes[randomEventindex];
            Event event = new Event(randomEventType,ticketId);
            eventQueue.addEvent(event);
        }
    }
}
