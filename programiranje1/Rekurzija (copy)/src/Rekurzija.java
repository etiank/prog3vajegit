public class Rekurzija {

    public static void main(String[] args) {
        System.out.println(vsota(10));
        System.out.println(vsotaRek(10));
        System.out.println(fakultetaRek(10));
        System.out.println(jePotenca2(256));
    }


    //vsota stevil od 1 do n
    public static int vsota(int n){
        int vsota=0;
        for (int i = 0; i <= n; i++) {
            vsota+=i;
        }
        return vsota;
    }

    //rekurzivna rešitev vsote 1 do n
    public static int vsotaRek(int n){
        if (n==1){
            return 1;
        }else{
            return n+vsotaRek(n-1);
        }
    }

    //rekurzivna funkcija za izračun fakultete n
    public static int fakultetaRek(int n){
        if (n==1){
            return 1;
        }else{
            return n*fakultetaRek(n-1);
        }
    }

    //rek. funkcija ki pove ali je stevilo potenca st 2
    public static boolean jePotenca2(int n){
        if (n==2){
            return true;
        }else if (n%2!=0){
            return false;
        }else {
            return jePotenca2(n/2);
        }
    }



}
