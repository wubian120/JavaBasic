package cn.brady.leecode;

/**
 * @description: 29 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * @auther: bian.wu
 * @date: 2019/4/25 18:32
 */
public class A29两数相除 {
    public int divide(int dividend, int divisor) {
        // 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // 记录结果
        int result = 0;

        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;
            //乘 2
            long t1 = tmp<<1;
            //tmp 变到 比 dvd 大 之前的那个值。
            while (dvd >= t1) {
                tmp <<= 1;
                mul <<= 1;
                t1 = tmp<<1;
            }
            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;

            // 修正结果
            result += mul;
        }

        return result * sign;
    }


    public int divide_two(int dividend, int divisor){

        int sign = ((dividend<0)^(divisor<0)) ? -1:1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        int result = 0;
        while ((dvd -= dvs) >=0){
            result++;
        }

        return result * sign;
    }

    public static void main(String... args) {

        A29两数相除 a = new A29两数相除();
        int dvd = 10, dvo = 3;
//        int result = a.divide(dvd, dvo);

        int result  = a.divide_two(dvd,dvo);

        System.out.println(result);





        System.out.println("end");


    }
}
