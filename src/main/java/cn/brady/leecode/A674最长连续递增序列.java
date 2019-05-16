package cn.brady.leecode;

/**
 * @description: 674 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 * <p>
 * todo: 674 最长连续递增序列
 * todo: 1.跟一遍             2019-03-29 done
 * todo: 2.理解               2019-03-29 done
 * todo: 3. 跟着写一遍         2019-03-29 done
 * todo: 4. 背着写一遍
 * todo: 5.可以默写完成
 * @auther: bian.wu
 * @date: 2019/3/28 22:07
 */
public class A674最长连续递增序列 {

    /**
     * @param nums
     * @return
     * @status pass
     * @beat 69.9%
     */
    public static int findLengthOfLCIS_one(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int length = 1;
        int max = 0;
        for (int i = 0; i < len - 1; i++)
            if (nums[i] < nums[i + 1])
                length++;
            else {
                max = Integer.max(length, max);
                length = 1;
            }
        return Integer.max(length, max);
    }

    public static void main(String... args) {

//        int[] nums = {2,2,2,2,2};
//        int[] nums = {1,3,5,4,7};
        int[] nums = {1, 3, 5, 7};
//        int result = A674最长连续递增序列.findLengthOfLCIS_one(nums);
        int result = A674最长连续递增序列.findLengthOfLCIS_self_one(nums);

        System.out.println(result);
    }

    /**
     * 674 最长连续递增序列
     * self
     * 2019.03.29
     */
    public static int findLengthOfLCIS_self_one(int[] nums) {

        int len = nums.length;
        if (len == 0) return 0;

        int currentLen = 1, maxLen = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                currentLen++;
            } else {
                //不连续增长， currentLen 重置
                maxLen = Math.max(currentLen, maxLen);
                currentLen = 1;
            }
        }
        return Math.max(maxLen, currentLen);
    }

    public static int findLengthOfLCIS_self_two(int[] nums) {
        return 0;
    }


}
