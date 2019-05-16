package cn.brady.algorithm.backtracking;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/25 00:16
 */
public class KnapSack01_backtrack {

    public static int maxW;

    public static void pack(int i, int cw, int[] items,int n, int w){
        if(cw == w || i == n){
            if(cw > maxW){
                maxW = cw;
            }
            return;
        }

        pack(i+1, cw, items, n,w);
        if(cw + items[i]<=w){
            pack(i+1, cw+items[i], items, n,w);
        }
    }



}
