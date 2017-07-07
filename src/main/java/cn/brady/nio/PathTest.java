package cn.brady.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

/**
 * NIO.2 Files.walkFileTree(); Path 用法。
 * http://blog.csdn.net/zhongweijian/article/details/8453293/
 * Created by Brady on 2017/7/5.
 */
public class PathTest {

    public static void main(String[] args){


        String path = "F:\\down-t\\House.of.Cards.S04.1080p.HDTV.DD5.1.x264-CasStudio";
        Path p1 = Paths.get(path);

        FileSystem fs = p1.getFileSystem();

        System.out.println(fs.provider().toString());
        Set<String> attributes = fs.supportedFileAttributeViews();
        for(String s : attributes){

            System.out.println(s);
        }


        String c = "D:\\";
//        Path path1 = Paths.get(path);

        try{
            FileVisitor visitor = new FindTargetFilesVisitor();
            Path start = Paths.get(c);
            Files.walkFileTree(start,visitor);

        }catch (IOException e){
            e.printStackTrace();
        }

//        System.out.println(path1.toString());
//        System.out.println(path1.getParent().toString());

    }



}
class FindTargetFilesVisitor extends SimpleFileVisitor<Path>{

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.toString().endsWith("txt")){
            System.out.println(file.getFileName());
        }


        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println(exc);
        return FileVisitResult.CONTINUE;
    }
}