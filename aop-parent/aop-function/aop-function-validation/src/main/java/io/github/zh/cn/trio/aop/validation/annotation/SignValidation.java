package io.github.zh.cn.trio.aop.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface SignValidation {

	/**
	 * @return 执行策略
	 */
	String aopStrategy() default "";

	/**
	 * @return 验证表达式
	 */
	String validationExpress();

	/**
	 *@return  错误码
	 */
	String errorCode() default "";

	/**
	 * @return 错误消息
	 */
	String errorMsg() default "";

	/**
	 *@return 错误返回表达式
	 */
	String errorReturn() default "";
}
