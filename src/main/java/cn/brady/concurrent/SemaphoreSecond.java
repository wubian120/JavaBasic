//package cn.brady.concurrent;
//
//import java.util.Random;
//import java.util.concurrent.Semaphore;
//
///**
// * Created by Brady on 2017/6/5.
// */
//public class SemaphoreSecond {
//
//    public static void main(String[] args){
//
//        final Semaphore semaphore = new Semaphore(2);
//
//        for(int i=0; i<5; i++){
//            final int j = i;
//
//            // 匿名内部类
//            new Thread(()->{
//
//                try{
//                    semaphore.acquire();
//                    System.out.println(" student " + j + " read book.");
//                    Thread.sleep(new Random().nextInt(10000) + 1000);
//
//                    System.out.println(" student " + j + " finished book.");
//                    semaphore.release();
//
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//
//            }).start();
//        }
//    }
//
//}
