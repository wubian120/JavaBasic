package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/6 11:59
 */
public class A215数组中的第k个最大元素_self_one {

    public int findKthLargest(int[] nums, int k) {

        quickSort(0,nums.length-1,nums);

        return nums[nums.length -k];
    }

    private void quickSort(int left, int right, int[] data){


        if(left < right){
            int l = left, r = right;
            int mid = left + (right-left) /2;
            int pivot = data[mid];

            while (l<r){
                while (data[l] < pivot){ l++; }
                while (data[r] > pivot){ r--; }

                if(l<=r){
                    int t = data[l];
                    data[l] = data[r];
                    data[r] = t;
                    l++;
                    r--;
                }

                if(l<right){
                    quickSort(l,right,data);
                }
                if(r>left){
                    quickSort(left,r,data);
                }
            }
        }


    }

}