package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/17 06:02
 */
public class A11盛水最多的容器 {

    /***
     * @beat   99.3%
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int head = 0, tail = height.length-1;
        int maxArea = 0;
        while (head < tail) {
            int w = tail - head;
            int h, area;
            if(height[tail] < height[head]) {
                h = height[tail];
                tail = tail - 1;
            } else {
                h = height[head];
                head = head + 1;
            }
            area = w * h;
            if ( area> maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String...args){
        A11盛水最多的容器 a11 = new A11盛水最多的容器();

        int[] nums ={1,8,6,2,5,4,8,3,7};
        int result  = a11.maxArea(nums);

        System.out.println(result);

    }
}
