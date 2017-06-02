package io.github.zh.cn.trio.aop.logger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.zh.cn.trio.aop.logger.config.LoggerBeanConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TrioLogger {

	
	/**
	 * @return 触发时间  默认异常触发
	 */
	 String targetTime() default LoggerBeanConfig.TIME_ERROR;
	 
	 
	 /**
	  *@return 执行策略
	  */
	 String aopStrategy() default "";
	 
	 /**
	  *@return 触发等级 默认info
	  */
	 String targetLevel() default LoggerBeanConfig.LEVEL_INFO;
	 
	 /**
	  *@return 日志名称 默认目标主日志
	  */
	 String targetName() default "";
	 
	 
	 /**
	  * @return 日志模板
	  */
	 String modelString() default "";
}
