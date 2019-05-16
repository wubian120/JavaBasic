package cn.brady.leecode;

/**
 * @description: leecode 50
 * https://leetcode-cn.com/problems/powx-n/
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51655964 参考
 * @auther: bian.wu
 * @date: 2018/12/11 02:19
 */
public class Pow1st {

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        /**n 过大 导致溢出的情况*/
        int t = n / 2;
        if (n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if (n % 2 == 0) {
            return res * res;
        }
        return res * res * x;

//        double value = x;
//        if(n > 0){
//            for(int i=1;i<n;i++){
//                value *= x;
//            }
//        }else if(n < 0){
//            value = 1/x;
//            for(int i=1;i<-n;i++){
//                value *= 1/x;
//            }
//        }else {
//            value = 1.0;
//        }


    }


    public static void main(String... args) {
        double x = 2.0;
        int n = 10;

        double x1 = 2.1;
        int n1 = 3;

        double x2 = 2.0;
        int n2 = -2;

        double result = Pow1st.myPow(x2, n2);


        System.out.println(" end ");

    }
}
