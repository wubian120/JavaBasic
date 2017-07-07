package cn.brady.designpattern.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Brady on 2017/6/29.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object t){
        target = t;
    }

    public Object newInstance(){

        if(target == null){
            System.out.println("target is null.");
            return null;
        }
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        try{

            if("getName".equals(method.getName())){
                System.out.println("+++Before+++" + method.getName() + "+++");
                 result = method.invoke(target, args);
                System.out.println("+++After+++" + method.getName() + "+++");
                return result;
            }else if("getAge".equals(method.getName())){
                System.out.println("+++Before+++" + method.getName() + "+++");
                result = method.invoke(target, args);
                System.out.println("+++After+++" + method.getName() + "+++");
                return result;
            }else {

                System.out.println("+++Before+++" + method.getName() + "+++");
                result = method.invoke(target, args);
                return result;



            }


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error--");
            throw e;
        }




    }


    public static void main(String[] args){

        UserService us = new UserServiceImpl();
        MyInvocationHandler ih = new MyInvocationHandler(us);

        UserService usProxy = (UserService) ih.newInstance();

        usProxy.getName(9);

        usProxy.getAge(23);


    }
}
