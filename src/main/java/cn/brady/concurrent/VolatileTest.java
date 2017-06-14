package cn.brady.concurrent;

/**
 * 《深入理解Java虚拟机JVM高级特性》
 * 12章，Java内存模型与线程
 * 12.1代码清单
 * Created by Brady on 2017/6/6.
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args){

        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i=0;i<THREAD_COUNT; i++){

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while(Thread.activeCount() > 1){

            Thread.yield();

            System.out.print(race+" ");
        }

    }

}
