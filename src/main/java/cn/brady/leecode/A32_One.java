package cn.brady.leecode;

/**
 * @description:  leetcode  32  最长有效括号
 *
 * 题目： https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 参考： https://blog.csdn.net/weixin_38823568/article/details/80997966
 *
 *  需用到辅助数组d[s.length()]，
 *  表示从当前字符开始，到字符串结尾的最长有效括号子串长度
 *  （当前字符需为有效括号子串的第一个字符）
 *
 *   解题思路：从字符串结尾往前处理，求辅助数组d[]
 *
 *  当前字符下标为index，若当前字符为左括号'('，判断index+1+d[index+1]位置的字符是否为右括号')'，
 *  若为右括号，则d[index] = d[index+1]+2，
 *  并且判断index+1+d[index+1]+1位置的元素是否存在，
 *  若存在，则d[index] += d[index+1+d[index+1]+1]（解决上述两个有效括号子串直接相邻的情况）
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
