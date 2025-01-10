package org.vaje12;

import mpi.MPI;
import util.Logger;

import java.util.Arrays;

public class Example5Allgather {

    public static final int ROOT = 0;

    public static void main(String[] args) {

        MPI.Init(args);

        int me = MPI.COMM_WORLD.Rank();
        int nodes = MPI.COMM_WORLD.Size();

        int[] sendBuffer = new int[3];
        int[] receiveBuffer = new int[nodes * 3]; // zbira vse koscke v en velik buffer

        sendBuffer[0] = me + 1;
        sendBuffer[1] = me + 1;
        sendBuffer[2] = me + 1;

        MPI.COMM_WORLD.Allgather(sendBuffer, 0, 3, MPI.INT,
                receiveBuffer, 0, 3, MPI.INT); // ni roota na koncu ker noben ne dela nic posebnega (ni main characterja)

        Logger.log(me + " has " + Arrays.toString(receiveBuffer));

        MPI.Finalize();

    }
}
