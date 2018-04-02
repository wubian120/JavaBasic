package cn.brady.leecode;


/**
 * 2017-11-02
 * https://leetcode.com/problems/two-sum/description/
 * status : done  2017-11-2
 *
 */

public class TwoSum {




    public static int[] twoSum(int[] nums, int target){

        int indices[] = new int[2];
        for(int i=0; i< nums.length;i++){


            for(int j =i+1; j<nums.length;j++){

                if((nums[i] + nums[j]) == target){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }else {
                    continue;
                }
            }



        }



        return indices;

    }


    public static void main(String[] args){

        int[] case1= {3,2,3}; int target1 = 6;
        int[] case2 = {3,3}; int target2 = 6;
        int[] case3 = {2,5,5,11}; int target3 = 10;

        int[] arr = {2,5,5,11};
        int target = 10;

        int index[] = TwoSum.twoSum(arr,target);


        for(int i : index){

            System.out.println(i);
        }

    }
}
