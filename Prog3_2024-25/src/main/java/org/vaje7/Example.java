package org.vaje7;

import util.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) throws IOException {
        //to connect: telnet localhost 7777
        //to see: netstat -nlp | grep 7777

       new Server().start();
       new UserInput().start();

    }
}
