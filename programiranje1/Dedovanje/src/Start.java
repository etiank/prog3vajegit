public class Start {
    public static void main(String[] args) {

        Pravokotnik prvi = new Pravokotnik("Rdeč",
                new GeometrijskaOblika.Tocka(5,10),
                new GeometrijskaOblika.Tocka(0,5));


        System.out.println(prvi.obseg());
        System.out.println(prvi.ploscina());

        Pravokotnik drugi = new Pravokotnik("Modri",new GeometrijskaOblika.Tocka(8,14),new GeometrijskaOblika.Tocka(6,11));

        System.out.println("Prvi in drugi se sekata?"+prvi.seSekata(drugi));

        Pravokotnik tretji = new Pravokotnik("Zelen",new GeometrijskaOblika.Tocka(6,10),new GeometrijskaOblika.Tocka(1,5));

        System.out.println("prvi in tretji se sekata?"+prvi.seSekata(tretji));

        Kvadrat ena = new Kvadrat("Črn",new GeometrijskaOblika.Tocka(5,11),new GeometrijskaOblika.Tocka(0,5));

        System.out.println(ena.ploscina());
        System.out.println(ena.obseg());
        System.out.println(ena.seSekata(prvi));


        Kvader k1 = new Kvader("Črn",new GeometrijskaOblika.Tocka(5,10),new GeometrijskaOblika.Tocka(0,5),3);


        System.out.println("Povrsina Kvadra"+ k1.povrsina());
        System.out.println("Volumen kvadra"+ k1.volumen());
        System.out.println("ploscina kvadra"+ k1.ploscina());
    }
}
