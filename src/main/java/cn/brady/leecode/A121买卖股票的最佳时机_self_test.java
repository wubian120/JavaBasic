package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/6 10:19
 */
public class A121买卖股票的最佳时机_self_test {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice > profit){
                profit = prices[i] - minPrice;
            }

        }
        return profit;
    }
}
