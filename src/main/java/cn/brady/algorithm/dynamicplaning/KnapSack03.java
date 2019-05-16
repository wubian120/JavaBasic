package cn.brady.algorithm.dynamicplaning;

import java.util.Arrays;

/**
 * @description: leetcode  416 分割等和子集  passed
 *
 *
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @auther: bian.wu
 * @date: 2019/2/18 10:13
 */
public class KnapSack03 {

    private static boolean knapSack(int[] nums, int sum){
        int size = nums.length;
        boolean[] dp = new boolean[sum+1];

        for(int i=0;i<=sum;i++){
            dp[i]= (i==nums[0]);
        }

        for(int i=1;i<size;i++){
            for(int j=sum;j>= nums[i];j--){
                dp[j] = dp[j]|| dp[j-nums[i]];
            }
        }
        return dp[sum];
    }


    public static boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if(sum % 2 !=0){
            return false;
        }
        return knapSack(nums,sum/2);
    }

    public static void main(String...args){

//        int[] data = {1,5,11,5};
        int[] data = {1,2,3,5};

        boolean isCan = KnapSack03.canPartition(data);

        System.out.println("end");
    }



}
