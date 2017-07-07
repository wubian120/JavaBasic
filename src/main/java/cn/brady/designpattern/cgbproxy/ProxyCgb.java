package cn.brady.designpattern.cgbproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * https://yq.aliyun.com/articles/71337?utm_campaign=wenzhang&utm_medium=article&utm_source=QQ-qun&2017329&utm_content=m_15243
 * Created by Brady on 2017/6/13.
 */
public class ProxyCgb implements MethodInterceptor{
    private Object obj;

    public Object createProxy(Object target){
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());

        enhancer.setCallback(this);
        enhancer.setClassLoader(target.getClass().getClassLoader());
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result = null;
        doBefore();
        result = methodProxy.invokeSuper(o,objects);
        doAfter();


        return result;
    }

    private void doBefore(){
        System.out.println(" before method invoke..");
    }

    private void doAfter(){
        System.out.println(" after method invoke...");
    }



    public static void main(String[] args){


        HelloWolrd hello = new HelloWolrd();
        ProxyCgb cgb = new ProxyCgb();
        HelloWolrd hw = (HelloWolrd) cgb.createProxy(hello);
        hw.sayHello();;




    }



}
