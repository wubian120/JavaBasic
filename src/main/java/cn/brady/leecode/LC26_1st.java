package cn.brady.leecode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @description: 26.删除排序数组中的重复项  done 2018.12.15
 *
 * @auther: bian.wu
 * @date: 2018/12/15 09:11
 */
public class LC26_1st {

    public static int removeDuplicates(int[] nums) {

        Set<Integer> solidSet = new HashSet<>();
        List<Integer> finalList = new LinkedList<>();

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if(!solidSet.contains(nums[i])){
                solidSet.add(nums[i]);
                finalList.add(nums[i]);
            }
        }
        int index = 0;
        for(Integer i : finalList){
            nums[index++] = i;
        }

        return finalList.size();
    }


    public static void main(String... args) {

        int[] num1 = new int[]{1, 1, 2};

        int[] num2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] num3 = new int[]{};

        LC26_1st.removeDuplicates(num1);


        System.out.println("end");


    }
}
