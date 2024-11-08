package org.Vaje5_producerConsumer;

public class Event {
    private int ticketId;
    private EventType eventType;

    public Event(EventType eventType, int ticketId) {
        this.eventType = eventType;
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public EventType getEventType() {
        return eventType;
    }

}
