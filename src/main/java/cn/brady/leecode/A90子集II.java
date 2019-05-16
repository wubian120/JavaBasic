package cn.brady.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @思路：
 *      题意及分析：和subsets类似，都是使用回溯的方法求解，不过需要跳过重复的，在剩余的数组中如果当前数字等于前面数字跳过即可。
 *
 * @beat  100%
 * @auther: bian.wu
 * @date: 2019/4/3 21:15
 */
public class A90子集II {


    List<List<Integer>> list;//结果集
    List<Integer> al;//每一项
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<List<Integer>>();
        al = new ArrayList<Integer>();
        Arrays.sort(nums);
        //排列组合
        count(nums,al,0);
        return list;
    }

    private void count(int[] nums, List<Integer> al, int j){

        list.add(new ArrayList<Integer>(al));//不重复的才添加

        for(int i = j; i < nums.length;i++){
            if(i == j || nums[i] != nums[i-1]){//去除重复
                al.add(nums[i]);//添加
                count(nums,al,i+1);
                al.remove(al.size()-1);//去除，为下一个结果做准备
            }
        }
    }









}
