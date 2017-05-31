package io.github.zh.cn.trio.aop.logger.strategy;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.croe.strategy.AopStrategy;

import io.github.zh.cn.trio.aop.logger.config.LoggerBeanConfig;
import io.github.zh.cn.trio.aop.logger.face.LoggerFace;

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
		loggerFace.logger(aopUtilContext, targetTime);
	}

}
