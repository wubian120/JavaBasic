package cn.brady.leecode;

/**
 * @description: 33 搜素旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/28 16:34
 */
public class A33搜素旋转排序数组 {

    /**
     * @ref  https://www.cnblogs.com/keeya/p/9689927.html
     * @beat  55%
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums==null||nums.length<1) return -1;

        int left = 0;
        int right = nums.length - 1;
        //分成两段
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            //target 在前半段
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

            //target 在后半段
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


}
