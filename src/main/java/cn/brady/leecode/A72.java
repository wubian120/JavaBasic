package cn.brady.leecode;

/**
 * @description: 72 编辑距离  dp
 * https://leetcode-cn.com/problems/edit-distance/submissions/
 *
 *  todo: 72 编辑距离   dp
 *
 *  todo: 1.跟一遍
 *  todo: 2.理解
 *  todo: 3.背着写一遍
 *  todo: 4.可以默写完成
 *
 * @auther: bian.wu
 * @date: 2019/3/21 00:52
 */
public class A72 {


//
//    passed  16ms      beat 58%
//    https://blog.csdn.net/sinat_33150417/article/details/85294956
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //dp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

}
