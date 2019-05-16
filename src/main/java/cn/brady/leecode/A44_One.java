package cn.brady.leecode;

/**
 * @description: 44 通配符 匹配  self；

 * todo: 44 通配符匹配，
 * todo: 1.跟一遍
 * todo: 2.理解
 * todo: 3. 背着写一遍
 * todo: 4.可以默写完成

 *
 * @auther: bian.wu
 * @date: 2019/3/18 15:25
 */
public class A44_One {

    /**
     * @status pass
     * @beats   80%
     * @cost   82ms
     *
     */
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        //辅助数组dp，dp[i][j]表示s(0~i-1)与p(0~j-1)子串是否完全匹配
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;//s为空字符串 && p为空字符串
        for(int i = 1; i <= len1; i++)
            dp[i][0] = false;//s不为空，p为空字符串
        for(int j = 1; j <= len2; j++)
            dp[0][j] = (p.charAt(j-1) == '*' && dp[0][j-1]);//s为空字符串，p不为空

        //需s和p完全匹配，外层循环对p进行遍历
        for(int j = 1; j <= len2; j++)
            for(int i = 1; i <= len1; i++){
                if(p.charAt(j-1) != '*')
                    //若p[j-1]不为*，需判断s(0~i-2)与p(0~j-2)是否匹配（即dp[i-1][j-1]），并且s[i-1]与p[j-1]匹配
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || '?' == p.charAt(j-1));
                else

                    //若p[j-1]为*,需判断s(0~i-2)与p(0~j-1)是否匹配（当前*匹配s[i-1]及之前部分字符）
                    //或者判断s(0~i-1)与p(0~j-2)是否匹配(当前*匹配空字符串)
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];

            }

        return dp[len1][len2];

    }

    public static void main(String...args){



    }

}
