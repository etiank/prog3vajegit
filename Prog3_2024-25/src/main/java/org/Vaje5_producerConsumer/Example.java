package org.Vaje5_producerConsumer;

import util.LogLevel;
import util.Logger;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Progucer-consumer system");
        long startTime = System.currentTimeMillis();

        EventQueue queue = new EventQueue();
        Storage storage = new Storage();

        EventProducer producer = new EventProducer(queue);
        producer.start();

        CreateTicketConsumer createTicketConsumer = new CreateTicketConsumer(queue, storage);
        ValidateTicketConsumer validateTicketConsumer = new ValidateTicketConsumer(queue, storage);
        UseTicketConsumer useTicketConsumer = new UseTicketConsumer(queue, storage);


        createTicketConsumer.setDaemon(true);
        validateTicketConsumer.setDaemon(true);
        useTicketConsumer.setDaemon(true);


        createTicketConsumer.start();
        validateTicketConsumer.start();
        useTicketConsumer.start();

        producer.join();

        while (queue.getSize()>0){
            Thread.sleep(50);
        }


        long endTime = System.currentTimeMillis();
        Logger.log("Time: " + (endTime - startTime) + "ms", LogLevel.Success);
    }
}
