package cn.brady.designpattern.factory;

/**
 * Created by Brady on 2017/5/18.
 */
public class Red implements Color {

    @Override
    public void sayColor() {
        System.out.println(this.getClass().getName());
    }
}
