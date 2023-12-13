package org.example;

import org.example.item.ClientItem;
import org.example.item.Item;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.BlockingQueue;

@ClientEndpoint
public class BlockchainClient {
    private static Session userSession;
    public static BlockingQueue<Item> messageQueue;
    @OnOpen
    public void onOpen(Session session){
        userSession = session;
        System.out.println("Connected to server.");
    }

    @OnMessage
    public void onMesseage(String message){
        try {
            messageQueue.put(new ClientItem(message));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @OnClose
    public void onClose(CloseReason closeReason){
        System.out.println("Closed connection "+closeReason.getReasonPhrase());
    }


    public static void askLastBlock(){
        try {
            userSession.getBasicRemote().sendText("last-block");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void connect(BlockingQueue<Item> queue){

        messageQueue = queue;

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "wss://prog3.student.famnit.upr.si/hashchain";

        try {
            container.connectToServer(BlockchainClient.class, URI.create(uri));
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
