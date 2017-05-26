package cn.brady.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Created by Brady on 2017/5/15.
 */
public class Endians {

    public static void main(String[] args){

        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[12]);
        byteBuffer.asCharBuffer().put("abcdef");

        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);

        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));


        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));





    }

}
