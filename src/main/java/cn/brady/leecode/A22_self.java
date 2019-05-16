package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/14 10:43
 */
public class A22_self {


    public static List<String> generateParenthesis(int n) {

        List<String> results = new LinkedList<>();
        int left, right;
        left = right = n;
        generate(results,"",left,right);
        return results;
    }

    private static void generate(List<String> results, String temp, int left, int right) {
        if(right == 0 && left==0){
            results.add(temp);
            return;
        }
        if(left>0){
            generate(results,temp+"(",left-1,right);
        }
        if(right>left){
            generate(results, temp+")", left, right-1);
        }
    }

}
