package cn.brady.io;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Thinking in java  18.10.7 文件加锁
 * Created by Brady on 2017/5/16.
 */
public class FileLocking {

    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fileLock = fos.getChannel().tryLock();
        if(fileLock != null){
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);

            fileLock.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }

}
