package cn.brady.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brady on 2017/6/5.
 */
public class ReentrantLockFirst implements Runnable{

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {

        for(int j=0;j<10000;j++){

            reentrantLock.lock();

            try{
                i++;
            } finally {
                reentrantLock.unlock();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException{

        ReentrantLockFirst lockFirst = new ReentrantLockFirst();
        Thread t1 = new Thread(lockFirst);
        Thread t2 = new Thread(lockFirst);

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();

        System.out.println(i);




    }
}
