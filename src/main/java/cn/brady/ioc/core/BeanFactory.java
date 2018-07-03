package cn.brady.ioc.core;/**
 * Copyright (C), 2015-2018, ele me
 * FileName: BeanFactory
 * Author:   bian.wu
 * Date:     2018/6/27 15:13
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */


/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/27
 * @since 1.0.0
 */



public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
