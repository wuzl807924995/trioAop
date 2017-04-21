package com.zh.cn.trio.aop.utils.function.logger.aspect;

import com.zh.cn.trio.aop.utils.aspect.AbstractAopAspect;
import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;

public class LoggerXmlAspect extends AbstractAopAspect<LoggerConfig> {

	private LoggerConfig loggerConfig;

	@Override
	public LoggerConfig createBean(AopUtilContext<LoggerConfig> aopUtilContext) {
		return loggerConfig;
	}

}
