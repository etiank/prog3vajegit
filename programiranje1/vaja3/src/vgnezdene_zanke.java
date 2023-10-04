public class vgnezdene_zanke {
    public static void main(String[] args) {
        basicVgnezdenje();
        //kvadrat();
        //kvadrat2();
        //trikotnik();
        //trikotnik2();
        zeta();
    }

    public static void basicVgnezdenje() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("(" + i + "," + j + ")");
            }
            System.out.println();
        }

    }

    public static void kvadrat() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }

    }

    public static void kvadrat2() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i % 2 == j % 2) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");

                }
            }
            System.out.println();
        }

    }

    public static void trikotnik() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i >= j) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");

                }
            }
            System.out.println();
        }
    }

    public static void trikotnik2() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i <= j) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");

                }
            }
            System.out.println();
        }
    }

    public static void zeta() {
        int d=7;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if ((i == 0)||(i==(d-1))||(i==j)||(i==d-j-1)) {
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

}
