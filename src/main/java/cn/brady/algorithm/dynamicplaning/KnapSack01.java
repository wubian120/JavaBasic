package cn.brady.algorithm.dynamicplaning;

/**
 * @description: 0-1背包问题    递归解法
 *
 * https://blog.csdn.net/chanmufeng/article/details/82955730
 * @auther: bian.wu
 * @date: 2019/2/14 23:53
 */
public class KnapSack01 {

    /**
     *
     * @param weights
     * @param values
     * @param index
     * @param capacity 当前背包 剩余容量
     * @return 最大价值
     */
    private static int solveKS(int[] weights, int[] values, int index, int capacity){
        if(index<0 || capacity<=0){
            return 0;
        }
        /**不放第index个物品价值*/
        int res = solveKS(weights,values,index-1, capacity);
        if(weights[index] <=capacity){
            res = Math.max(res,values[index]+solveKS(weights,values,index-1,capacity-weights[index]));
        }
        return res;
    }

    public static int knapSack(int[] weights, int[] values, int capacity){
        int size = weights.length;
        return solveKS(weights,values,size-1,capacity);
    }

    public static void main(String...args){
        int[] w = {2,1,3,2};
        int[] v = {12,10,20,15};

        int maxValue = knapSack(w,v,5);

        System.out.println("end");

    }



}
