package com.sunzequn.sunmysql.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sloriac on 15/11/18.
 * <p>
 * The annotation for the property of a entity,
 * specifying the name of it`s corresponding column.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String name() default "";
}
