import java.util.concurrent.RecursiveTask;

public class FjStDeljiteljev extends RecursiveTask<Long> {

    int[] stevila;
    int startIdx;
    int endIdx;
    private static int thSize = 1;

    public FjStDeljiteljev(int[] stevila, int startIdx, int endIdx) {
        this.stevila = stevila;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    protected Long compute() {
        if (endIdx-startIdx<=thSize){//ustavitveni pogoj
            Long st = new Long(0);
            for (int i = startIdx; i < endIdx; i++) {
                st+= deljitelji(stevila[i]);
            }
            return st;
        }else {//rekurzivni korak
            int midIdx = (startIdx + endIdx) >>> 1; //deljenje z dva z bit shiftingom
            FjStDeljiteljev left = new FjStDeljiteljev(stevila,startIdx,midIdx);
            left.fork();//poslje v izvajanje
            //procesiraj desni subtask
            startIdx=midIdx;
            return compute() + left.join();//compute vedno pred join, ker ce ne caka na join
        }
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
