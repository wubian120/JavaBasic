package cn.brady.designpattern.observer;


/***
 *
 * 观察者模式
 * 目标
 *
 * bian.wu
 * 2018.9.11
 *
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notityObserver(String s);
}
