package cn.brady.leecode;

/**
 * @description:  64 最小路径 和  passed
 *
 * @参考 ：  https://blog.csdn.net/czj1992czj/article/details/80362244
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/18 16:36
 */
public class A64_One {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //row
        int m = grid.length;
        //column
        int n = grid[0].length;
        int[] dp = new int[n];
        //第一步 就是网格第一个点 值
        dp[0] = grid[0][0];
        //初始化 dp 第一行， 相当于一直往右走 需要的步数。
        for (int j = 1; j < n; j++) {
            // 初始化第一行的每一列， = 前一列 + 网格 第一行 第j列值
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            //从第2行 开始， 初始化第1行, 第一行 + 第 i 行 第一个值。
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                //计算第i行 第j列 ，第j列 最小值。
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[n - 1];
    }

    public static int minPathSum_self_one(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //row
        int m = grid.length;
        //column
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int col = 1;col<n;col++){
            dp[0][col] = grid[0][col] + dp[0][col-1];
        }
        for(int row=1;row<m;row++){
            dp[row][0] = grid[row][0] + dp[row-1][0];
        }

        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                dp[row][col] = grid[row][col] + Math.min(dp[row-1][col],dp[row][col-1]);
            }
        }
        return dp[m-1][n - 1];
    }




    public static void main(String... args) {

//        int[][] data = {{1, 2, 3}, {2, 3, 4}};
        int[][] data = {{1, 3, 1}, {1, 5, 1},{4, 2, 1}};

        int result = A64_One.minPathSum(data);

        System.out.println(result);
        System.out.println(data.length);
        System.out.println(data[0].length);



    }

}
