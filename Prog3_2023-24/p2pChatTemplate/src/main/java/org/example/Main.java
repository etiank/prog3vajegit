package org.example;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static final int port = 6000;
    public static final String entryPoint = "172.16.153.10";
    public static boolean isentryPoint=false;
    public static String myIp;

    public static void main(String[] args) {
        findMyIp();

        CryptoUtil.generatePubPvtKey();
        HashMap<String, Peer> peerHashMap = new HashMap<>();
        BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();

        new InputHandler(peerHashMap).start();
        new MessageService(messageQueue,peerHashMap).start();

        if (!isentryPoint){
            //first connection
            try {
                Socket connection = new Socket(entryPoint,port);
                Peer p = new Peer(peerHashMap,messageQueue,connection);
                p.start();
                p.handshake();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println(Constants.UTIL+" Server running on port: "+port);
            while (true){
                Socket connection = server.accept();
                Peer p = new Peer(peerHashMap,messageQueue,connection);
                p.start();
                System.out.println(Constants.UTIL+" Connection accepted on port: "+connection.getPort());
            }
        } catch (IOException e) {
            System.out.println(Constants.ERROR+" Port already in use");
        }

    }

    public static void findMyIp(){
        //find my Ip:
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface inter = (NetworkInterface) e.nextElement();
                if (inter.isUp() && !inter.isLoopback()) {
                    Enumeration addr = inter.getInetAddresses();
                    while (addr.hasMoreElements()) {
                        InetAddress address = (InetAddress) addr.nextElement();
                        myIp = address.getHostAddress().replace("/", "");
                        if (myIp.length() <= 15) { //ipv4
                            System.out.println(Constants.UTIL + " LocalIp: " + myIp);
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }
}