package cn.brady.leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: leecode 14. 最长公共前缀
 * <p>
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @auther: bian.wu
 * @date: 2018/12/2 21:08
 */
public class LongestCommonPrefix1st {

    public static String longestCommonPrefix(String[] strs) {

        Map<Integer, Character> commonCharMap = new HashMap<>();
        List<Character> commonList = new LinkedList<>();
        int currentIndex = 0;
        char currentChar;
        char curCommonChar;


        List<String> wordList = Arrays.asList(strs);


        int longest = wordList.stream().mapToInt(s->s.length()).max().getAsInt();

        for(int i=0;i<longest;i++){

        }


        for (String s : strs) {
            char[] chars = s.toCharArray();
            currentChar =  chars[currentIndex];

            if(commonCharMap.containsKey(currentIndex)){
                char c1 = commonCharMap.get(currentIndex);
                if(c1 == currentChar){
                    continue;
                }else {
//                    commonCharMap.remove()
                    break;
                }
            }else {
                commonCharMap.put(currentIndex,currentChar);
            }
            currentIndex++;

        }

        List<Character> commonCharlist = new LinkedList<>();
        String result = "";
        if(commonCharMap.values().size() > 0){
            commonCharlist.addAll(commonCharMap.values());
            result = commonCharlist.stream().map(c->c.toString()).collect(Collectors.joining());
        }

        return result;
    }

    public static void main(String... args) {
        String[] sss = {"dog", "racecar", "car"};
        String[] sss1 = {"dog", "dogi", "doggg"};
        String[] sss2 = {"flower", "flow", "flight"};
        String result = LongestCommonPrefix1st.longestCommonPrefix(sss2);

        System.out.println(result);
    }

}
