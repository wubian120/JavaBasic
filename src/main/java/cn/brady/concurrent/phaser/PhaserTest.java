package cn.brady.concurrent.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by Brady on 2017/6/14.
 */
public class PhaserTest {

    public static void main(String[] args){
        Phaser phaser = new Phaser(1);
        for(int i=0; i<3; i++){
            new PhaserThread((char)(97+i), phaser).start();
        }

        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        phaser.arrive();
    }

}

class PhaserThread extends Thread{

    private char c;
    private Phaser phaser;

    public PhaserThread(char c, Phaser p){
        this.c = c;
        this.phaser = p;
    }

    @Override
    public void run() {
        phaser.awaitAdvance(phaser.getPhase()); // latch.await();
        for(int i=0; i<100; i++){
            System.out.print(c + " ");
            if( i % 10 == 9){
                System.out.println();
            }
        }
    }
}