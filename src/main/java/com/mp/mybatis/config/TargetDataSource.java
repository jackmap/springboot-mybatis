package com.mp.mybatis.config;

import com.mp.mybatis.datasource.DataSourceType;

import java.lang.annotation.*;

/**
 * 自定义多数据源切换注解
 *
 * @author zrsupply
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {

	/**
	 * 切换数据源名称
	 */
	public DataSourceType value() default DataSourceType.MASTER;
}