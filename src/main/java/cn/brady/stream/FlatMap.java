/**
 * Copyright (C), 2015-2018, ele me
 * FileName: FlatMap
 * Author:   bian.wu
 * Date:     2018/6/28 15:52
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/28
 * @since 1.0.0
 */
public class FlatMap {

    public static void main(String... args){

        String[][] words = new String[][]{{"a","b"},{"c","d"},{"e","f"}};
        Stream<String[]> temp = Arrays.stream(words);

    }

}