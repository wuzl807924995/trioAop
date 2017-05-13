package com.zh.cn.trio.aop.utils.strategy.simple;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.logger.LoggerHelper;
import com.zh.cn.trio.aop.utils.function.logger.aspect.LoggerConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class SimpleLoggerAopStrategy implements AopStrategy<LoggerConfig> {

	@Override
	public void operAop(AopUtilContext<LoggerConfig> aopUtilContext, String targetTime) {
		LoggerHelper.logger(aopUtilContext, targetTime);
	}

}
