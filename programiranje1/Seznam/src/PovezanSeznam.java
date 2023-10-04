public class PovezanSeznam {
    //UREJENI SEZNAM

    //hrani referenco na prvi element seznama
    public Vozlisce glava;
    //ob inicializaciji in ko je seznam prazen je glava null

    //default konstruktor (ne rabimo ga pisati)
    public PovezanSeznam() {
    }

    public boolean najdi(int element) {
        if (glava == null) {
            return false;
        } else {
            return glava.najdi(element);
        }
    }

    public boolean vstavi(int element) {
        if (glava == null) {
            Vozlisce novo = new Vozlisce(element);
            glava = novo;//glava shrani referenco na novo vozlisce
            return true;
        } else if (element <= glava.kljuc) {//vstavi element na zacetek seznama
            if (element < glava.kljuc) {//elementa ni, ga dodamo
                Vozlisce novo = new Vozlisce(element);
                novo.rep = glava;//shrani naslednji element da ga ne izgubimo
                glava = novo;//vpise vrednost v glavo
            }
            return true;
        } else {//drugace povej naslednjemu vozliscu naj vstavi element
            return glava.vstavi(element);
        }
    }

    public boolean brisi(int element) {
        if (glava == null) {//prazen seznam nimamo kaj brisat
            return false;
        } else if (glava.kljuc == element) {//pogledaj ali je naslednji element za brisat
            glava = glava.rep;
            return true;
        } else {
            return glava.brisi(element);
        }
    }


    public int stElementov(){
        if (glava == null) {
            return 0;
        }else{
            return glava.stElementov();
        }
    }


}
