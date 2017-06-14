package cn.brady.io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  NIO read file example;
 *  House of Card  season 5 script.
 *
 *  Worked well.
 *
 * Created by Brady on 2017/6/12.
 */
public class NIOTest {

    public static void main(String[] args) throws Exception{

        FileInputStream fis = new FileInputStream("D:\\house.of.cards.2013.s05e01.720p.webrip.x264-morose.eng.srt");

        FileChannel fc = fis.getChannel();
        ByteBuffer bf = ByteBuffer.allocate((int)fc.size());

        fc.read(bf);

        bf.rewind();

        while (bf.hasRemaining()){

            System.out.print((char)bf.get());
        }

        System.out.println("...The End...");

    }

}
