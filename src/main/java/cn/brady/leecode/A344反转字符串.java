package cn.brady.leecode;

/**
 * @description:
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

示例 1：

输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
 *
 * @auther: bian.wu
 * @date: 2019/3/28 16:03
 */
public class A344反转字符串 {


    /**
     * @status  pass
     * @beat    9%
     * @param s
     */
    public static void reverseString_one(char[] s) {
        for(int i = 0;i < s.length/2; i ++){
            char change = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = change;
        }

    }

    public static void main(String...args){

//        char[] s = {'H','a','n','n','a','h'};
        char[] s = {'h','e','l','l','o'};

        A344反转字符串.reverseString__self_one(s);

        System.out.println("end");

    }

    public static void reverseString__self_one(char[] s) {
        int b = 0, e = s.length-1;
        while (b<e){
            if(s[b]==s[e]){
                b++;
                e--;
                continue;
            }else {
                char temp = s[b];
                s[b] = s[e];
                s[e] = temp;
                b++;
                e--;
            }
        }





    }


}
