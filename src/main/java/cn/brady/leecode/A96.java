package cn.brady.leecode;

/**
 * @description:  96不同的 二叉搜索树  dp
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/

给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3



 * todo: 96 不同的二叉搜索树
 * todo: 1.跟一遍                 2019-03-26
 * todo: 2.理解                   2019-03-26
 * todo: 3. 背着写一遍
 * todo: 4.可以默写完成


 * @auther: bian.wu
 * @date: 2019/3/21 10:42
 */
public class A96 {

    /**
     * pass   0ms  beats 100%
     * @ref： https://blog.csdn.net/qq_38595487/article/details/79598628
     *        https://www.jianshu.com/p/4570ce2ba076
     *
     * 从 1 到 n 个 节点的二叉搜索树，   左子 小于 节点，  右子 大于 节点，
     *     中序遍历 就是  自然排序；  不同形态的 二叉树子树  可能个数 就是 左子树 * 右子树.
     * @规律
     * 假设 n个节点组成的二叉搜索树的个数 G(n) ，f（i） 是以i为根的 二叉搜索树的个数。
     *
     *  G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n) ------------ 1
     *
     * n为根节点，  i为 子树根节点， 左子树 [1,2,3,4,...,i-1] 右子树 [i+1, i+2, ... n]
     *  所以当 i 为 根，  左子 个数 i-1,  右子树个数  n-i;
     *
     *  f(i) = G（i-1）* G(n-i)  --------- 2
     *
     *  由 1， 2 两式可得 ：
     *
     *  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + G(2) * G(n-3) +... + G(n-1) * G(0)
     *
     *
     *
     */
    public static int numTrees(int n) {

        if (n == 0)return 0;
        if (n == 1) return 1;

        int[] nums = new int[n+1];
        nums[0] = 1; nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] +=  nums[j] * nums[i-1-j];
            }
        }
        return nums[n];

    }


    public static void main(String...args){
        int n = 3;

        int result = A96.numTrees(n);


        System.out.println(result);
    }

    public static int numTrees_self_one(int n){
        if(n==0)return 0;
        if(n==1) return 1;

        int[] num = new int[n+1];
        num[0] = num[1] = 1;

        for(int i=2;i<=n;i++){
            //遍历 子节点 个数的乘积 之和；
            for(int j=0;j<i;j++){
                num[i] += num[j] * num[i-1-j];
            }
        }

        return num[n];
    }

}
