package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description: 322 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * @auther: bian.wu
 * @date: 2019/5/9 16:31
 */
public class A322零钱兑换 {


    /***
     * 动态规划做法
     * @beat   50%
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i ++) {
            for(int j = 0; j <= amount; j ++) {
                int pre = j - coins[i];
                if(pre >= 0 && dp[pre] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[pre] + 1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }


    /***
     * @beat  95%
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_two(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] count = new int[1];
        count[0] = Integer.MAX_VALUE;
        int index = coins.length - 1;
        dfs(coins, amount, 0,count,index);
        if(count[0] != Integer.MAX_VALUE)
            return count[0];
        return -1;
    }
    private static void dfs(int[] coins, int amount, int nowCount, int[] count, int index) {
        if(nowCount >= count[0])
            return;
        if(amount == 0) {
            count[0] = Math.min(count[0], nowCount);
            return;
        }
        for (int i = index; i >= 0; i--) {
            if(coins[i] > amount || amount/coins[index] + nowCount >= count[0])
                continue;
            dfs(coins, amount-coins[i], nowCount+1, count, i);
        }
    }

}
