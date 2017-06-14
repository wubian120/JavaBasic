package cn.brady.jvm;

/**
 * Created by Brady on 2017/6/6.
 */
public class ClassLoadSecond {

    public static void main(String[] args){

        SuperClass[] sca = new SuperClass[10];

//        System.out.println(SubClass.value);
    }

}

class SuperClass{

    static {
        System.out.println("Super class init...");
    }
    public static int value = 55;
}

class SubClass extends SuperClass{

    static {
        System.out.println("Subclass init...");
    }

}
//output:
//Super class init...
//        55

