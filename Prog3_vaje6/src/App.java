import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class App {

    public static int[] numbers = new int[100_000_000];//_ je za lažjo berljivost

    //public static List<Long> partial_results = new ArrayList<>();//resitev ki ne deluje

    static int num_proc = 4;
    public static long[] partial_results = new long[num_proc];


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num_proc, new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier broken by "+ Thread.currentThread().getName());
                long res = 0;
                for (Long l : partial_results) {
                    res+=l;
                }
                System.out.println("Sum of all values: "+res);
                fillArray();
            }
        });
        fillArray();
        int chunk = numbers.length/num_proc;



        for (int i = 0; i < num_proc; i++) {
            //ustvari niti in startaj
            new Thread(new Summator(cyclicBarrier,partial_results,(i*chunk),((i+1)*chunk),numbers,i)).start();
        }

    }

    public static void fillArray(){
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=r.nextInt(1000);
        }
    }

}
