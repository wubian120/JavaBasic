package cn.brady.concurrent.wait_notify;

/**
 * Created by Brady on 2017/6/14.
 */
public class YieldTest implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        for(int i=0;i<5;i++){

            System.out.println(Thread.currentThread().getName() + " i: " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args){

        YieldTest yt = new YieldTest();

        Thread t1 = new Thread(yt,"First T");

        Thread t2 = new Thread(yt,"Second T");

        t1.start();
        t2.start();






    }

}
