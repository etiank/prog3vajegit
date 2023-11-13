import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FindMax implements Runnable{

    public static int[] polje = new int[500000000];
    public static Random r = new Random();

    public static AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
    //volatile ne deluje
    public int startIndex;
    public int koncniIndex;

    public static void main(String[] args) {
        //napolnimo polje
        for (int i = 0; i < polje.length; i++) {
            polje[i]=r.nextInt(1000);
        }
        //na naključno polje damo neko velko stevilo
        polje[r.nextInt(polje.length)] = Integer.MAX_VALUE;


        //sekvencno iskanje
        int mas = Integer.MIN_VALUE;
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < polje.length; i++) {
            if (mas<polje[i]){
                mas=polje[i];
            }
        }
        long t1 = System.currentTimeMillis() - t0;
        System.out.println("Sekvencno iskanje je naslo max: "+mas+" v casu "+t1+"ms");



        //vzporedna izvedba
        t0 = System.currentTimeMillis();
        int numProc = 10000;//Runtime.getRuntime().availableProcessors();//vrne st procesorjev racunalnika

        System.out.println("St procesorjev je: "+numProc);

        int chunk = (polje.length/numProc)+1;//velikost segmenta ki bo obdelal nit
        Thread[] niti = new Thread[numProc];
        for (int i = 0; i < numProc; i++) {
            niti[i]= new Thread(new FindMax(i,chunk));
            niti[i].start();
        }
        for (int i = 0; i < numProc; i++) {
            try {
                niti[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        t1 = System.currentTimeMillis() - t0;
        System.out.println("Vzporedno iskanje je naslo max: "+max.get()+" v casu "+t1+"ms");



        //vzporedna izvedba s thread pool-om
        max.set(Integer.MIN_VALUE);
        t0=System.currentTimeMillis();
        numProc = Runtime.getRuntime().availableProcessors();

        int numTask = 10000;
        ExecutorService executor = Executors.newFixedThreadPool(numProc);
        chunk = (polje.length/numTask)+1;
        for (int i = 0; i < numTask; i++) {
            executor.submit(new FindMax(i,chunk));//submitamo taske executorju
        }
        //zapre executor
        executor.shutdown();
        while (!executor.isTerminated()){}//cakaj


        t1 = System.currentTimeMillis() - t0;
        System.out.println("Vzporedno iskanje s thread pool-om je naslo max: "+max.get()+" v casu "+t1+"ms");
    }

    public FindMax(int index, int chunkSize){
        this.startIndex = index * chunkSize;
        this.koncniIndex = Math.min(startIndex+chunkSize, polje.length);//da ne zletimo izven polja
    }


    @Override
    public void run() {
        for (int i = startIndex; i < koncniIndex; i++) {
            updateMax(polje[i]);
        }
    }
    //atomic CAS - compare and swap
    public static void updateMax(int newValue){
        int prevValue;
        do {
            prevValue = max.get();
            if (prevValue >= newValue) {
                return;
            }
            //compareAndSet se enkrat testira, da se ni slucajno vmes spremenil
        }while(!max.compareAndSet(prevValue,newValue));
    }


}
