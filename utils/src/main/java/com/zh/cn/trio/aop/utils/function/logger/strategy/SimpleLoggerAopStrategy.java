package com.zh.cn.trio.aop.utils.function.logger.strategy;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.logger.LoggerHelper;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class SimpleLoggerAopStrategy implements AopStrategy<LoggerBeanConfig> {

	@Override
	public void operAop(AopUtilContext<LoggerBeanConfig> aopUtilContext, String targetTime) {
		LoggerHelper.logger(aopUtilContext, targetTime);
	}

}
