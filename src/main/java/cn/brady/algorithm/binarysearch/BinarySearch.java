package cn.brady.algorithm.binarysearch;

/**
 * 二分法查找（Binary Search）
 * https://www.yhspy.com/blog/138/
 * Created by Brady on 2017/6/14.
 */
public class BinarySearch {

    public static void main(String[] args){

        int[] data = { 23,2, 4, 6, 7, 9, 13, 16, 19, 31, 53, 84, 99, 101, 351};
//
        int target = 351;
        int index = BinarySearch.binarySearch(data, target);

        System.out.println("index : " + index);
    }

    /**
     * binary search ;
     * @param data   input data array
     * @param target
     * @return position
     */
    public static int binarySearch(int[] data, int target){

        if(data == null || data.length == 0){
            return -1;
        }

        int s = 0 ;
        int e = data.length - 1;
        int index = -1;

        while (s  <  e){
            int mid = (e + s) / 2;
            System.out.println("mid: "+mid);

            if(data[mid] == target){
                index = mid;
                break;
            }else if(data[mid] < target){
                s = mid;
            }else if(data[mid] > target){
                e = mid;
            }
        }
        if(data[s] == target){
            index = s;
        }

        if(data[e] == target){
            index = e;
        }
        return index;

    }


}
