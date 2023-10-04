import java.util.Scanner;

public class nizi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vpisi poved:");
        String text = sc.nextLine();
        //spremenimo funkcijo tako da vsak tretji znak postane *
        for (int i = 0; i < text.length(); i++) {
            if ((i%3)==0) {
                System.out.print("*");
            }else {
                System.out.print(text.charAt(i));
            }
        }
        System.out.println();
        //zanka ki izpiše vsako besedo v svoji vrsti
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==' '){//znake moramo primerjati z enojnimi narekovaji(dvojni ne delujejo)
                System.out.println();
            }else{
                System.out.print(text.charAt(i));
            }
        }
        System.out.println();
        //zanka izpiše besedilo v obratnem redu
        for (int i = text.length()-1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }


    }


}
