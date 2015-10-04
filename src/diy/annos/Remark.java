package diy.annos;

import java.lang.annotation.*;

/**
 * @author Tian
 * @date 2015/9/23
 */
@Target(ElementType.FIELD)@Retention(RetentionPolicy.RUNTIME)@Documented
public @interface Remark {
    String value() default "";
}
