package org.Vaje9;

import java.io.IOException;
import java.util.UUID;

public class Message {
    public final MessageType type;
    public final String body;
    public final String id;
    public String sender;
    public String signature;

    public Message(String rawMessage) throws IOException {
        String[] tokens = rawMessage.split(" ", 5);//2 pomeni da splita na maximum 2 kosa
        if (tokens.length != 5) {
            throw new IOException("Invalid message structure");
        }

        this.id = tokens[0];
        try {
            this.type = MessageType.valueOf(tokens[1]);
        } catch (IllegalArgumentException ex) {
            throw new IOException("Invalid message structure");
        }
        this.sender = tokens[2];
        this.signature = tokens[3];
        this.body = tokens[4];

    }

    public Message(MessageType type, String body) {
        this.type = type;
        this.body = body;
        this.id = UUID.randomUUID().toString();
        this.sender = Constants.USERNAME.replace(" ", "_");
    }

    public String toString() {
        return id + " " + type + " " + sender + " " + signature + " " + body;
    }

}
