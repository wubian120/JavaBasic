package cn.brady.concurrent.contools;


import java.util.concurrent.CyclicBarrier;

/***
 *
 * bian wu
 * 2018.2.6
 * http://ifeve.com/concurrency-cyclicbarrier/
 */

public class CyclicBarrierTestFst {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    cyclicBarrier.await();
                }catch (Exception e){

                }
                System.out.println(Thread.currentThread().getId() +" name: "+ Thread.currentThread().getName() + " 1");

            }
        }).start();

        try{
            cyclicBarrier.await();
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getId() +" name: "+ Thread.currentThread().getName() + " 2");


    }




}
