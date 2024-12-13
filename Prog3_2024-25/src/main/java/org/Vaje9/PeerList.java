package org.Vaje9;

import util.LogLevel;
import util.Logger;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class PeerList {

    private static ArrayList<Peer> peers = new ArrayList<>();

    public synchronized static void addPeer(Peer peer) {
        peers.add(peer);
    }

    public synchronized static void removePeer(Peer peer) {
        peers.remove(peer);
    }

    public synchronized static void broadcast(Message message) {
        for (Peer peer : peers) {
 
            peer.sendMessage(message);
        }
    }

    public synchronized static void connectToRemote(String ip){
        Socket socket = null;

        for(Peer peer : peers){
            if(ip.equals(peer.getIP())){
                return;
            }
        }

        try {
            socket = new Socket(ip, Constants.PORT);
        } catch (IOException e) {
            Logger.log("Could not connect to socket: "+ e.getMessage(), LogLevel.Error);
        }

        Peer peer = null;
        try {
            peer = new Peer(socket);
        } catch (IOException e) {
            Logger.log("Could not create peer"+e.getMessage(), LogLevel.Error);
        }


        new Thread(peer).start();

        
        if (peers.size()<2) {
            peer.sendMessage(new Message(MessageType.PEER_DISCOVERY_REQUEST, "2"));
        }

    }

    public synchronized static String[] getPeerIps(int max){
        int ipsToPull = Math.min(max, peers.size());
        Collections.shuffle(peers);//zmesa peere da ne vrne vedno istih
        String[] ips = new String[ipsToPull];
        for (int i = 0; i < ipsToPull; i++) {
            ips[i]=peers.get(i).getIP();

        }
        return ips;
    }


}
