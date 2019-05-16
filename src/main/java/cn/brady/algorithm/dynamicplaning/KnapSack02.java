package cn.brady.algorithm.dynamicplaning;

/**
 * @description:  动态规划 解 0-1背包问题
 *
 * https://blog.csdn.net/chanmufeng/article/details/82955730
 *
 * @auther: bian.wu
 * @date: 2019/2/17 21:35
 */
public class KnapSack02 {

    public static int knapSack(int[] w, int[] v, int c){
        int size = w.length;
        if(size==0){
            return 0;
        }

        int[][] dp = new int[size][c+1];

        for(int i=0;i<=c;i++){
            dp[0][i] = w[0] <= i ? v[0]:0;
        }

        for(int i=1;i<size;i++){
            for(int j=0;j<=c;j++){
                dp[i][j] = dp[i-1][j];
                if(w[i] <=j ){
                    dp[i][j] = Math.max(dp[i][j], v[i]+ dp[i-1][j-w[i]]);
                }
            }
        }
        return dp[size-1][c];

    }

    public static void main(String...args){

        int[] w = {2,1,3,3};
        int[] v = {12,10,20,15};

        int result = KnapSack02.knapSack(w,v,5);
        System.out.println("end");

    }

}
