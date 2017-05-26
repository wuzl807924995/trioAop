package com.zh.cn.trio.aop.hystrix.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioHystrix {

	/**
	 * 执行策略
	 */
	String aopStrategy() default "";

	/**
	 * 填充模式
	 */
	String format() default "";

	/**
	 * 验证表达式
	 */
	String HystrixModelBeanName();
}
