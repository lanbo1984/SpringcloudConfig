package com.coolq.app.common.datasource.annotation;

import java.lang.annotation.*;

/**
 * 切换数据源
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface SwitchDs {
    DbMsEnum ms() default DbMsEnum.SCHEDB;
}
