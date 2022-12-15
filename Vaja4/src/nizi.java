public class nizi {


    public static void main(String[] args) {
        String niz = "Danes je zelo grdo vreme, vidim 9 oblakov.";
        char[] polje;
        //pokličemo funkcijo iz razreda pomocnik
        polje = pomocnik.vPoljeZnakov(niz);
        System.out.println(polje[4]);
        System.out.println(polje[20]);

        String res = pomocnik.vString(polje);
        System.out.println(res);

        //želimo zamenjat poljuben znak v nizu z zvezdico
        char menjaj = 'e';
        String zamenjano = pomocnik.zamenjajZnak(niz , menjaj);
        System.out.println(zamenjano);

        System.out.println(pomocnik.vVelikeCrke(niz));

        /*SUBSTRING
        izvleci eno podzaporedje znakov iz niza
        ustvari en podniz*/
        //substring(začetni index, končni index)
        //niz iz prvih pet znakov
        System.out.println(niz.substring(0,5));

        //vrni zadnjih pet znakov
        System.out.println(niz.substring(niz.length()-5));

        //vrni vmesnih pet znakov na polovici niza
        System.out.println(niz.substring(niz.length()/2-5/2,niz.length()/2+5/2+1));

        //palindromi
        String obrnjen = pomocnik.obrni(niz);
        System.out.println("Niz je palindrom? --> "+obrnjen.equals(niz));


        int v = 1256521;
        String stevila = ""+v;//avtomatsko pretvori število v niz
        System.out.println("Niz je palindrom? --> "+stevila.equals(pomocnik.obrni(stevila)));

    }


}
