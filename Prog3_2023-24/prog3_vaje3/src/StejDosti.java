import java.util.concurrent.atomic.AtomicLong;

public class StejDosti implements Runnable{
    public static Object object = new Object();
    public int eksponent;
    public static  long stevec= 0;
    //public static AtomicLong stevec = new AtomicLong(0);

    public static void main(String[] args) {
        int e = 26;
        System.out.println("Niti bodo stele do "+ (int)Math.pow(2,e+1));
        Thread nit1 = new Thread(new StejDosti(e));
        Thread nit2 = new Thread(new StejDosti(e));

        long t0 = System.currentTimeMillis();

        nit1.start();
        nit2.start();

        try {
            nit1.join();
            nit2.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        long t = System.currentTimeMillis() - t0;
        System.out.println("Niti so prestele: "+stevec+" v casu:"+t+"ms");
    }

    //konstruktor
    public StejDosti(int eksponent){
        this.eksponent=eksponent;
    }

    @Override
    public void run() {
        for (int i = 0; i < Math.pow(2, eksponent); i++) {
            //stevec++;
            //stevec.incrementAndGet();
            stej2();
        }
    }

    public static synchronized void stej(){
        stevec++;
    }

    public void stej2(){
        synchronized (object){
            stevec++;
        }
    }

}
