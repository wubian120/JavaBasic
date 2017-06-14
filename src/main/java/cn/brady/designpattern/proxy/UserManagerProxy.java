package cn.brady.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Brady on 2017/6/13.
 */
public class UserManagerProxy implements InvocationHandler {

    private Object target;

    public Object newProxyInstance(Object target){

        this.target = target;

        // Class 的 getClassLoader() ;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;

        try{
            System.out.println(" proxy invoke...");

            obj = method.invoke(target,args);



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error--");
            throw e;
        }

        return obj;
    }



}
