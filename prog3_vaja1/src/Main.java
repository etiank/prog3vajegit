public class Main extends Thread{
    public static void main(String[] args) {

        //dve instanci razreda main
        Main ena = new Main();
        Main dva = new Main();
        //instanciramo nit
        Thread tri = new Thread(new Nit());

        System.out.println(Thread.currentThread().getName()+": bom startal ostale niti");
        //startamo niti
        ena.start();
        dva.start();
        tri.start();


        if (tri.isAlive()){
            System.out.println("Nit zivi");
        }else {
            System.out.println("Nit je dead");
        }


        try {
            ena.join();
            dva.join();
            tri.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /*
        Nit starta le enkrat, zato moramo narediti novo
        ena = new Main();
        ena.start();
         */
        System.out.println(Thread.currentThread().getName()+": procesiram rezultat");

        if (tri.isAlive()){
            System.out.println("Nit zivi");
        }else {
            System.out.println("Nit je dead");
        }

    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": racunam...");

        System.out.println(Thread.currentThread().getName()+": konec racunanja");
    }


}