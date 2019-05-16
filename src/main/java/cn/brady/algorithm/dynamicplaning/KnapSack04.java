package cn.brady.algorithm.dynamicplaning;

/**
 * @description: 0-1背包 动态规划解法， 空间优化 一维数组
 * <p>
 * https://blog.csdn.net/chanmufeng/article/details/82955730
 * @auther: bian.wu
 * @date: 2019/2/21 10:35
 */
public class KnapSack04 {

    public static int knapSack(int[] w, int[] v, int c) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }
        int[] dp = new int[c + 1];

        for (int i = 0; i <= c; i++) {
            dp[i] = w[0] <= i ? v[0] : 0;
        }

        for (int i = 1; i < size; i++) {
            for (int j = c; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }

        return dp[c];
    }

    public static void main(String... args) {
        while (true){
            int[] w = {2, 1, 3, 2};
            int[] v = {12, 10, 20, 15};
            int result = knapSack(w, v, 5);
            System.out.println("end");
        }


    }

}
