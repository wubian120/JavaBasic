package cn.brady.jvm;

/**
 * Created by Brady on 2017/6/6.
 */
public class ClassLoadFirst {

    public static void main(String[] args){

        Singleton singleton = Singleton.getSingleton();
        System.out.println("counter1: " + singleton.counter1);

        System.out.println("counter2: " + singleton.counter2);


    }

}

class Singleton{

    private static Singleton single = new Singleton();

    public static int counter1 ;
    public static int counter2 = 0;

    private Singleton(){
        counter1 ++;
        counter2++;

    }

    public static Singleton getSingleton(){
        return single;
    }

}
