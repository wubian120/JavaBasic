package cn.brady.jvm;

/**
 * Created by Brady on 2017/6/6.
 */
public class ClassLoadTest {

    public static void main(String[] args){

        System.out.println(Son.a);

    }
}


class Father {

    static {
        System.out.println(" Father is inited...");
    }

    public static  int a = 1;

}

class Son extends Father {


    static {
        System.out.println("Son is inited..");
    }

}