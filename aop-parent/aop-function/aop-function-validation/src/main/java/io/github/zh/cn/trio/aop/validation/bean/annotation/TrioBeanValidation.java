package io.github.zh.cn.trio.aop.validation.bean.annotation;

public @interface TrioBeanValidation {

	String beanName() default "";

	/**
	 *
	 * @return 执行策略
	 */
	String aopStrategy() default "";

	/**
	 * @return 填充模式
	 */
	String format() default "";
}
