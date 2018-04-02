package cn.brady.stream;

import java.util.Comparator;

public class Utils implements Comparator<A> {

    @Override
    public int compare(A a1, A a2) {
        return  a1.getNum() -  a2.getNum();
    }

}
