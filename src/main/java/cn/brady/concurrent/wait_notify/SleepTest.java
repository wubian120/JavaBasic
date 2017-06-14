package cn.brady.concurrent.wait_notify;

/**
 *
 *http://blog.csdn.net/zcf396720/article/details/52040608
 * Created by Brady on 2017/6/14.
 */
public class SleepTest {

    public synchronized void testSleep(){
        System.out.println(Thread.currentThread().getName() + "Sleep start...");

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "Sleep end...");

    }

    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() + "Wait start ... ");
        synchronized (this){
            try{
                wait(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "wait end...");
    }

    public static void main(String[] args){

        final SleepTest st = new SleepTest();

        for(int i=0;i<5; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    st.testSleep();
                }
            }).start();

        }

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("------------------ fen ------");

        final SleepTest st2 = new SleepTest();
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    st2.testWait();
                }
            }).start();
        }

    }


}
