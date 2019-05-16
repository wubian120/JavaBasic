package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:  60 第K个排列
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * @auther: bian.wu
 * @date: 2019/4/28 17:21
 */
public class A60第K个排列 {


    /***
     * @思路： 找下标
     *
     * 这个题不需要求出所有的排列然后返回某个位置的字符串，特定位置的字符串组合是有规律的（在有序的状态下）。
     * 例如1234，1后面有三个数，那么1开头的数有3!个，
     * 同理，2，3，4也是如此，所以n个数，要找到第k个数，那么第一个数的位置一定是k/(n−1)! k/(n-1)!k/(n−1)!，
     * （由于k从0开始，所以用的时候要减1）。
     * 第一个数确定好之后可以直接拿走，然后在字符串中删除这个数，然后在剩下的字符串中找位置，
     * 这时的位置k就变成了k%(n−1)! k\%(n-1)!k%(n−1)!，
     * 接下来的步骤就可以循环了。
     * 一直到最后一个字符即可。
     *
     * 我们可以发现，每一位上1,2,3,4分别都出现了6次，当第一位上的数字确定了，后面三位上每个数字都出现了2次，当第二位也确定了，后面的数字都只出现了1次，当第三位确定了，那么第四位上的数字也只能出现一次，那么下面我们来看k = 17这种情况的每位数字如何确定，由于k = 17是转化为数组下标为16：
     *
     * 最高位可取1,2,3,4中的一个，每个数字出现3！= 6次，所以k = 16的第一位数字的下标为16 / 6 = 2，即3被取出
     * 第二位此时从1,2,4中取一个，k = 16时，k' = 16 % (3!) = 4，而剩下的每个数字出现2！= 2次，所以第二数字的下标为4 / 2 = 2，即4被取出
     * 第三位此时从1,2中去一个，k' = 4时，k'' = 4 % (2!) = 0，而剩下的每个数字出现1！= 1次，所以第三个数字的下标为 0 / 1 = 0，即1被取出
     * 第四位是从2中取一个，k'' = 0时，k''' = 0 % (1!) = 0，而剩下的每个数字出现0！= 1次，所以第四个数字的下标为0 / 1= 0，即2被取出
     *
     * 那么我们就可以找出规律了
     * a1 = k / (n - 1)!
     * k1 = k
     *
     * a2 = k1 / (n - 2)!
     * k2 = k1 % (n - 2)!
     * ...
     *
     * an-1 = kn-2 / 1!
     * kn-1 = kn-2 / 1!
     *
     * an = kn-1 / 0!
     * kn = kn-1 % 0!
     *
     */
    //// @beat   100%
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];
        //初始化char[] arr；
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = (char) (i + '0');
        }

        int cur = 0;
        int remain = k - 1;
        while (remain > 0) {

            int step = getFactorial(n - cur - 1);
            int loop = remain / step;
            //为什么要交换 arr[cur] cur[cur+i]
            for (int i = 1; i <= loop; i++) {
                char tmp = arr[cur];
                arr[cur] = arr[cur + i];
                arr[cur + i] = tmp;
            }

            remain = remain % step;
            cur++;
        }

        return new String(arr);
    }
    //求递归
    private int getFactorial(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }


    /***
     * @beat   75%
     * @main    主要参考
     * @param n
     * @param k
     * @return
     */
    public String getPermutation_two(int n, int k) {
        //list中元素为当前未纳入排列中的元素
        List<Integer> f = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            f.add(i);
        }

        String s = "";
        int jc = 1;
        //求 n的阶乘
        for(int i = 1; i <= n; i++)
            jc *= i;
        //求下标
        for(int i = 0; i < n-1 && k != 1; i++) {
            //n-i的阶乘
            jc /= (n-i);
            int a = k/jc;
            int b = k%jc == 0 ? 1:0;
            int cur = a-b;
//            int cur = k/jc - (k%jc == 0 ? 1 : 0);
            k -= cur*jc;

            s += f.get(cur);
            f.remove(cur);
        }

        for(int i = 0; i < f.size(); i++) {
            s += f.get(i);
        }

        return s;
    }


    public static void main(String...args){

        int n = 4;
        int k = 15;
        A60第K个排列 a = new A60第K个排列();
//        String result = a.getPermutation(n,k);
        String result = a.getPermutation_two(n,k);


        System.out.println("end");
    }

}
