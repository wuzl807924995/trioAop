package com.zh.cn.trio.aop.utils.function.logger.strategy;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;
import com.zh.cn.trio.aop.utils.function.logger.LoggerHelper;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class SimpleLoggerAopStrategy implements AopStrategy<LoggerBeanConfig> {

	private LoggerFace loggerFace;
	
	
	public LoggerFace getLoggerFace() {
		return loggerFace;
	}


	public void setLoggerFace(LoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}


	@Override
	public void operAop(AopUtilContext<LoggerBeanConfig> aopUtilContext, String targetTime) {
		LoggerHelper.logger(loggerFace,aopUtilContext, targetTime);
	}

}
