package cn.brady.leecode;

/**
 * @description: leecode 11 最大盛水容器
 *
 * pass the test 2018.12.11
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @auther: bian.wu
 * @date: 2018/12/11 03:23
 */
public class ContainerWithMostWater1st {
    public static int maxArea(int[] height) {

        if(height.length < 0){
            return 0;
        }
        /**index, height·*/

        int len = height.length;
        int maxValue = 0;

        int vol = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1; j<len;j++){
                int h = height[i] > height[j] ? height[j]:height[i];
                vol = Math.abs(j-i) * h;
                if(vol > maxValue){
                    maxValue = vol;
                }
            }
        }

        return maxValue;
    }

    public static void main(String...args){

        int[] t1 = new int[]{1,8,6,2,5,4,8,3,7};



    }
}
