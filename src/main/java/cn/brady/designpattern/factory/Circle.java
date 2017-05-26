package cn.brady.designpattern.factory;

/**
 * Created by Brady on 2017/5/18.
 */
public class Circle implements Shape{

    @Override
    public void sayHi() {
        System.out.println("I am a " + this.getClass().getName());
    }
}
