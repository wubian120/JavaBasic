package cn.brady.functioninterface;/**
 * Copyright (C), 2015-2018, ele me
 * FileName: FunctionalInterfaceExamFst
 * Author:   bian.wu
 * Date:     2018/6/23 13:20
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */


import java.util.List;
import java.util.function.Predicate;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/23
 * @since 1.0.0
 */

@FunctionalInterface
public interface FunctionalInterfaceExamFst<T> extends Predicate<T> {

    boolean test(T t);

    default boolean test(Integer n) {
        return n % 2 == 0;
    }
}
