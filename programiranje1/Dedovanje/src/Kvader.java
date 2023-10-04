public class Kvader extends Pravokotnik implements GeometrijskoTelo{
    //Kvader je pravokotnik s dodatno dimenzijo

    public int h;

    public Kvader(String barva, Tocka zgornjaDesna, Tocka spodnjaLeva, int visina) {
        super(barva, zgornjaDesna, spodnjaLeva);
        this.h = visina;
    }

    @Override
    public double volumen() {
        return super.ploscina()*h;//super se nanaša na metode super razreda
    }

    @Override
    public double povrsina() {
        return 2*(super.ploscina()+stranicaA()*h+stranicaB()*h);
    }

    //OVERRIDING
    //metoda se obnaša različno, če je v super ali pod razredu
    //podpis metode je enak
    public double ploscina(){
        return -1;
    }
    public double obseg(){
        return -1;
    }

    //OVERLOADING
    //metoda se obnasa razlicno v odvisnosti od podanih parametrov
    //podpis metode se razlikuje samo v podanih parametrih
    public double volumen(int a, int b, int c){
        return a*b*c;
    }

    public double volumen(double a, double b, double c){
        return a*b*c;
    }



}
