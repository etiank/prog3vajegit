package org.example;

import com.google.gson.Gson;
import org.example.item.ClientItem;
import org.example.item.Item;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static BlockingQueue<Item> queue = new LinkedBlockingQueue();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        BlockchainClient.connect(queue);

        Item item;
        while (true){
            try {
                item = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (item instanceof ClientItem){
                processClientItem((ClientItem) item);
            }
        }
    }

    public static void processClientItem(ClientItem item){
        System.out.println(item.message);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BlockchainClient.askLastBlock();
        

    }

}