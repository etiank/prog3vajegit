public class Parametri {
//prenos po vrednosti in prenos po referenci
    public static void main(String[] args) {
        //prenos po vrednosti
        int n=10;
        System.out.println("Pred funkcijo je n: "+n);
        parametri1(n);
        System.out.println("Po funkciji je n: "+n);
        System.out.println("-----------prenos po referenci");

        int[] p=new int[1];
        p[0]=10;
        System.out.println("Pred funkcijo je p: "+p[0]);
        parametri2(p);
        System.out.println("Po funkciji je p: "+p[0]);
    }

    public static void parametri1(int n){
        System.out.println("Vrednost n v funkciji je: "+n);
        n++;
        System.out.println("Vrednost n v funkciji je: "+n);
    }

    public static void parametri2(int[] p) {
        System.out.println("V funkciji je p: " + p[0]);
        p[0]++;
        System.out.println("V funkciji je p: " + p[0]);
    }
}
