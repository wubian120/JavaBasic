package cn.brady.leecode;

/**
 * @description:
 * @beat 99%
 * @auther: bian.wu
 * @date: 2019/4/10 07:13
 */
public class A215数组中的第K个最大元素Three {

    public static int findKthLargest(int[] nums, int k) {
        k--;
        int i = 0;
        int j = nums.length - 1;
        int point;
        while (i <= j) {
            point = part(nums, i, j);
            if (point == k) break;
            if (point < k) {
                i = point + 1;
            } else {
                j = point - 1;
            }
        }
        return nums[k];
    }

    public static int part(int[] nums, int i, int j) {
        //中位数
        int point = i + (j - i) / 2;
        while (i < j) {
            while (i < point && nums[i] >= nums[point]) {
                i++;
            }
            while (j > point && nums[j] <= nums[point]) {
                j--;
            }

            swap(nums, i, j);

            if (point == i) {
                point = j;
                i++;
            } else if (point == j) {
                point = i;
                j--;
            } else {
                i++;
                j--;
            }
        }
        return point;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String... args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int result = A215数组中的第K个最大元素Three.findKthLargest(nums, 2);

        System.out.println(result);

    }


}
