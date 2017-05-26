package cn.brady.designpattern.factory;

/**
 * Created by Brady on 2017/5/18.
 */
public class White implements Color {
    @Override
    public void sayColor() {
        System.out.println(this.getClass().getName());
    }
}
