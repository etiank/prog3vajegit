package org.Vaje11;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        Map.init();

        new Thread(new Gui()).start();
        new Thread(new GameLoop()).start();
        new Thread(new InputHandler()).start();
    }



}
