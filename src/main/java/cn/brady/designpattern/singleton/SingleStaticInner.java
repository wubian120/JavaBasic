package cn.brady.designpattern.singleton;

/**
 *
 *
 * Created by Brady on 2017/5/23.
 */
public class SingleStaticInner {

    private SingleStaticInner(){}

    public static SingleStaticInner getInstance(){
        return InstanceHolder.instance;
    }

    //静态内部类
    private static class InstanceHolder{
        private static final SingleStaticInner instance = new SingleStaticInner();
    }
}
