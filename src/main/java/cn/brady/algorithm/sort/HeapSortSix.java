package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2018/12/18 10:41
 */
public class HeapSortSix {


    public static void sort(int[] data) {
        int len = data.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapify(data, i, 0);
        }
    }

    /**
     * n len
     * i index
     */
    private static void heapify(int[] data, int n, int i) {
        int larger = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && data[left] > data[larger]) {
            larger = left;
        }
        if (right < n && data[right] > data[larger]) {
            larger = right;
        }

        if (larger != i) {
            swap(data, i, larger);
            heapify(data, n, larger);
        }

    }

    private static void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String... args) {
        int arr[] = {0, 19, 99, -3, 5, 9, 120, 12, 11, 32, 13, 5, 6, 7};

        HeapSortSix.sort(arr);

        System.out.println("end");
    }
}
