public class Fibonacci {

    public static void main(String[] args) {
        //F(n)=F(n-1)+F(n+2)
        System.out.println(fibbonacci(5));

    }

    public static int fibbonacci(int n) {
        if (n == 0) {
            return 0;
        }else if (n==1){
            return 1;
        } else{
            return fibbonacci(n-1)+fibbonacci(n-2);
        }


    }


}
