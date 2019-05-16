package cn.brady.leecode;

/**
 * @description:
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *  如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *  注意你不能在买入股票前卖出股票。
 *
 *  示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * todo: 121 买卖股票最佳时机
 * todo: 1.跟一遍         19-03-21 done
 * todo: 2.理解           19-03-21 done
 * todo: 3. 背着写一遍     19-03-21 done
 * todo: 4.可以默写完成
 *
 * @思路 最小价格， 最大profit， 循环， 如果 小于最小价格， 换；  如果 当前价格- 最小价格 > maxprofit  换。

 * @参考
 * 1.https://blog.csdn.net/weixin_41876155/article/details/80036893 (包含 n2 和 On 两种)
 * https://blog.csdn.net/qq_41231926/article/details/84402352
 * @auther: bian.wu
 * @date: 2019/3/21 10:16
 */
public class A121买卖股票最佳时机 {

    /**
     * pass  2ms  beats 88%
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxPro) {
                maxPro = prices[i] - minPrice;
            }
        }
        return maxPro;
    }


    /**
     * @ref  https://blog.csdn.net/qq_41231926/article/details/84402352
     * @beat 36%
     * @param prices
     * @return
     */
    public static int maxProfit_two(int[] prices) {
        int result = 0;
        if(prices.length == 0){
            return result;
        }
        int[] dp = new int[prices.length];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i < dp.length; i++){
            if(prices[i - 1] < dp[i - 1]){
                dp[i] = prices[i - 1];
            }else{
                dp[i] = dp[i - 1];
            }
//            dp[i] = Math.min(prices[i-1],dp[i-1]);
        }
        for(int i = 1; i < dp.length; i++){
            if(prices[i] - dp[i] > result){
                result = prices[i] - dp[i];
            }
        }
        return result;
    }

    public static void main(String...args){

        int[] prices = {7,1,5,3,6,4};
//        int result = A121买卖股票最佳时机.maxProfit_self_one(prices);
//        int result = A121买卖股票最佳时机.maxProfit_two(prices);
        int result = A121买卖股票最佳时机.maxProfit_self_two(prices);
        System.out.println(result);
    }


    /**
     * self done  2019-03-21
     * @param prices
     * @return
     */
    public static int maxProfit_self_one(int[] prices){

        int len=prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=0;i<len;i++){
            int profit = prices[i]-minPrice;
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            if(profit>maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static int maxProfit_self_two(int[] prices){
        int len = prices.length;
        if(len==0){
            return 0;
        }
        int result = 0;
        // dp 代表 在 每个价格下 的最小价格。
        int[] dp = new int[len];
        dp[0] = prices[0];

        //遍历价格数组，取每个价格下的最小价格。
        for(int i=1;i<len;i++){
            dp[i] = Math.min(prices[i],dp[i-1]);
        }

        //遍历数组 求收益
        for(int i=1;i<len;i++){
            int currentProfix = prices[i] - dp[i];
            if(result<currentProfix){
                result = currentProfix;
            }
        }
        return result;
    }


}
