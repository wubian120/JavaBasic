package cn.brady.generic;

/**
 * Created by Brady on 2017/5/5.
 */
public class BridgePair<T> {

    private T first;
    private T second;

    public BridgePair(){
        first = null;
        second = null;
    }

    public BridgePair(T first, T second){
        this.first  = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

}
