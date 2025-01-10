package org.vaje12;

import mpi.MPI;
import util.Logger;

import java.util.Arrays;

public class Example2Broadcast {

    public static final int GROOT = 0; // XD it's actually root

    public static void main(String[] args) {

        MPI.Init(args);

        int me = MPI.COMM_WORLD.Rank();
        int nodes = MPI.COMM_WORLD.Size();

        // broadcast, posljemo isti msg vsem
        int[] buffer = new int[1];

        if (me == GROOT) {
            buffer[0] = 3; // root ima 3, vsi ostali imajo se 0
        }

        MPI.COMM_WORLD.Bcast(buffer, 0, 1, MPI.INT, GROOT);

        //POZOR TUDI SAMEMU SEBI POSILJA
        Logger.log(me + " has " + Arrays.toString(buffer));

        MPI.Finalize();

    }

}
