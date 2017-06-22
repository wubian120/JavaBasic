package cn.brady.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * example form <>深入理解虚拟机JVM高级特性</>
 *
 * Created by Brady on 2017/6/16.
 */
public class ClassLoaderFourth {

    public static void main(String[] args) throws Exception{

        ClassLoader bradyLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);

                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);

                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = bradyLoader.loadClass("cn.brady.jvm.ClassLoaderFourth").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof cn.brady.jvm.ClassLoaderFourth);




    }

}
