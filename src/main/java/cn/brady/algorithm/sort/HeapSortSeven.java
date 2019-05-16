package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2018/12/18 12:03
 */
public class HeapSortSeven {

    public static void sort(int[] data) {
        int len = data.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(data, i, 0);
            heapify(data, 0, i);
        }

    }

    private static void heapify(int[] arr, int i, int n) {

        int larger = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[larger] < arr[left]) {
            larger = left;
        }
        if (right < n && arr[larger] < arr[right]) {
            larger = right;
        }

        if (larger != i) {
            swap(arr, larger, i);
            heapify(arr, larger, n);
        }

    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String... args) {


        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSortSeven.sort(data);

        System.out.println("end");

    }

}
