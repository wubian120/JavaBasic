package cn.brady.leecode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description:  无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @auther: bian.wu
 * @date: 2018/11/29 09:45
 */
public class LengthOfLongestSubstring1st {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() > 0) {
            String sub = "";
            Set<String> subStringSet = new HashSet<>();

            int markLabel = 0;
            int i = 0;
            int len = s.length();
            for(;i<len;){
                char cur = s.toCharArray()[i];
                if(sub.indexOf(cur) == -1){
                    sub += cur;
                    i++;
                }else {
                    subStringSet.add(sub);
                    sub = "";
                    markLabel++;
                    i = markLabel;
                }
            }
            subStringSet.add(sub);
            int maxLen = Collections.max(subStringSet.stream().map(s1->s1.length()).collect(Collectors.toList()));
            return maxLen;
        } else {
            return 0;
        }

    }

    public static void main(String... args) {


        String testSample1 = "abcabcbb";
        String testSample2 = "pwwkew";
        String testSample3 = "aab";
        String testSample4 = "dvdf";



//        System.out.println(s.contains("a"));


        lengthOfLongestSubstring(testSample4);


        String s = "a";

        Set<String> strSet = new HashSet<>();
        strSet.add(s);
        s += "c";

        System.out.println(s);

        System.out.println("end");

    }


}
