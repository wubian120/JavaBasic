package cn.brady.algorithm.heapsort;

import java.util.Arrays;

/**
 * Created by Brady on 2017/5/24.
 */
public class HeapSort {


    public static void sort(int[] arr){

        //第一次 从第一个非叶节点开始
        for(int i = arr.length/2 - 1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }
        // 最后一个节点与 大顶节点 交换，割裂 再调整
        for(int j = arr.length-1; j > 0; j--){
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整
     * @param arr
     * @param i
     * @param length
     * @param <T>
     */
    public static  void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i];  //取出i结点

        //从i节点的左子节点开始，即2i+1；
        for(int k = i * 2 + 1; k < length; k *= 2){

            //如果左侧子节点小于 右侧子节点，则指向右子节点
            if( (k + 1) < length && (arr[k] < arr[k+1])){
                k++;
            }

            //如果子节点大于父节点，将子节点赋值给父节点（不用交换）
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }

        }
        //temp 放在最终位置
        arr[i] = temp;


    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args){

        int[] arra = {10,312,34,5,11,43,953,7,91,34,641};

        sort(arra);

        System.out.println(Arrays.toString(arra));

    }

}
