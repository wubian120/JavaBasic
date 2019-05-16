package cn.brady.algorithm.sort.quicksort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/21 12:19
 */
public class QuickSortSelf_One {

    public static void main(String...args){


        int[] data = {19,9,8,22,0,381,9,19,1};
        System.out.print("before : ");
        for(int i : data){
            System.out.print(i+" , ");
        }

        System.out.print("\n");

        QuickSortSelf_One.sort(data);

        System.out.print("after : ");
        for(int i : data){
            System.out.print(i+" , ");
        }
        System.out.print("\n");


    }

    public static void sort(int[] data){

        if(data==null || data.length==0){
            return;
        }
        int len = data.length;

        quickSort(data,0,len-1);


    }

    public static void quickSort(int[] data, int low, int high){
        if(low>=high){
            return;
        }
        int l = low, h = high;
        int m = low + (high-low)/2;
        int pivot = data[m];

        while (l<h){
            while (data[l]<pivot){
                l++;
            }
            while (data[h]>pivot){
                h--;
            }
            if(l<=h){
                int t = data[l];
                data[l] = data[h];
                data[h]=t;
                l++;
                h--;
            }
            if(l<high){
                quickSort(data,l,high);
            }
            if(low<h){
                quickSort(data,low,h);
            }
        }

    }


}
