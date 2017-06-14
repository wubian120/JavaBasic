package cn.brady.designpattern.singleton;

/**
 * lazy style
 * Created by Brady on 2017/6/8.
 */
public class SingletonLazy {
    public static SingletonLazy instance = null;

    private SingletonLazy(){

    }

    //不加锁 可能读到  初始化一半的  对象。
    public static synchronized SingletonLazy getInstance(){

        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }


}
