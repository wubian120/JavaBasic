package cn.brady.leecode;

/**
 * @description:  数组中第K个最大元素
 * @status  pass
 * @
 * @auther: bian.wu
 * @date: 2019/4/10 07:10
 */
public class A215_self_one {


    public static int findKthLargest(int[] nums, int k){
        //从0开始， 所以第k大， k-1；
        k--;

        int lower = 0, higher = nums.length-1, pivot;

        while (lower<higher){
            pivot = part(nums,lower,higher);
            if(pivot==k){
                break;
            }else if(pivot<k){
                lower = pivot+1;
            }else {
                higher = pivot-1;
            }
        }
        return nums[k];
    }

    public static int part(int[] nums, int lower, int higher){
        //中位数
        int point = lower + (higher-lower)/2;
        while (lower<higher){
            while (lower < point && nums[lower] > nums[point]){
                lower++;
            }
            while (higher>point && nums[higher] < nums[point]){
                higher--;
            }
            swap(nums,lower,higher);
            if(point == lower){
                point = higher;
                lower++;
            }else if(point == higher){
                point = lower;
                higher--;
            }else {
                lower++;
                higher--;
            }
        }
        return point;
    }

    public static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String...args){

        int[] nums = {3,2,1,5,6,4};

        int result = A215_self_one.findKthLargest(nums,2);

        System.out.println(result);

    }

}

