public class TestCode {
    public static boolean done=false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                    while (!done){
                        count++;
                        System.out.println(count);//ce tega ni se zatakne v loopu
                    }
                System.out.println(Constants.RESULT+Thread.currentThread().getName()+" je stel:"+count);
            }
        }).start();
        System.out.println(Constants.INFO+Thread.currentThread().getName()+" je startal");
        Thread.sleep(1000);
        done = true;

        System.out.println(Constants.INFO+"flag set to "+done);
    }


}
