package org.vaje12;

import mpi.MPI;
import util.Logger;

import java.util.Arrays;

public class Example7Allreduce {

    public static final int ROOT = 0;

    public static void main(String[] args) {

        MPI.Init(args);

        int me = MPI.COMM_WORLD.Rank();
        int node = MPI.COMM_WORLD.Size();

        int[] sendBuffer = new int[1];
        int[] receiveBuffer = new int[1];

        sendBuffer[0] = me + 1;


        MPI.COMM_WORLD.Allreduce(sendBuffer,0,
                receiveBuffer, 0, 1, MPI.INT, MPI.SUM); // no main character

        Logger.log(me + " has " + Arrays.toString(receiveBuffer));

        MPI.Finalize();

    }

}
