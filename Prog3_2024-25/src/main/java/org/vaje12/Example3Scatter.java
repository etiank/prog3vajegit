package org.vaje12;

import mpi.MPI;
import util.Logger;

import java.util.Arrays;

public class Example3Scatter {

    public static final int ROOT = 0;

    public static void main(String[] args) {

        MPI.Init(args);

        int me = MPI.COMM_WORLD.Rank();
        int nodes = MPI.COMM_WORLD.Size();

        int[] sendBuffer = new int[nodes * 2];
        int[] receiveBuffer = new int[2];

        if (me == ROOT){
            for (int i = 0; i < nodes * 2; i++) {
                sendBuffer[i] = i;
            }
        }

        MPI.COMM_WORLD.Scatter(sendBuffer, 0, 2, MPI.INT, receiveBuffer, 0, 2, MPI.INT, ROOT);
        // cosa mandiamo, da dove cominciamo a mandare, quanto mandiamo, cosa mandiamo,
        // dove riceviamo, da dove riceviamo, quanto riceviamo, cosa riceviamo, root

        Logger.log(me + " has " + Arrays.toString(receiveBuffer));

        MPI.Finalize();

    }

}
