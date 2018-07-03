/**
 * Copyright (C), 2015-2018, ele me
 * FileName: NumberStreams
 * Author:   bian.wu
 * Date:     2018/6/28 11:39
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/28
 * @since 1.0.0
 */
public class NumberStreams {

    public static void main(String[] args) {

        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);

//        evenNumbers.forEach(a -> System.out.println(a));


        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * b + b * b)}));

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));

    }


}