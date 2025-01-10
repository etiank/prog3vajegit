package org.vaje12;
import mpi.*;
import util.Logger;

import javax.swing.*;

public class Example1Init {

    public static void main(String[] args) {
        MPI.Init(args);

        int me = MPI.COMM_WORLD.Rank();
        int nodes = MPI.COMM_WORLD.Size();

        Logger.log("Hello from " + me + " out of " + (nodes-1));

        JFrame f = new JFrame();
        f.setSize(200,200);
        f.setVisible(true);

        MPI.Finalize();
    }

}
