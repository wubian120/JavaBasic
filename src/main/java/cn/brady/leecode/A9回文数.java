package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/28 21:57
 */
public class A9回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        /**判断奇偶性*/
        if (x % 2 == 1) {
        }
        String xStr = String.valueOf(x);
        int i, j;
        i = 0;
        j = xStr.length() - 1;

        while (i < j) {
            char before = xStr.charAt(i++);
            char after = xStr.charAt(j--);
            if (before == after) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    /***
     * @beat 98%
     * @param x
     * @return
     */
    public boolean isPalindrome_two(int x) {
        if (x < 0) {
            return false;
        }

        int n = x;
        int m = 0;
        while (n != 0) {
            //t = n的个位数；
            int t = n % 10;
            m = m * 10 + t;
            n = n / 10;

        }
        return x == m;

    }

    public static void main(String... args) {
        int num = 2121;

        A9回文数 a = new A9回文数();
        a.isPalindrome_two(num);

    }

}
