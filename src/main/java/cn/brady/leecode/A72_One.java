package cn.brady.leecode;

/**
 * @description: 72 编辑距离
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/19 12:13
 */
public class A72_One {


    /**
     * passed   814ms
     *
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();

        int[][] dp= new int[1005][1005];
        int len2 = word2.length();
        for(int i=0;i<=len1;i++)dp[i][0] = i;
        for(int j=0;j<=len2;j++)dp[0][j] = j;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)== word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[len1][len2];

    }


    public static void main(String...args){

        String word1 = "horse";
        String word2 = "ros";
        int len = A72_One.minDistance(word1,word2);

        System.out.println(len);

    }


}
