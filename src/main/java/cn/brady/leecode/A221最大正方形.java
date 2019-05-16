package cn.brady.leecode;

/**
 * @description: 221  最大正方形  DP
 * https://leetcode-cn.com/problems/maximal-square/
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * todo: 221 最大正方形 DP
 * todo: 1.跟一遍
 * todo: 2.理解
 * todo: 3. 背着写一遍
 * todo: 4.可以默写完成

 * @auther: bian.wu
 * @date: 2019/3/26 18:01
 */
public class A221最大正方形 {

    /**
     * @cost  16ms
     * @beats  50%
     * @ref: https://blog.csdn.net/jmspan/article/details/51330616
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] len = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (matrix[i-1][j-1]=='1') {
                    len[i][j] = Math.min(len[i-1][j-1], Math.min(len[i-1][j], len[i][j-1])) + 1;;
                }
                max = Math.max(max, len[i][j]);
            }
        }
        return max*max;
    }

    public static void main(String...args){

        char[][] matrix =  {{'1','0','1','0','0'},{'1','0','1','1','1'}, {'1','1','1','1','1'},{'1','0','0','1','0'}};
        int result = A221最大正方形.maximalSquare(matrix);

        System.out.println(result);

    }
}
