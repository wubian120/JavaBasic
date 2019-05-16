package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description: 85 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例:
 * 输入:
 * [
 *   ['1','0','1','0','0'],
 *   ['1','0','1','1','1'],
 *   ['1','1','1','1','1'],
 *   ['1','0','0','1','0']
 * ]
 * 输出: 6
 *
 * @auther: bian.wu
 * @date: 2019/4/27 10:24
 */
public class A85最大矩形 {

    /***
     * @beat   95%
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        //m 行， n 列
        int m = matrix.length, n = matrix[0].length;

        int[] left = new int[n], right = new int[n], height = new int[n];
        //right 都置为 n
        Arrays.fill(right, n);

        int max = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            int curRight = n;
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }

        return max;
    }

    /***
     * @beat  90%
     * @param matrix
     * @return
     */
    public int maximalRectangle_two(char[][] matrix) {
        int res = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return res;
        }
        //用于存放最当前的高
        int[][] matrixint = new int[matrix.length][matrix[0].length];
        //第一层的高度是当前的数字最高为1
        for (int i = 0; i < matrix[0].length; i++) {
            // 48 是 ASCII 0 的值
            matrixint[0][i] = matrix[0][i] - 48;
        }
        //循环所有一行一行的向下来计算每行的高度（一行一行的截取矩形的高度）
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //如果为零说明断开不能与上一层相连
                if (matrix[i][j] == '0') {
                    matrixint[i][j] = 0;
                } else {
                    //不为零则进行计算加上本身的1
                    matrixint[i][j] = matrixint[i - 1][j] + 1;
                }
            }
        }
        // 每一行都可以看做是一个底 一行一行的进行算面积（知道高了找到相应最大的宽就好了）
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //大于零的高有意义
                if (matrixint[i][j] > 0) {
                    //定义两个指针进行搜索宽
                    int left = j - 1;
                    int right = j + 1;
                    int wide = 1;
                    //搜索每一个高比当前中间这个高的值（向左可以组成矩形）
                    while (left >= 0 && matrixint[i][left] >= matrixint[i][j]) {
                        left--;
                        wide++;
                    }
                    while (right < matrixint[0].length && matrixint[i][right] >= matrixint[i][j]) {
                        right++;
                        wide++;
                    }
                    //计算面积
                    int air = matrixint[i][j] * wide;
                    if (air > res) {
                        res = air;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String...args){

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        A85最大矩形 a = new A85最大矩形();
//        int result = a.maximalRectangle_two(matrix);
        int result = a.maximalRectangle(matrix);
        System.out.println(result);
        System.out.println("end");
    }
}
