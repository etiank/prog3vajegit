package org.Vaje9;

import util.LogLevel;
import util.Logger;

import java.io.*;
import java.net.Socket;

public class Peer implements Runnable{

    private Socket socket;
    private BufferedReader peerReader;
    private BufferedWriter peerWriter;

    public Peer (Socket socket) throws IOException {
        this.socket = socket;

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osr = new OutputStreamWriter(os);

        peerReader = new BufferedReader(isr);
        peerWriter = new BufferedWriter(osr);
    }

    @Override
    public void run() {
        PeerList.addPeer(this);

        while (true) {
            String rawMessage = waitForMessage();
            if (rawMessage == null) {
                Logger.log("Disconnecting from peer...",LogLevel.Warn);
                break;
            }
            
            Message message = null;
            try{
                message = new Message(rawMessage);
            }catch (IOException e){
                Logger.log("Protocol violation: "+ e.getMessage(), LogLevel.Error);
                break;
            }
            
            Logger.log(message.toString(),LogLevel.Debug);
            TaskQueue.queue.add(new Task(this, message));

            
        }
        
        PeerList.removePeer(this);

        try {
            peerReader.close();
            peerWriter.close();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private String waitForMessage() {
        try {
            return peerReader.readLine();
        } catch (IOException e) {
            Logger.log("Could not read message: "+e.getMessage(), LogLevel.Error);
            return null;
        }

    }

    public void sendMessage(Message message) {
        try {
            Logger.log("Sending message", LogLevel.Debug);
            peerWriter.write(message+"\n");
            peerWriter.flush();
        } catch (IOException e) {
            Logger.log("Could not write message: "+e.getMessage(), LogLevel.Error);
        }
    }

    public String getIP(){
        return socket.getInetAddress().toString().replace("/", "");//zbrise zacetni /
    }

}
