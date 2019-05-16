package cn.brady.algorithm.backtracking;

/**
 * @description:  回溯算法
 * @ref:   https://blog.csdn.net/qq_37763204/article/details/79519671
 *
 * 解决n皇后 问题  ，   放置判定标准， 俩俩不在一行，  不在一列，  不在对角线
 *
 *  todo: 回溯算法  例题1  八皇后问题
 *  todo: 1.跟一遍         19-03-24 done
 *  todo: 2.理解           19-03-24 done
 *  todo: 3.把 回溯树 列一遍
 *  todo: 3. 背着写一遍
 *  todo: 4.可以默写完成
 *
 * @auther: bian.wu
 * @date: 2019/3/24 12:07
 */
public class BackTrackingOne {

    //x[i]=j  表示 i 列 放在 j 行上.
    public static int[] x;


    public static int number;
    public static int sum = 0;

    public static int totalNQueens(int n){
        number=n;
        x = new int[n+1];
        backTrace(1);
        return sum;
    }

    private static void backTrace(int t){
        if(t>number){
            // t> number  代表什么含义？
            sum++;
        }else {
            for(int j=1; j<=number; j++){
                x[t]=j;
                if(place(t)){
                    backTrace(t+1);
                }
            }
        }
    }

    private static boolean place(int col){

        for(int i=1;i<col; i++){
            // 判定是否合法，   前面判定 是否在 对角线上，  后面判断是否在同一行。
//            if(Math.abs(col-i) == Math.abs(x[col]-x[i])|| x[col]==x[i]){
//                return false;
//            }

            /** 判断是否在 对角线 */
            if(Math.abs(col-i) == Math.abs(x[col]-x[i])){
                return false;
            }
            /**判断是否在 同一行*/
            if(x[col]==x[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String...args){

        int n = 4;

        int result = BackTrackingOne.totalNQueens(n);

        System.out.println(result);

    }


}
