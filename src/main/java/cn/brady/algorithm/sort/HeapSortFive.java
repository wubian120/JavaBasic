package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2018/12/18 09:11
 */
public class HeapSortFive {

    private static int[] data;
    private static int left;
    private static int right;
    private static int mark;

    public static void buildHeap(int[] d){
        int n = d.length-1;
        for(int i=n/2;i>=0;i--){
            maxHeadp(data,i,n);
        }
    }

    public static void maxHeadp(int[] d, int i,int n){
        left = 2*i;
        right = 2*i+1;
        int larger;
        if(left <n && d[left] > d[i]){
            larger = left;
        }else {
            larger = i;
        }

        if(right <= n && d[right] > d[i]){
            larger = right;
        }

        if(larger != i){
            swap(d,i,larger);
            maxHeadp(d,larger,d.length-1);
        }

    }

    public static void sort(int[] d){
        HeapSortFive.data = d;
        buildHeap(data);
        int n = data.length-1;

        for(int i=n; i>0; i--){
            swap(data,0,i);
            n = n-1;
            maxHeadp(d,0,n);
        }
    }

    public static void swap(int[] data, int i, int j){
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    public static void main(String...args){
        int[] a1 = {43, 3, 0, 5, 67, 132, 1, 2, 4, 90,8, 9, 90};
        sort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }



    }

}
