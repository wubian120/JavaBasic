package cn.brady.leecode;

/**
 * @description: leecode 62 不同路径 done  beats 100%
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @auther: bian.wu
 * @date: 2019/2/8 15:29
 */
public class LC62_2nd {

    public static int uniquePaths(int m, int n) {
//        int[][] ways = new int[m][n];
        if(m<=0 ||n<=0){
            return 0;
        }
        int[] paths=new int[n];
        paths[0] = 1;

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                paths[j] += paths[j-1];
            }
        }
        return paths[n-1];

    }

    public static void main(String...args){
        int m = 7;
        int n = 3;

        int result = uniquePaths(m,n);

        System.out.println("end");
    }

}
