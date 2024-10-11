import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class StejDeljitelje {

    public static void main(String[] args) {
        Random r = new Random();
        int[] stevila = new int[5_000_000];
        for (int i = 0; i < stevila.length; i++) {
            stevila[i]=r.nextInt(10_000);
        }

        seqStejDeljitelje(stevila);
        fjDumbDeljitelji(stevila);
        fjDeljitelji(stevila);
    }


    public static void seqStejDeljitelje(int[] stevila){
        long t0 = System.currentTimeMillis();
        long st = 0;
        for (int i = 0; i < stevila.length; i++) {
            st += deljitelji(stevila[i]);
        }
        long t = System.currentTimeMillis()-t0;
        System.out.println("Sekvencna, st deljiteljev: "+st+" v casu: "+t+" ms" );
    }


    public static void fjDumbDeljitelji(int[] stevila){
        ForkJoinPool myPool = (ForkJoinPool) Executors.newWorkStealingPool();

        long t0 = System.currentTimeMillis();
        long st = 0;

        DumbForkJoinTask task = new DumbForkJoinTask(stevila);
        st = myPool.invoke(task);
        //st = ForkJoinPool.commonPool().invoke();//ne uporabljaj tega

        long t = System.currentTimeMillis()-t0;
        System.out.println("Dumb fork join framework, st deljiteljev: "+st+" v casu: "+t+" ms" );
        System.out.println("Stevilo work stealinga: "+myPool.getStealCount());//work stealing je pocasna operacija
    }


    public static void fjDeljitelji(int[] stevila){
        ForkJoinPool myPool = (ForkJoinPool) Executors.newWorkStealingPool();

        long t0 = System.currentTimeMillis();
        long st = 0;

        FjStDeljiteljev task = new FjStDeljiteljev(stevila,0,stevila.length);
        st = myPool.invoke(task);

        long t = System.currentTimeMillis()-t0;
        System.out.println("Pravilen fork join framework, st deljiteljev: "+st+" v casu: "+t+" ms" );
        System.out.println("Stevilo work stealinga: "+myPool.getStealCount());//work stealing je pocasna operacija
    }



    public static int deljitelji(int n){
        int d = 0;
        for (int i = 1; i <= (n/2); i++) {
            if (n%i==0) {
                d++;
            }
        }
        return d+1;
    }


}
