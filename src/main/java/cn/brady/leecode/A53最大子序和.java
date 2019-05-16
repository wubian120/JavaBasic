package cn.brady.leecode;

/**
 * @description: leetcode 53 最大子序和   已完成
 * @题目： https://leetcode-cn.com/problems/maximum-subarray/
 * @参考： 动态规划解法  https://blog.csdn.net/zwzsdy/article/details/80029796
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * @auther: bian.wu
 * @date: 2019/2/28 22:54
 */
public class A53最大子序和 {

    /**
     * 动态规划解法
     * @status pass
     * @beat  100%
     *
     */
    public static int maxSubArrayDP(int[] nums) {
        int sum = nums[0];
        // n为当前值
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果当前 值 >0 ,则+， 否则，就重新开始
            if (n > 0) {
                n += nums[i];
            } else {
                n = nums[i];
            }
            if (sum < n) {
                sum = n;
            }
        }
        return sum;
    }

    /**
     * @status pass
     * @beat 75%
     */
    public static int maxSubArray_two(int[] nums) {
        int sum = nums[0];
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (n > 0) n += nums[i];
            else n = nums[i];
            if (sum < n) sum = n;
        }
        return sum;

    }

    public static int maxSubArray1(int[] nums) {
        int sum = nums[0];
        int n = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            n += nums[i];
            if (n < 0) {
                sum = 0;
            } else if (n > 0) {
                sum = n;
            }

        }

        return sum;

    }

    public static void main(String... args) {

        // 正确答案  6
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int result = A53最大子序和.maxSubArray1(nums);


        int result = A53最大子序和.maxSubArrayDP(nums);

        System.out.println(result);
    }

    public static int maxSubArray_self_one(int[] nums) {
        int sum , current;
        sum = current= nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(current>0){
                current+=nums[i];
            }else {
                current=nums[i];
            }
            if(current>sum){
                sum=current;
            }
        }
        return sum;
    }


}
