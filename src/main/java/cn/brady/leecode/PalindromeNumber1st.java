package cn.brady.leecode;

/**
 * @description: 9. 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/
 * 输入: 121
 * 输出: true
 *
 * @auther: bian.wu
 * @date: 2018/11/30 15:01
 */
public class PalindromeNumber1st {

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        /**判断奇偶性*/
        if(x % 2 == 1){ }
        String xStr = String.valueOf(x);
        int i,j;
        i = 0;
        j = xStr.length()-1;

        while (i<j){
            char before = xStr.charAt(i++);
            char after = xStr.charAt(j--);
            if(before == after){
               continue;
            }else {
                return false;
            }
        }
        return true;
    }


    public static void main(String...args){

        int x = 10;
        boolean isPalindrome = PalindromeNumber1st.isPalindrome(x);

        System.out.println(isPalindrome);


    }


}
