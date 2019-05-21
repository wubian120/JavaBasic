package cn.brady.algorithm.蓄水池采用;

import java.util.Random;

/**
 * @description: 单机版 蓄水池抽样
 * https://www.cnblogs.com/snowInPluto/p/5996269.html
 * @auther: bian.wu
 * @date: 2019/5/21 16:38
 */
public class SimpleReservoirSampling {

    public static int[] sample(int m, int[] dataStream){

        Random random = new Random();
        int[] reservoir = initReservoir(m,dataStream);
        int len = reservoir.length;
        //初始化 数据集 个数 为 m ;
        for(int i=0;i<len;i++){
            reservoir[i] = dataStream[i];
        }
        //if(ran<m)  ===   m/
        for(int j=m; j<dataStream.length;j++){
            int ran = random.nextInt(j+1);
            if(ran < m){
                reservoir[ran] = dataStream[j];
            }
        }
        return reservoir;
    }

    private static int[] initReservoir(int m, int[] dataStream){

        int[] reservoir;

        if(m>dataStream.length){
            reservoir = new int[dataStream.length];
        }else {
            reservoir = new int[m];
        }
        return reservoir;
    }

}
