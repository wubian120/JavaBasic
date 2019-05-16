package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description: leecode  70  done.   和 LC70_1st 相比 提高很多
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * @auther: bian.wu
 * @date: 2019/2/9 09:57
 */
public class LC70_2nd {


    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return getStairs(n);
    }

    private int getStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] == -1) {
            memo[n] = getStairs(n - 1) + getStairs(n - 2);
        }
        return memo[n];
    }

    public static void main(String... args) {

        int n = 5;

        LC70_2nd lc70_2nd = new LC70_2nd();

        int result = lc70_2nd.climbStairs(n);


    }


}
