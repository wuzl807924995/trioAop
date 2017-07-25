package io.github.zh.cn.trio.aop.logger.strategy;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.logger.context.LoggerBeanContext;

@Component("LoggerStrategy")
public class LoggerStrategy implements AopStrategy {

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		LoggerBeanContext loggerBeanContext = (LoggerBeanContext) aopUtilContext;
		loggerBeanContext.getLoggerFace().logger(loggerBeanContext, targetTime);
	}

}
