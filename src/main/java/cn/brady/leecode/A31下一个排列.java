package cn.brady.leecode;

/**
 * @description:
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @auther: bian.wu
 * @date: 2019/4/21 08:48
 */
public class A31下一个排列 {
    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1)
            return;
        // len-2 防止越界
        int i = nums.length - 2;
        // 找降序
        // 这里的=的作用，如果两个数相等，依旧继续走，
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            // 从右往左找到第一个大于nums[i]的元素
            // 注意等号
            // 也就是从i+1开始找到最小的一个比nums[i]大的元素
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        // 如果nums是降序，则i是-1，和下面逆置一样
        // 将i之后的元素逆置
        int k = nums.length - 1;
        i++;
        for (; i < k; i++, k--)
            swap(nums, i, k);
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String...args){

        int[] nums1 = {1,2,3,4,5,6,7};
        int[] nums2 = {5,4,3,2,1};
        int[] nums3 = {1,1,5,3,4,9,8,2};

        A31下一个排列 a = new A31下一个排列();

        a.nextPermutation(nums3);
        System.out.println("end");

    }

}
