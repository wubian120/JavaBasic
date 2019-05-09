package cn.brady.concurrent.semaphoreExample.product_comsume;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 实现生产者与消费者
 * https://www.cnblogs.com/leodaxin/p/7703721.html
 */
public class Buffer {

    List<Integer> buffer = new LinkedList<>();

    /**
     * 互斥
     */
    private Semaphore mutex = new Semaphore(1);

    /**
     * 生产可用 信号量
     */
    private Semaphore canProductorCount = new Semaphore(10);


    /**
     * 消费可用 信号量
     */
    private Semaphore canConsumerCount = new Semaphore(0);

    Random rm = new Random(10);

    public void get() throws InterruptedException {

        canConsumerCount.acquire();
        try {
            mutex.acquire();
            int val = buffer.remove(0);
            System.out.println(Thread.currentThread().getName() + " 正在消费数据为 " + val + " buffer 目前大小为： " + buffer.size());
        } finally {
            mutex.release();

            canProductorCount.release();
        }

    }

    public void put() throws InterruptedException {
        canProductorCount.acquire();
        try {
            mutex.acquire();
            int val = rm.nextInt(10);
            buffer.add(val);
            System.out.println(Thread.currentThread().getName() + " 正在生产数据为： " + val + " buffer 目前大小： " + buffer.size());

        } finally {
            mutex.release();

            /**消费者 增加 可消费数量 */
            canConsumerCount.release();
        }


    }
}
