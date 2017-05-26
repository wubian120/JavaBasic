package cn.brady.designpattern.singleton;

/**
 * 饿汉式 单例
 * Created by Brady on 2017/5/23.
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

}
