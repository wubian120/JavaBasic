package cn.brady.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/15 06:03
 */
public class A1_self {

    public int[] twoSum_self_one(int[] nums, int target){
        Map<Integer,Integer> numberMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numberMap.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(numberMap.containsKey(complement) && numberMap.get(complement) !=i){
                return new int[]{i,numberMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
