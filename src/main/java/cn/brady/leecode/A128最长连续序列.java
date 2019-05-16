package cn.brady.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:  128 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 *
 * todo: 128  最长连续序列，
 * todo: 1.跟一遍     2019.3.29 done
 * todo: 2.理解        2019.3.29 done
 * todo: 3.跟着写一遍   2019.3.29 done
 *
 *
 * todo: 4. 背着写一遍
 *
 * todo: 5.可以默写完成
 * @auther: bian.wu
 * @date: 2019/3/29 11:00
 */
public class A128最长连续序列 {

    /**
     * @beat  33%
     * @ref  https://blog.csdn.net/MebiuW/article/details/53886129
     * counter 保存每个数及 所存在的个数
     */
    public static int longestConsecutive_one(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (counter.containsKey(num)) continue;
            int leftCount = counter.getOrDefault(num - 1, 0);
            int rightCount = counter.getOrDefault(num + 1, 0);
            int sum = leftCount + rightCount + 1;

            counter.put(num, sum);
            counter.put(num - leftCount, sum);
            counter.put(num + rightCount, sum);
            res = Math.max(res, sum);
        }
        return res;
    }


    /**
     * @思路： 首先，将数组都存入HashSet， 然后遍历数组，判断HashSet中 是否存在， 如果存在继续判断，循环，同时移除， 最后判断最长
     * @大O   O(2n)
     * @beat  60%
     * @ref  http://www.cnblogs.com/grandyang/p/4276225.html
     *
     */
    public static  int longestConsecutive_two(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) --pre;
                while (s.remove(next)) ++next;
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;

    }

    public static void main(String...args){

        int[] num = {100, 4, 200, 1, 3, 2};

//        int result = A128最长连续序列.longestConsecutive_one(num);
        int result = A128最长连续序列.longestConsecutive_self_one(num);

        System.out.println(result);


    }


    public static int longestConsecutive_self_one(int[] nums){

        int res = 0;
        HashSet<Integer> dic = new HashSet<>();
        for(int n : nums){
            dic.add(n);
        }
        for(int n:nums){
            if(dic.remove(n)){
                int pre = n-1, next = n+1;
                while (dic.remove(pre)){
                    --pre;
                }
                while (dic.remove(next)){
                    ++next;
                }
                res = Math.max(res, next-pre-1);
            }
        }
        return res;
    }


}
