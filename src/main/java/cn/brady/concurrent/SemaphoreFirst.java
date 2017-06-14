package cn.brady.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Brady on 2017/6/5.
 */
public class SemaphoreFirst {

    private static final int SEM_MAX = 12;



    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(SEM_MAX);

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(new MyThread(semaphore, 7));
        service.execute(new MyThread(semaphore, 4));
        service.execute(new MyThread(semaphore, 2));

        service.shutdown();

    }

}

class MyThread extends Thread{

    private volatile Semaphore semaphore;

    private int count;

    public MyThread(Semaphore sema, int count){

        this.semaphore = sema;
        this.count = count;
    }

    @Override
    public void run() {

        try{
            semaphore.acquire(count);
            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " acquire count = " + count);

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {

            semaphore.release(count);
            System.out.println(Thread.currentThread().getName() + " release " + count);
        }

    }


}
