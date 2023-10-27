public class Main {

    public static volatile boolean done = false;
    //volatile povzroci da done preberemo iz RAM-a namesto iz cache-a

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (!done){
                    count++;
                    //System.out.println(count); tega ne smemo uporabiti za sinhronizacijo
                }
                System.out.println(Thread.currentThread().getName()+" koncal stet:"+count);
            }
        }).start();
        System.out.println(Thread.currentThread().getName()+" startal sem nit");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        done=true;
        System.out.println(Thread.currentThread().getName()+" postavil sem done na: "+done);

    }
}