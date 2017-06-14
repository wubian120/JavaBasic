package cn.brady.concurrent.wait_notify;

/**
 * Created by Brady on 2017/6/14.
 */
public class JoinTestNoJoin implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + " start..");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end..");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        for(int i=0;i<5;i++){

            Thread t = new Thread(new JoinTestNoJoin());
            t.start();

        }
        System.out.println(" Without sleep Finished..");


        System.out.println(" Join test start... ");

        for(int i=0;i<5;i++){
            Thread t1 = new Thread(new JoinTestNoJoin());
            t1.start();
            try{
                t1.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

