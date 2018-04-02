package cn.brady.concurrent.deadlock;

public class Chopstick {

    private boolean taken = false;

    public synchronized void take() throws InterruptedException{

        while (taken){
            wait();
        }

        taken = true;

    }

    public synchronized void drop(){
        taken = false;
        notifyAll();
    }


    public static void main(String[] args){


        int size = 5;

        for(int i=0;i<size; i++){

            System.out.println(" i : " + i);
            int j = (i+1) % size;
            System.out.println("i+1 % size " + j);

        }

    }


}
