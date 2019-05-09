package cn.brady.concurrent.semaphoreExample.fst;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Employee implements Runnable {

    private String id;
    private static Random random = new Random(47);
    private Semaphore semaphore;

    public Employee(String id, Semaphore semaphore){
        this.id = id;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        try{
            semaphore.acquire();
            System.out.println(this.id +" is using the resource");
            TimeUnit.MILLISECONDS.sleep(random.nextInt());

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
            System.out.println(this.id+" is leaving resource.");

        }

    }
}
