package cn.brady.leecode;

/**
 * @description:
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * @auther: bian.wu
 * @date: 2019/4/29 10:59
 */
public class A44通配符匹配 {

    /***
     * @beat   80
     * @param s
     * @param p
     * @return
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


    /***
     *
     * @beat  95%
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_two(String s, String p) {
        // 指定双指针，sIndex指向s字符串，pIndex指向p字符串
        int sIndex = 0;
        int pIndex = 0;
        int match = 0;
        int startIndex = -1;
        // 从s字符串作为基准进行比对
        while (sIndex < s.length()){
            // 当pIndex位置的字符和sIndex位置的相同或者pIndex位置的为?时，驱动双指针向前移动一位
            if (pIndex < p.length()  && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            }
            // 当发现'*'时，对p指针直接移动到下一位，将'*'的index传给startIndex处理，同时将s指针传给match指针
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                startIndex = pIndex;
                match = sIndex;
                pIndex++;
            }
            // 当'*'匹配字符时，pIndex始终保持startIndex+1，即'*'的下一位，然后移动match指针和sIndex指针
            // 当出现s和p指针重新匹配时，会被第一个if语句拦截，移动双指针
            // 当移动到一个新的'*'时，在第二个else if重新更新sIndex
            // 可能会出现匹配短了的情况，比如匹配"adcbeb"和"*a*b"，程序会在第一个b就直接跳出，但此时程序检查到后续不匹配的情况
            // 此时重新把startIndex+1赋给pIndex，相当于把第一个b包含进*中进行匹配，然后再出现下一个b时再匹配
            else if (startIndex != -1) {
                pIndex = startIndex + 1;
                match++;
                sIndex = match;
            }

            else
                return false;
        }

        // 检查p剩余的子串
        while (pIndex < p.length() && p.charAt(pIndex) == '*')
            pIndex++;

        return pIndex == p.length();
    }




}
