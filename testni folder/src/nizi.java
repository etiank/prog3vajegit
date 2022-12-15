public class nizi {

    public static void main(String[] args) {
        String palindrom = "osemopitihhitipomeso";
        String niPalindrom = "dvajsetmack";
        System.out.println("Niz " +palindrom+" je palindrom? "+jePalindrom(palindrom));
        System.out.println("Niz " +niPalindrom+ " je palindrom? "+jePalindrom(niPalindrom));


        String mlin="Kdor prvi pride, Prvi melje";
        String[] tokens = mlin.split(" ");
        String drugi = zamenjaj(tokens,"prvi","drugi");
        System.out.println(drugi);
        drugi=zamenjaj2(tokens,"prvi","drugi");
        System.out.println(drugi);
    }

    public static String zamenjaj (String[] tokens, String stari, String novi) {
        String res = "";
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(stari)){//equals primerja dva stringa
                res=res+novi+" ";
            }else{
                res=res+tokens[i]+" ";
            }
        }
        return res;
    }
    public static String zamenjaj2 (String[] tokens, String stari, String novi) {
        String res = "";
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equalsIgnoreCase(stari)){// ignore case ignorira začetnice
                res=res+novi+" ";
            }else{
                res=res+tokens[i]+" ";
            }
        }
        return res;
    }


    public static boolean jePalindrom (String s){
        int j=s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=s.charAt(j)){
                //ni palindrom
                return false;
            }
            j--;
        }
        return true;
    }

}
