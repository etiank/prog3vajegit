package org.Vaje9;

import util.LogLevel;
import util.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {
    private ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public void run() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            Logger.log("Could not start server on port 7777: "+e.getMessage(), LogLevel.Error);
            return;
        }
        Logger.log("Server listening on port 7777: ");

        while (true) {
            Socket newPeerConection = null;
            try {
                newPeerConection = serverSocket.accept();
            } catch (IOException e) {
                Logger.log("Could not accept connection: "+e.getMessage(), LogLevel.Error);
                continue;
            }

            Logger.log("--- New connection: ---");
            Logger.log("-> Local IP: "+newPeerConection.getLocalAddress());
            Logger.log("-> PORT: "+newPeerConection.getLocalPort());
            Logger.log("-> Remote IP: "+newPeerConection.getInetAddress());
            Logger.log("-> Remote PORT: "+newPeerConection.getPort());
            Logger.log("-----------------------");


            try {
                executor.submit(new Peer(newPeerConection));
            } catch (IOException e) {
                Logger.log("Could not run peer: "+e.getMessage(), LogLevel.Error);
            }
        }
    }
}
