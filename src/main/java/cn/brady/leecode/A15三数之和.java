package cn.brady.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 15 三数之和  数组 双指针
 * https://leetcode-cn.com/problems/3sum/
 *
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 * 满足要求的三元组集合为：
 * [ [-1, 0, 1],  [-1, -1, 2] ]

 * todo: 15 三数之和
 * todo: 1.跟一遍
 * todo: 2.理解
 * todo: 3. 背着写一遍
 * todo: 4.可以默写完成
 * @auther: bian.wu
 * @date: 2019/3/28 10:46
 */
public class A15三数之和 {

    /**
     * @status pass
     * @beat 96%
     * @cost 52ms
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            int target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k]);
                    results.add(result);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        return results;
    }

    public static void main(String... args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> results = A15三数之和.threeSum(nums);

        for (List<Integer> res : results) {
            for (Integer num : res) {
                System.out.print(num+" ");
            }
            System.out.println(" ");
        }
    }

}
