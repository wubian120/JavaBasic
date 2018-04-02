package cn.brady.concurrent.key_synchronized;

public class SyncCounter implements Runnable {

    private int count;

    public SyncCounter(){
        count = 0;
    }

    public void countAdd(){

        synchronized (this){
            for(int i=0;i<5;i++){
                try{
                    System.out.println("countAdd "+Thread.currentThread().getName() + ": " + (count++));
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void printCount(){

        for(int i=0;i<5;i++){
            try{
                System.out.println("printCount "+Thread.currentThread().getName() + ": " + count);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }



    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        if(threadName.equals("A")){
            countAdd();
        }else if(threadName.equals("B")){
            printCount();
        }


    }

    public static void main(String[] args){

        SyncCounter counter = new SyncCounter();
        Thread thread1 = new Thread(counter,"A");
        Thread thread2 = new Thread(counter,"B");

        thread1.start();
        thread2.start();
    }

}
