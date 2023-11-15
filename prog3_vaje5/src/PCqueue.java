import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PCqueue {

    static BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(1);
    static Random r = new Random();

    public static void produce(){
        while (true){
            Integer value = r.nextInt(100);
            try {
                buffer.put(value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" produced: "+value);
        }
    }

    public static void consume(){
        while (true){
            try {
                System.out.println(Thread.currentThread().getName()+" consumed: +"+buffer.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        }).start();




        //Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                    consume();
            }
        }).start();

        //Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        }).start();

        //Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        }).start();

        //Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        }).start();



        //Delaj za toliko ms
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);//zakljuci program
    }



}
