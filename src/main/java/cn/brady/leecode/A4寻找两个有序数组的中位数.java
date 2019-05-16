package cn.brady.leecode;

/**
 * @description: 4.寻找两个有序数组的中位数  hard  done  2018.12.18
 * <p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @auther: bian.wu
 * @date: 2018/12/11 19:43
 */
public class A4寻找两个有序数组的中位数 {

    public static int[] num1;
    public static int[] num2;

    public static int[] data;


    public static int getParentIndex(int current) {
        return (current - 1) >> 1;
    }

    public static int getLeftIndex(int current) {
        return (current << 1) + 1;
    }

    public static int getRightIndex(int current) {
        return (current << 1) + 2;
    }

    private static void swap(int[] dt, int i, int j) {
        int t = dt[i];
        dt[i] = dt[j];
        dt[j] = t;
    }

    private static void heapyfy(int[] data, int i, int n) {

        int larger = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left<n && data[left] > data[larger]){
            larger = left;
        }
        if(right<n && data[right] > data[larger]){
            larger = right;
        }
        if(larger != i){
            swap(data, i,larger);
            heapyfy(data,larger,n);
        }
    }

    public static void sort(int[] data){
        int len = data.length;
        for(int i= len/2 -1 ;i>= 0; i--){
            heapyfy(data,i,len);
        }

        for(int i=len-1;i>=0;i--){
            swap(data,i,0);
            heapyfy(data,0,i);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        data = new int[len1 + len2];

        for (int i = 0; i < len1; i++) {
            data[i] = nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            data[len1 + i] = nums2[i];
        }
        sort(data);
        double  result = 0.0;
        int totalLen = len1+len2;
        if(totalLen % 2 !=0){
            result = (double) data[totalLen/2];
        }else {
            result = (double) (data[totalLen/2] + data[totalLen/2 -1]) /2;
        }

        return result;
    }

    /**
     * @beat  100%
     * @ref https://blog.csdn.net/liushiqi0826/article/details/85055317
     *
     */
    public double findMedianSortedArrays_two(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArrays(nums2, nums1);
        if (n == 0) return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2) left = mid2 + 1;
            else if (L2 > R1) right = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;

    }

    public static void main(String... args) {

        int[] nums1 = {90, 32, 12, 3, 2, 1};
        int[] nums2 = {1, 2, 3, 4, 5, 6};

        A4寻找两个有序数组的中位数.findMedianSortedArrays(nums1, nums2);

        System.out.println("pause");
    }

}
