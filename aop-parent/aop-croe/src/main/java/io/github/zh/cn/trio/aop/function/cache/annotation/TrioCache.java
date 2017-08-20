package io.github.zh.cn.trio.aop.function.cache.annotation;

import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioCache {

	/**
	 *@return 缓存时间
	 */
	int cacheTime() default -1;

	/**
	 *@return 缓存模式
	 */
	String cacheModel() default CacheFace.READ_WRITE;

	/**
	 *@return 缓存建 模板字符
	 */	
	String keyModelString() default "";
}
