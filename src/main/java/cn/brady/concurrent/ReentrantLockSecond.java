package cn.brady.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * ReentrantLock example from
 * http://blog.csdn.net/startupmount/article/details/37080277?utm_source=tuicool&utm_medium=referral
 * Created by Brady on 2017/6/7.
 */
public class ReentrantLockSecond {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock fairLock = new ReentrantLock(true);

    private int n;

    static class NonFairTestThread implements Runnable{

        private ReentrantLockSecond rls;

        public NonFairTestThread(ReentrantLockSecond rls){
            this.rls = rls;
        }

        @Override
        public void run() {
            lock.lock();
            try{
                rls.setNum(rls.getNum() + 1);
                System.out.println(Thread.currentThread().getName() + "notfairLock... ..." + rls.getNum());

            }finally {
                lock.unlock();
            }
        }
    }

    static class FairTestThread implements Runnable{

        private ReentrantLockSecond rls;

        public FairTestThread(ReentrantLockSecond rls){
            this.rls = rls;
        }


        @Override
        public void run() {
            fairLock.lock();
            try{
                rls.setNum(rls.getNum() + 1);
                System.out.println(Thread.currentThread().getName()+" fairlock==== " + rls.getNum()+ " " + fairLock.getHoldCount() +" queue lenght= " + fairLock.getQueueLength());
            }finally {
                fairLock.unlock();
            }

        }
    }


    public static void main(String[] args){

        ReentrantLockSecond rls = new ReentrantLockSecond();
        for(int i=0;i<100; i++){

            Thread noT = new Thread(new NonFairTestThread(rls));

            noT.setName("non fair[" + i + 1 + "]");

            noT.start();

            Thread fairT = new Thread(new FairTestThread(rls));

            fairT.setName("non fair[" + i + 1 + "]");

            fairT.start();

        }





    }

    public void setNum(int num){
        n = num;
    }

    public int getNum(){
        return n;
    }





}
