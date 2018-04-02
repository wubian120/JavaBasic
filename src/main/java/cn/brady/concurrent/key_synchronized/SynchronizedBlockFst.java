package cn.brady.concurrent.key_synchronized;

public class SynchronizedBlockFst implements Runnable{

    private static int count;

    public SynchronizedBlockFst(){
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this){
            for(int i=0; i<5;i++){

                try{
                    System.out.println(Thread.currentThread().getName() + ": "+(count++));
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static int getCount() {
        return count;
    }


    public static void main(String[] args){

        SynchronizedBlockFst synchronizedBlockFst = new SynchronizedBlockFst();
//        Thread thread1 = new Thread(synchronizedBlockFst, "Sync1");
//        Thread thread2 = new Thread(synchronizedBlockFst, "Sync2");
        Thread thread1 = new Thread(new SynchronizedBlockFst(), "Sync1");
        Thread thread2 = new Thread(new SynchronizedBlockFst(), "Sync2");

        thread1.start();
        thread2.start();

    }

}
