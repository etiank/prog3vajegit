package org.vaje8;

import java.io.IOException;

public class Message {
    public final MessageType type;
    public final String body;

    public Message(MessageType type, String body){
        this.type = type;
        this.body = body;
    }

    public Message(String rawMessage) throws IOException{
        String[] tokens = rawMessage.split(" ",2);//2 pomeni da splita na maximum 2 kosa
        if (tokens.length!=2) {
            throw new IOException("Invalid message structure");
        }
        this.type = MessageType.valueOf(tokens[0]);
        this.body = tokens[1];
        
    }

    public String toString(){
        return type+" "+body;
    }

}
