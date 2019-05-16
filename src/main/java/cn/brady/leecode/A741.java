package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description:  741 摘樱桃  DP
 * @参考:  https://blog.csdn.net/LaputaFallen/article/details/79998775 (good) （pass）
 * @auther: bian.wu
 *
 * todo: 741 摘樱桃 DP
 * todo: 1.跟一遍
 * todo: 2.理解
 * todo: 3. 背着写一遍
 * todo: 4.可以默写完成
 *
 * @date: 2019/3/22 12:15
 */
public class A741 {

    /**
     * @solution: 解法1(dfs + memorization)
     * @参考:  https://blog.csdn.net/LaputaFallen/article/details/79998775 (good) （pass）
     */
    public int cherryPickup(int[][] grid) {
        int N = grid.length;

        int[][][] dp = new int[N][N][N];

        for(int[][] layer : dp){
            for(int[] line : layer){
                Arrays.fill(line, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, dfs(grid, dp, 0, 0, 0, N));
    }
    public int dfs(int[][]grid, int[][][] dp, int r1, int c1, int c2, int N){
        int r2 = r1 + c1 - c2;

        if(r1 == N || r2 == N || c1 == N || c2 == N || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }else if(r1 == N - 1 && c1 == N - 1){
            return grid[r1][c1];
        }else if(dp[r1][c1][c2] != Integer.MIN_VALUE){
            return dp[r1][c1][c2];
        }else{
            int ans = grid[r1][c1];
            if(c1 != c2)    ans += grid[r2][c2];
            ans += Math.max(Math.max(dfs(grid, dp, r1, c1 + 1, c2 + 1, N), dfs(grid, dp, r1 + 1, c1, c2, N)), Math.max(dfs(grid, dp, r1, c1 + 1, c2, N), dfs(grid, dp, r1 + 1, c1, c2 + 1, N)));
            dp[r1][c1][c2] = ans;
            return ans;
        }
    }








}
