package org.example;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class MessageService extends Thread{

    BlockingQueue<Message> messageQueue;
    HashMap<String, Peer> peerHashMap;

    public MessageService(BlockingQueue<Message> messageQueue, HashMap<String, Peer> peerHashMap) {
        this.messageQueue = messageQueue;
        this.peerHashMap = peerHashMap;
    }

    public void run(){
        while (true){
            Message message = null;
            try {
                message=messageQueue.take();
                if (CryptoUtil.verifyMessage(message)){
                    switch (message.header){
                        case HANDSHAKE:
                            peerHashMap.get(message.sender).ack();
                            break;
                        case ACK:
                            System.out.println(Constants.UTIL+" Linked to the p2p chat");
                            break;
                        case CHAT:
                            break;
                    }
                }else {
                    System.out.println(Constants.WARN+" message verification failed");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
