package cn.brady.leecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * @auther: bian.wu
 * @date: 2019/3/28 13:01
 */
public class A354俄罗斯套娃信封问题 {

    /**
     * @param envelopes
     * @return
     * @beats 84%
     * @status pass
     * @ref https://www.jianshu.com/p/8d20581ceb07
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        int max;
        int res = 0;
        for (int i = 1; i < envelopes.length; i++) {
            max = 0;
            for (int j = res; j >= 0; j--) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    max = j + 1;
                    res = Math.max(res, max);
                    break;
                }
            }
            if (max == res || envelopes[i][1] < envelopes[max][1])
                envelopes[max][1] = envelopes[i][1];
        }
        return res + 1;
    }

    public static void main(String... args) {

        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};

        int result = A354俄罗斯套娃信封问题.maxEnvelopes(envelopes);

        System.out.println(result);

    }

}
