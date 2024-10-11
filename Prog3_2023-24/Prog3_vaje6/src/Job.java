import java.util.concurrent.CountDownLatch;

public class Job implements Runnable{

    private CountDownLatch latch;
    private int index;

    public Job(CountDownLatch latch, int index){
        this.latch=latch;
        this.index=index;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started");

        try {
            Thread.sleep(index*3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        latch.countDown();//zmanjsa stevec CountdownLatcha

        System.out.println(Thread.currentThread().getName()+" waiting for others");

        try {
            latch.await();//cakaj na latch-u
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" completed");

    }
}
