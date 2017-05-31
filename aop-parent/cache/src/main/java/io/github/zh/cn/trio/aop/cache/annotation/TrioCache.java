package io.github.zh.cn.trio.aop.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.zh.cn.trio.aop.cache.model.CacheModel;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioCache {

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
	 * 缓存建 模板字符
	 */
	String keyModelString() default "";
}
