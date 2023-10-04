public class Vozlisce {
    // kljuc->vrednost
    public int kljuc;
    //kazalec na naslednje vozlisce seznama
    public Vozlisce rep;

    public Vozlisce(int kljuc) {
        this.kljuc = kljuc;
    }

    public boolean najdi(int element) {
        if (kljuc == element) {//ce smo nasli element
            return true;
        } else if ((rep != null) && (element > kljuc)) {//ce je se elementov
            return rep.najdi(element);
        } else {
            return false;//smo na koncu seznama
        }
    }

    public boolean vstavi(int element) {
        if (rep == null) {
            Vozlisce novo = new Vozlisce(element);
            rep = novo;
            return true;
        } else if (element <= rep.kljuc) {
            if (element < rep.kljuc) {
                Vozlisce novo = new Vozlisce(element);
                novo.rep = rep;
                rep = novo;
            }
            return true;
        } else {
            return rep.vstavi(element);
        }
    }


    public boolean brisi(int element) {
        if (rep == null) {//konec seznama nimamo kaj za brisat
            return false;
        } else if (rep.kljuc == element) {
            //brisi naslednji element
            rep = rep.rep;
            return true;
        } else {
            return rep.brisi(element);
        }
    }

    public int stElementov(){
        if (rep == null) {
            //zadnji element seznama
            return 1;
        }else{
            return 1+ rep.stElementov();
        }
    }

}
