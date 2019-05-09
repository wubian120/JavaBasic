package cn.brady.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock solve deadlock
 * from this
 * http://www.cnblogs.com/zhengbin/p/6503412.html?utm_source=tuicool&utm_medium=referral
 * Created by Brady on 2017/6/5.
 */
public class ReentrantDeadLockExam {


    public static void main(String[] args) throws InterruptedException{

        InLock inLock1 = new InLock(1);
        InLock inLock2 = new InLock(2);

        Thread thread1 = new Thread(inLock1, "thread one");
        Thread thread2 = new Thread(inLock2, "thread two");

        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();

    }

}

class InLock implements Runnable{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public InLock(int lock){
        this.lock = lock;
    }



    @Override
    public void run() {

        try{
            if(lock == 1){
                lock1.lockInterruptibly(); //获取锁 除非 当前线程中断。
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + " ,执行完毕。");

            }else {
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+ ", 执行完毕。");

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName()+ " 推出！");
        }

    }
}