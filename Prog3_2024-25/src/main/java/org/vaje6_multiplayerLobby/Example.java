package org.vaje6_multiplayerLobby;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Scanner sc = new Scanner(System.in);
        while (true) {
            sc.nextLine();

            executorService.submit(new Player());


        }
    }

}
