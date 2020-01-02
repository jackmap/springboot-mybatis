package com.mp.mybatis.config;

import com.mp.mybatis.datasource.DataSourceType;

import java.lang.annotation.*;

/**
 * 模板数据库
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

	String value() default "datasource1";
}