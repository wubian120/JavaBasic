package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/19 16:55
 */
public class QuickSort_One {


    public static void quickSort(int[] data) {
        int len = data.length;
        if (len == 0) {
            return;
        }
        int l = 0;
        int h = len - 1;

        qs(data,l,h);

    }

    private static void qs(int[] data, int low, int high) {

        if (low >= high){
            return;
        }
        int l=low, h=high;
        int p = (high-low)/2 +low;
        int pivot = data[p];

        while (l<=h){
            while (data[l]<pivot){
                l++;
            }
            while (data[h]>pivot){
                h--;
            }

            if(l<=h){
                int temp = data[l];
                data[l] = data[h];
                data[h] =temp;
                l++;
                h--;
            }

            if(low<h){
                qs(data,low,h);
            }

            if(l<high){
                qs(data,l,high);
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

        QuickSort_One.quickSort(data);

        System.out.print("after : ");
        for(int i : data){
            System.out.print(i+" , ");
        }
        System.out.print("\n");

    }


}
