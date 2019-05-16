package cn.brady.leecode;

/**
 * @description: leecode 35 搜索插入位置    done  2018.12.28
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/
 * @auther: bian.wu
 * @date: 2018/12/26 16:52
 */
public class LC35_1st {

    public static int searchInsert(int[] nums, int target) {

        int len = nums.length;
        int index = len / 2;
        int mid = nums[index];

        if (target > nums[len - 1]) {
            return len;
        }
        if (target < nums[0]) {
            return 0;
        }

        if (mid > target) {

            while (index > 0) {
                if (target > mid) {
                    return index+1;
                } else if (target== mid) {
                    return index;
                } else {
                    index--;
                    mid = nums[index];
                }
            }

            if (mid >= target) {
                return 0;
            } else {
                return 1;
            }


        } else if (mid < target) {

            while (index < len - 1) {
                if (mid >= target) {
                    return index;
                } else {
                    index++;
                    mid = nums[index];
                }
            }
            if (target > mid) {
                return len;
            } else {
                return len - 1;
            }


        } else {
            return len / 2;
        }
    }


    public static void main(String... args) {

        int[] t1 = {1, 2, 5, 6};
        int tar1 = 5;
        int[] t2 = {1, 3, 5, 6};
        int tar2 = 2;
        int[] t3 = {1, 3, 5, 6};
        int tar3 = 7;
        int[] t4 = {1, 3, 5, 6};
        int tar4 = 0;

        int[] t5 = {1};
        int tar5 = 0;
        int[] t6 = {1, 3, 5};
        int tar6 = 5;

        int[] t7 = {1, 2, 4, 6, 7};
        int tar7 = 3;
        int result = LC35_1st.searchInsert(t7, tar7);
        System.out.println(result);

        System.out.println("end");
    }

}
