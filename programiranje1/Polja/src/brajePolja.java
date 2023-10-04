import java.util.Scanner;

public class brajePolja {

    public static void main(String[] args) {
        //1. način branja polja
        Scanner sc = new Scanner(System.in);
/*        System.out.println("Koliko stevil boste vnesli");
        int n = sc.nextInt();
        int[] polje = new int[n];
        System.out.println("Vpisi stevila");
        for (int i = 0; i < n; i++) {
            polje[i] = sc.nextInt();
        }
  */
        System.out.println("Vnesi stevila s presledkom");
        String niz = sc.nextLine();
        String[] besede = niz.split(" ");//razdeli niz v več nizov kjer je presledek
        int[] polje = new int[besede.length];
        for (int i = 0; i < polje.length; i++) {
            polje[i] = Integer.parseInt(besede[i]);//pretvori string v int
        }
        izpis(polje);
        liha(polje);
        vecjeOd(polje, 100);
        System.out.println(min(polje));
    }


    public static void izpis(int[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }

    public static void liha(int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] % 2 != 0) {
                System.out.print(p[i] + " ");
            }

        }
        System.out.println();
    }

    //izpisi stevila iz polja ki so vecja od v
    public static void vecjeOd(int[] p, int v) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] > v) {
                System.out.print(p[i] + " ");
            }
        }
        System.out.println();

    }

    //funkcija ki vrne nejmanjši element v polju
    public static int min(int[] p) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < p.length; i++) {
            if (p[i] < min) {
                min = p[i];
            }
        }
        return min;
    }
}
