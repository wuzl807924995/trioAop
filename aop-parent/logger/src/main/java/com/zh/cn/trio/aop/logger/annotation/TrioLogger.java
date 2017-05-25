package com.zh.cn.trio.aop.logger.annotation;

import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;

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
	  * 触发等级 默认info
	  */
	 String targetLevel() default LoggerBeanConfig.LEVEL_INFO;
	 
	 /**
	  * 日志名称 默认目标主日志
	  */
	 String targetName() default "";
	 
	 /**
	  * 执行策略
	  */
	 String aopStrategy() default "";
	 
	 /**
	  * 填充模式
	  */
	 String format() default "";
	 
	 /**
	  * 日志接口
	  */
	 String loggerFace() default "";
	 
	 /**
	  * 日志模板
	  */
	 String modelString() default "";
}
