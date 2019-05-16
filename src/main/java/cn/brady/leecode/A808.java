package cn.brady.leecode;

/**
 * @description: 808 分汤  DP
 * @auther: bian.wu
 * @date: 2019/3/22 11:30
 */
public class A808 {

    /***
     * @Answer：
     * @参考： https://blog.csdn.net/tiefanhe/article/details/80165420
     * @Status: pass
     * //  todo: 808 分汤   dp
     * //  todo: 1.跟一遍
     * //  todo: 2.理解
     * //  todo: 3. 背着写一遍
     * //  todo: 4.可以默写完成
     */


    //使用数组来缓存已经 计算过的结果，进而在递归中剪枝。
    public static double[][] memo = new double[200][200];

    public static double soupServings(int N) {
        //>5000 trick
        //技巧，（N+24）/25 进而将25，50，75，100 缩减到 1，2，3，4. 从而减少memo 的使用。
        return N >= 5000 ? 1.0 : getProbability((N + 24) / 25, (N + 24) / 25);
    }

    //返回 A为a ml， B为bml 情况下，A先空以及AB同时为空的概率之和。
    public static double getProbability(int a, int b) {
        //A 和B 同时为空的概率的 half。 这里<0 意味着不够serve。
        if (a <= 0 && b <= 0) return 0.5;
        //A 为空的概率为1
        if (a <= 0) return 1;
        //B 不可能在 A不空的情况下为空。
        if (b <= 0) return 0;
        if (memo[a][b] > 0) return memo[a][b];
        //当前阶段，分别选择 4个operation 中的某一个operation，进入下一层迭代。
        memo[a][b] = 0.25 * (getProbability(a - 4, b) + getProbability(a - 3, b - 1) + getProbability(a - 2, b - 2) + getProbability(a - 1, b - 3));
        return memo[a][b];

    }

    public static void main(String... args) {

        int a = (75 + 24) / 25;


        int n = 100;

        double result = A808.soupServings(n);


        System.out.println(result);

    }

    public static double soupServings_self(int n){

        int a= (n+24)/25, b= (n+24)/25;
        int[][] memo = new int[a+1][b+1];



        return 0.0;
    }

}
