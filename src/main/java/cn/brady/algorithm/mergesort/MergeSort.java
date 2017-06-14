package cn.brady.algorithm.mergesort;

/**
 * Created by Brady on 2017/5/27.
 */
public class MergeSort {

    private static void merge(int[] array, int low, int mid, int high){

        int fir = low;
        int sec = mid + 1;
        int k = 0;

        int[] temp = new int[high - low +1];

        while(fir <= mid && sec <= high){

            if(array[fir] <= array[sec]){

                temp[k++] = array[fir++];

            }else {

                temp[k++] = array[sec++];
            }
        }

        while(fir <= mid){
            temp[k++] = array[fir++];
        }

        while (sec <= high){
            temp[k++] = array[sec++];
        }

        for(fir = low, k=0; fir <= high; fir++, k++){
            array[fir] = temp[k];
        }

        temp = null;


    }


    public static void mergeSort(int[] array, int low, int high){


        int mid = (low + high)/2;
        if(low < high){

            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }


    }

    public static void main(String[] args){

        int[] source = {12,34,8,123,67,54,9,4,63,1111,22222,453};

        for(int i : source){
            System.out.print(i+ " , ");
        }
        MergeSort.mergeSort(source, 0, source.length-1);

        System.out.println(" ... ");

        for(int j : source){
            System.out.print(j + " , ");
        }

    }




}
