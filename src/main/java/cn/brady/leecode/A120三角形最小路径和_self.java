package cn.brady.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/5 20:01
 */
public class A120三角形最小路径和_self {

    public static int minimumTotal_self_one(List<List<Integer>> triangle) {
        int rows = triangle.size();

        for (int r = rows - 2; r >= 0; r--) {
            int cols = triangle.get(r).size();
            for (int col = 0; col<cols; col++){
                triangle.get(r).set(col,triangle.get(r).get(col) + Math.min(triangle.get(r+1).get(col),triangle.get(r+1).get(col+1)));
            }
        }

        return triangle.get(0).get(0);
    }

    /**
     * pass
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal_self_two(List<List<Integer>> triangle) {

        int rows = triangle.size();
        int[] minSteps = new int[rows + 1];

        for (int i = rows - 1; i >= 0; i--) {
            int colSize = triangle.get(i).size();
            for (int j = 0; j < colSize; j++) {
                minSteps[j] = Math.min(minSteps[j], minSteps[j + 1]) + triangle.get(i).get(j);
            }
        }


        return minSteps[0];
    }


    /***
     * @status pass
     * @beat    99%
     * @param triangle
     * @return
     */
    public static int minimunTotal_self_three(List<List<Integer>> triangle){

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
        int[] i1 = {-1};
        int[] i2 = {2, 3};
        int[] i3 = {1, -1, -3};
//        int[] i4 = {4, 1, 8, 3};
        List<Integer> nums1 = Arrays.stream(i1).mapToObj(Integer::new).collect(Collectors.toList());
        List<Integer> nums2 = Arrays.stream(i2).mapToObj(Integer::new).collect(Collectors.toList());
        List<Integer> nums3 = Arrays.stream(i3).mapToObj(Integer::new).collect(Collectors.toList());
//        List<Integer> nums4 = Arrays.stream(i4).mapToObj(Integer::new).collect(Collectors.toList());

        triangle.add(nums1);
        triangle.add(nums2);
        triangle.add(nums3);
//        triangle.add(nums4);

        int result = A120三角形最小路径和_self.minimumTotal_self_two(triangle);

        System.out.println(result);
    }

}
