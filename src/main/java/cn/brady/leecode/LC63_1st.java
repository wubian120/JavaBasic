package cn.brady.leecode;

/**
 * @description: leetcode 63 不同路径II
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 参考 ：
 * https://segmentfault.com/a/1190000009969855
 * @auther: bian.wu
 * @date: 2019/2/9 11:06
 */
public class LC63_1st {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) {
            return 0;
        }
        int column = obstacleGrid[0].length;
        int path = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                path = 0;
            }
            obstacleGrid[i][0] = path;
        }
        path = 1;
        for (int j = 0; j < column; j++) {
            if (obstacleGrid[0][j] == 1) {
                path = 0;
            }
            obstacleGrid[0][j] = path;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }

    public static void main(String... args) {

        int[][] maxtrix = {{0}};

        int result = LC63_1st.uniquePathsWithObstacles(maxtrix);

        System.out.println("end");
    }
}
