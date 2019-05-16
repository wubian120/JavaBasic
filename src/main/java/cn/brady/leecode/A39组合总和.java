package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * @beat    99%
 * @auther: bian.wu
 * @date: 2019/4/21 11:45
 */
public class A39组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        solution(candidates,0,target,res,list,candidates.length);
        return res;
    }

    public void solution(int[] candidates,int index,int target,List<List<Integer>> res,List<Integer> list,int len){
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }

        if(index >= len) return;
        solution(candidates,index + 1,target,res,list,len);
        if(candidates[index] <= target){
            list.add(candidates[index]);
            solution(candidates, index, target-candidates[index],res, list, len);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String...args){

        int[] nums = {2,3,5};
        int target = 8;

        A39组合总和 a = new A39组合总和();
        List<List<Integer>> results = a.combinationSum(nums,target);

        System.out.println("end");
    }




}
