package io.github.zh.cn.trio.aop.function.logger.strategy;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.function.logger.context.LoggerBeanContext;

public class LoggerStrategy implements LoggerAopStrategy {

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		LoggerBeanContext loggerBeanContext = (LoggerBeanContext) aopUtilContext;
		loggerBeanContext.getLoggerFace().logger(loggerBeanContext, targetTime);
	}

}
