package cn.brady.algorithm.binarysearch;

public class BinarySearch1 {


    /**
     * 二分查找, 给定有序数组，查找是否包含某个值，包含返回 下标，不包含返回-1
     * https://www.61mon.com/index.php/archives/187/
     * @param data
     * @param target
     * @return
     */
    public static int binarySearch(int[] data, int target){

        if(data == null && data.length == 0){
            return -1;
        }
        int left = 0;
        int right = data.length - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(data[mid] > target){
                right = mid-1;
            }else if(data[mid] < target){
                left = mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 给定有序数组，查找target第一次出现的下标，不存在则返回-1。
     * 即找到所有 符合target值的 最小下标
     * @param array
     * @param target
     * @return
     */
    public static int binarySearchOne(int array[], int target){
       int left = 0;
       int right = array.length - 1;

       while(left <= right){

           int mid = left+((right - left) >> 1);

           if(array[mid] >= target){
               right = mid - 1;
           }else if(array[mid] < target){
               left = mid + 1;
           }

       }
        return array[right + 1] == target ? right+1 : -1;
    }



    public static void main(String[] args){


        int array[] = {1,2,3,4,5,5,6,7,8,9,10,10,10,11,12};

        int length = array.length;
        System.out.println("length: "+ length);

        int index = binarySearchOne(array,5);


        int left = 0;
        int right = 20;

        int middle = left + ((right - left) >> 2);

        System.out.println(middle);


    }

}
