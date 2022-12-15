import java.util.Scanner;

public class prastevila {
    //Praštevilo je naravno število,ki je večje od ena in ima točno 2 deljitelja
    //število 1 in samega sebe
    //primer praštevil: 2 3 5 7 11 13 17 19 23
    public static void main(String[] args) {

        System.out.println("Vpiši naravno število");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int stDeljiteljev = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {//zaradi lastnosti praštevil lahko uporabimo koren števila
            if (n % i == 0) {
                stDeljiteljev++;
            }
        }
        if (stDeljiteljev == 1) {
            System.out.println("je praštevilo");
        } else {
            System.out.println("ni praštevilo");
        }
    }
}
