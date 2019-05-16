package cn.brady.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * @beat 98%
 * @auther: bian.wu
 * @date: 2019/4/21 15:03
 */

public class A39组合总和two {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0)
            return list;
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        help(tmp, target, 0, candidates);
        return list;
    }

    public void help(List<Integer> tmp, int taget, int start, int nums[]) {
        if (taget < 0)
            return;
        if (taget == 0) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > taget) {
                break;
            }
            tmp.add(nums[i]);
            help(tmp, taget - nums[i], i, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String...args){

        int[] nums = {2,3,5};
        int target = 8;

        A39组合总和two a = new A39组合总和two();
        List<List<Integer>> results = a.combinationSum(nums,target);

        System.out.println("end");
    }
}
