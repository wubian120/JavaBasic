package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/29 09:06
 */
public class A215数组中的第K个最大元素_two {

    /**
     * @param nums
     * @param k
     * @return
     * @ref https://blog.csdn.net/qq799028706/article/details/85924178
     * @status pass
     * @beat 98.44%
     */
    public static int findKthLargest(int[] nums, int k) {


        return kthLargest(nums,0,nums.length-1,nums.length-k);

    }

    private static int kthLargest(int[] data, int left, int right, int k) {

        while (true) {
            // 就一个数 ，
            if (left == right) {
                return data[left];
            }


            int mid = left + (right - left) / 2;
            if (data[left] > data[mid]) {
                swap(data, left, mid);
            }
            if (data[left] > data[right]) {
                swap(data, left, right);
            }

            if (data[mid] > data[right]) {
                swap(data, mid, right);
            }

            int partitionIndex = partition2nd(data, left, right, mid);

            if (partitionIndex == k) {
                return data[k];
            } else if (partitionIndex < k) {
                left = partitionIndex + 1;
            } else if (partitionIndex > k) {
                right = partitionIndex - 1;
            }

        }

    }

    private static int partition2nd(int[] data, int left, int right, int mid) {

        int pivot = data[mid];
        swap(data, mid, right);
        int i = left, j = left;
        while (j < right) {
            if (data[j] < pivot) {
                swap(data, i, j);
                i++;

            }
            j++;
        }
        swap(data, right, i);
        return i;
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







    public static void main(String... args) {

        int[] nums = {7, 6, 2, 1, 3, 4};
        int k = 2;

        int result = A215数组中的第K个最大元素_two.findKthLargest(nums, k);
        System.out.println(result);
    }


}
