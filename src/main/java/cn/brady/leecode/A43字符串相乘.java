package cn.brady.leecode;

/**
 * @description:  43 字符串相乘
 *
 https://leetcode-cn.com/problems/multiply-strings/submissions/

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。


 * @auther: bian.wu
 * @date: 2019/3/26 18:13
 */
public class A43字符串相乘 {

    /**
     * @cost  31ms
     * @beat   64%
     * @ref : https://blog.csdn.net/cmqwan/article/details/84554827#_65
     *
     */
    public static String multiply(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty()
                ||(num1.length() == 1 && num1.charAt(0) == '0')
                || (num2.length() == 1 && num2.charAt(0) == '0'))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2 + 1];
        for(int i = 0 ; i < len1;i++) {
            int a = num1.charAt(i) - '0';
            for(int j = 0; j < len2; j++) {
                int b = num2.charAt(j) - '0';
                ans[len1 + len2 - i - j - 2] += a * b ;
            }
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < len1 + len2   ;i++) {
            res.append(ans[i] % 10);
            ans[i + 1] += ans[i] / 10;
        }
        String result = res.reverse().toString();
        if(result.startsWith("0"))
            result = result.substring(1, len1 + len2);
        return result;

    }

    public static void main(String...args){

        String  s1 = "2";
        String  s2 = "31";

        String result = A43字符串相乘.multiply(s1,s2);

        System.out.println(result);
    }

}
