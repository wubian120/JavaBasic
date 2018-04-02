package cn.brady.basic.annotation;


import java.lang.annotation.*;

/**
 * 自定义 水果名 注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    String value() default "";

}



