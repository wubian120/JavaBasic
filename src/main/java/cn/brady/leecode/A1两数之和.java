package cn.brady.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @auther: bian.wu
 * @date: 2019/4/14 19:25
 */
public class A1两数之和 {

    /***
     * @beat  99%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int max = 0xfff;
        int[] map = new int[max + 1];
        int index = 0, i;
        Arrays.fill(map, -1);
        for (i = 0; i < nums.length; i++) {
            index = (target - nums[i]) & max;
            if (map[index] != -1) {
                break;
            }
            map[nums[i] & max] = i;
        }
        return new int[]{map[index], i};
    }

    /***
     * @beat  92%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_two(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
