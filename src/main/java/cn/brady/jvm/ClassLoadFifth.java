package cn.brady.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * Created by Brady on 2017/7/3.
 */
public class ClassLoadFifth extends ClassLoader {

    private String classPath;
    public ClassLoadFifth(String classPath){

        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception{

        name = name.replaceAll("\\.","/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");

        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);

        fis.close();
        return data;

    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            byte[] data = loadByte(name);
            return defineClass(name,data,0,data.length);
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException();
        }

    }

    public static void main(String[] args)throws Exception{

        ClassLoadFifth classLoadFifth = new ClassLoadFifth("d:/TestClass");
        Class clazz = classLoadFifth.loadClass("cn.brady.jvm.TestClass");
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getDeclaredMethod("sayHi", null);

        helloMethod.invoke(obj, null);
    }

}
