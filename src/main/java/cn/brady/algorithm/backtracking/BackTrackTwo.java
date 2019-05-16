package cn.brady.algorithm.backtracking;

/**
 * @description: https://blog.csdn.net/qq_37763204/article/details/79519671
 * @auther: bian.wu
 * @date: 2019/4/14 06:34
 */
public class BackTrackTwo {
    //当前解
    int[] x;
    //皇后个数
    int N;
    //当前已找到的可行方案数
    int sum = 0;

    public int totalNQueens(int n) {
        N = n;
        x = new int[N + 1];
        backTrace(1);
        return sum;
    }
    //  x[i] = t ， 表示的是 i 行 皇后 放在 t 列上 和之前的已放的 皇后 是否符合要求。
    private boolean place(int col) {
        for (int i = 1; i < col; i++) {
            boolean is对角线冲突= Math.abs(col-i) == Math.abs(x[col]-x[i]);
            boolean is竖行冲突 = x[col] == x[i];
            if(is对角线冲突 || is竖行冲突){
//            if (Math.abs(col - i) == Math.abs(x[col] - x[i]) || x[col] == x[i]) {
                return false;
            }
        }
        return true;
    }

    private void backTrace(int t) {
        if (t > N) {
            sum++;
        } else {
            //第t行 遍历所有的节点
            for (int j = 1; j <= N; j++) {
                //t行 放j列上
                x[t] = j;
                // 如果第j个节点可以放下皇后
                if (place(t)) {
                    //接着放下一个
                    backTrace(t + 1);
                }
            }
        }
    }

    public static void main(String... args) {

        BackTrackTwo btw = new BackTrackTwo();
        // 8  -> 92
        // 4  -> 2;
        System.out.println(btw.totalNQueens(4));
    }


}
