package cn.brady.leecode;

/**
 * @description:  84 柱状图中的最大矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * @auther: bian.wu
 * @date: 2019/4/27 10:18
 */
public class A84柱状图中的最大矩形 {

    /***
     * @beat 86%
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights)
    {
        int len = heights.length;
        if(len == 1)
            return heights[0];
        int res = 0;
        for(int i = 0; i < len;i++)
        {
            if(i+1 == len || heights[i] > heights[i+1])
            {
                int minh = heights[i];
                for(int j = i;j >= 0;j--)
                {
                    minh = Math.min(minh, heights[j]);
                    res = Math.max(res, minh * (i-j+1));
                }
            }
        }
        return res;
    }

    /***
     * @beat   97%
     * @param heights
     * @return
     */
    public int largestRectangleArea_two(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return getMax(heights, 0, heights.length);
    }
    int getMax(int[] heights, int s, int e) {

        if (s + 1 >= e) return heights[s];

        int min = s;

        boolean sorted = true;

        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1]) sorted = false;
            if (heights[min] > heights[i]) min = i;
        }

        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++) {
                max = Math.max(max, heights[i] * (e - i));
            }
            return max;
        }

        int left = (min > s) ? getMax(heights, s, min) : 0;

        int right = (min < e - 1) ? getMax(heights, min + 1, e) : 0;

        return Math.max(Math.max(left, right), (e - s) * heights[min]);
    }


    public static void main(String...args){
        int[] h = {2,1,5,6,2,3};

        A84柱状图中的最大矩形 a = new A84柱状图中的最大矩形();
        int result = a.largestRectangleArea(h);

        System.out.println("end");

    }



}
