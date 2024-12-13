package org.Vaje9;

import util.LogLevel;
import util.Logger;

import java.util.ArrayList;

public class ProtocolHandler extends Thread{

    private ArrayList<String> history = new ArrayList<>();
    @Override
    public void run() {
        while (true) {
            Task task = null;

            try {
                task = TaskQueue.queue.take();
            } catch (InterruptedException e) {
                Logger.log("Could not take task: "+e.getMessage(), LogLevel.Error);
                continue;
            }

            if(!CryptoUtil.verifyMessage(task.message)){
                continue;
            }

            if (history.contains(task.message.id)){
                continue;
            }
            history.add(task.message.id);



            try{
                switch (task.message.type) {
                case CHAT -> handleChat(task);
                case PEER_DISCOVERY_REQUEST -> handlePeerDiscoveryRequest(task);
                case PEER_DISCOVERY_RESPONSE ->handlePeerDiscoveryResponse(task);
            }}catch(Exception e){
                Logger.log("Error handling message!", LogLevel.Error);
            }        }
    }
    
    private void handleChat(Task task){
        Logger.chat(task.message.sender, task.message.body);
        //PeerList.broadcast(task.message);
    }


    private void handlePeerDiscoveryRequest(Task task){
        int ipsToPull = Integer.parseInt(task.message.body);
        String[] ips = PeerList.getPeerIps(ipsToPull);
        String body = String.join(";", ips);
        task.sender.sendMessage(new Message(MessageType.PEER_DISCOVERY_RESPONSE, body));
    }

    private void handlePeerDiscoveryResponse(Task task){
        String[] ips = task.message.body.split(";");
        for (String ip : ips) {
            if (!ip.equals(Constants.MY_IP)) {
                PeerList.connectToRemote(ip);    
            }
            
        }
    }
    
}
