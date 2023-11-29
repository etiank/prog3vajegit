import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelCCTask implements Runnable{

    public static HashMap<Integer, Set<Integer>> graph;
    private Set<Integer> startVertices;//delo ki bo obdelal thread
    private static AtomicInteger closedTriplets = new AtomicInteger();
    private static AtomicInteger openTriplets = new AtomicInteger();

    public ParallelCCTask(Set<Integer> startVertices){
        this.startVertices=startVertices;
    }
    @Override
    public void run() {
        for (Integer n : this.startVertices) {
            for (Integer v : graph.get(n)) {
                for (Integer u : graph.get(v)) {
                    if (u != n){
                        //nasli smo triplet
                        if (graph.get(u).contains(n)){
                            //closed
                            closedTriplets.incrementAndGet();
                        }else {
                            //open
                            openTriplets.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    public static double getCC(){
        double cc = closedTriplets.get()/(1.0*(closedTriplets.get()+openTriplets.get()));
        System.out.println("Clustering coeficient: "+cc+" open triplets: "+openTriplets.get()+" closed triplets: "+closedTriplets.get());
        return cc;
    }

}
