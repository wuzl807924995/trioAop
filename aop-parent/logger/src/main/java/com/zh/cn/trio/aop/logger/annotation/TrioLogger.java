package com.zh.cn.trio.aop.logger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioLogger {

	/**
	 * 是否异步
	 */
	boolean async() default false; 
	
	/**
	 * 触发时间  默认异常触发
	 */
	 String targetTime() default LoggerBeanConfig.TIME_ERROR;
	 
	 
	 /**
	  * 执行策略
	  */
	 String aopStrategy() default "";
	 
	 /**
	  * 填充模式
	  */
	 String format() default "";
	 
	 /**
	  * 触发等级 默认info
	  */
	 String targetLevel() default LoggerBeanConfig.LEVEL_INFO;
	 
	 /**
	  * 日志名称 默认目标主日志
	  */
	 String targetName() default "";
	 
	 /**
	  * 日志接口
	  */
	 String loggerFace() default "";
	 
	 /**
	  * 日志模板
	  */
	 String modelString() default "";
}
