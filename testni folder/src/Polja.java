public class Polja {

    public static void main(String[] args) {
/*        int[] polje = new int[7];//deklariramo polje in dodelimo 7 prostorov
        polje[0] = 0;//dodelimo vrednost prvemu elementu
        polje[1] = 5;
        polje[2] = 4;
        polje[5] = 120;
        polje[6] = 1000;
        System.out.println(polje[0]);
        System.out.println(polje[1]);
        System.out.println(polje[2]);
        System.out.println(polje[5]);
        System.out.println(polje[6]);
        System.out.println(polje[3]);
*/
        double[] polje2 = {1.2, 2.333333, 4544.12, 21142.23, 12, 123.4};
        for (int i = 0; i < polje2.length; i++) {
            System.out.print(polje2[i]+"  ");
        }
        System.out.println();
        double sum=0;
        for (int i = 0; i < polje2.length; i++) {
            sum = sum + polje2[i];
        }
        System.out.println(sum);
    }


}
