import java.util.ArrayList;
import java.util.List;

public class Buffer {
    List<Integer> buff = new ArrayList<>();
    int maxSize;
    public Buffer(int maxSize){
        this.maxSize=maxSize;

    }


    public void push(int el){
        if (buff.size()<maxSize){
            buff.add(el);
        }
    }

    public Integer pop(){
        if (!buff.isEmpty()) return buff.remove(0);
        else return null;
    }

    public boolean isFull(){
        if (maxSize==buff.size()) return true;
        return false;
    }
    public boolean isEmpty(){
        return buff.isEmpty();
    }

}
