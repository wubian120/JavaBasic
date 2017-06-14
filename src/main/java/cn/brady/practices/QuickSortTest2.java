package cn.brady.practices;

/**
 * Created by Brady on 2017/6/5.
 */
public class QuickSortTest2 {

    public void sort(int[] input, int s, int e){

        if(input == null || input.length == 0){
            return;
        }

        if(s <= e){
            return;
        }

        int mid = (e - s) / 2;
        if(mid <= 0){
            return;
        }

        quickSort(input, s, mid);
        quickSort(input, mid+1, e);

    }

    private void quickSort(int data[], int start, int end){

        int mid = (end - start) / 2;
        if(mid <= 0){
            return;
        }

        int pivot = data[start];
        start++;

        while(start <= mid){

            if(data[start] > pivot){

                int t = data[start];
                data[start] = pivot;
                pivot = t;

            }
            start++;
        }

        while(mid < end){

            if(data[end] < pivot){
                int t = data[end];
                data[end] = pivot;
                pivot = t;
            }

            end--;
        }


    }


    public static void main(String[] args){
        QuickSortTest2 qs = new QuickSortTest2();
        int dat[] = {9345,76412, 99,12,123, 34, 67, 321, 6, 6753 };

        for(int i : dat){
            System.out.print(i + ", ");
        }


        System.out.println();

        System.out.println("......");

        qs.quickSort(dat, 0, dat.length-1);

        for(int i : dat){
            System.out.print(i + ", ");
        }


    }

}
