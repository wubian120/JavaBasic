package cn.brady.io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Brady on 2017/5/16.
 */
public class LargeMappedFiles {
    static int length = 0x8ffffff;  //128m
    public static void main(String[] args) throws Exception{

        MappedByteBuffer out = new RandomAccessFile("test.dat","rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);

        for(int i=0; i<length; i++){
            out.put((byte)'x');
        }

        System.out.print("Finished writing");
        for(int i= length/2; i< length/2 + 6; i++){
            System.out.print((char)out.get());
        }



    }

}
