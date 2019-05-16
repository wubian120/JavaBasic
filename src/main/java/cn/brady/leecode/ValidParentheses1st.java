package cn.brady.leecode;

import java.util.*;

/**
 * @description: leecode 20 有效的括号
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @auther: bian.wu
 * @date: 2018/12/2 20:38
 */
public class ValidParentheses1st {

    public static boolean isValid(String s) {

        Map<Character,Character> charMap= new HashMap<>();
        charMap.put(')','(');
        charMap.put(']','[');
        charMap.put('}','{');

        Map<Character,Integer> frontCharMap = new HashMap<>();
        Map<Character,Integer> backCharMap = new HashMap<>();
        frontCharMap.put('(',1);
        frontCharMap.put('[',2);
        frontCharMap.put('{',3);
        backCharMap.put(')',-1);
        backCharMap.put(']',-2);
        backCharMap.put('}',-3);

        List<Character> characterList = new LinkedList<>();

        int len = s.length();
        char[] chars = s.toCharArray();
        if (len % 2 != 0) {
            return false;
        }

        int label = 0;
        int curIndex = 0;
        char last;
        for(;curIndex < len;curIndex++){

            char cc = chars[curIndex];

            if(frontCharMap.containsKey(cc)) {
                characterList.add(cc);
                label += frontCharMap.get(cc);
            }
            if(backCharMap.containsKey(cc)){
                label += backCharMap.get(cc);
                if(characterList.size() > 0){
                    last = ((LinkedList<Character>) characterList).getLast();
                }else {
                    return false;
                }
                if(charMap.containsKey(cc)){
                    char c1 = charMap.get(cc);
                    if(c1 == last){
                        ((LinkedList<Character>) characterList).removeLast();
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }

        if(label == 0 ){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String... args) {
        Set<Character> charSet = new HashSet<>();
        charSet.add('(');

        String s = "(())";


        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                System.out.println("true");
            }
        }

        String s1 = "{{{(()()))[[[[]]]]}}}";
        String s2 = "(]";
        String s3 = "([)]";
        String s4 = "()[]{}";
        String s5 = "(([])){}[]";
        String s6 = "){";
        String s7 ="()";

        boolean isValid = ValidParentheses1st.isValid(s7);

        System.out.println("end");

    }
}
