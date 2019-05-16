package cn.brady.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 17 电话号码的字母组合  回溯  pass
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @参考：
 * @状态：
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/20 19:19
 */
public class A17_One {


    /***
     * @beat  99.9%
     */
    char[][] refer = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations_best(String digits) {
        List<String> list = new ArrayList<>();
        if(!digits.equals(""))
            dfs(digits,list,"");
        return list;
    }
    public void dfs(String digits,List<String> list,String cur){
        if(digits.equals(""))
            list.add(cur);
        else{
            int n = digits.length(),num = digits.charAt(n-1)-'0';
            for(int i = 0;i<refer[num].length;i++){
                dfs(digits.substring(0,n-1),list,refer[num][i]+cur);
            }
        }
    }




    /**
     *  pass  14ms
     *  https://blog.csdn.net/FaustoPatton/article/details/82312975
     */
    public static List<String> letterCombinations_One(String digits) {

        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});
        int len = digits.length();

        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int flag2 = Integer.parseInt(digits.substring(i, i + 1));
            String[] tem = map.get(flag2);
            List<String> list_tmp = new ArrayList<>();
            if (i != 0) {
                for (int j = 0; j < res.size(); j++) {
                    for (int k = 0; k < tem.length; k++) {
                        String f = res.get(j) + "" + tem[k];
                        list_tmp.add(f);
                    }
                }
                res = list_tmp;
            } else {
                for (int k = 0; k < tem.length; k++) {
                    res.add(tem[k]);
                }
            }
        }
        return res;
    }


    /**
     *  pass  5ms   beat 22.51%
     * 参考 ： https://blog.csdn.net/cmqwan/article/details/84074745
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations_two(String digits) {
        if(digits.length()==0){
            return Collections.EMPTY_LIST;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] chars = digits.toCharArray();
        List<String> results = new ArrayList<>();
        results.add("");

        for(char c : chars){
            List<String> tmpList = new ArrayList<>();

            String sufStr = map.get(c);
            for(String str: results){
                for(Character tmpC : sufStr.toCharArray()){
                    String tmpStr = str+tmpC;
                    tmpList.add(tmpStr);
                }
            }
            results = tmpList;
        }

        return results;
    }


    public static List<String> letterCombinations_three(String digits) {

        return null;
    }


    public static void main(String... args) {

        String digits = "23";
//        List<String> results = A17_One.letterCombinations_One(digits);
        List<String> results = A17_One.letterCombinations_two(digits);

        for (String s : results) {
            System.out.println(s);
        }


    }


}
