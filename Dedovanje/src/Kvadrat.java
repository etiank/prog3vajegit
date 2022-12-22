public class Kvadrat extends Pravokotnik {
    public Kvadrat(String barva, Tocka zgornjaDesna, Tocka spodnjaLeva) {
        super(barva, zgornjaDesna, spodnjaLeva);
        if ((int)stranicaA() != (int)stranicaB()){
            System.out.println("Lik ni kvadrat");
            System.exit(1);//zaključi kvadrat, ker ni kvadrat
        }


    }


}
