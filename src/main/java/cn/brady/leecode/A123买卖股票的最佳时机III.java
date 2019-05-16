package cn.brady.leecode;

/**
 * @description: leetcode 买卖股票的最佳时机III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * @auther: bian.wu
 * @date: 2019/4/1 15:50
 */
public class A123买卖股票的最佳时机III {


    /**
     * @param prices
     * @return
     * @beat 31%
     * @ref https://blog.csdn.net/qq_41231926/article/details/84451773
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        int len = prices.length;
        if (0 == len) {
            return result;
        }
        int[][] dp = new int[3][len];
        for (int k = 1; k <= 2; k++) {
            dp[k][0] = 0;
            int min = prices[0];

            for (int i = 1; i < len; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
            }
        }
        return dp[2][len - 1];
    }

    /**
     * @beat 58%
     */
    public static int maxProfit_two(int[] prices) {
        /**
         * 对于任意一天，都有四种变量
         * 第一次买 收益最大， 第一次卖 收益最大
         * 第二次买 收益最大， 第二次卖 收益最大
         * 于是分别对四个变量进行更新。 第二次卖的收益 就是 结果。
         */
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);

            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }


    public static void main(String... args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

//        int result = A123买卖股票的最佳时机III.maxProfit_two(prices);
        int result = A123买卖股票的最佳时机III.maxProfit_self_one(prices);

        System.out.println(result);

    }

    public static int maxProfit_self_one(int[] prices) {

        // buy 必须为最大， 以便于每天价格比较，从而选取较小的那个
        int fstBuy, sndBuy;
        fstBuy = sndBuy = Integer.MAX_VALUE;
        int fstSell = 0, sndSell = 0;

        for (int price : prices) {
            //第一次买， 根据价格，哪个小，就设哪个为第一次买入
            fstBuy = Math.min(price, fstBuy);
            // 第一次卖出， 比较当前价格与第一次买进价格之差， 选较大的
            fstSell = Math.max(fstSell, price - fstBuy);

            //第二次买进，价格与第一次卖出 之差， 较小的那个
            sndBuy = Math.min(price - fstSell, sndBuy);
            sndSell = Math.max(price - sndBuy, sndSell);
        }
        return sndSell;

    }


    public static int maxProfit_self_snd(int[] prices) {

        int fstBuy = Integer.MAX_VALUE, sndBduy = Integer.MAX_VALUE;
        int fstSell = 0, sndSell = 0;

        for(int price: prices){
            fstBuy = Math.min(price, fstBuy);
            fstSell = Math.max(fstSell, price-fstBuy);
            sndBduy = Math.min(sndBduy, price-fstSell);
            sndSell = Math.max(sndSell, price-sndBduy);
        }

        return sndSell;

    }


}
