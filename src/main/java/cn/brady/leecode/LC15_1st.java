package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 15 三数之和
 * <p>
 * https://leetcode-cn.com/problems/3sum/
 * @auther: bian.wu
 * @date: 2018/12/19 19:43
 */
public class LC15_1st {

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> numList = new LinkedList<>();
        for (int i : nums) {
            numList.add(i);
        }
        numList = numList.stream().sorted().collect(Collectors.toList());

//        sort(nums.begin(), nums.end());
//        if (nums.empty() || nums.back() < 0 || nums.front() > 0) return {};
        for (int k = 0; k < nums.length; ++k) {
            if (numList.get(k) > 0) break;
            if (k > 0 && numList.get(k) == numList.get(k - 1)) continue;
            int target = 0 - numList.get(k);
            int i = k + 1, j = numList.size() - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> aresult = new LinkedList<>();
                    aresult.add(numList.get(k));
                    aresult.add(numList.get(i));
                    aresult.add(numList.get(j));
                    res.add(aresult);

                    while (i < j && numList.get(i) == numList.get(i + 1)) ++i;
                    while (i < j && numList.get(j) == numList.get(j - 1)) --j;
                    ++i;
                    --j;
                } else if (numList.get(i) + numList.get(j) < target) ++i;
                else --j;
            }
        }
        return res;
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();
        List<Integer> result;
        List<Integer> biggers = new LinkedList<>();
        List<Integer> smallers = new LinkedList<>();
        boolean hasZero = false;

        for (int i : nums) {
            if (i > 0) {
                biggers.add(i);
            } else if (i < 0) {
                smallers.add(i);
            } else {
                hasZero = true;
            }
        }

        for (int i : nums) {
            int k = i;
            result = new LinkedList<>();
            result.add(i);
            if (i > 0) {
                for (int j : smallers) {
                    k += j;
                    result.add(j);
                    if (k > 0) {

                    } else if (k < 0) {

                    } else {
                        if (hasZero) {
                            result.add(0);
                        }
                    }
                }
            }


            if (result.size() == 3) {
                results.add(result);
            }
        }

        return results;
    }

    public static void main(String... args) {
        int[] num1 = {-1, 0, 1, 2, -1, -4};


        LC15_1st.threeSum2(num1);

    }


}
