package cn.brady.concurrent.threadpool;

import java.util.concurrent.*;

/***
 *
 * 线程池 封装
 *
 * bian.wu
 * 2018.9.14
 *
 */
public class ThreadPoolExecutors{


    public static final int COMPUTING = 1;
    public static final int IO = 2;

    public static ExecutorService getFixedThreaPool(int fixNum){

        return new ThreadPoolExecutor(fixNum,fixNum,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    }



    private ThreadPoolExecutors(){}

}
