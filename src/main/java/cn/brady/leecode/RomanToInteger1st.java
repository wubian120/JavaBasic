package cn.brady.leecode;

import java.util.HashMap;

/**
 * @description: 13罗马转数字
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * pass  but not my code
 *
 * @auther: bian.wu
 * @date: 2018/12/7 15:51
 */
public class RomanToInteger1st {

    public static int romanToInt(String s) {

        if (s == null || s.length() < 1) {
            return -1;
        }

        char[] ch = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int res = 0;
        // 临时变量，保存的是当前遍历的上一个数值的值
        int temp = 0;
        // 当前罗马值的大小
        int value = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            value = hm.get(ch[i]);
            // 左加
            if (temp <= value) {
                res += value;
                temp = value;
                // 右减
            } else {
                res -= value;
                temp = value;
            }
        }
        return res;

    }


    public static void main(String... args) {

        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";

        int result = RomanToInteger1st.romanToInt(s2);


        System.out.println("end");

    }
}
