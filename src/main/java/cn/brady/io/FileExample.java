package cn.brady.io;

import java.io.File;

/**
 * example form http://blog.csdn.net/qq_37810594/article/details/71404683?utm_source=tuicool&utm_medium=referral
 * Created by Brady on 2017/5/17.
 */
public class FileExample {

    public static void createFile(String path,String file){
        File newFile = new File("d:/" + path + file + ".txt");
        File dir = new File("d:/"+path);
        try{
            dir.mkdirs();
            //如果没有该文件，则创建
            newFile.createNewFile();

            System.out.println("file name: " + newFile.getName());
            System.out.println("file path: " + newFile.getPath());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String paht = "adir/";
        String filename = "createFile";

        createFile(paht, filename);

    }

}

