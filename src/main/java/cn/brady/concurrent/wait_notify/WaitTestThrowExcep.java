package cn.brady.concurrent.wait_notify;

/**
 * Created by Brady on 2017/6/14.
 */
public class WaitTestThrowExcep {


    //throw java.lang.IllegalMonitorStateException
    public void testWait(){

        System.out.println("Start wait...   ");
        try{
            wait(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("...End wait...");

    }

    public synchronized void testSynWait(){

        System.out.println("Start wait...   ");
        try{
            wait(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("...End wait...");

    }

    public static void main(String[] args){

        final WaitTestThrowExcep wt = new WaitTestThrowExcep();
        new Thread(new Runnable() {
            @Override
            public void run() {
                wt.testSynWait(); // this worked
//                wt.testWait();  throw java.lang.IllegalMonitorStateException
            }
        }).start();




    }

}
