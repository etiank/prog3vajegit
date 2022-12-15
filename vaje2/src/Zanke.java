public class Zanke {
    public static void main(String[] args) {
        //basicZanka();
        //printSoda();
        //vsota();
        fakulteta();
    }

    //Izpiši števila 1...10
    public static void basicZanka() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

    }

    public static void printSoda() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void vsota() {
        int delnaVsota = 0;
        for (int i = 1; i <= 10; i++) {
            delnaVsota = delnaVsota + i;
        }
        System.out.println(delnaVsota);
    }
    //izpiši fakulteto števila 10
    public static void fakulteta() {
        int delnafakulteta = 1;
        for (int i = 1; i <= 10; i++) {
            delnafakulteta = delnafakulteta * i;
        }
        System.out.println(delnafakulteta);
    }
}
