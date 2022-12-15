import java.util.Random;

public class NapadalniPanel {
    //lastnosti
    public int x;
    public int y;
    public String color;

    public Planet[] nevtralni;
    public Planet[] mojiPlaneti;
    public Planet[] nasprotnik;

    Random rand = new Random();

    //konstruktor
    public NapadalniPanel(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;

    }

    public String napad() {
        if (mojiPlaneti != null && nasprotnik != null) {
            //se igramo
            if (nevtralni != null) {
                //napadi nevtralne
                return nakljucniNapad(nevtralni);
            } else {
                //napadi nasprotnika
                return nakljucniNapad(nasprotnik);
            }
        }return "";
    }


    public String nakljucniNapad(Planet[] planeti){
        String napad ="";
        for (int i = 0; i < mojiPlaneti.length; i++) {
            Planet a = mojiPlaneti[i];
            Planet b = nakljucni(planeti);
            napad += napadiPlanet(a,b);
        }
        return napad;
    }

    public String napadiPlanet(Planet a, Planet b){
        String poteza = "A"+" "+a.getIme()+" "+b.getIme()+ "\n";
        return poteza;
    }



    public Planet nakljucni(Planet[] planeti){
        //vrne nakljucni int med 0 in podano vrednostjo
        int i= rand.nextInt(planeti.length);
        Planet p=planeti[i];
        return p;
    }


    //metoda
    public void dodajPlanet(String[] t) {
        //ustvarimo planet
        Planet p = new Planet(t);
        //dodaj planet v pravilno polje planetov
        if (p.getColor().equals("null")) {
            //nevtralni
            nevtralni = ustvariProstorInDodaj(p, nevtralni);
        } else if (p.getColor().equals((this.color))) {
            //moj planet
            mojiPlaneti = ustvariProstorInDodaj(p, mojiPlaneti);
        } else {
            //nasprotnik
            nasprotnik = ustvariProstorInDodaj(p, nasprotnik);
        }
    }

    public Planet[] ustvariProstorInDodaj(Planet p, Planet[] polje) {
        Planet[] res;//polje ki ga bomo vrnili
        if (polje == null) {//preveri ali je polje inicializirano
            //če ni inicializirano ustvari polje
            res = new Planet[1];
        } else {
            res = new Planet[polje.length + 1];
            //prepisali elemente polja
            for (int i = 0; i < polje.length; i++) {
                res[i] = polje[i];
            }
        }
        //dodaj planet p na konec polja
        res[res.length - 1] = p;
        return res;
    }

}
