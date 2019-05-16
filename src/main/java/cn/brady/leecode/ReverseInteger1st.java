package cn.brady.leecode;

/**
 * @description: 整数反转
 * 以下为标准答案
 *
 * https://leetcode-cn.com/problems/reverse-integer/solution/
 * @auther: bian.wu
 * @date: 2018/11/29 22:32
 */
public class ReverseInteger1st {


    public int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;

        }
        return rev;
    }


    public static void main(String... args) {

        int x = 983;

        int pop = x % 10;


        System.out.println(pop);

    }

}
