import java.util.Scanner;

public class bralec {

    public static void main(String[] args) {
        Scanner bralec = new Scanner(System.in);
        System.out.println("Vstavi ime:");
        String ime = bralec.nextLine();
        System.out.println("Vstavi starost:");
        int starost = bralec.nextInt();

        System.out.println("Uporabnik:"+ime+" je star "+ starost+ "let");
    }

}
