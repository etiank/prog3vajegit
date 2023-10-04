import java.util.Arrays;
import java.util.Scanner;

public class VDN {

    public static void main(String[] args) {
//------------------------------------------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);                        //Sprejme
        System.out.println("Vnesi cela števila, ločena z vejico.");      //polje števil
        String vhod = sc.nextLine();                                //v obliki Stringa.

        String stevila[] = vhod.split(",");                   //String vhod odreže na posamezna števila,
                                                                    //še vedno v String obliki.
        int polje[] = new int[stevila.length];                      //Polju določim dolžino, ki je enaka številu
                                                                    //elementov, ki smo jih vnesli.

//------------------------------------------------------------------------------------------------------------------

        int liha = 0;
        int soda = 0;
        double vsota = 0;
        double povp;
        int stPalindromov = stevila.length;

//------------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < stevila.length; i++) {
            char stevke[] = stevila[i].toCharArray();               //Deklariram polje znakov in vanj s toCharArray
            for (int j = 0; j < stevke.length; j++) {               //vpišem števke števila na indexu i, nato se
                if (stevke[j] != stevke[stevke.length - 1 - j]) {   //sprehajam po polju znakov in primerjam znake
                    stPalindromov--;                                //če znaki na nasprotnih mestih niso enaki,
                    break;                                          //stPalindromov zmanjsam za 1, ker to število ni
                }                                                   //palindrom in prekinem notranji for loop.
            }                                                       //Postopek ponovim z zunanjim for loop-om za
        }                                                           //vsa števil, ki smo jih vnesli.

//------------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < stevila.length; i++) {                  //V tem for loop-u z Integer.parseInt,
            polje[i] = Integer.parseInt(stevila[i]);                //spreminjam Stringe iz stevila[] v integerje
            if (polje[i] % 2 == 0) {                                //in jih zapišem v polje[]
                soda++;                                             //Spotoma preverim njihovo sodost in izračunam
            } else {                                                //vsoto.
                liha++;
            }
            vsota += polje[i];
        }
        povp = vsota / polje.length;                                //Izračunam povprečje.

//------------------------------------------------------------------------------------------------------------------
        int poVelikosti []=new int[polje.length];
        for (int i = 0; i < polje.length; i++) {                    //naredim novo polje in prekopiram originalno
            poVelikosti[i]=polje[i];                                //polje vanj
        }
        for(int i=0;i< poVelikosti.length-1;i++){                   //uporabim "bubble sort"
            for(int j=0;j< poVelikosti.length-1-i;j++){
                if(poVelikosti[j]>poVelikosti[j+1]){
                    int temp = poVelikosti[j];
                    poVelikosti[j]=poVelikosti[j+1];
                    poVelikosti[j+1]=temp;
                }
            }
        }

//------------------------------------------------------------------------------------------------------------------

        double varianca = 0;
        for (int i = 0; i < polje.length; i++) {
            varianca = varianca +                                   //Izračunam varianco,
                       (polje[i] - povp) * (polje[i] - povp);       //ker jo potrebujem za
        }                                                           //izračun deviacije.
        varianca = varianca / polje.length;

        double deviacija = Math.sqrt(varianca);                     //Izračunam deviacijo.

//------------------------------------------------------------------------------------------------------------------

        double mediana = 0;
        if (poVelikosti.length % 2 != 0) {                          //Če imam sodo število elementov,
            mediana = poVelikosti[poVelikosti.length / 2];          //vzamem sredino sortiranega polja,
        } else {                                                    //v nasprotnem primeru,
            mediana = (poVelikosti[poVelikosti.length / 2]          //pa povprečje srednjih
                    + poVelikosti[poVelikosti.length / 2 - 1])      //dveh elementov sortiranega polja.
                    / 2;
        }
//------------------------------------------------------------------------------------------------------------------
        int diffCounter=1;                                          //naredim števec za različna števila,z 1 začnem,
        for (int i = 1; i < poVelikosti.length; i++) {              //ker ko vidi prvi dve števili mora napisat 2
            if(poVelikosti[i]!=poVelikosti[i-1]){                   //se sprehodim skozi urejeni array
                diffCounter++;                                      //če sta primerjani števili različni, prišteje
            }                                                       //števcu 1
        }

//------------------------------------------------------------------------------------------------------------------

        int drugoNajmanse=0;
        if(diffCounter==1){                                         //poiščem drugo najmanjše število,
            drugoNajmanse=poVelikosti[0];                           //ignoriram enaka števila,
        }else{                                                      //razen v primeru, da so vsa enaka
            for (int i = 0; i < poVelikosti.length; i++) {
                if (poVelikosti[i] != poVelikosti[i+1]) {
                    drugoNajmanse=poVelikosti[i+1];
                    break;
                }

            }
        }

