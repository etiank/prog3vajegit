public class Pravokotnik extends GeometrijskaOblika implements GeometrijskiLik{
    //extends izrazi dedovanje
    //v javi razred lahko extenda samo en sam razred!!
    //implementira lahko več interfacov

    //vertikalno poravnan pravokotnik

    public Tocka zgornjaDesna;

    public Tocka spodnjaLeva;


    //konstruktor, beseda super se nanaša na SUPER razred
    public Pravokotnik(String barva, Tocka zgornjaDesna, Tocka spodnjaLeva) {
        super("pravokotnik",barva);//klic na konstruktorja super razreda mora biti prvi ukaz konstruktorja razreda ki deduje
        this.zgornjaDesna = zgornjaDesna;
        this.spodnjaLeva = spodnjaLeva;
    }

    public double stranicaA(){
        return zgornjaDesna.x- spodnjaLeva.x;
    }

    public double stranicaB(){
        return zgornjaDesna.y-spodnjaLeva.y;
    }

    @Override
    public boolean seSekata(GeometrijskaOblika oblika) {
        Pravokotnik drugi;
        //preverimo ali je oblika instanca pravokotnika
        if (oblika instanceof Pravokotnik){
            drugi = (Pravokotnik) oblika;//oblika castamo v Pravokotnik
        }else{
            System.out.println("Primerjas jabolko s krompirjem");
            return false;
        }
        //preverimo ali se NE sekata ob straneh
        if (this.zgornjaDesna.x < drugi.spodnjaLeva.x || this.spodnjaLeva.x > drugi.zgornjaDesna.x){
            return false;
        }
        //preverimo ali se NE sekata drug nad drugim
        if (this.spodnjaLeva.y>drugi.zgornjaDesna.y||this.zgornjaDesna.y<drugi.spodnjaLeva.y){
            return false;
        }
        return true;
    }

    @Override
    public double ploscina() {
        return stranicaA()*stranicaB();
    }

    @Override
    public double obseg() {
        return 2*stranicaA()+2*stranicaB();
    }
}
