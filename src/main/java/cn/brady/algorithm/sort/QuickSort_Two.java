package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/19 17:15
 */
public class QuickSort_Two {

    public static void quickSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int low = 0, high = data.length - 1;

        qs(data, low, high);

    }

    private static void qs(int[] data, int low, int high) {
        if(low>=high){
            return;
        }
        int l = low, h=high, m=low+(high-low)/2;
        int pivot = data[m];
        while (l<=h){
            while (data[l]<pivot){
                l++;
            }
            while (data[h]>pivot){
                h--;
            }
            if(l<=h){
                int t=data[l];
                data[l] = data[h];
                data[h] = t;
                l++;
                h--;
            }
            if(l<high){
                qs(data,l,high);
            }
            if(low<h){
                qs(data,low,h);
            }

        }

    }

    public static void main(String...args){

        int[] data = {19,9,8,22,0,381,9,19,1};
        System.out.print("before : ");
        for(int i : data){
            System.out.print(i+" , ");
        }

        System.out.print("\n");
        QuickSort_Two.quickSort(data);
        System.out.print("after : ");
        for(int i : data){
            System.out.print(i+" , ");
        }
        System.out.print("\n");

    }

}
