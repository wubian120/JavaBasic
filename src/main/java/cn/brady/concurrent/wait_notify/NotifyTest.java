package cn.brady.concurrent.wait_notify;

/**
 * example of  notify()...
 * http://blog.csdn.net/zcf396720/article/details/52040608
 * Created by Brady on 2017/6/14.
 */
public class NotifyTest {

    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName()+ " start wait..");

        try{
            wait(0);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "wait end...");

    }

    public static void main(String[] args) throws InterruptedException{

        final NotifyTest nt = new NotifyTest();
        for(int i=0;i<5; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    nt.testWait();
                }
            }).start();
        }

        synchronized (nt){
            nt.notify();
        }

        Thread.sleep(3000 );
        System.out.println("---------------");

        synchronized (nt){

            nt.notifyAll();
        }

    }

}
