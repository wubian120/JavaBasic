package cn.brady.leecode;


import java.util.*;

import static java.lang.Math.abs;

/**
 *   Longest Substring Without Repeating Characters
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * status ： done
 *
 *  重复出现的 字符 之间的 位置
 *  多个字符重复出现
 *
 *
 */
public class LongestSubstring {


    public static int longestSubstring(String s){

        int i,j,len;
        Set<Character> charset = new HashSet<>();
        i = 0;
        len = 0;
        j = 0;
        int q = 0;
        char[] chs = s.toCharArray();
        while (i<s.length()){

            if(charset.contains(chs[i])){

                if(j > len){
                    len = j;
                }
                j=1;

            }else{
                j++;
                if(j>len){
                    len = j;
                }
                charset.add(chs[i]);
            }
            i++;
        }



        return len;


    }


    /**
     *  pass the test
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){

        int length = 0;
        int j = 0;
        if(s == null || s.length() == 0){
            return length;
        }
        if(s.length() == 1){
            length = 1;
            return length;
        }
        char[] chs = s.toCharArray();

        Map<Character,Integer> characterMap = new HashMap();
        for(int i=0;i<chs.length;i++){

            if(characterMap.containsKey(chs[i])){

                int order = characterMap.get(chs[i]);
                int t = i - order;
                if(t > 1){
                    // 两种情况
                    if(t < j){
                        j = t;
                    }
                    if(t > j){
                        j++;
                    }
                }else if(t == 1){
                    j = 1;

                }
                characterMap.remove(chs[i]);
                characterMap.put(chs[i],i);

                if(j > length){
                    length = j;
                }
            }else {

                j++;
                characterMap.put(chs[i],i);
                if(j > length){
                    length = j;
                }

            }

        }


        return length;

    }


    public static void sort(){

        List<Integer> list = new ArrayList<>();

        list.add(19);
        list.add(123);
        list.add(1);
        list.add(4534);

        Collections.sort(list);

        System.out.println(list);

    }



    public static void main(String[] args){

        String sw1 = "abdvcdfac";

        String  s= "abcabcbb"; //expected 3
        String s1 = "bbbbbb";  // 1
        String s2 = "pwwkew";  // 3
        String s3 = "au";      // 2
        String s4 = "aab";     // 2
        String s5 = "abb";     // 2
        String s6 = "abba";    // 2
        String s7 = "dvdf";    // 3
        String s8 = "tmmzuxt"; // 5

        int i = lengthOfLongestSubstring(s8);

//        int i = longestSubstring(s7);

        System.out.println(i);


    }



}
