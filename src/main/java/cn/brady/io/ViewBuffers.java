package cn.brady.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by Brady on 2017/5/15.
 */
public class ViewBuffers {

    public static void main(String[] args){

        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{ 0, 0, 0, 0, 0, 0, 0,'a'});
        byteBuffer.rewind();  //? rewind() ???

        System.out.print("Byte Buffer: ");
        while(byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.position()+ " -> " + byteBuffer.get() + ", ");
        }
        System.out.print("\n");

        CharBuffer charBuffer = ((ByteBuffer)byteBuffer.rewind()).asCharBuffer();
        System.out.print("Byte Buffer: ");
        while(charBuffer.hasRemaining()){
            System.out.print(charBuffer.position()+ " -> " + charBuffer.get() + ", ");
        }






    }
}
