package cn.brady.concurrent.phaser;

import java.util.concurrent.Phaser;

/**
 * example from below:
 * http://www.cnblogs.com/chenssy/p/4989515.html?utm_source=tuicool&utm_medium=referral
 *
 * Created by Brady on 2017/6/28.
 */
public class PhaserTest2 {

    public static void main(String[] args){
        Phaser p = new Phaser(5);

        for(int i=0;i<5; i++){

            Task01 t = new Task01(p);
            Thread thread = new Thread(t,"t"+i);
            thread.start();

        }
        System.out.println(" the end ... ");
    }

}


class Task01 implements Runnable{
    private final Phaser phaser;

    public Task01(Phaser p){
        this.phaser = p;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " get done, waiting for other task... ");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + " continue working.....");
    }
}
//output:
//    the end ...
//        t0 get done, waiting for other task...
//        t2 get done, waiting for other task...
//        t3 get done, waiting for other task...
//        t4 get done, waiting for other task...
//        t1 get done, waiting for other task...
//        t4 continue working.....
//        t2 continue working.....
//        t0 continue working.....
//        t1 continue working.....
//        t3 continue working.....


