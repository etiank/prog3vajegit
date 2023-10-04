public class Start {
    public static void main(String[] args) {
        PovezanSeznam ps = new PovezanSeznam();
        System.out.println(ps.najdi(5));
        System.out.println(ps.vstavi(5));
        System.out.println(ps.najdi(5));

        System.out.println(ps.vstavi(2));
        System.out.println(ps.vstavi(10));
        System.out.println(ps.vstavi(8));
        System.out.println(ps.vstavi(15));
        System.out.println(ps.vstavi(12));

        System.out.println("Najdi" + ps.najdi(8));
        System.out.println("Najdi" + ps.najdi(50));

        System.out.println("Najdi" + ps.najdi(10));
        System.out.println(ps.brisi(10));
        System.out.println("Najdi" + ps.najdi(10));

        System.out.println(ps.stElementov());

    }

}
