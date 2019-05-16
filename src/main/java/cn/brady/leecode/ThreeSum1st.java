package cn.brady.leecode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description: 15 三数之合
 *
 * https://leetcode-cn.com/problems/3sum/
 *
 * @auther: bian.wu
 * @date: 2018/12/4 03:43
 */
public class ThreeSum1st {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> swo  = numList.stream()
                .flatMap(a->IntStream.of(nums).mapToObj(b->Math.addExact(a,b)))
                .distinct().collect(Collectors.toList());

//        Stream.iterate(nums,t->new int[]{t[0],t[1],t[2]}).collect(Collectors.toList());





        return null;
    }

    public static void main(String...args){
        int[] t1= {1,4,5,6};


        Calendar now = Calendar.getInstance();
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);

        now.add(Calendar.HOUR_OF_DAY, -2);
        Date biginTime = now.getTime();
        now.add(Calendar.HOUR_OF_DAY, 3);
        Date endTime = now.getTime();


        List<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(5);

        intList.add(3);

        intList.sort((i1,i2)->i1.compareTo(i2));



        ThreeSum1st.threeSum(t1);

        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]}).limit(20)
                .map(t->t[1])
                .forEach(System.out::println);
    }

}
