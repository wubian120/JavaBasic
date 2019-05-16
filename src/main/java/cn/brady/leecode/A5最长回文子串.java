package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/2/17 11:17
 */
public class A5最长回文子串 {

    /**
     * @status wrong  can't pass
     * @beat
     *
     * DP
     */
    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }
                return s.substring(0,1);
        }
        int maxLen = 1;
        int length = s.length();
        String longestStr = s.substring(0,1);
        int[][] dp = new int[length][length];
        //初始化 自己和自己 是回文
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        //初始化 两个相等字符是 回文
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }

        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] == 1 && l > maxLen) {
                        longestStr = s.substring(i, j + 1);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return longestStr;
    }

    public static void main(String... args) {

        String s = "babad";
        String s1 = "abcda";
//        String s = "ac";
        String longest = "";
        longest = A5最长回文子串.longestPalindrome(s1);

        System.out.println(longest);
        System.out.println("end");


    }

}
