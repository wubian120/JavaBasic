package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description: leetcode 16 最接近的三数之和  passed
 * @base on : https://blog.csdn.net/xc121566/article/details/81331628
 * @auther: bian.wu
 * @date: 2019/2/24 18:25
 */
public class A16_One {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sub = 0, abssub = 0, sum = 0;
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            int left = 0, right = len-1;
            while(left<i && i<right){

                sub = nums[left] + nums[right] + nums[i] - target;
                abssub = Math.abs(sub);

                if(closest > abssub){
                    closest = abssub;
                    sum = nums[left] + nums[right]+nums[i];
                }
                if(sub > 0){
                    right--;
                }else if(sub<0){
                    left++;
                }else{
                    sum=nums[left] + nums[right] + nums[i] ;
                    break;
                }
            }
        }
        return sum;



    }

    public static void main(String... args) {
        int[] nums = {-1,2,1,4};
        int target = 1;

        int result = A16_One.threeSumClosest(nums,target);

        System.out.println("result : " + result);
    }


}
