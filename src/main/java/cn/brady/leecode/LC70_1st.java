package cn.brady.leecode;

/**
 * @description: leecode 70 爬楼梯  done beats 4.4%
 *
 *  斐波那契数列
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @auther: bian.wu
 * @date: 2019/2/9 09:37
 */
public class LC70_1st {


    public int climbStairs(int n) {
        return getSteps(n);
    }

    private int getSteps(int n) {
        if (n == 1) {
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return getSteps(n-1) + getSteps(n-2);
    }


    public static void main(String... args) {


    }

}
