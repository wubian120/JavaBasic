package cn.brady.leecode;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/1 21:56
 */
public class A220存在重复元素III {

    /**
     * @param nums 数组
     * @param k    并且 i 和 j 之间的差的绝对值最大为 ķ
     * @param t    nums [i] 和 nums [j] 的差的绝对值最大为 t
     * @return
     * @beat 94%
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 10000) return false;
        if (k <= 0 || t < 0) return false;
        int len = nums.length;
        if (len < 2) return false;

        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= i - k && j >= 0; j--) {
                long dif = (long) temp - (long) nums[j];
                if (dif >= (0 - t) && dif <= t) {
                    return true;
                }

            }
        }
        return false;
    }


    /**
     * @beat  39%
     * @ref  https://blog.csdn.net/weixin_41681068/article/details/82721992
     * @思路： 如果使用普通的遍历方法进行遍历，则时间复杂度是O(Nk),会超出时限。
     *        我们可以换一种思路，维持一个长度为k的窗口，
     *        在这个窗口内搜索是否存在与nums[i]绝对值为t的元素，如果不存在，则更新窗口。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public  static boolean containsNearbyAlmostDuplicate_one(int[] nums, int k, int t) {
        if(k<1||t<0||nums.length<=1) return false;

        //创建一个窗口
        SortedSet<Long> set=new TreeSet<Long>();
        for(int i=0;i<nums.length;i++) {
            //创建这个窗口的一个子集，子集的 取值范围为(nums[i]-t,nums[i]+t+1)，也就是与nums[i]相差t的元素组成的集合
            Set<Long> subSet=set.subSet((long) nums[i]-t,(long) nums[i]+t+1);

            //若集合不为空，则证明存在这样的元素
            if(!subSet.isEmpty()) return true;
            //下面的代码是为了维护窗口的长度为k
            if(i>=k) set.remove((long) nums[i-k]);
            set.add((long) nums[i]);
        }

        return false;
    }

    public static void main(String...args){

//        int[] numbers = {1,2,3,1};
//        int k=3,t=0;
//        int[] numbers = {1,0,1,1};
//        int k=1,t=2;

        int[] numbers = {1,5,9,1,5,9};
        int k=2,t=3;
        boolean exist = A220存在重复元素III.containsNearbyAlmostDuplicate_one(numbers,k,t);

        System.out.println(exist);



    }

}
