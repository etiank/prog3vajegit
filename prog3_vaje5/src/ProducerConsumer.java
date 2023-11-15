import java.util.Random;

public class ProducerConsumer {
    public static Buffer buffer = new Buffer(10);
    public static Random r = new Random();
    public static void produce() throws InterruptedException{
        while (true){
            synchronized (buffer) {//pridobimo monitor buferja
                while (buffer.isFull()){
                    buffer.wait();//cakamo na bufferju
                }
                Integer value = r.nextInt(100);
                buffer.push(value);
                buffer.notifyAll();//reci consumerju da nadaljuje
                System.out.println(Thread.currentThread().getName() + " produced: " + value);
            }
        }
    }
    public static void consume() throws InterruptedException{
        while (true){
            synchronized (buffer) {
                while (buffer.isEmpty()){
                    buffer.wait();
                }
                Integer value = buffer.pop();
                buffer.notifyAll();//reci producerju da lahko nadaljuje
                System.out.println(Thread.currentThread().getName() + " consumed: " + value);
            }
        }
    }

    public static void main(String[] args) {
        //Producer
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        //Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        //se en consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
