package cn.brady.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 13.罗马转数字
 * 个人实现
 * https://leetcode-cn.com/problems/roman-to-integer/submissions/
 * @auther: bian.wu
 * @date: 2018/12/7 16:00
 */
public class RomanToInteger2nd {

    class Node{
        int value;
        Node left;
        Node right;
    }

    public int romanToInt2(String s){
        Node n1 = new Node();




        return 0;
    }

    public static int romanToInt(String s) {

        if(s == null || s.length() < 1){
            return -1;
        }

        Map<Character, Integer> roman2NumMap = new HashMap<>();
        roman2NumMap.put('I', 1);
        roman2NumMap.put('V', 5);
        roman2NumMap.put('X', 10);
        roman2NumMap.put('L', 50);
        roman2NumMap.put('C', 100);
        roman2NumMap.put('D', 500);
        roman2NumMap.put('M', 1000);

        int value =0;
        char[] chars = s.toCharArray();
        int len = s.length();
        int i = len - 1;
        int lastNum = roman2NumMap.get(chars[i]);
        while (i >= 0) {
            int current = roman2NumMap.get(chars[i]);
            if(current >= lastNum){
                value += current;
                lastNum = current;
            }else {
                value -= current;
                lastNum = current;
            }
            i--;
        }

        return value;
    }


    public static void main(String... args) {

        String s = "CXXXII";

        int result = RomanToInteger2nd.romanToInt(s);

        System.out.println("end");

    }


}
