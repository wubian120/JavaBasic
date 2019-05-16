package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/7 16:24
 */
public class A46 {


    /***
     * @ref  leetcode records
     * @beat 100%
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {

        if (nums == null) return result;
        int len = nums.length;
        sortNums(nums, 0, len);
        return result;
    }

    private static List<List<Integer>> result = new ArrayList<List<Integer>>();

    public static void sortNums(int[] nums, int n, int len) {
        List<Integer> list = new ArrayList();
        if (len - 1 == n) {
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);

            }
            result.add(list);
            return;
        }
        for (int j = n; j < len; j++) {
            swap(nums, n, j);
            sortNums(nums, n + 1, len);
            swap(nums, n, j);      //不还原，for不同次的循环使用的nums不同
        }
    }

    public static void swap(int[] nums, int n, int j) {
        int temp = 0;
        temp = nums[n];
        nums[n] = nums[j];
        nums[j] = temp;
    }


}
