package cn.brady.leecode;


import java.util.HashMap;
import java.util.Map;

/**
 *  2017-11-7
 *  思路：
 *  1.将两个 数组 a, b合并，需要确定 两个数组中元素的 大小关系
 *  2.比较两个数组，可能出现的情况，
 *  2.1 a < b  c = [a,b]
 *  2.2 a > b  c = [b,a]
 *  2.3 a,b互有大小  交织在一起， 则不断二分 取比较，插入到新数组。
 *
 *
 *
 */
public class MedianTwoSortedArray {

    public double  findMedian(int[] nums1, int[] nums2){

        double result = 0.0;

        Map<Integer, Integer> wholeMap = new HashMap<>();

        int lenN = nums1.length;
        int lenM = nums2.length;

        int medianN1 = nums1[lenN/2];
        int medianN2 = nums2[lenM/2];

//        //最小 比 最大
//        if(nums1[0] > nums2[lenM-1]){
//
//            // whole[nums2, nums1], median =  (m+n)/2 = m/2 + n/2
//
//        }else if(nums1[lenN-1] < nums2[0]){
//
//            // same as  median = m/2 + n/2
//        }else if(){
//
//        }








        return  result;
    }





}
