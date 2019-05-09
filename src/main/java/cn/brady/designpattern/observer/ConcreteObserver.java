package cn.brady.designpattern.observer;


/***
 *
 * bian.wu
 * 2018.9.11
 * 观察者模式
 * 实例观察者
 */
public class ConcreteObserver implements Observer{

    @Override
    public void execute(String s) {
        System.out.println(s);
    }
}
