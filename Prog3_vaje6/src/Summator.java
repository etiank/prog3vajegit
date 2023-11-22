import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Summator implements Runnable{

    CyclicBarrier barrier;
    //List<Long> partial_results;
    long[] partial_results;
    int startIndex;
    int endIndex;

    int[] numbers;
    int indexNiti;

    @Override
    public void run() {
        long sum;
        while (true) {
            sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += numbers[i];
            }
            //partial_results.add(sum);//treba popravit
            partial_results[indexNiti] = sum;
            System.out.println(Thread.currentThread().getName() + " computed the sum: " + sum);

            try {
                barrier.await();//pocaka da ostale niti pridejo do barriera
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Summator(CyclicBarrier barrier, long[] partial_results, int startIndex, int endIndex, int[] numbers, int indexNiti) {
        this.barrier = barrier;
        this.partial_results = partial_results;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.numbers = numbers;
        this.indexNiti=indexNiti;
    }
}
