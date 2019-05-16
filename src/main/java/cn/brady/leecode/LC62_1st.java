package cn.brady.leecode;

/**
 * @description:  leecode  62 不同路径  done.
 *
 * https://leetcode-cn.com/problems/unique-paths/submissions/
 *
 * @auther: bian.wu
 * @date: 2019/2/8 13:34
 */
public class LC62_1st {

    public int uniquePaths(int m, int n) {

        int[][] ways = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    ways[i][j] = 1;
                }else {
                    ways[i][j]=ways[i-1][j]+ways[i][j-1];
                }
            }
        }
        return ways[m-1][n-1];
    }

    public static void main(String... args){
//        int m = 7;
        int m = 3;
        int n = 2;

        LC62_1st lc621st = new LC62_1st();

        int result = lc621st.uniquePaths(m,n);
        System.out.println("end");
    }





}
