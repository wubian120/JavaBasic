/**
 * Copyright (C), 2015-2018, ele me
 * FileName: BeanDefinition
 * Author:   bian.wu
 * Date:     2018/6/27 13:55
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/6/27
 * @since 1.0.0
 */
@Data
@ToString
public class BeanDefinition {

    private String name;

    private String className;
    private String interfaceName;

    private List  constructorArgs;
    private List  propertyArgs;




}