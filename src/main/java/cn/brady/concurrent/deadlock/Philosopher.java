package cn.brady.concurrent.deadlock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{

    private Chopstick left;
    private Chopstick right;

    private int id;
    private int ponderFactor;

    private Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int factor){

        this.ponderFactor = factor;
        this.id = id;
        this.left = left;
        this.right = right;

    }

    private void pause() throws InterruptedException{

        if(ponderFactor == 0){
            return;
        }

        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));

    }

    public void run(){


        try{
            System.out.println(this + "  .... thinking...");
            pause();
            System.out.println(this + "  .... left take...");
            left.take();
            System.out.println(this + "  .... right take...");
            right.take();

            System.out.println(this + "  .... eating ...");
            pause();
            System.out.println(this + "  .... left drop...");
            left.drop();
            System.out.println(this + "  .... right drop...");
            right.drop();

        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(this + " quit ");
        }
    }


    @Override
    public String toString() {
        return "Philosopher  " + id;
    }




    public static void main(String[] args)throws InterruptedException{

        int ponder = 5;
        int size = 5;

        ExecutorService exec = Executors.newCachedThreadPool();

        Chopstick[] chopsticks = new Chopstick[size];

        for(int i=0;i < size; i++){
            chopsticks[i] = new Chopstick();
        }

        for(int i=0; i<size; i++){
            Philosopher p = new Philosopher(chopsticks[i], chopsticks[(i+1) % size],i ,ponder);
            exec.execute(p);
        }

        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();

    }
}
