import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Generics {

    public static <T> void printCollection (Collection<T> c){
        for (T e: c) {
            System.out.print(e+" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            al.add(i);
        }
        printCollection(al);

        Collections.shuffle(al);
        printCollection(al);

        Collections.sort(al);
        printCollection(al);

        Collections.reverse(al);
        printCollection(al);

        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(1,"kruh");
        hm.put(1222,"banana");
        hm.put(4,"sir");
        hm.put(5,"kruh");
        hm.put(1222,"prsut");

        printCollection(hm.keySet());
        printCollection(hm.values());

    }

}
