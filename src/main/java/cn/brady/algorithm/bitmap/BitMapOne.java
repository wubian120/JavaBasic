package cn.brady.algorithm.bitmap;

/**
 * @description: bitmap 算法
 *
 * https://www.jianshu.com/p/6082a2f7df8e
 * @auther: bian.wu
 * @date: 2019/4/28 12:40
 */
public class BitMapOne {

    private byte[] bytes;
    private int capacity;


    public BitMapOne(int capacity){
        this.capacity = capacity;
        // 1byte 存储8个数， capacity/8 +1 转换为byte  >> 3 相当于除8
        bytes = new byte[(capacity>>3)+1];

    }


    public void add(int num){
        //num / 8  得到 在 bytes中的索引位置
        int arrayIndex = num >> 3;
        // num%8 得到 在 bytes[index]的位置
        int position = num & 0x07;
        //将1左移position后，那个位置自然就是1，
        // 然后和以前的数据做|，这样，那个位置就替换成1了。
        bytes[arrayIndex] |= 1<<position;

    }

    public boolean contain(int num){
        int index = num>>3;
        int pos = num & 0x07;
        return (bytes[index] & (1<< pos)) !=0;
    }


    public static void main(String...args){

        BitMapOne bitMapOne = new BitMapOne(100);
        bitMapOne.add(81);

        boolean isExist = bitMapOne.contain(81);

//
//        int i = 1;
//        int a =  1<<i;



        System.out.println(isExist);
        System.out.println("end");

    }



}
