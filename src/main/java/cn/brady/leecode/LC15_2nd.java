package cn.brady.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: leecode 15 三数之和
 * done
 * 参考  http://www.cnblogs.com/patatoforsyj/p/9496345.html
 *
 * @auther: bian.wu
 * @date: 2018/12/22 14:41
 */
public class LC15_2nd {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = len - 1;
            int target = 0 - nums[i];
            while (j<k){
                if(nums[j] + nums[k] == target){
                    List<Integer> result = Arrays.asList(nums[i],nums[j],nums[k]);
                    results.add(result);
                    while (j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while (j<k&&nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }else if(nums[j] + nums[k] > target){
                    k--;
                }else {
                    j++;
                }
            }
        }

        return results;
    }


    public static void main(String... args) {
        int[] num1 = {-1, 0, 1, 2, -1, -4};

        threeSum(num1);

    }

}
