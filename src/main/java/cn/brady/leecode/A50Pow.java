package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/21 10:22
 */
public class A50Pow {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;

        int t = n / 2;
        if(n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        //n 偶数
        if((n & 1) == 0) return res * res;
        //n 奇数
        return res * res * x;

    }
}
