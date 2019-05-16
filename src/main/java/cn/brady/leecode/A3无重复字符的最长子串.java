package cn.brady.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 3 无重复字符的最长子串
 * @参考:  https://www.cnblogs.com/chenyingjie1207/p/10048346.html (good)
 * @auther: bian.wu
 * @date: 2019/3/22 14:59
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * todo: leetcode 3 无重复字符的最长子串
 *
 * todo: 1.跟一遍    done  19-03-22
 * todo: 2.理解
 * todo: 3.背着写一遍
 * todo: 4.可以默写完成
 *
 */
public class A3无重复字符的最长子串 {

    /**
     * @title: 滑动窗口
     * @Status: pass  61ms beats 63%
     *
     */
    public static int lengthOfLongestSubstring_one(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     *
     * @beats  70%
     * @status  pass
     * @思路  滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            int t = s.charAt(j);

            i = Math.max(index[t], i);
            ans = Math.max(ans, j - i + 1);

            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    public static void main(String...args){

        String s ="abcadbcbd";
//        String s = "bbbbb";
//        String s = "pwwkew";
        int result = A3无重复字符的最长子串.lengthOfLongestSubstring(s);

        int i1 = 'a';
        int ib = 'b';
        int iz = 'z';

        System.out.println(result);

    }

    /**
     * @思路 滑动窗口
     * @beat  91%
     * @ref https://www.cnblogs.com/chenyingjie1207/p/10048346.html
     * @return
     */
    public static int lengthOfLongestSubstring_two(String s) {



        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
//        return 0;
    }




}
