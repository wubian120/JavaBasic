package cn.brady.leecode;

/**
 * @description:  14 最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 *
 * @auther: bian.wu
 * @date: 2019/3/22 15:55
 *
 * todo: leetcode 14 最长公共前缀
 *
 * todo: 1.跟一遍    done  19-03-22
 * todo: 2.理解      done  19-03-22
 * todo: 3.背着写一遍  done 19-03-22
 * todo: 4.可以默写完成
 *
 *
 */
public class A14最长公共前缀 {

    /**
     *
     * @record: 9ms
     * @beats:   75%
     * @reference: https://blog.csdn.net/fengpojian/article/details/81326781
     *
     *
     */
    public static String longestCommonPrefix(String[] strs) {

        int count = strs.length;
        String prefix = "";
        if(count != 0){
            //第一个字符串
            prefix = strs[0];
        }
        for(int i=0; i<count; i++){
            //关键代码，如果子串匹配， 则换 下一个要比较字符串， 如果子串 不匹配， 则从后往前缩小 子串，
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }


    public static void main(String...args){
        String[] s = {"dog","racecar","car"};
        String[] s1 = {"flower","flow","flight"};

//        String result = A14.longestCommonPrefix(s1);
        String result = A14最长公共前缀.longestCommonPrefix_self_one(s1);
        String stest = "flower";

        System.out.println(result);

        System.out.println(s1[1].startsWith(stest));

    }


    /**
     *
     *
     *
     */
    public static String longestCommonPrefix_self_one(String[] strs) {

        int len = strs.length;
        String commonPrefix = "";
        if(len>0){
            commonPrefix=strs[0];
        }

        for(int i=0;i<len;i++){
            while (!strs[i].startsWith(commonPrefix)){
                commonPrefix = commonPrefix.substring(0,commonPrefix.length()-1);
            }
        }
        return commonPrefix;

    }


    public static String longestCommonPrefix_self_two(String[] strs) {


        return "";
    }


}
