package cn.brady.jvm;


import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Brady on 2017/6/7.
 */
public class ClassLoaderThird {

    public static void main(String[] args) throws IOException{
        ClassLoader sysLoader = ClassLoader.getSystemClassLoader();

        System.out.println("系统类加载");

        Enumeration<URL> eml = sysLoader.getResources("");
        while(eml.hasMoreElements()){
            System.out.println(eml.nextElement());
        }

//        ClassLoader extensionLoader


    }

}
