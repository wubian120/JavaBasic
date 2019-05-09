package cn.brady.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Brady on 2017/5/26.
 */
public class ThreadPoolExampleFirst {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i<20; i++){

            Runnable worker = new WorkerThread(" " + i);
            executorService.execute(worker);
        }

    }

}

class WorkerThread implements Runnable{

    private String command;

    public WorkerThread(String s){
        command = s;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start.Command = " + command);

        processCommand();

        System.out.println(Thread.currentThread().getName() + " End. ");

    }

    private void processCommand(){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}