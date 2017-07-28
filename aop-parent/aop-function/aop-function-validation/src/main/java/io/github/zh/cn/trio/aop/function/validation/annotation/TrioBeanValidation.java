package io.github.zh.cn.trio.aop.function.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioBeanValidation {

	String beanName();

	/**
	 *
	 * @return 执行策略
	 */
	String aopStrategy() default "";

}
