package cn.brady.algorithm;

import java.util.Random;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/16 16:12
 */
public class Top100 {


    public void top100(int[] data, int start, int end, int k) {
        int switchPointer = start;
        int pivot = data[end];
        for (int i = start; i < end; i++) {
            if (data[i] >= pivot) {
                swap(data, switchPointer, i);
                switchPointer++;
            }
        }
        swap(data, end, switchPointer);
        if (switchPointer < k - 1) {
            top100(data, switchPointer + 1, end, k);
        } else if (switchPointer == k - 1) {
            return;
        } else {
            top100(data, 0, switchPointer - 1, k);
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    public static void main(String...args){

        int number = 100000000;
        int k = 100;
        int range =  100000001;
        int[] array = new int[number];

        Random random = new Random();
        for(int i=0;i<number;i++){
            array[i] = random.nextInt(range);
        }

        Top100 top100 = new Top100();
        Long t1 = System.currentTimeMillis();
        top100.top100(array, 0, array.length-1, k);

        Long t2 = System.currentTimeMillis();
        System.out.println("total time: " + (t2-t1));
        for(int i=0;i<k;i++){
            System.out.println(array[i]);
        }

    }

}
