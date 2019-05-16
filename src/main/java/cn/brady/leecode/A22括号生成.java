package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22 括号生成  回溯算法
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * @auther: bian.wu
 * todo: 22 括号生成 ，回溯
 * todo: 1.跟一遍    done  19-03-21 跟了一遍
 *
 * todo: 2.理解
 *
 * todo: 3. 背着写一遍
 *
 * todo: 4.可以默写完成
 *
 * @date: 2019/3/20 23:54
 */
public class A22括号生成 {

    /**
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis_One(int n){
        List<String> result = new ArrayList<>();

        generate(result,"",n,n);

        return result;
    }

    public static void generate(List<String> list, String str,int left,int right){
        if(left==0&&right==0){
            list.add(str);
            return;
        }
        if(left>0){
            generate(list,str+"(",left-1,right);
        }
        if(right>left){
            generate(list,str+")",left,right-1);
        }


    }


    public static void main(String...args){

        int n = 3;

        List<String> results = generateParenthesis_One(n);

        for(String s:results){
            System.out.println(s);
        }

    }

}
