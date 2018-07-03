/**
 * Copyright (C), 2015-2018, ele me
 * FileName: PredicateExtender
 * Author:   bian.wu
 * Date:     2018/6/23 12:48
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.functioninterface;

import java.util.function.Predicate;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/23
 * @since 1.0.0
 */
public class PredicateExtender implements Predicate<Integer> {

    public Integer sum(Integer n1, Integer n2){
        return n1+n2;
    }


    @Override
    public boolean test(Integer t) {
        return t == 20;
    }
}