package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/29 09:06
 */
public class A215数组中的第K个最大元素 {

    /**
     * @param nums
     * @param k
     * @return
     * @ref https://blog.csdn.net/qq799028706/article/details/85924178
     * @status pass
     * @beat 98.44%
     */
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);

    }


    //交换
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 求中位数 如果 左 > 中   左 > 右  中 > 右 ， 则交换； 返回 中位数
    private static int medianOf3(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (nums[left] > nums[mid]) {
            swap(nums, left, mid);
        }
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }
        if (nums[mid] > nums[right]) {
            swap(nums, mid, right);
        }
        return mid;
    }


    //
    private static int partition(int[] nums, int left, int right, int mid) {

        int pivot = nums[mid];
        //交换 中位数 与 最右侧（大）值
        swap(nums, mid, right);
        //i初识 最左侧值
        int i = left;
        //j 从左 至 右 迭代
        for (int j = left; j < right; j++) {
            //如果
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, right, i);
        return i;
    }

    private static int quickSort(int[] nums, int left, int right, int k) {
        //循环 不断移动 partitionIndex
        while (true) {
            if (left == right) {
                return nums[left];
            }
            int mid = medianOf3(nums, left, right);
            int partitionIndex = partition(nums, left, right, mid);

            if (partitionIndex == k) {
                return nums[k];
            } else if (partitionIndex < k) {
                left = partitionIndex + 1;
            } else {
                right = partitionIndex - 1;
            }
        }
    }


    public static void main(String... args) {

        int[] nums = {7, 6, 2, 1, 3, 4};
        int k = 2;

        int result = A215数组中的第K个最大元素.findKthLargest(nums, k);
        System.out.println(result);
    }


}
