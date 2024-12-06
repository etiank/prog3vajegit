package org.Vaje9;

import java.util.Scanner;

public class UserInput extends Thread {


    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        while (true) {
            String body = s.nextLine();
           
            PeerList.broadcast(new Message(MessageType.CHAT, body));
        }
    }
}
