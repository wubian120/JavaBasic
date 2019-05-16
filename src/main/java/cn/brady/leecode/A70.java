package cn.brady.leecode;

/**
 * @description: 70 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @auther: bian.wu

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶


 * todo: 70 爬楼梯  dp
 * <p>
 * todo: 1.跟一遍        done 2019.3.20
 * todo: 2.理解          done 2019.3.20
 * todo: 3.背着写一遍     done 2019.3.20
 * todo: 4.可以默写完成   done 2019.3.20
 * todo:
 * @date: 2019/3/21 00:27
 */
public class A70 {

    private int[] memo;

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int sum[] = new int[n + 1];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 2] + sum[i - 1];
        }
        return sum[n];
    }


    /**
     * pass   3ms   beats 82%
     *
     * @param n
     * @return
     */
    public int climbStairs_two(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];

    }


    /**
     * accdording  self  write
     * */
    public static int climbStairs_third(int n) {
        if(n<=2){
            return n;
        }
        int[] memo = new int[n+1];
        for(int i=1;i<=2;i++){
            memo[i] = i;
        }
        for(int i=3;i<=n;i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }


    public static void main(String... args) {

        int n = 5;



        int result = A70.climbStairs_self_one(n);
//        int result = A70.climbStairs_third(n);


        System.out.println(result);
    }


    /**
     * @param n
     * @return
     */
    public static int climbStairs_self_one(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];

    }


}
