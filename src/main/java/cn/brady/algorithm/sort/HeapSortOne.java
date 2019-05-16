package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2018/12/16 16:33
 */
public class HeapSortOne {

    public static void sort(int[] data) {

        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data,len, i);
        }

        for(int i=len-1;i>=0; i--){
            int t = data[0];
            data[0] = data[i];
            data[i] = t;

            heapify(data,i,0);
        }

    }


    public static void heapify(int[] data, int n, int i) {

        int largestIndex = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && data[left] > data[largestIndex]) {
            largestIndex = left;
        }

        if (right < n && data[right] > data[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != i) {

            int temp = data[i];
            data[i] = data[largestIndex];
            data[largestIndex] = temp;
            heapify(data, n, largestIndex);
        }

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String... args) {
        int[] data1 = new int[]{10, 4, 90, 34, 5, 65, 90, 43, 9};

        HeapSortOne.sort(data1);

        System.out.println("end");

    }
}
