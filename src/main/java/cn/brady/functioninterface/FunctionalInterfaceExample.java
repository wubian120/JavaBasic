/**
 * Copyright (C), 2015-2018, ele me
 * FileName: FunctionalInterfaceExample
 * Author:   bian.wu
 * Date:     2018/6/23 12:24
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.functioninterface;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/23
 * @since 1.0.0
 */
public class FunctionalInterfaceExample {


    public static void main(String[] args) {
        List<Integer> numberList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> numberList2 = Arrays.asList(2, 3, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17);

        System.out.println("输出：");

        new Thread(()->System.out.println(numberList2)).start();


        BiFunction<Integer,Integer, Integer> biFuncAdd = (i1, i2) -> i1+i2;

        List<Integer> numbers3 = getAdd(numberList1,numberList2,new BiFuncTest());
//        for(int a : numberList1){
//            for(int b : numberList2){
//
//                numbers3.add(new BiFuncTest().apply(a,b));
//
//            }
//        }

        System.out.println(numbers3);

    }

    public static void predicateExampleFst(List<Integer> numbers) {

        System.out.println("output: ");
        eval(numbers, n -> true);

        System.out.println("偶数： ");
//        eval(numbers, n -> n % 2 == 0);

        FunctionalInterfaceExamFst<Integer> fife = new FunctionalInterfaceExamFst<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n > 1;
            }
        };


        eval(numbers, fife);


    }


    public static void eval(List<Integer> numbers, FunctionalInterfaceExamFst predicate) {
        for (Integer n : numbers) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }

    }

    public static List<Integer> getAdd(List<Integer> l1,List<Integer> l2, BiFunction<Integer,Integer,Integer> biFunction){
        List<Integer> l3 = new ArrayList<>();
        for(Integer i1 : l1){
            for(Integer i2 : l2){
                l3.add(biFunction.apply(i1,i2));
            }
        }
        return l3;
    }


}