//------------------------------------------------------------------------------------------------------------------
        int nums[]=new int[diffCounter];                            //array, v katerega bom vpisal števila
        int numOfEquals[]=new int [diffCounter];                    //array, ki bo štel koliko je enakih
        int a=0;
        int m;
        float vProcentih[]= new float[diffCounter];                 //float v katerega bo zapisana frekvenca pojavitev
        for (m=1; m < poVelikosti.length; m++) {                    //števila v procentih
            nums[a]=poVelikosti[m-1];                               //zapišem število
            numOfEquals[a]=numOfEquals[a]+1;                        //št. enakih prištejem 1
            if (poVelikosti[m - 1] != poVelikosti[m]) {             //če sosednji števili nista enaki, začnem
                a++;                                                //štet pojavitve naslednjega
            }
        }
        numOfEquals[a]=numOfEquals[a]+1;                            //zadnjemu številu moram prištet 1, ker v zgornjem
        nums[a]=poVelikosti[m-1];                                   //for loopu preskoči zadnji kos

//------------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < diffCounter; i++) {
            vProcentih[i]= (float)numOfEquals[i] / poVelikosti.length;
            vProcentih[i]=vProcentih[i]*100;                        //izračunam pojavitev vsakega št. v %
        }

//------------------------------------------------------------------------------------------------------------------

        int najboljPogosto=0;
        for (int i = 0; i < diffCounter; i++) {                     //primerjam, katero število se največkrat pojavi
            for (int j = 0; j < diffCounter; j++) {
                if (numOfEquals[j]>numOfEquals[i]){
                    najboljPogosto=nums[j];
                }
            }
        }

//------------------------------------------------------------------------------------------------------------------

        boolean palAliNe = false;
        int najPal = 0;
        String palVStringu;

        for (int i = 0; true; i++) {
            if (palAliNe == true) {                                 //Če je palAliNe true, pomeni, da je
                break;                                              //spodnji del kode našel največji možni
            }                                                       //palindrom, zato prekinem neskončen for loop.

            najPal = poVelikosti[poVelikosti.length - 1] - 1 - i;   //Začnem s številom, ki je za 1 manjše od
            palVStringu = "" + najPal;                              //največjega števila in ga pretvorim v String,
            char ch[] = palVStringu.toCharArray();                  //katerega pretvorim v polje znakov, s katerim
                                                                    //preverjam, če je število palindrom.

            for (int j = 0; j < ch.length; j++) {
                if (ch[j] != ch[ch.length - 1 - j]) {               //Če znaki na nasprotnih mestih niso enaki,
                    break;                                          //število ni palindrom, prekinem for loošp in
                } else if (j >= ch.length - 1 - j) {                //poskusim z naslednjim številom. V nasprotnem
                    palAliNe = true;                                //primeru pa preveri, če je že na sredini polja
                    break;                                          //znakov, kar bi pomenilo, da je število
                }                                                   //palindrom, lahko končam preverjati.
            }
        }

//------------------------------------------------------------------------------------------------------------------

        String obratno="";
        for (int i = stevila.length-1; i >= 0; i--) {
            obratno=obratno+stevila[i]+",";
        }

//------------------------------------------------------------------------------------------------------------------

        System.out.println("Število elementov: " + polje.length);
        System.out.println("Število različnih elementov: " + diffCounter);
        System.out.println("Število sodih števil: " + soda);
        System.out.println("Število lihih števil: " + liha);
        for (int i = 0; i < numOfEquals.length; i++) {
            System.out.println("Frekvenca pojavitve števila "+nums[i] +" je "+vProcentih[i]+"%");
        }
        System.out.println("Najbolj pogosto število je: "+najboljPogosto);
        System.out.println("Največje število: " + poVelikosti[poVelikosti.length - 1]);
        System.out.println("Drugo najmanjše število: " + drugoNajmanse);
        System.out.println("Povprečje: " + povp);
        System.out.println("Deviacija je: "+deviacija);
        System.out.println("Mediana je: "+mediana);
        System.out.println("Vsota je: "+vsota);
        System.out.println("Število palindromov je: "+stPalindromov);
        System.out.println("Največje palindromno število, manjše od največjega podanega števila je: "+najPal);
        System.out.println("Vneseno polje v obratnem vrstnem redu: "+obratno);



    }


}
