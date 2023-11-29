import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    //seznam sosednosti - adjacency list
    //usmerjen graf
    public static HashMap<Integer, Set<Integer>> graph = new HashMap();


    public static void main(String[] args) {
        populateGraph(40_000,2_000_000);
        long t0 = System.currentTimeMillis();
        ccSequential();
        long t1 = System.currentTimeMillis()-t0;
        System.out.println("Cas sekvencno: "+t1+" ms");

        t0 = System.currentTimeMillis();
        ccParalel();
        t1 = System.currentTimeMillis()-t0;
        System.out.println("Cas paralelno: "+t1+" ms");


    }

    public static double ccParalel(){
        ParallelCCTask.graph=graph;
        int num_proc = Runtime.getRuntime().availableProcessors();//stevilo jeder
        Set[] startVertices = new Set[num_proc];
        for (int i = 0; i < startVertices.length; i++) {
            startVertices[i]=new HashSet();
        }
        for (Integer n : graph.keySet()) {
            startVertices[n%num_proc].add(n);
        }
        ExecutorService executor = Executors.newFixedThreadPool(num_proc);
        for (Set<Integer> s:startVertices) {
            executor.submit(new ParallelCCTask(s));
        }
        executor.shutdown();
        while (!executor.isTerminated()){};
        return ParallelCCTask.getCC();
    }


    public static double ccSequential(){
        double cc = 0;
        int openTriplets = 0;
        int closedTriplets = 0;

        for (Integer n : graph.keySet()) {
            for (Integer v : graph.get(n)) {
                for (Integer u : graph.get(v)) {
                    if (u != n){
                        //nasli smo triplet
                        if (graph.get(u).contains(n)){
                            //closed
                            closedTriplets++;
                        }else {
                            //open
                            openTriplets++;
                        }
                    }
                }
            }
        }
        cc = closedTriplets/(1.0*(closedTriplets+openTriplets));
        System.out.println("Clustering coeficient: "+cc+" open triplets: "+openTriplets+" closed triplets: "+closedTriplets);
        return cc;
    }





    public static void populateGraph(int n, int e){
        int links = e;
        Random r = new Random();
        //ustvarili n vozlišč
        for (int i = 0; i < n; i++) {
            graph.put(i,new HashSet<>());
        }
        //naključno poveži vozlišča
        while (e>0){
            int v = r.nextInt(n);
            int u = r.nextInt(n);
            if (v!=u){
                if (!graph.get(v).contains(u)){
                    //ustvari povezavo
                    graph.get(v).add(u);
                    e--;
                }
            }
        }
        System.out.println("Ustvarili smo nakljucen usmerjen graf s: "+n+" vozlišči in "+links+" povezavami");
    }
}
