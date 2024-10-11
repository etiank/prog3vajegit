import java.util.Random;

public class MatrixMul implements Runnable{
    public int indexNiti;   //index vrstice na kateri operira thread
    public static  int N = 1000;
    public static int[][] A;
    public static int[][] B;
    public static int[][] Czaporedno;
    public static int[][] Cvzporedno;


    public static void main(String[] args) {
        A = populateMatrix(new int[N][N]);
        B = populateMatrix(new int[N][N]);
        long t0 = System.currentTimeMillis();       //cas ob startu
        Czaporedno = zaporednoMnozenjeMatrik(A,B);
        long t = System.currentTimeMillis() - t0;   //pretekel cas
        System.out.println(Constants.INFO+" zaporedno mnozenje matrik je trajalo: "+t+"ms");

        Cvzporedno = new int[N][N];
        Thread[] niti = new Thread[N];
        t0 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            niti[i]= new Thread(new MatrixMul(i));
            niti[i].start();
        }
        for (int i = 0; i < N; i++) {
            try {
                niti[i].join();//pocakaj da se nit zakljuci
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        t = System.currentTimeMillis()-t0;
        System.out.println(Constants.INFO+" vzporedno mnozenje matrik je trajalo: "+t+"ms");
        if (equalM(Cvzporedno, Czaporedno)){
            System.out.println(Constants.RESULT+"Matriki sta enaki");
        }else {
            System.out.println(Constants.RESULT+"Matriki sta razlicni");
        }
    }


    public static boolean equalM(int[][]a,int[][]b){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j]!=b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public MatrixMul(int i){
        this.indexNiti = i; //constructor
    }

    @Override
    public void run() {         //to dela vsaka nit
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                Cvzporedno[this.indexNiti][j] += A[this.indexNiti][k]*B[k][j];
            }
        }
    }



    public static int[][] zaporednoMnozenjeMatrik (int[][] a, int[][] b){
        int [][] c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }



    public static int[][] populateMatrix(int[][] m){
        Random r = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j]= r.nextInt(1000);
            }
        }
        return m;
    }


}
