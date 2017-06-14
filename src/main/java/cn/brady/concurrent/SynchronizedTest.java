package cn.brady.concurrent;

/**
 * Created by Brady on 2017/5/26.
 */
public class SynchronizedTest {

    public static Object obj = new Object();
    public static void main(String[] args){

        synchronized (obj){
            System.out.println("this is a synchronized test.");
        }

    }
}
