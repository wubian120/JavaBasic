package cn.brady.basic.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Writer {
    String name();
    int age();
}
