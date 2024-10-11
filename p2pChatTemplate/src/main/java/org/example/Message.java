package org.example;


public class Message {
    long timestamp;
    Protocol header;
    String signature;
    String sender;
    String body;

    public Message(Protocol header, String body) {
        this.header = header;
        this.body = body;
        this.sender = ""; // public key
        this.signature = ""; // ecc sign
        this.timestamp = System.currentTimeMillis();
    }
}
