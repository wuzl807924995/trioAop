package com.zh.cn.trio.aop.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioCache {

	/**
	 * 是否异步
	 */
	boolean async() default false;

	/**
	 * 触发时间 默认异常触发
	 */
	String[] targetTime() default {CacheBeanConfig.TIME_BEFORE,CacheBeanConfig.TIME_AFTER};

	/**
	 * 执行策略
	 */
	String aopStrategy() default "";

	/**
	 * 填充模式
	 */
	String format() default "";

	/**
	 * 缓存时间
	 */
	int cacheTime() default -1;

	/**
	 * 缓存模式
	 */
	String cacheModel() default CacheModel.READ_WRITE;

	/**
	 * 缓存实现接口
	 */
	String cacheFace() default "";

	/**
	 * 缓存建 模板字符
	 */
	String keyModelString() default "";
}
