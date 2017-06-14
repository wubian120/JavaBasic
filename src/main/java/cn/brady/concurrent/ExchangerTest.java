package cn.brady.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *  Exchanger Example
 *  http://blog.csdn.net/chenssy/article/details/50108099
 * Created by Brady on 2017/6/14.
 */
public class ExchangerTest {

    public static void main(String[] args){

        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();

        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }

}
class Producer implements Runnable{

    private List<String> buffer;

    private final Exchanger<List<String>> exchanger;

    Producer(List<String> buffer, Exchanger<List<String>> exchanger){
        this.buffer    = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for(int i=0; i<10; i++){
            System.out.println("Producer: Cycle :" + cycle);

            for(int j=0; j<10; j++){
                String message = "Event " + ((i * 10)+j);
                System.out.println("Producer: "+message);
                buffer.add(message);
            }

            try{
                buffer = exchanger.exchange(buffer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Producer : " + buffer.size());

            cycle++;
        }

    }
}

class Consumer implements Runnable{

    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger){
        this.buffer    = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for(int i=0; i<10; i++){
            System.out.println("Consumer: Cycle: " + cycle);
            try{
                buffer = exchanger.exchange(buffer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Consumer: "+buffer.size());
            for(int j=0; j<10; j++){

                System.out.println("Consumer: " + buffer.get(0));
                buffer.remove(0);

            }
            cycle++;

        }

    }
}