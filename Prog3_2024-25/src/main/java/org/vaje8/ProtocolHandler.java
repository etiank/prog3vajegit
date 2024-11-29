package org.vaje8;

import util.LogLevel;
import util.Logger;

public class ProtocolHandler extends Thread{

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

            switch (task.message.type) {
                case CHAT -> handleChat(task);
                case PEER_DISCOVERY_REQUEST -> handlePeerDiscoveryRequest(task);
                case PEER_DISCOVERY_RESPONSE ->handlePeerDiscoveryResponse(task);
            }
        }
    }
    
    private void handleChat(Task task){
        Logger.log(task.message.body, LogLevel.Success);
        // PeerList.broadcast(task.message);
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
