public class EmailParser {

    public static void main(String[] args) {
        String naslov = "niki.hrovatin@famnit.upr.si";
        System.out.println("Domena:");
        String domena = naslov.substring(pomocnik.indeksOd(naslov,'@')+1);
        System.out.println(domena);


        String[] p = domena.split("\\.");
        //z dvojnim \\ lahko uporabimo piko
        System.out.println(p[0]);


    }



}
