package cn.brady.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 18 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 注意： 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @auther: bian.wu
 * @date: 2019/4/15 06:39
 */
public class A18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        //外循环
        for (int i = 0; i < len - 3; i++) {
            //判断相等  //nums[i] == nums[i-1] 意味 这次循环和下次循环相等
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //最小值大于目标值结束
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //最大值小于目标值跳过此循环
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            //内循环
            for (int j = i + 1; j < len - 2; j++) {
                //判断相等
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //最小值大于目标值结束
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //最大值小于目标值跳过此循环
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                //左右指针寻找满足条件的值
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }
        return result;
    }

    public static void main(String...args){
        int[] nums = {4,12,5,9};
        Arrays.sort(nums);


        System.out.println("end");


    }

}
