package cn.brady.basic.annotation;


import java.lang.annotation.*;

/**
 * 水果颜色注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color{BLUE, RED, GREEN};


    Color fruitColor() default Color.GREEN;

}
