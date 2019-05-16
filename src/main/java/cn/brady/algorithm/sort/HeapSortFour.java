package cn.brady.algorithm.sort;

/**
 * @description:  fail
 * @auther: bian.wu
 * @date: 2018/12/18 09:04
 */
public class HeapSortFour {


    public static void sort(int[] data) {
        int len = data.length;
        for (int i = len / 2 - 1; i > 0; i--) {
            adjustHeap(data, i, len);
        }

        for (int j = data.length - 1; j > 0; j--) {
            swap(data, 0, j);
            adjustHeap(data, 0, j);
        }

    }

    public static void adjustHeap(int[] data, int i, int len) {

        int temp = data[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && data[k] < data[k + 1]) {
                k++;
            }
            if (data[k] > temp) {
                data[i] = data[k];
                i = k;
            } else {
                break;
            }
        }
        data[i] = temp;
    }

    public static void swap(int[] data, int j, int i) {
        int temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

    public static void main(String...args){
        int[] data ={2,111,91,81,27,63,5,4,1};

        sort(data);

        System.out.println("end");

    }

}
