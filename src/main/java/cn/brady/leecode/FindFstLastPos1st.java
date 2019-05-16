package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: leecode 34.在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @auther: bian.wu
 * @date: 2018/12/11 03:01
 */
public class FindFstLastPos1st {

    public int[] searchRange(int[] nums, int target) {

        List<Integer> indexList = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == target){
                indexList.add(i);
            }
        }
        int[] result = null;
        if(indexList.size() >0){
            result = new int[]{indexList.get(0),indexList.get(indexList.size()-1)};
        }else {
            result = new int[]{-1,-1};
        }

        return result;
    }
}
