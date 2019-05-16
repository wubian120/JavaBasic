package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/1 19:49
 */
public class A4寻找两个有序数组的中位数_self_one {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length, totalLen = len1 + len2;

        int[] data = new int[len1 + len2];

        for (int i = 0; i < len1; i++) {
            data[i] = nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            data[len1 + i] = nums2[i];
        }
        heapSort(data);

        if ((totalLen & 1) == 1) {
            return (double) data[totalLen / 2];
        } else {
            return (double) (data[totalLen / 2] + data[totalLen / 2 - 1]) / 2;
        }
    }

    private static void heapSort(int[] data) {
        int len = data.length;
        //从 最下层 最左侧 第一个非叶节点开始
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data, i, len);
        }

        for (int j = len - 1; j >= 0; j--) {
            //第一个 与 最有一个交换
            swap(data, 0, j);

            heapify(data, 0, j);
        }

    }

    private static void heapify(int[] data, int index, int len) {
        int larger = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < len && data[left] > data[larger]) {
            larger = left;
        }

        if (right < len && data[right] > data[larger]) {
            larger = right;
        }

        if (larger != index) {
            swap(data, larger, index);
            heapify(data, larger, len);
        }

    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    public static void main(String... args) {
        int[] data = {5, 6, 3, 2, 1, 7, 12, 9, 3, 4, 90, 2};

        A4寻找两个有序数组的中位数_self_one.heapSort(data);


        System.out.println("end");


    }
}
