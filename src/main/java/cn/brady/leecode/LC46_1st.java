package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: leecode 46 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @auther: bian.wu
 * @date: 2018/12/18 17:35
 */
public class LC46_1st {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new LinkedList<>();
        backTack(resultList,new LinkedList<>(),nums);

        return resultList;
    }

    public static void backTack(List<List<Integer>> resultList, List<Integer> result, int[] data) {
        if (result.size() == data.length) {
            resultList.add(new LinkedList<>(result));
        } else {
            int len = data.length;
            for (int i = 0; i < len; i++) {
                if (result.contains(data[i])) {
                    continue;
                }
                result.add(data[i]);
                backTack(resultList, result, data);
                result.remove(result.size() - 1);
            }
        }
    }


    public static void main(String...args){

        int[] t1 = {1,2,3};
        List<List<Integer>> resultList = LC46_1st.permute(t1);

        System.out.println("end");

    }


}
