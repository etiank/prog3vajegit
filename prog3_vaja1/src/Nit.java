
import static java.lang.Thread.sleep;

public class Nit implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": racunam...");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Thread.currentThread().getName()+": konec racunanja");
    }
}
