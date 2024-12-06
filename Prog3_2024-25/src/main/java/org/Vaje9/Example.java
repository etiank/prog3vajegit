package org.Vaje9;


import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        //to connect: telnet localhost 7777
        //to see: netstat -nlp | grep 7777

       new Server().start();
       new UserInput().start();
       new ProtocolHandler().start();


        if (!Constants.MY_IP.equals(Constants.BOOTSTRAP_IP)) //ce nisi ti server se povezi nanj
            PeerList.connectToRemote(Constants.BOOTSTRAP_IP);
        }


    
}
