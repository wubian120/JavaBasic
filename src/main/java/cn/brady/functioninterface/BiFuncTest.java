/**
 * Copyright (C), 2015-2018, ele me
 * FileName: BiFuncTest
 * Author:   bian.wu
 * Date:     2018/6/23 18:15
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.functioninterface;

import java.util.function.BiFunction;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/23
 * @since 1.0.0
 */
public class BiFuncTest implements BiFunction<Integer,Integer,Integer> {

    @Override
    public  Integer apply(Integer integer, Integer integer2) {
        return integer * integer2;
    }

}