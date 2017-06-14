package cn.brady.practices.java7concurrentcookbook;

/**
 *  java7 cocurrent cookbook
 *  example 1
 * Created by Brady on 2017/6/6.
 */
public class Caculator implements Runnable{

    private int number;

    public Caculator(int n){
        number = n;
    }

    @Override
    public void run() {
        for(int i=0;i < 10; i++){

            System.out.printf("%s : %d * %d = %d\n",Thread.currentThread().getName(), number,i,i * number);


        }
    }

    public static void main(String[] args){

        System.out.println(Thread.currentThread().getName() + ".1.. ");

        for(int i=0; i<5; i++){
            Caculator cal = new Caculator(i);
            Thread thread = new Thread(cal);
            thread.start();

        }

        System.out.println(Thread.currentThread().getName() + ".2.. ");


    }


}
