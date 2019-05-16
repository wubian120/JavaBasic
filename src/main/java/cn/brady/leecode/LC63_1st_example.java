package cn.brady.leecode;

/**
 * @description: leetcode 63 不同路径II  参考答案  已验证
 *  * 参考 ：
 *  * https://segmentfault.com/a/1190000009969855
 * @auther: bian.wu
 * @date: 2019/2/9 16:28
 */
public class LC63_1st_example {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int row = obstacleGrid.length;
        if(row==0){
            return 0;
        }
        int column = obstacleGrid[0].length;

        int path = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 1 ; i<row ; i++){
            if(obstacleGrid[i][0] == 1){
                path = 0;
            }
            obstacleGrid[i][0] = path;
        }

        path = 1;
        for(int i = 0 ; i<column ; i++){
            if(obstacleGrid[0][i] == 1){
                path = 0;
            }
            obstacleGrid[0][i] = path;
        }

        for(int i = 1 ; i<row ; i++){
            for(int j = 1 ; j<column ; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[row-1][column-1];
    }





}
