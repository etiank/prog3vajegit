public class PrimitivniTipi {
    public static void main(String[] args) {
        System.out.println("Hello!");
        celaStevil();
        racionalnaStevil();
        bool();
        znaki();
        nizi();
    }

    public static void celaStevil() {
        int a = 5;
        int b = 8;
        int vsota = a + b;
        System.out.println((vsota));

        vsota++;
        System.out.println(vsota);

        vsota /= 4;
        System.out.println(vsota);

        long max = Integer.MAX_VALUE;
        System.out.println(max);

        max++;
        System.out.println(max);

        System.out.println(0b100);//0b za zapis v binarni kosi
        System.out.println(0x100);//0x za HEX kodo
    }

    public static void racionalnaStevil() {
        float c = 5.1f;//f dodamo za float stevila, za double stevila dodamo d
        System.out.println(c);
        float kol = 13 / 2;
        System.out.println(kol);

        kol = 13 / 2f;
        System.out.println(kol);

        float nat1 = 5.6f + 5.8f;
        System.out.println(nat1);

        double nat2 = 5.6f + 5.8f;
        System.out.println(nat2);

        double nat3 = 5.6d + 5.8d;
        System.out.println(nat3);


    }

    public static void bool() {
        boolean yes = true;
        System.out.println(yes);

        Boolean no = !yes;
        System.out.println(no);

        System.out.println(yes && no);
        System.out.println(yes || no);
    }

    public static void znaki() {
        char z = 'a';
        System.out.println(z);
        System.out.println((int) z);
        System.out.println((char) 100);

        System.out.println((char) (z - 32));

    }

    public static void nizi() {
        String niz = "Hello";
        System.out.println(niz);
        String zin = "World!";
        System.out.println(niz + " " + zin);
        System.out.println(zin.charAt(4));//charAt vzame crko na mestu ki ga dolocimo (v tem primeru petem mestu, ker se zacnejo z pozicijo 0)
        System.out.println(niz.substring(2,4));//substring vzame vse crke med dvemi pozicijami
    }


}
