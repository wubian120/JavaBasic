package cn.brady.jvm;

/**
 * Created by Brady on 2017/7/3.
 */
public class TestClass {

    public void sayHi(){
        System.out.println(" Hi this is testclass's sayHi()....");
        System.out.println("...class loader... " + getClass().getClassLoader().getClass() +" load...");
    }

}
