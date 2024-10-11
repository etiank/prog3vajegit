package org.Vaje2;

import util.Logger;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example2");

        Worker worker = new Worker();
        worker.start();


        new Scanner(System.in).nextLine();
        Logger.log("Stopping worker...");
        worker.setRunning(false);

        worker.join();

        Logger.log("Done");

    }
}
