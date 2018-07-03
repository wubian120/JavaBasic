/**
 * Copyright (C), 2015-2018, ele me
 * FileName: ConstructorArg
 * Author:   bian.wu
 * Date:     2018/6/27 14:45
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.ioc.bean;

import lombok.Data;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/27
 * @since 1.0.0
 */

@Data
public class ConstructorArg {

    private int index;
    private String ref;
    private String name;
    private Object value;

}