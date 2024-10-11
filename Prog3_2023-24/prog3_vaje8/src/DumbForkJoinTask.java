import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DumbForkJoinTask extends RecursiveTask<Long> {

    int[] stevila;

    public DumbForkJoinTask(int[] stevila){
        this.stevila=stevila;
    }

    @Override
    protected Long compute() {
        List<ForkJoinTask> forks = new ArrayList<>();
        for (int i = 0; i < stevila.length; i++) {
            int num = stevila[i];
            forks.add(new RecursiveTask() {
                @Override
                protected Long compute() {
                    return (long)deljitelji(num);
                }
            }.fork());//fork poda task v izvajanje
        }
        long stDeljiteljev = 0;

        for (ForkJoinTask<Long> t : forks) {
            stDeljiteljev += t.join();
        }

        return stDeljiteljev;
    }

    public int deljitelji(int n){
        int d = 0;
        for (int i = 1; i <= (n/2); i++) {
            if (n%i==0) {
                d++;
            }
        }
        return d+1;
    }
}
