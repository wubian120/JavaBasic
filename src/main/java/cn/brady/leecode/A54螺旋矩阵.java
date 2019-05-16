package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/8 07:15
 */
public class A54螺旋矩阵 {

    /***
     * @beat 95%
     * 我们这里首先定义方向：向下表示y正方向，向右表示x正方向。
     * 我们再定义两个点，分别是左上x1,y1和右下x2,y2，
     * 这样我们每循环一次将x1++,y1++并且x2--,y2--
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int dx = 0, dy = 1, x = 0, y = 0;

        /***
         * 四个方向走
         * 水平向右 则 dx=0, dy=1； 向下 则 dx=-1, dy=0;
         * 水平向左 则 dx=0, dy=-1; 向上 则 dx=0, dy=1;
         *
         */
        while (res.size() < n * m) {
            res.add(matrix[x][y]);
            matrix[x][y] = 0;
            if (x + dx < 0 || x + dx >= m || y + dy < 0 || y + dy >= n || matrix[x + dx][y + dy] == 0) {
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
            x += dx;
            y += dy;
        }
        return res;
    }

    public static void main(String... args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

//        int[][] nums = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        A54螺旋矩阵 a = new A54螺旋矩阵();

        List<Integer> result = a.spiralOrder(nums);

        System.out.println(result);

    }

}
