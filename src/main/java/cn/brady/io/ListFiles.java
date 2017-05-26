package cn.brady.io;

import java.io.File;

/** 查找指定目录下，指定类型文件。
 * Created by Brady on 2017/5/11.
 */
public class ListFiles {

    public static void main(String[] args){

        String path = "d:/";
        File dic = new File(path);
        File[] files = dic.listFiles();

        System.out.println(files.length);
        for(File file : files){
            System.out.println(file.getName());
        }


    }



}
