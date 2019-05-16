package cn.brady.leecode;

/**
 * @description:  leetcode  32  最长有效括号
 *
 * 题目： https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 参考： https://blog.csdn.net/weixin_38823568/article/details/80997966
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/4 20:20
 */
public class A32_One {


    public static int longestValidParentheses(String s) {
        if(null == s) return 0;

        int len = s.length(), max = 0;
        int[] d = new int[len];

        for(int index = len-2; index >= 0; index--){
            int symIndex = index+1+d[index+1];
            if('(' == s.charAt(index) && symIndex < len && ')' == s.charAt(symIndex)){
                d[index] = d[index+1]+2;
                if(symIndex+1 < len){
                    d[index] += d[symIndex+1];
                }
            }

            max = Math.max(max, d[index]);
        }
        return max;

    }

    public static void main(String...args){

        String s = "(()";

        int maxLen = A32_One.longestValidParentheses(s);

        System.out.println("End");
    }

}
