package cn.brady.jvm;

/**
 * Created by Brady on 2017/6/6.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init..");
    }
    public static final String HELLOWORLD = "Hello world";
}
