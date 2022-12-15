import java.util.Scanner;

public class IFF {


        public static void main (String[]args) {
            for (;;){
            System.out.println("Vstavi poljubno število:");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
                if (n < 0) {
                    System.out.println("Število je negativno");
                } else {
                    if (n == 10) {
                        System.out.println("Število je 10");
                    } else if (n>10){
                        System.out.println("Število je večje od 10");
                    }else {
                        System.out.println("Število je manjše od 10");
                    }
                }
            }

        }
}
