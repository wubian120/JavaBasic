package cn.brady.leecode;

/**
 * @description: 695 岛屿最大面积
 * <p>
 * todo: leetcode 695 岛屿最大面积  深度优先
 * <p>
 * todo: 1.跟一遍
 * todo: 2.理解
 * todo: 3.背着写一遍
 * todo: 4.可以默写完成
 * @auther: bian.wu
 * @date: 2019/3/27 23:53
 */
public class A695岛屿的最大面积 {

    /**
     * @param grid
     * @return
     * @ref
     * @cost 41ms
     * @beats 64%
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 当前一片岛屿的面积
                    int area = dfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }

        }
        return res;
    }

    // 核心
    private static int dfs(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;  //置为0
            int sum = 1 + dfs(grid, i + 1, j)
                    + dfs(grid, i - 1, j)
                    + dfs(grid, i, j + 1)
                    + dfs(grid, i, j - 1);
            return sum;
        } else {
            return 0;
        }

    }


    public static void main(String... args) {

        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int result = A695岛屿的最大面积.maxAreaOfIsland(grid);

        System.out.println(result);

    }


}
