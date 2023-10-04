public class pomocnik {

    char[] polje;

    //funkcija pretvori niz v polje znakov
    public static char[] vPoljeZnakov(String niz) {
        char[] res = new char[niz.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = niz.charAt(i);
        }
        return res;
    }

    // funkcija vzame polje znakov in ga konkatenira v String
    public static String vString(char polje[]) {
        String res = "";
        int i = 0;
        while (i < polje.length) {
            res = res + polje[i];
            i++;
        }
        return res;
    }

    //funkcija ki zamenja poljuben znak z zvezdico
    public static String zamenjajZnak(String niz, char znak) {
        char[] polje = new char[niz.length()];
        polje = vPoljeZnakov(niz);
        for (int i = 0; i < polje.length; i++) {
            if (polje[i] == znak) {
                polje[i] = '*';
            }
        }
        return vString(polje);
    }

    //funkcija sprejme niz, pretvori male črke v velike
    public static String vVelikeCrke(String niz) {
        char[] polje = new char[niz.length()];
        polje = vPoljeZnakov(niz);
        for (int i = 0; i < polje.length; i++) {
            //ce je mala crka zamenjaj z veliko
            if ('a' <= polje[i] && polje[i] <= 'z') {
                //typecasting-pretvorba med tipi
                //polje interpretira kot int, odšteje in interpretira kot char
                polje[i] = (char) ((int) polje[i] - 32);
            }
        }
        return vString(polje);
    }

    //obrne niz npr. "kruh" -> "hurk"
    public static String obrni (String niz){
        String res="";
        for (int i = niz.length()-1; i >=0 ; i--) {
            res = res + niz.charAt(i);
        }
        return res;
    }

    //funkcija ki vrne indeks poljubnega znaka v nizu
    //če znaka ni v nizu vrni -1
    public static int indeksOd(String niz, char znak){
        for (int i = 0; i < niz.length(); i++) {
            if (niz.charAt(i)==znak){
            return i;
            }
        }
        return -1;
    }


}
