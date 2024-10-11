package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class InputHandler extends Thread{

    private HashMap<String, Peer> peerHashMap;

    public InputHandler( HashMap<String, Peer> peerHashMap){
        this.peerHashMap = peerHashMap;
    }

    public void run(){
        Scanner vhod = new Scanner(System.in);
        while(true){
            String message = vhod.nextLine();
            Message m = new Message(Protocol.CHAT,message);
            CryptoUtil.signMessage(m);

            peerHashMap.values().forEach(peer ->{
                peer.send(m);
            });
        }
    }
}
