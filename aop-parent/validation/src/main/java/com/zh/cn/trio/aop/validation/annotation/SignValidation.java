package com.zh.cn.trio.aop.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface SignValidation {

	
	 /**
	  * 执行策略
	  */
	 String aopStrategy() default "";
	 
	 /**
	  * 填充模式
	  */
	 String format() default "";
	 
	 /**
	  * 验证接口
	  */
	 String ValidationFace() default "";
	 
	 /**
	  * 验证表达式
	  */
	 String validationExpress();

	 /**
	  * 错误码
	  */
	 String errorCode() default "";
	 
	 /**
	  * 错误消息
	  */
	 String errorMsg() default "";
	 
	 /**
	  * 错误返回表达式
	  */
	 String errorReturn() default "";
}
