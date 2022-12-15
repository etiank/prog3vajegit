import java.util.Scanner;

public class prestopnoLeto {
    //Leto je prestopno če je deljivo s 4 in ni deljivo s 100
    //Če je deljivo s 400 je vedno prestopno
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("Vnesi leto");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            if (((n % 4 == 0) && (n % 100 != 0)) || n % 400 == 0) {
                System.out.println("Leto je prestopno");
            } else {
                System.out.println("Leto ni prestopno");
            }
        }
    }

}
