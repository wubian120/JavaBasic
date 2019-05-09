package cn.brady.designpattern.observer;


import java.util.LinkedList;
import java.util.List;

/***
 * 观察者模式
 * 实例目标
 *
 * bian.wu
 * 2018.9.11
 *
 */
public class ConcreteSubject implements Subject{

    protected List<Observer> observerList = new LinkedList<>();
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);

    }

    @Override
    public void notityObserver(String s) {
        for(Observer observer : observerList){
            observer.execute(s);
        }
    }



    public static void main(String... args){

        ConcreteSubject concreteSubject = new ConcreteSubject();

        concreteSubject.addObserver(new ConcreteObserver());
        concreteSubject.addObserver(new ConcreteObserver());
        concreteSubject.addObserver(new ConcreteObserver());
        concreteSubject.notityObserver("hello observer");



    }
}

