package cn.brady.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by Brady on 2017/5/16.
 */
public class UsingBuffers {

    private static void symmetricScramble(CharBuffer buffer){

        while(buffer.hasRemaining()){

            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();

            buffer.reset();
            buffer.put(c2).put(c1);

        }

    }

    public static void main(String[] args){

        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 2);

        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(data);

        System.out.println(charBuffer.rewind());

        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());

    }

}
