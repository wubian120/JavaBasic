package cn.brady.generic;

/**
 * 泛型接口
 * Created by Brady on 2017/5/5.
 */
public interface Message<T> {

    T getMessage();

    void setMessage(T t);

}
