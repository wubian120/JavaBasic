package cn.brady.generic;

/**
 * 泛型方法
 * Created by Brady on 2017/5/5.
 */
public class GenericFunction {

    public static <T> void staticMethod(T a){

        System.out.println(a);
    }

    public <T> void regularMethod(T a){
        System.out.println(a);
    }

    public static void main(String[] args){

        String s = "123141";

        staticMethod(s);

        GenericFunction gf = new GenericFunction();
        gf.<String>regularMethod(s);
    }

}
