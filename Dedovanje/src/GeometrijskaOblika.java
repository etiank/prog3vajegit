public abstract class GeometrijskaOblika {
    //abstraktne razrede ni moč instancirati!!!

    public String ime; //ime geometrijske oblike

    public String barva;

    //konstruktor
    public GeometrijskaOblika(String ime, String barva) {
        this.ime = ime;
        this.barva = barva;
    }

    public void opis(){
        System.out.println("Geometrijska oblika: "+ime+" barva: "+barva);
    }

    //abstraktna metoda
    //pove ali se dve geometrijski obliki sekata
    public abstract boolean seSekata(GeometrijskaOblika oblika);

    //Vgnezdeni razred tocka
    static class Tocka{
        int x;
        int y;

        public Tocka(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //Evklidska razdalja med dvema točkama
        public double razdalja(Tocka b){
            return Math.sqrt((  Math.pow(b.x-this.x,2)  +   Math.pow(b.y-this.y,2)  ));
        }
    }

}
