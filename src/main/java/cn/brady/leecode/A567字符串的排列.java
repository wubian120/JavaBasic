package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description: 567 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * todo: 567  字符串的排列， 双指针 滑动窗口
 * todo: 1.跟一遍
 *
 * todo: 2.理解
 *
 * todo: 3. 背着写一遍
 *
 * todo: 4.可以默写完成
 * @auther: bian.wu
 * @date: 2019/3/22 16:25
 */
public class A567字符串的排列 {

    /**
     *
     * @status  pass
     * @beats   58%
     * @ref     http://www.cnblogs.com/MrSaver/p/9638279.html
     *
     */
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(char c : s1.toCharArray())
            c1[c-'a']++;

        for(int i=0;i<l2;i++)
        {
            if(i>=l1)
                --c2[s2.charAt(i-l1)-'a'];//先把坐标查过的
            c2[s2.charAt(i)-'a']++;
            if(Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }

    /***
     * @beat  100
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion_one(String s1, String s2) {
        if (null == s1 || null == s2) {
            return false;
        }
        int lengthFirst = s1.length();
        int lengthSecond = s2.length();
        if (lengthFirst > lengthSecond) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < lengthFirst; i++) {
            map1[chars1[i] - 'a']++;
            map2[chars2[i] - 'a']++;
        }
        if (Arrays.equals(map1,map2)) {
            return true;
        }
        for (int i = 0; i + lengthFirst < lengthSecond; i++) {
            /**
             * i+1,代表向右移动一位，移动一位之后，如果有相同的，减去，则是当前i到lengthFirst区间的实际数值
             */
            map2[chars2[i] - 'a']--;
            /**
             * i + lengthFirst代表这个区间的最后一个值，假设向右移动，最后这个值是新的，所以是要加1的
             */
            map2[chars2[i + lengthFirst] - 'a']++;

            /**
             * 如果两个数组值是一样的，代表题目条件是满足的
             */
            if (Arrays.equals(map1,map2)) {
                return true;
            }
        }
        return false;

    }


    public static void main(String...args){
        String s1 = "ab";
        String s2 = "eidbaooo";

//        String s1 = "abaaa";
//        String s2 = "eidboaoo";



//        boolean result = A567字符串的排列.checkInclusion(s1,s2);
        boolean result = A567字符串的排列.checkInclusion_one(s1,s2);

        System.out.println(result);
    }


    public boolean checkInclusion_self_one(String s1, String s2) {

        return false;
    }

}
