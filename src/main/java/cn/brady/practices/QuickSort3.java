package cn.brady.practices;

/**
 * works fine
 * Created by Brady on 2017/6/5.
 */
public class QuickSort3 {

    private int data[];
    private int length;

    public void sort(int[] input){

        if(input == null || input.length == 0){
            return;
        }

        this.data = input;
        length = input.length;

        quickSort(0, length-1);


    }

    private void quickSort(int lower, int higher){

        if(lower >= higher){
            return;
        }

        int l = lower;
        int h = higher;
        int mid = lower + (higher - lower) /2;
        if (mid <= 0){
            System.out.println(" mid is lower or equal 0");
            return;
        }
        int pivot = data[mid];

        while (l <= h){

            while( data[l] < pivot){
                l++;
            }

            while(data[h] > pivot){
                h--;
            }

            if(l <= h){
                int temp = data[l];
                data[l]  = data[h];
                data[h]  = temp;

                l++;
                h--;
            }

        }

        if(lower < h){
            quickSort(lower, h);
        }
        if(l < higher){
            quickSort(l, higher);
        }


    }



    public static void main(String[] args){

        int dat[] = {9345,76412, 99,12,123, 34, 67, 321, 6, 6753 };

        for(int i: dat){
            System.out.print(i + " , ");
        }

        System.out.println(" ... ");
        QuickSort3 qs = new QuickSort3();

        qs.sort(dat);

        for(int i: dat){
            System.out.print(i + " , ");
        }

    }

}
