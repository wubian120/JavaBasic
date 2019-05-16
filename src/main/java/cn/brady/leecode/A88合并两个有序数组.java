package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/7 16:19
 */
public class A88合并两个有序数组 {


    /***
     * @beat   100%
     * @
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int index=m+n-1;
        while(index>=0){
            //前两个判断要放在前面，防止空指针异常
            if(i<0){
                nums1[index--]=nums2[j--];
            }else if(j<0){
                nums1[index--]=nums1[i--];
            }
            else if(nums1[i]>nums2[j] && i>=0){
                nums1[index--]=nums1[i--];
            }else if(nums1[i]<=nums2[j]&& j>=0){
                nums1[index--]=nums2[j--];
            }
        }
    }

    public static void merge_self_one(int[] nums1, int m, int[] nums2, int n){
        int len = m+n-1;
        int index = len-1, m1=m-1, n1 = n-1;

        while (index>=0){

            if(nums1[m1] > nums2[n1] && m1>=0){
                nums1[index--] = nums1[m1--];
            }


        }



    }


    public static void main(String...args){
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;
        int[] num2 = {2,5,6};
        int n = 3;

        A88合并两个有序数组.merge(num1,m,num2,n);

        System.out.println("end");
    }

}
