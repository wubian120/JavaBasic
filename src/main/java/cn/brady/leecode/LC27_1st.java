package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: leecode 27 移除元素
 *
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @auther: bian.wu
 * @date: 2018/12/22 18:24
 */
public class LC27_1st {


    public static int removeElement(int[] nums, int val) {

        int len = nums.length;
        List<Integer> vals = new LinkedList<>();
        for(int i : nums){
            if(i ==val){
                len--;
            }else {
                vals.add(i);
            }
        }
        for(int i=0;i<vals.size();i++){
            nums[i] = vals.get(i);
        }
        return len;
    }

    public static void main(String...args){

        int[] a1 = {3,2,2,3};

        LC27_1st.removeElement(a1,3);


    }

}
