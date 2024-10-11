package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Peer extends Thread{

    HashMap<String,Peer> peerHashMap;
    BlockingQueue<Message> messageQueue;
    Socket connection;
    Gson gson = new Gson();
    BufferedReader in;
    BufferedWriter out;
    String nodeID;  //public key

    public Peer(HashMap<String, Peer> peerHashMap, BlockingQueue<Message> messageQueue, Socket connection)throws IOException {
        this.peerHashMap = peerHashMap;
        this.messageQueue = messageQueue;
        this.connection = connection;
        this.in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        this.out=new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
    }

    public void send(Message m){

    }

    public void handshake(){
        Message m = new Message(Protocol.HANDSHAKE,"");
        System.out.println(Constants.SEND+" Start handshake");
        CryptoUtil.signMessage(m);
        try {
            out.write(gson.toJson(m));
            out.newLine();
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ack(){
        Message m = new Message(Protocol.ACK,"");
        System.out.println(Constants.SEND+" ack connection");
        CryptoUtil.signMessage(m);
        try {
            out.write(gson.toJson(m));
            out.newLine();
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(){
        String received;
        try {
            while (connection.isConnected()&&(received=in.readLine())!=null){
                //read from socket
                System.out.println(Constants.RECEIVE+" Received message from: "+connection.hashCode());
                Message m = gson.fromJson(received, Message.class);//sestavi obl+jekt iz Json


                if (! peerHashMap.keySet().contains(m.sender)){
                    this.nodeID = m.sender;
                    peerHashMap.put(m.sender,this);
                }
                messageQueue.put(m);

            }
        }catch (Exception e){
            System.out.println(Constants.ERROR+" Protocol violation ");
            try {
                in.close();
                out.close();
                connection.close();
                System.out.println(Constants.WARN+" Connection closed");
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }

}
