package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 77 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * Cn k；
 * https://leetcode-cn.com/problems/combinations/
 * @auther: bian.wu
 * @date: 2018/12/15 14:15
 */
public class LC771st {
    public static List<List<Integer>> combine(int n, int k) {

        List<Integer> results = null;

        List<List<Integer>> resultsList = new LinkedList<>();

        for(int i=1;i<=n;i++){

            results = new LinkedList<>();
            int j = i+1;
            int size = results.size();
            while (size<k && j<n){
                results.add(j++);
                size = results.size();
            }
//            for(int j=i+1;j<=n;j++){
//                results.add(j);
//            }
            resultsList.add(results);
        }


        return resultsList;
    }

    public static void main(String...args){

        int n = 4;
        int k = 2;

        LC771st.combine(n,k);


        System.out.println("end");

    }
}
