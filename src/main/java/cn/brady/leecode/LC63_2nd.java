package cn.brady.leecode;

/**
 * @description: leetcode 63 不同路径II   done
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * 参考 ： https://blog.csdn.net/cmqwan/article/details/85009435
 *
 * @auther: bian.wu
 * @date: 2019/2/9 16:52
 */
public class LC63_2nd {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] path = new int[n];
        path[0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    path[j]=0;
                }else if(j>0){
                    path[j] += path[j-1];
                }
            }
        }
        return path[n-1];
    }

}
