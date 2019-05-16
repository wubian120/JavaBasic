package cn.brady.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: leecode 79 单词搜索
 *
 *  status ： 未完成
 *
 *  https://leetcode-cn.com/problems/word-search/
 *
 * @auther: bian.wu
 * @date: 2019/1/14 11:34
 */
public class LC79_1st {

    public boolean exist(char[][] board, String word) {

        char[] wordChars = word.toCharArray();
        Map<Character,Integer> charNumMap = new HashMap<>();

        for(char c : wordChars){
            if(charNumMap.containsKey(c)){
                int num = charNumMap.get(c);
                num++;
                charNumMap.put(c,num);
            }else {
                charNumMap.put(c,1);
            }
        }





        return false;
    }

    public static void main(String...args){

        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};


        String word1 = "ABCCED";
        LC79_1st lc79_1st = new LC79_1st();
        Boolean isHas = lc79_1st.exist(board1,word1);


    }


}
