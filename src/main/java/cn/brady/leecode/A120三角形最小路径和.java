package cn.brady.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 120 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @ref: https://blog.csdn.net/qq_17550379/article/details/82797218
 * @思路： 从下往上 走
 * todo: 120 三角形最小路径和 DP
 * todo: 1.跟一遍
 * todo: 2.理解
 * todo: 3. 跟着写一遍
 * todo: 4. 背着写一遍
 * todo: 5.可以默写完成
 * @auther: bian.wu
 * @date: 2019/3/26 15:38
 */
public class A120三角形最小路径和 {

    /**
     * @status pass
     * @cost 9ms
     * @beats 44%
     * @ref https://blog.csdn.net/ccccc1997/article/details/81347254
     * @思路： 从最下面一行 开始，
     */
    public static int minimumTotal_one(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        //先从最下面一行开始
        int row = triangle.size() - 1;
        for (int i = row; i >= 0; i--) {
            int col = triangle.get(i).size();
            for (int j = 0; j < col; j++) {
                //该行 第 j 个，
                int currentTri = triangle.get(i).get(j);

                int minRes = Math.min(res[j], res[j + 1]);
                res[j] = minRes + currentTri;
            }
        }
        return res[0];
    }

    /***
     * @beat  96%
     * @param triangle
     * @return
     */
    public int minimumTotal_two(List<List<Integer>> triangle) {
        int rows = triangle.size();

        int[] dp = new int[rows+1];

        for(int r=rows-1;r>=0;r--){
            int cols= triangle.get(r).size();
            for(int c = 0;c<cols;c++){
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c],dp[c+1]);
            }
        }

        return dp[0];
    }




    public static void main(String... args) {

        List<List<Integer>> triangle = new LinkedList<>();
        int[] i1 = {2};
        int[] i2 = {3, 4};
        int[] i3 = {5, 6, 7};
        int[] i4 = {4, 1, 8, 3};
        List<Integer> nums1 = Arrays.stream(i1).mapToObj(Integer::new).collect(Collectors.toList());
        List<Integer> nums2 = Arrays.stream(i2).mapToObj(Integer::new).collect(Collectors.toList());
        List<Integer> nums3 = Arrays.stream(i3).mapToObj(Integer::new).collect(Collectors.toList());
        List<Integer> nums4 = Arrays.stream(i4).mapToObj(Integer::new).collect(Collectors.toList());

        triangle.add(nums1);
        triangle.add(nums2);
        triangle.add(nums3);
        triangle.add(nums4);

        int result = A120三角形最小路径和.minimumTotal_one(triangle);

        System.out.println(result);

    }





}
